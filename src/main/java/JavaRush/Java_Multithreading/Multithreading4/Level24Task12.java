package JavaRush.Java_Multithreading.Multithreading4;

import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/*
Знания - сила!
1. В методе sort написать компаратор для Stock:
1.1. Первичная сортировка по name в алфавитном порядке
1.2. Вторичная сортировка по дате без учета часов, минут, секунд (сверху самые новые),
потом по прибыли от положительных к отрицательным

... open 125,64 and last 126,74 - тут прибыль = 126,74-125,64
... open 125,64 and last 123,43 - тут прибыль = 123,43-125,64

2. Разобраться с *Format-ами и исправить IllegalArgumentException.

Подсказка - это одна строчка.

Пример вывода:
Fake Apple Inc. AAPL | 17-11-2025 open 125,64 and last 123,43
Fake Applied Materials, Inc. AMAT | 15-01-1983 change 0,26

Требования:
Во время работы программы не должны возникать исключения.
Программа должна выводить данные на экран.
Метод sort должен корректно сортировать полученный список в соответствии с условием задачи.
Класс Solution.Stock должен быть публичным.
*/

public class Level24Task12 {
    public static void main(String[] args) {
        List<Stock> stocks = getStocks();
        sort(stocks);
        Date actualDate = new Date();
        printStocks(stocks, actualDate);
    }

    public static void printStocks(List<Stock> stocks, Date actualDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        double[] filelimits = {0d, actualDate.getTime()};
        String[] filepart = {"change {4}", "open {2} and last {3}"};

        ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
        Format[] testFormats = {null, null, dateFormat, fileform}; // ТУТ
        MessageFormat pattform = new MessageFormat("{0}   {1} | {5} {6}");
        pattform.setFormats(testFormats);

        for (Stock stock : stocks) {
            String name = ((String) stock.get("name"));
            String symbol = (String) stock.get("symbol");
            double open = !stock.containsKey("open") ? 0 : ((double) stock.get("open"));
            double last = !stock.containsKey("last") ? 0 : ((double) stock.get("last"));
            double change = !stock.containsKey("change") ? 0 : ((double) stock.get("change"));
            Date date = (Date) stock.get("date");
            Object[] testArgs = {name, symbol, open, last, change, date, date.getTime()};
            System.out.println(pattform.format(testArgs));
        }
    }

    public static void sort(List<Stock> list) {
        list.sort(new Comparator<Stock>() {
            public int compare(Stock stock1, Stock stock2) {
//              Первичная сортировка по имени
                char[] tempArray = ((String) stock1.get("name")).toCharArray();
                char[] tempArray2 = ((String) stock2.get("name")).toCharArray();
                int lengthCheck;
                if (tempArray.length < tempArray2.length) {
                    lengthCheck = tempArray.length;
                } else {
                    lengthCheck = tempArray2.length;
                }
                for (int i = 0; i < lengthCheck; i++) {
                    if (tempArray[i] > tempArray2[i]) {
                        return 1;
                    } else if (tempArray[i] < tempArray2[i]) {
                        return -1;
                    }
                }
//                Вторичная сортировка по дате без учета часов, минут, секунд (сверху самые новые),
//                потом по прибыли от положительных к отрицательным
                // Дата
                if(removeTime((Date) stock1.get("date")).after(removeTime((Date) stock2.get("date")))){
                    return 1;
                } else if (removeTime((Date) stock1.get("date")).before(removeTime((Date) stock2.get("date")))){
                    return -1;
                }
                // прибыль
                double profit1 = calculationProfit(stock1);
                double profit2 = calculationProfit(stock2);
                System.out.println(profit1);
                System.out.println(profit2);
                System.out.println(profit1-profit2);
                if(profit1 > profit2){
                    return 1;
                } else {
                    return -1;
                }
            }
        });
    }
    public static Date removeTime(Date date){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        return calendar.getTime();
    }
    public static Double calculationProfit(Stock stock){
        double profit;
        if(stock.containsKey("change")){
            profit = (Double) stock.get("change");
        } else {
            profit = (Double) stock.get("open") - (Double) stock.get("last");
        }
        return profit;
    }
    public static class Stock extends HashMap<String, Object> {
        public Stock(String name, String symbol, double open, double last) {
            put("name", name);
            put("symbol", symbol);
            put("open", open);
            put("last", last);
            put("date", getRandomDate(2020));
        }

        public Stock(String name, String symbol, double change, Date date) {
            put("name", name);
            put("symbol", symbol);
            put("date", date);
            put("change", change);
        }
    }

    public static List<Stock> getStocks() {
        List<Stock> stocks = new ArrayList<>();

        stocks.add(new Stock("Fake Apple Inc.", "AAPL", 125.64, 123.43));
        stocks.add(new Stock("Fake Cisco Systems, Inc.", "CSCO", 25.84, 26.3));
        stocks.add(new Stock("Fake Google Inc.", "GOOG", 516.2, 512.6));
        stocks.add(new Stock("Fake Intel Corporation", "INTC", 21.36, 21.53));
        stocks.add(new Stock("Fake Level 3 Communications, Inc.", "LVLT", 5.55, 5.54));
        stocks.add(new Stock("Fake Microsoft Corporation", "MSFT", 29.56, 29.72));


        stocks.add(new Stock("Fake Microsoft Corporation", "MSFT", 1.56, 29.72));
        stocks.add(new Stock("Fake Nokia Corporation (ADR)", "NOK", .1, getRandomDate()));
        stocks.add(new Stock("Fake Oracle Corporation", "ORCL", .15, getRandomDate()));
        stocks.add(new Stock("Fake Starbucks Corporation", "SBUX", .03, getRandomDate()));
        stocks.add(new Stock("Fake Yahoo! Inc.", "YHOO", .32, getRandomDate()));
        stocks.add(new Stock("Fake Applied Materials, Inc.", "AMAT", .26, getRandomDate()));
        stocks.add(new Stock("Fake Comcast Corporation", "CMCSA", .5, getRandomDate()));
        stocks.add(new Stock("Fake Sirius Satellite", "SIRI", -.03, getRandomDate()));
        stocks.add(new Stock("Fake A", "SIRI", -1.03, new Date()));
        stocks.add(new Stock("Fake A", "SIRI", -.04, new Date()));

        return stocks;
    }

    public static Date getRandomDate() {
        return getRandomDate(1970);
    }

    public static Date getRandomDate(int startYear) {
        int year = startYear + (int) (Math.random() * 30);
        int month = (int) (Math.random() * 12);
        int day = (int) (Math.random() * 28);
        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
        return calendar.getTime();
    }
}