package Core8;


import java.io.*;

/*
1 Измени класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream. Используй наследование.
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 Вызвать метод flush().
2.2 Дописать следующий текст "JavaRush © All rights reserved.", используй метод getBytes().
2.3 Закрыть поток методом close().
 */

public class Level18Task13 extends FileOutputStream {
    private FileOutputStream fileOutputStream;

    public static String fileName = "C:/tmp/result.txt";

    public Level18Task13(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
        this.fileOutputStream = fileOutputStream;
    }

    @Override
    public void write(int b) throws IOException {
        fileOutputStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        fileOutputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        fileOutputStream.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    @Override
    public void close() throws IOException {
        fileOutputStream.flush();
        String a = "JavaRush © All rights reserved.";
        fileOutputStream.write(a.getBytes());
        fileOutputStream.close();

    }

    public static void main(String[] args) throws FileNotFoundException {
        new Level18Task13(new FileOutputStream(fileName));
    }

}
