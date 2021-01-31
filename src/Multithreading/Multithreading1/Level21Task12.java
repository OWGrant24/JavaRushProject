package Multithreading.Multithreading1;
/*
В классе FakeConnection реализуй интерфейс AutoCloseable, чтобы объекты этого типа можно было использовать в try-with-resources.
Метод close() должен выводить на экран фразу "Closing database connection..."
В блоке try последовательно вызови методы usefulOperation() и unsupportedOperation().

Вывод на экран должен быть следующим:
Establishing database connection...
Entering body of try block.
Executing useful operation.
Operation is not supported yet!
Closing database connection...

Обрати внимание на то, что ресурсы были освобождены автоматически несмотря на исключение брошенное
методом unsupportedOperation.
*/
public class Level21Task12 {
    public static void main(String[] args) {
        Level21Task12_DBConnectionManager dbConnectionManager = new Level21Task12_DBConnectionManager();
        try (Level21Task12_FakeConnection fakeConnection = dbConnectionManager.getFakeConnection()) {
            System.out.println("Entering body of try block.");
            fakeConnection.usefulOperation();
            fakeConnection.unsupportedOperation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}