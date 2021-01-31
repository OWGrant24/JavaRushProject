package Collections4.Collections1;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/*
Напиши программу, которая будет считать подробную информацию о папке и выводить ее на консоль.

Первым делом считай путь к папке с консоли.
Если введенный путь не является директорией - выведи "[полный путь] - не папка" и заверши работу.
Затем посчитай и выведи следующую информацию:

Всего папок - [количество папок в директории и поддиректориях]
Всего файлов - [количество файлов в директории и поддиректориях]
Общий размер - [общее количество байт, которое хранится в директории]

Используй только классы и методы из пакета java.nio.

Квадратные скобки [ ] выводить на экран не нужно.
Требования:
Метод main должен считывать путь к папке с консоли.
Если введенный путь не является директорией - нужно вывести "[полный путь] - не папка" и завершить работу.
Используй только классы и методы из пакета java.nio.
На консоль должна быть выведена следующая информация: "Всего папок - [количество папок в директории и поддиректориях]".
На консоль должна быть выведена следующая информация: "Всего файлов - [количество файлов в директории и поддиректориях]".
На консоль должна быть выведена следующая информация: "Общий размер - [общее количество байт, которое хранится в директории]".
 */
public class Level31Task13 {
    public static void main(String[] args) throws IOException {
        String pathStr = "Exp";
        Path pathDir = Paths.get(pathStr);
        if (!Files.isDirectory(pathDir)) {
            System.out.printf("%s - не папка", pathStr);
        } else {
            AtomicInteger atomicCountDir = new AtomicInteger(0);
            AtomicInteger atomicCountFiles = new AtomicInteger(0);
            AtomicLong atomicSizeDir = new AtomicLong(0);

            Files.walkFileTree(pathDir, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (attrs.isDirectory()) {
                        atomicCountDir.getAndIncrement();
                    } else {
                        atomicCountFiles.getAndIncrement();
                        atomicSizeDir.getAndAdd(attrs.size());
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    atomicCountDir.getAndIncrement();
                    return FileVisitResult.CONTINUE;
                }
            });
            System.out.printf("Всего папок - %d\n", atomicCountDir.get() - 1);
            System.out.printf("Всего файлов - %d\n", atomicCountFiles.get());
            System.out.printf("Общий размер - %d\n", atomicSizeDir.get());

        }
    }
}
