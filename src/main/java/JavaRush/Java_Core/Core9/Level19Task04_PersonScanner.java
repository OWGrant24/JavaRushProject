package JavaRush.Java_Core.Core9;

import java.io.IOException;

public interface Level19Task04_PersonScanner {
    Level19Task04_Person read() throws IOException;

    void close() throws IOException;
}
