package Zip.command;

import Zip.ConsoleHelper;
import Zip.FileProperties;
import Zip.ZipFileManager;

import java.util.List;

// Команда просмотра содержимого архива
public class ZipContentCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Просмотр содержимого архива.");
        ZipFileManager zfm = getZipFileManager();
        ConsoleHelper.writeMessage("Содержимое архива:");
        List<FileProperties> list = zfm.getFilesList();
        for(FileProperties fp : list){
            System.out.println(fp.toString());
        }
        ConsoleHelper.writeMessage("Содержимое архива прочитано.");

    }
}
