package JavaRush.JavaRush_Projects.Zip.command;

import JavaRush.JavaRush_Projects.Zip.ConsoleHelper;
import JavaRush.JavaRush_Projects.Zip.ZipFileManager;
import JavaRush.JavaRush_Projects.Zip.exception.PathIsNotFoundException;
import java.nio.file.Paths;

// Команда распаковки архива
public class ZipExtractCommand extends ZipCommand {

    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Распаковка архива");
            ConsoleHelper.writeMessage("Введите путь для распаковки"); // Введите полное имя файла или директории для распаковки
            String path = ConsoleHelper.readString();
            ZipFileManager zipFileManager = getZipFileManager();
            zipFileManager.extractAll(Paths.get(path));
            ConsoleHelper.writeMessage("Архив распакован");
        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Вы неверно указали zip файл");
        }
    }
}
