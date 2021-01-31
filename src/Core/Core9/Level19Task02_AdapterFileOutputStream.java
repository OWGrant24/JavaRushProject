package Core.Core9;


import java.io.FileOutputStream;
import java.io.IOException;

/*
Используй класс AdapterFileOutputStream,
чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter.
 */
public class Level19Task02_AdapterFileOutputStream implements Level19Task02_AmigoStringWriter {
    public Level19Task02_AdapterFileOutputStream(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
    }

    public static void main(String[] args) {

    }
    private FileOutputStream fileOutputStream;
    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        fileOutputStream.write(s.getBytes());
    }

    @Override
    public void close() throws IOException {
        fileOutputStream.close();
    }
}
