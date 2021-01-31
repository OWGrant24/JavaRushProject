package Multithreading.Multithreading9.Level29Task12Exp;
/*
Есть программа, в которой реализована система логирования по принципу:
- если событие уровня FATAL - происходит звонок директору, отправляется СМС-сообщение CEO,
 выводится сообщение в консоль, происходит логирование в файл;
- если событие уровня ERROR - отправляется СМС-сообщение CEO, выводится сообщение в консоль,
 происходит логирование в файл;
- если событие уровня WARN - выводится сообщение в консоль, происходит логирование в файл;
- если событие уровня INFO - происходит логирование в файл.

В программе реализован паттерн "цепочка ответственности". Изучи его внимательно. В классах FileLogger,
 ConsoleLogger, SmsLogger, PhoneLogger есть много повторяющегося кода. Подними весь повторяющийся код
 в абстрактный класс AbstractLogger.
Подъемом в рефакторинге называется перенос полей, методов, конструкторов из всех наследников в одного
общего предка. Из наследников, при этом, удаляется код, который перенесен в класс предка.

Логика работы программы не должна измениться.
 */
public class Level29Task12_Solution {
    public static void main(String[] args) {
        Level29Task12_Logger logger3 = new Level29Task12_PhoneLogger(Level29Task12_Level.FATAL);
        Level29Task12_Logger logger2 = new Level29Task12_SmsLogger(Level29Task12_Level.ERROR);
        Level29Task12_Logger logger1 = new Level29Task12_ConsoleLogger(Level29Task12_Level.WARN);
        Level29Task12_Logger logger0 = new Level29Task12_FileLogger(Level29Task12_Level.INFO);

        logger3.setNext(logger2);
        logger2.setNext(logger1);
        logger1.setNext(logger0);

        logger3.inform("Everything is OK", Level29Task12_Level.INFO);
        logger3.inform("We found a bug", Level29Task12_Level.WARN);
        logger3.inform("Database connection error", Level29Task12_Level.ERROR);
        logger3.inform("System shut down", Level29Task12_Level.FATAL);
    }
}
