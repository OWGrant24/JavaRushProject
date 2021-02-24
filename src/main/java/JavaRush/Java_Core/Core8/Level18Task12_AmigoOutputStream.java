package JavaRush.Java_Core.Core8;

import java.io.IOException;

public interface Level18Task12_AmigoOutputStream {
    void flush() throws IOException;

    void write(int b) throws IOException;

    void write(byte[] b) throws IOException;

    void write(byte[] b, int off, int len) throws IOException;

    void close() throws IOException;
}
