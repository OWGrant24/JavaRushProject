package Java_Multithreading.Multithreading5;
/* Работать в поте лица!
Реализуй логику метода interrupt, который должен прерывать
трэд предварительно закрыв используемые ресурсы.
Используй метод super-класса в блоке finally.
 */

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Level25Task07 extends Thread {
    private static final int BUFFER_SIZE = 2000;    //2000 bytes
    private final Socket socket;
    private final InputStream in;

    public Level25Task07(Socket socket) throws IOException {
        this.socket = socket;
        this.in = socket.getInputStream();
    }

    public void interrupt() {
        //implement logic here
        try {
            socket.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            super.interrupt();
        }
    }

    public void run() {
        try {
            byte[] buf = new byte[BUFFER_SIZE];
            while (true) {
                int count = in.read(buf);
                if (count < 0) {
                    break;
                } else {
                    if (count > 0) {
                        //process buffer here
                    }
                }
            }
        } catch (IOException ignored) {
        }
    }

    public static void main(String[] args) {
    }
}