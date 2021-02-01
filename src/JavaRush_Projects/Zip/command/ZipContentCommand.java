package JavaRush_Projects.Zip.command;

import JavaRush_Projects.Zip.ConsoleHelper;
import JavaRush_Projects.Zip.FileProperties;
import JavaRush_Projects.Zip.ZipFileManager;

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
