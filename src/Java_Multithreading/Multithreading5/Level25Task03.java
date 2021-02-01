package Java_Multithreading.Multithreading5;
/*
Свой enum
Реализуй интерфейс Columnable у Column, описание методов смотрите в джавадоках.
Реализуй логику метода Column.getVisibleColumns.
Метод Column.configureColumns уже реализован, его не меняй.
Создавать дополнительные поля нельзя.
Метод main не участвует в тестировании.
 */
public class Level25Task03 {
    /**
     * Output:
     * <p/>
     * Available Amount
     * Account Number
     * Bank Name
     * --------------------
     * Available Amount
     * Bank Name
     */
    public static void main(String[] args) {

        Level25Task03_Column.configureColumns(Level25Task03_Column.Amount, Level25Task03_Column.AccountNumber, Level25Task03_Column.BankName);

        for (Level25Task03_Columnable columnable : Level25Task03_Column.getVisibleColumns()) {
            System.out.println(columnable.getColumnName());
        }

        System.out.println("--------------------");
        Level25Task03_Column.AccountNumber.hide();

        for (Level25Task03_Columnable columnable : Level25Task03_Column.getVisibleColumns()) {
            System.out.println(columnable.getColumnName());
        }
    }
}
