package JavaRush.JavaRush_Projects.Zip.command;

import JavaRush.JavaRush_Projects.Zip.ConsoleHelper;
import JavaRush.JavaRush_Projects.Zip.ZipFileManager;
import java.nio.file.Paths;

/*
Все команды, которые работают с архивом, должны быть унаследованы от класса ZipCommand.
 */
public abstract class ZipCommand implements Command {

    public ZipFileManager getZipFileManager() throws Exception{
        ConsoleHelper.writeMessage("Введите полный путь файла архива (в конце расширение .zip)");
        String path = ConsoleHelper.readString();
        return new ZipFileManager(Paths.get(path));
    }
}
