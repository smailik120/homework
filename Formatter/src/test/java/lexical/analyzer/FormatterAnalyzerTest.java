package lexical.analyzer;

import exception.ReaderException;
import exception.WriterException;
import org.junit.Before;
import org.junit.Test;
import work.with.files.ReaderOfString;
import work.with.files.WriterToString;

import java.io.IOException;

import static org.junit.Assert.*;

public class FormatterAnalyzerTest {

    @Before
    public void before() {
        FormatterAnalyzer.getAnalyzer().setState("space");
    }
    @Test
    public void workForStringFirst() throws ReaderException, WriterException, IOException {
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
    public void workForStringSecond() throws ReaderException, WriterException, IOException {
        FormatterAnalyzer analyzer = FormatterAnalyzer.getAnalyzer();
        StringBuilder input = new StringBuilder("{{\r\n     s}}");
        ReaderOfString stringReader = new ReaderOfString(input);
        StringBuilder output = new StringBuilder();
        WriterToString stringWriter = new WriterToString(output);
        analyzer.work(stringReader, stringWriter);
        assertTrue("{\r\n    {\r\n        s\r\n    }\r\n}".equals(output.toString()));
    }

    @Test
    public void workForStringThird() throws ReaderException, WriterException, IOException {
        FormatterAnalyzer analyzer = FormatterAnalyzer.getAnalyzer();
        StringBuilder input = new StringBuilder("{ s t }");
        ReaderOfString stringReader = new ReaderOfString(input);
        StringBuilder output = new StringBuilder();
        WriterToString stringWriter = new WriterToString(output);
        analyzer.work(stringReader, stringWriter);
        assertTrue("{\r\n    s t\r\n}".equals(output.toString()));
    }
}