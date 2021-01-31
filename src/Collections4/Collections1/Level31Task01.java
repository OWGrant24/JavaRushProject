package Collections4.Collections1;

import java.io.*;
import java.util.*;

/*
1. На вход метода main() подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя (полный путь) существующего файла,
 который будет содержать результат.
2. Переименовать resultFileAbsolutePath в allFilesContent.txt (используй метод FileUtils.renameFile(), и,
если понадобится, FileUtils.isExist()).
3. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
3.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
3.2. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 3.1. После каждого тела файла записать "\n".
Все файлы имеют расширение txt.
В качестве разделителя пути используй "/".
Для создания файлов используй конструктор File(String pathname).

Требования:
Файл, который приходит вторым параметром в main, должен быть переименован в allFilesContent.txt.
Нужно создать поток для записи в переименованный файл.
Содержимое всех файлов, размер которых не превышает 50 байт, должно быть записано в файл allFilesContent.txt в отсортированном по имени файла порядке.
Поток для записи в файл нужно закрыть.
Не используй статические переменные.
 */
public class Level31Task01 {
    public static void main(String[] args) throws IOException {
//        String path_args0 = args[0];
//        String path_args1 = args[1];
        String path_args0 = "Exp\\test";//путь к директории path
        String path_args1 = "Exp\\3101.txt"; //имя (полный путь) существующего файла, который будет содержать результат.
        File filePath_args0 = new File(path_args0);
        File filePath_args1 = new File(path_args1);

        File filePathAllFileContent = new File(filePath_args1.getParentFile() + "/allFilesContent.txt"); // getParent?
        if (Level31Task01_FileUtils.isExist(filePath_args1)) {
            Level31Task01_FileUtils.renameFile(filePath_args1, filePathAllFileContent);
        }
        Queue<File> queue = new LinkedList<>();
        queue.add(filePath_args0);
        List<File> listFiles = new ArrayList<>();
        while (queue.peek() != null) {
            File file = queue.remove();
            for (File f : Objects.requireNonNull(file.listFiles())) {
                if (f.isDirectory()) {
                    queue.add(f);
                    System.out.println("Директория " + f.getName() + " добавлена в колекцию");

                } else {
                    if (f.length() <= 50) {
                        listFiles.add(f);
                    }
                }
            }
        }
        sortList(listFiles);
        int countFiles = 0;

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePathAllFileContent))) {
            for (File file : listFiles) {
                try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
                    byte[] buffer = new byte[bis.available()];
                    while (bis.available() > 0) { //пока есть еще непрочитанные байты
                        // прочитать очередной блок байт в переменную buffer и реальное количество в count
                        int count = bis.read(buffer);
                        //записать блок(часть блока) во второй поток
                        bos.write(buffer, 0, count);
                    }
                    bos.write("\n".getBytes());
                    countFiles++;
                }

            }
        }
        System.out.println();
        System.out.printf("Записано %d файлов", countFiles);
    }
    public static List<File> sortList(List<File> list) {
        Comparator<File> comparator = new Comparator<>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Collections.sort(list, comparator);
        return list;
    }
}

