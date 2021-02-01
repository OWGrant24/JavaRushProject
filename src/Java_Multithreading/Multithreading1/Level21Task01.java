package Java_Multithreading.Multithreading1;
/* Определяем адрес сети
https://ru.wikipedia.org/wiki/%D0%9C%D0%B0%D1%81%D0%BA%D0%B0_%D0%BF%D0%BE%D0%B4%D1%81%D0%B5%D1%82%D0%B8
https://www.youtube.com/watch?v=U7dp9bTwf3Q
https://www.youtube.com/watch?v=PbJfgFpY4Jg

1. Даны IP-адрес и маска подсети, необходимо вычислить адрес сети - реализуй метод getNetAddress.
Используйте операцию поразрядной конъюнкции (логическое И).

Пример:
IP-адрес: 11000000 10101000 00000001 00000010 (192.168.1.2)
Маска подсети: 11111111 11111111 11111110 00000000 (255.255.254.0)
Адрес сети: 11000000 10101000 00000000 00000000 (192.168.0.0)

2. Реализовать метод print, который выведет в консоль данные в двоичном коде. Для IP-адреса(192.168.1.2)
должна быть выведена строка "11000000 10101000 00000001 00000010"
3. Метод main не участвует в тестировании

 */
public class Level21Task01 {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] add = new byte[4];
        for(int i=0; i<add.length; i++){
            add[i]=(byte)(ip[i] & mask[i]);
        }
        // Обратный перевод , подумать
//        for(int i = 0; i<add.length;  i++){
//
//        }

        System.out.println();
        return add;
    }

    public static void print(byte[] bytes) {
        for(byte b : bytes){
            int segment = Integer.parseInt(Integer.toBinaryString(Byte.toUnsignedInt(b)));
            // Java 8 обеспечивает Byte.toUnsignedInt преобразование byte to int путем преобразования без знака
            System.out.print((String.format("%08d", segment)) + " ");
            // Код Бори
//            System.out.format("%08d", Integer.parseInt(Integer.toBinaryString(b &255)));
        }
        System.out.println("");
    }
}
