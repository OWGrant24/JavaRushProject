package JavaRush.Java_Core.Core8;

import java.io.*;

/* Шифровка
Придумать механизм шифровки/дешифровки.

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName

где:
fileName - имя файла, который необходимо зашифровать/расшифровать.
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования.
-e - ключ указывает, что необходимо зашифровать данные.
-d - ключ указывает, что необходимо расшифровать данные.
 */
public class Level18Task26 {
    public static void main(String[] args) {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(args[1]));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(args[2]));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] massbyte = null;
        try {
            assert bufferedInputStream != null;
            massbyte = new byte[bufferedInputStream.available()];
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(args[0].equals("-e")) {
            while (true) {
                try {
                    if (!(bufferedInputStream.available() > 1)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    bufferedInputStream.read(massbyte);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            byte[] shifrArr = new byte[massbyte.length];
            for (int i = 0; i < massbyte.length; i++) {
                shifrArr[i] = (byte) (massbyte[i]+127);
            }
            try {
                bufferedOutputStream.write(shifrArr);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(args[0].equals("-d")) {
            while (true) {
                try {
                    if (!(bufferedInputStream.available() > 1)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    bufferedInputStream.read(massbyte);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            byte[] razshifrArr = new byte[massbyte.length];
            for (int i = 0; i < massbyte.length; i++) {
                razshifrArr[i] = (byte) (massbyte[i]-127);
            }
            try {
                bufferedOutputStream.write(razshifrArr);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
