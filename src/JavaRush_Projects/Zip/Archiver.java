package JavaRush_Projects.Zip;

import JavaRush_Projects.Zip.exception.WrongZipFileException;

import java.io.IOException;

/**

 */
public class Archiver {
    public static void main(String[] args) throws Exception {
        Operation operation = null;
        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException wzfe) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e){
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }
        }
        while (operation != Operation.EXIT);
    }

     public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("Выберите операцию:");
        ConsoleHelper.writeMessage(Operation.CREATE.ordinal() + " - упаковать файлы в архив\n" +
                Operation.ADD.ordinal() + " - добавить файл в архив\n" +
                Operation.REMOVE.ordinal() + " - удалить файл из архива\n" +
                Operation.EXTRACT.ordinal() + " - распаковать архив\n" +
                Operation.CONTENT.ordinal() + " - просмотреть содержимое архива\n" +
                Operation.EXIT.ordinal() + " - выход");
        int v = ConsoleHelper.readInt();
        Operation[] op = Operation.values();
        return op[v];
    }
}