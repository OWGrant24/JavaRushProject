package Collections4.Collections1;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/*
Реализовать логику метода getFileTree, который должен в директории root найти
список всех файлов включая вложенные.
Используй очередь, рекурсию не используй.
Верни список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
 */
public class Level31Task02 {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> ls = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        File folder = new File(root);
        queue.add(folder);
        while(queue.peek()!=null){
            File file = queue.remove();
            for(File f : Objects.requireNonNull(file.listFiles())) {
                if (f.isDirectory()) queue.add(f);
                else ls.add(f.getPath());
            }
        }
        return ls;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getFileTree("E:\\666"));
    }
}
