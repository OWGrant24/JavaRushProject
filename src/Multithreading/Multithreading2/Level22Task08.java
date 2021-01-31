package Multithreading.Multithreading2;

import java.util.HashMap;
import java.util.Map;

/*
Сформируй часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.

Пример:
{name=Ivanov, country=Ukraine, city=Kiev, age=null}

Результат:
name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'
 */
public class Level22Task08 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("front", "rex");
        map.put("way", null);
        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> pair : params.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            if (pair.getKey() != null && pair.getValue() != null) {
                sb.append(" and ");
                sb.append(key);
                sb.append(" = '");
                sb.append(value);
                sb.append("'");
            }


        }
        sb.delete(0,5);
        return sb.toString();
    }
}