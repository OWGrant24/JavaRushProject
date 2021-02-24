package JavaRush.JavaRush_Projects.Zip.command;

import JavaRush.JavaRush_Projects.Zip.ConsoleHelper;
import JavaRush.JavaRush_Projects.Zip.ZipFileManager;
import java.nio.file.Paths;

// Команда удаления файла из архива
public class ZipRemoveCommand extends ZipCommand {

    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Удаление файла из архива");
        ZipFileManager zipFileManager = getZipFileManager();
        ConsoleHelper.writeMessage("Введите полный путь файла в архиве"); // Введите полное имя файла который мы будем удалять
        String pathRemovingFile = ConsoleHelper.readString();
        zipFileManager.removeFile(Paths.get(pathRemovingFile));
        ConsoleHelper.writeMessage("Архив перезаписан, файл удален");
    }
}
