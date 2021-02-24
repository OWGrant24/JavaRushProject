package JavaRush.Java_Multithreading.Multithreading9;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

/*  отпр
Рефакторинг в соответствии с Naming and Code Convention
Требования:
Переименуй константу defaultFileName в соответствии с Naming and Code Convention.
Переименуй метод getFileLoaded() в соответствии с Naming and Code Convention.
Переименуй метод DownloadFileContent() в соответствии с Naming and Code Convention.
Переименуй метод isexpectedline() в соответствии с Naming and Code Convention.
Переименуй параметр expectedline метода принимающего String в соответствии с Naming and Code Convention.
*/
public class Level29Task01 {
    public static final String DEFAULT_FILE_NAME = "C:/tmp/strange_file_name.tmp";

    private final String localFileName;
    private List<String> contentAslines;
    private boolean fileLoaded;

    public Level29Task01 (String firstFileName) {
        localFileName = firstFileName == null ? DEFAULT_FILE_NAME : firstFileName;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = Level29Task01.class.getResource("Solution.java").getPath();

        Level29Task01 solution = new Level29Task01(fileName);
        solution.downloadFileContent();
        if (solution.isFileLoaded()) {
            System.out.println(solution.hasExpectedLine("public class Solution {"));   // Expected true
            System.out.println(solution.hasExpectedLine(" public class Solution {"));  // Expected false
        }
    }

    public boolean isFileLoaded() {
        return fileLoaded;
    }

    public void downloadFileContent() {
        try {
            contentAslines = Files.readAllLines((new File(localFileName)).toPath(), Charset.defaultCharset());
            fileLoaded = true;
        } catch (IOException e) {
            System.out.println("Unsuccessful. What a surprise!");
        }
    }

    public boolean hasExpectedLine(String expectedLine) {
        return contentAslines.contains(expectedLine);
    }
}
