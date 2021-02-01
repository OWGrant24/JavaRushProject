package Java_Collections.Collections1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
Требования:
В методе main нужно создать ZipInputStream для архива, собранного из кусочков файлов.
Файлы приходят аргументами в main, начиная со второго.
Создай поток для записи в файл, который приходит первым аргументом в main. Запиши туда содержимое файла из архива.
Поток для чтения из архива должен быть закрыт.
Поток для записи в файл должен быть закрыт.
 */
public class Level31Task06 { // готовое решение
    public static void main(String[] args) throws  IOException {
        File result = new File(args[0]);    //Файл результата, по совместительству имя этого файла мы ищем в архиве
        if (!result.exists()) {
            result.createNewFile();
        }
        List<FileInputStream> fileInputStreams = new ArrayList<>(); //Список входящих стримов из разных кусков архива

        //Расставляем имена файлов архива в нужном нам порядке
        List<String> fileNames = new ArrayList<>();
        fileNames.addAll(Arrays.asList(args).subList(1, args.length));
        Collections.sort(fileNames);

        //Создаем входящий стрим для каждого куска архива
        for (String name : fileNames) {
            fileInputStreams.add(new FileInputStream(name));
        }

        try (ZipInputStream is = new ZipInputStream(new SequenceInputStream(Collections.enumeration(fileInputStreams))))    //Входящий стрим общего архива
        {
            while (true) {
                ZipEntry entry = is.getNextEntry();
                if (entry == null) break;

                try (OutputStream os = new BufferedOutputStream(new FileOutputStream(result))) {
                    final int bufferSize = 1024;
                    byte[] buffer = new byte[bufferSize];
                    for (int readBytes; (readBytes = is.read(buffer, 0, bufferSize)) > -1; ) {
                        os.write(buffer, 0, readBytes);
                    }
                    os.flush();
                }
            }
        }
    }
}
