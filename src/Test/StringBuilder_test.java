package Test;

public class StringBuilder_test {
    public static void main(String[] args) {
        String numbers = "0123456789";

        StringBuilder sb = new StringBuilder(numbers);
        StringBuilder sb2 = new StringBuilder("Привет");

        // Метод append() присоединяет строковое представление любого другого типа данных в конце вызывающего объекта типа StringBuffer.
        sb.append("321");

        System.out.println("Емкость = " + sb.capacity()); //Текущий обьём выделенной памяти
        System.out.println("Длина = " + sb.length()); // Текущая длина

        // Значение отдельного символа можно извлечь из объекта типа StringBuffer, вызвав метод charAt ()
        // А значение символа в объекте типа StringBuffer можно установить с помощью метода setCharAt ()
        sb.charAt(5);
        sb.setCharAt(5,'a');
        sb.chars();
        int a = sb.codePointAt(6); //Возвращает кодовую точку в Юникоде на позиции index
        int b = sb.codePointBefore(6); // Возвращает кодовую точку в Юникоде на позиции, предшествующей i
        int c = sb.codePointCount(6,8); //
        sb.codePoints();
        System.out.println(sb.compareTo(sb2));
        // Метод delete() удаляет последовательность символов из вызывающего
        //объекта. Его параметр начальный_индекс обозначает индекс первого символа,
        //который требуется удалить, а параметр конечный_индекс - индекс символа,
        //следующего за последним из удаляемых символов.
        sb.delete(11,13);
        // Метод deleteCharAt() удаляет символ на указанной позиции.
        sb.deleteCharAt(10);
        // Предварительное выделение места для определенного количества символов после создания объекта типа StringBuffer чтобы установить емкость буфера.
        sb.ensureCapacity(16);
        //Для копирования подстроки из объекта типа StringBuffer в массив служит метод getChars
        char[] ch = new char[25];
        sb.getChars(1,2,ch,56);
        System.out.println(ch);
        sb.indexOf("67");
        sb.indexOf("67",2);
        // Этот метод вставляет одну символьную строку в другую.
        sb.insert(3,"999");
        //
        sb.lastIndexOf("67",6);
        //
        int d = sb.offsetByCodePoints(3,5);
        sb.replace(0,5,"Привет");
        // Измение порядка следования символов на обратный
        sb.reverse();

        // Для задания длины символьной строки в объекте типа StringBuffer служит метод setLength ()
        sb.setLength(77);
        //
        sb.substring(0,8);
        sb.substring(3);
        sb.trimToSize();
        
    }

}
