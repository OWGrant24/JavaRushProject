package JavaRush_Projects.Zip.command;

import JavaRush_Projects.Zip.ConsoleHelper;
import JavaRush_Projects.Zip.ZipFileManager;
import JavaRush_Projects.Zip.exception.PathIsNotFoundException;

import java.nio.file.Paths;

// Команда создания архива (упаковки файлов в архив)
public class ZipCreateCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Создание архива");
            ConsoleHelper.writeMessage("Введите то что мы будем архивировать"); // Введите полное имя файла или директории для архивации
            String path = ConsoleHelper.readString();
            ZipFileManager zipFileManager = getZipFileManager();
            zipFileManager.createZip(Paths.get(path));
            ConsoleHelper.writeMessage("Архив создан");
        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
        }
    }
}
