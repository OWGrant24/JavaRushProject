package JavaRush.Java_Collections.Collections1;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/*
В классе Solution переопредели логику двух методов:
- visitFile кроме своей логики должен добавлять в archived все пути к zip и rar файлам
- visitFileFailed должен добавлять в failed все пути к недоступным файлам и возвращать SKIP_SUBTREE

Пример вывода:
D:/mydir/BCD.zip

Метод main не участвует в тестировании

Требования:
В классе Solution нужно переопределить метод visitFile.
Метод visitFile, кроме своей логики, должен добавлять в поле archived все пути к zip и rar файлам.
В классе Solution нужно переопределить метод visitFileFailed.
Метод visitFileFailed должен добавлять в поле failed все пути к недоступным файлам и возвращать SKIP_SUBTREE.

 */
public class Level31Task04 extends SimpleFileVisitor<Path> {
    public static void main(String[] args) throws IOException {
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        final Level31Task04 solution = new Level31Task04();
        Files.walkFileTree(Paths.get("E:\\shab"), options, 20, solution);

        List<String> result = solution.getArchived();
        System.out.println("All archived files:");
        for (String path : result) {
            System.out.println("\t" + path);
        }

        List<String> failed = solution.getFailed();
        System.out.println("All failed files:");
        for (String path : failed) {
            System.out.println("\t" + path);
        }
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toString().endsWith(".zip") || file.toString().endsWith(".rar")) {
            archived.add(file.toAbsolutePath().toString());
        }
        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        failed.add(file.toAbsolutePath().toString());
        return FileVisitResult.SKIP_SUBTREE;
    }

    private List<String> archived = new ArrayList<>();
    private List<String> failed = new ArrayList<>();

    public List<String> getArchived() {
        return archived;
    }

    public List<String> getFailed() {
        return failed;
    }
}
