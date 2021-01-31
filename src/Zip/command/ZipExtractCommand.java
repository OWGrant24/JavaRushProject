package Zip.command;

import Zip.ConsoleHelper;
import Zip.ZipFileManager;
import Zip.exception.PathIsNotFoundException;

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
