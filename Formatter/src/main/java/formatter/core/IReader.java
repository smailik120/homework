package formatter.core;

import exception.ReaderException;

import java.io.IOException;

/**
 *
 * @param <T> String/Character.
 */
public interface IReader<T> {
    /**
     * readLexeme.
     * @return T.
     * @throws ReaderException exception.
     */
    T readLexeme() throws ReaderException;
    /**
     * close.
     * @throws ReaderException exception.
     * @throws IOException exception.
     */
    void close() throws IOException, ReaderException;

    /**
     * check that read must continue
     * @return boolean.
     * @throws ReaderException exception.
     */
    boolean hasChars() throws ReaderException;
}
