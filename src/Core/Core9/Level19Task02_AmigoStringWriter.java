package Core.Core9;

import java.io.IOException;

public interface Level19Task02_AmigoStringWriter {
    void flush() throws IOException;

    void writeString(String s) throws IOException;

    void close() throws IOException;
}
