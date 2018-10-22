package lexical.analyzer;

import exception.ReaderException;
import exception.WriterException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import work.with.files.ReaderOfString;
import work.with.files.WriterToString;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FormatterAnalyzerTest {
    @BeforeEach
    public void Before() {
        FormatterAnalyzer.getAnalyzer().setState("space");
    }
    @Test
    void workForStringFirst() throws ReaderException, WriterException, IOException {
        FormatterAnalyzer analyzer = FormatterAnalyzer.getAnalyzer();
        StringBuilder input = new StringBuilder("{{}}");
        ReaderOfString stringReader = new ReaderOfString(input);
        StringBuilder output = new StringBuilder();
        WriterToString stringWriter = new WriterToString(output);
        analyzer.work(stringReader, stringWriter);
        assertTrue("{\r\n    {\r\n    }\r\n}".equals(output.toString()));
        FormatterAnalyzer.getAnalyzer().setState("space");
    }
    @Test
    void workForStringSecond() throws ReaderException, WriterException, IOException {
        FormatterAnalyzer analyzer = FormatterAnalyzer.getAnalyzer();
        StringBuilder input = new StringBuilder("{{\r\n     s}}");
        ReaderOfString stringReader = new ReaderOfString(input);
        StringBuilder output = new StringBuilder();
        WriterToString stringWriter = new WriterToString(output);
        analyzer.work(stringReader, stringWriter);
        assertTrue("{\r\n    {\r\n        s\r\n    }\r\n}".equals(output.toString()));
    }
}