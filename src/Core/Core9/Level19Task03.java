package Core.Core9;
/*  Адаптация нескольких интерфейсов
Адаптируй IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы.
Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры).
Обратите внимание на формат вывода фамилии и имени человека.
*/

import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

public class Level19Task03 {
    public static Map<String, String> countries = new HashMap<>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args) {

    }
    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            for(Map.Entry<String,String> pair : countries.entrySet()){
                if(data.getCountryCode().equals(pair.getKey())){
                    return pair.getValue();
                }
            }
            return data.getCountryCode();

        }

        @Override
        public String getName() {
            return data.getContactLastName() +", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            Formatter formatter = new Formatter();
            formatter.format("%010d", data.getPhoneNumber());
            String tel =  formatter.toString();

            return "+" + data.getCountryPhoneCode() + "(" + tel.substring(0,3) + ")" +
                    tel.substring(3,6) + "-" + tel.substring(6,8) + "-" + tel.substring(8,10);
        }
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }
    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

}
