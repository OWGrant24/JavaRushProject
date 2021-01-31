package Core.Core9;

import java.io.*;
import java.nio.charset.Charset;

/*
Реализовать логику FileConsoleWriter.
Класс FileConsoleWriter должен содержать приватное поле FileWriter fileWriter.
Класс FileConsoleWriter должен содержать все конструкторы, которые инициализируют fileWriter для записи.
Класс FileConsoleWriter должен содержать пять методов write и один метод close:

public void write(char[] cbuf, int off, int len) throws IOException
public void write(int c) throws IOException
public void write(String str) throws IOException
public void write(String str, int off, int len) throws IOException
public void write(char[] cbuf) throws IOException
public void close() throws IOException
При записи данных в файл, должен дублировать эти данные на консоль.
 */
// Декоратор
public class Level19Task17_FileConsoleWriter  {
    private FileWriter fileWriter;
    // Конструкторы
    public Level19Task17_FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }
    public Level19Task17_FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName,append);
    }
    public Level19Task17_FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }
    public Level19Task17_FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file,append);
    }
    public Level19Task17_FileConsoleWriter(FileDescriptor fd) {
        this.fileWriter = new FileWriter(fd);
    }
    public Level19Task17_FileConsoleWriter(String fileName, Charset charset) throws IOException {
        this.fileWriter = new FileWriter(fileName,charset);
    }
    public Level19Task17_FileConsoleWriter(String fileName, Charset charset, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName,charset,append);
    }
    public Level19Task17_FileConsoleWriter(File file, Charset charset) throws IOException {
        this.fileWriter = new FileWriter(file,charset);
    }
    public Level19Task17_FileConsoleWriter(File file, Charset charset, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file,charset,append);
    }
    // Методы
    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.println(c);
    }
    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        for(int i=off; i<off+len; i++){
            System.out.print(cbuf[i]);
        }

    }
    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);

        System.out.println(str.substring(off,off+len));
    }
    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.println(str);
    }
    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        for(int i=0; i<cbuf.length; i++){
            System.out.print(cbuf[i]);
        }
    }
    public void close() throws IOException {
        fileWriter.close();
    }
}
