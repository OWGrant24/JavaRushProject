package JavaRush.Java_Core.Core8;

import java.io.FileInputStream;
import java.io.IOException;

/*
Измени класс TxtInputStream так, чтобы он работал только с txt-файлами (*.txt).
Например, first.txt или name.1.part3.txt.
Если передан не txt-файл, например, file.txt.exe, то конструктор должен
выбрасывать исключение UnsupportedFileNameException.
Подумай, что еще нужно сделать, в случае выброшенного исключения.
 */
public class Level18Task14 extends FileInputStream {
    public static String fileName;

    public Level18Task14(String fileName) throws IOException, Level18Task14_UnsupportedFileNameException {
        super(fileName);
        if (fileName.endsWith(".txt")) {
            this.fileName = fileName;
        }
        else {
            super.close();
            throw new Level18Task14_UnsupportedFileNameException();
        }

    }

    public static void main(String[] args) {

    }
}
