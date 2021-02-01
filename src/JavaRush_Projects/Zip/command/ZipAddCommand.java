package JavaRush_Projects.Zip.command;

import JavaRush_Projects.Zip.ConsoleHelper;
import JavaRush_Projects.Zip.ZipFileManager;
import JavaRush_Projects.Zip.exception.PathIsNotFoundException;

import java.nio.file.Paths;

//Команда добавления файла в архив
public class ZipAddCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Добавление файлов в архив");
            ZipFileManager zipFileManager = getZipFileManager();
            ConsoleHelper.writeMessage("Введите полный путь файла в архиве"); // Введите полное имя файла который мы будем добавлять в архив
            String pathAddFile = ConsoleHelper.readString();
            zipFileManager.addFile(Paths.get(pathAddFile));
            ConsoleHelper.writeMessage("Архив перезаписан, файл добавлен");
        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Вы неверно указали zip файл");
        }
    }
}
