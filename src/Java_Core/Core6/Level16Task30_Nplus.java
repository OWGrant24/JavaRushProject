package Java_Core.Core6;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

/*
Последовательный вывод файлов
1. Разберись, что делает программа.
2. В статическом блоке считай 2 имени файла firstFileName и secondFileName.  +
3. Внутри класса Solution создай нить public static ReadFileThread, которая реализует
интерфейс ReadFileInterface (Подумай, что больше подходит - Thread или Runnable).  +
3.1. Метод setFileName должен устанавливать имя файла, из которого будет читаться содержимое.
3.2. Метод getFileContent должен возвращать содержимое файла.
3.3. В методе run считай содержимое файла, закрой поток. Раздели пробелом строки файла.
4. Подумай, в каком месте нужно подождать окончания работы нити, чтобы обеспечить
последовательный вывод файлов.
4.1. Для этого добавь вызов соответствующего метода.

Ожидаемый вывод:
[все тело первого файла]
[все тело второго файла]
*/

public class Level16Task30_Nplus {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
//            firstFileName = reader.readLine();
//            secondFileName = reader.readLine();
            firstFileName =  "Exp\\1630_1.txt";
            secondFileName =  "Exp\\1630_2.txt";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }
    public static class ReadFileThread extends Thread implements ReadFileInterface{
        private String fullFileName;
        private StringBuffer fileContent = new StringBuffer("");

        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return fileContent.toString().trim();
        }

        @Override
        public void run() {
            try(BufferedReader bufferedFileReader = new BufferedReader(new FileReader(this.fullFileName))){
                while (bufferedFileReader.ready()){
                    fileContent.append(bufferedFileReader.readLine());
                    fileContent.append(" ");
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
//public static class ReadFileThread extends Thread implements Level16Task30_Nplus.ReadFileInterface {
//    private String fullFileName;
//    private StringBuffer fileContent;
//
//    @Override
//    public void setFileName(String fullFileName) {
//        this.fullFileName = fullFileName;
//    }
//
//    @Override
//    public String getFileContent() {
//        return fileContent.toString().trim();
//    }
//
//    @Override
//    public void run() {
//        try(BufferedReader bufferedFileReader = new BufferedReader(new FileReader(this.fullFileName))){
//            fileContent = new StringBuffer();
//            while (bufferedFileReader.ready()){
//                fileContent.append(bufferedFileReader.readLine());
//                fileContent.append(" ");
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//}