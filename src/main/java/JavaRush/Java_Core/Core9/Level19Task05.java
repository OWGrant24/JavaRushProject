package JavaRush.Java_Core.Core9;
import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер

Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.

Инициализируйте countries перед началом выполнения программы. +
Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Level19Task05 {
    public static Map<String, String> countries = new HashMap<>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.contact = contact;
            this.customer = customer;
        }

        @Override
        public String getCountryCode() {
            for(Map.Entry<String,String> pair : countries.entrySet()){
                if(customer.getCountryName().equals(pair.getValue())){
                    return pair.getKey();
                }
            }
            return customer.getCountryName();
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            return contact.getName().substring(contact.getName().indexOf(',')+2);
        }

        @Override
        public String getContactLastName() {
            return contact.getName().substring(0,contact.getName().indexOf(','));
        }

        @Override
        public String getDialString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("callto://");
            stringBuilder.append(contact.getPhoneNumber().replaceAll("[()-]", ""));
            return stringBuilder.toString();
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}
