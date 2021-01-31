package Multithreading.Multithreading9;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/*  отпр
Требования:
Переименуй переменную Solution типа Solution в соответствии с Naming and Code Convention.
Переименуй переменную name_of_file_to_be_opened_by_notepad типа String в соответствии с Naming and Code Convention.
Переименуй переменную NOTEPAD типа Process в соответствии с Naming and Code Convention.
Переименуй метод getstartnotepadprocess() в соответствии с Naming and Code Convention.
Переименуй параметр FILE_NAME метода принимающего String в соответствии с Naming and Code Convention.
Переименуй переменную cmd_array типа String[] в соответствии с Naming and Code Convention.
Переименуй метод Getabsolutepathtodefaulttxtfile() в соответствии с Naming and Code Convention.
Переименуй переменную uRi типа URI в соответствии с Naming and Code Convention.
 */
public class Level29Task02 {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        Level29Task02 solution = new Level29Task02();
        String nameOfFileToBeOpenedByNotepad = solution.getAbsolutePathToDefaultTxtFile().toString();
        Process notepad = solution.getStartNotepadProcess(nameOfFileToBeOpenedByNotepad);
        notepad.waitFor();
    }

    public Process getStartNotepadProcess(String fileName) throws IOException {
        String[] cmdArray = new String[]{"notepad.exe", fileName};
        return Runtime.getRuntime().exec(cmdArray);
    }

    public Path getAbsolutePathToDefaultTxtFile() throws URISyntaxException {
        URI uri = Level29Task02.class.getResource("file.txt").toURI();
        return Paths.get(uri);
    }
}
