package Java_Collections.Collections1;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Level31Task07 {
    private Level31Task07_FileData fileData;

    public Level31Task07(String pathToFile) {
        try {
            fileData = new Level31Task07_ConcreteFileData(Files.isHidden(Paths.get(pathToFile)),Files.isExecutable(Paths.get(pathToFile)),
                    Files.isDirectory(Paths.get(pathToFile)),Files.isWritable(Paths.get(pathToFile)));
        } catch (Exception e){
            fileData = new Level31Task07_NullFileData(e);
        }
    }

    public Level31Task07_FileData getFileData() {
        return fileData;
    }
}
