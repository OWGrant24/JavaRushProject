package Core6;

/*   Java_Core 6.5
Продвижение на политических дебатах
1. Разберись, что делает программа.
2. Нужно сделать так, чтобы Иванов сказал больше всего речей
на политических дебатах.
3. Подумай, какой метод можно вызвать у объекта ivanov,
чтобы Иванов разговаривал, пока не завершится всё свободное
время.
*/

public class Level16Task08 {
    public static int totalSpeechCount = 200; // количество речей
    public static int utterancesPerSpeech = 1000000; // высказываний в речи

    public static void main(String[] args) throws InterruptedException {
        Politician ivanov = new Politician("Иванов");
        ivanov.join();
        Politician petrov = new Politician("Петров");

        Politician sidorov = new Politician("Сидоров");


        while (ivanov.getSpeechCount() + petrov.getSpeechCount() + sidorov.getSpeechCount() < totalSpeechCount) {
        }

        System.out.println(ivanov);
        System.out.println(petrov);
        System.out.println(sidorov);
    }

    public static class Politician extends Thread {
        private volatile int utteranceCount;  // количество высказываний

        public Politician(String name) {
            super(name);
            start();
        }

        public void run() {
            while (utteranceCount < totalSpeechCount * utterancesPerSpeech) {
                // кол высказываний < кол речей (200) * кол высказываний
                utteranceCount++;
            }
        }

        public int getSpeechCount() {
            return utteranceCount / utterancesPerSpeech;
        }

        @Override
        public String toString() {
            return String.format("%s сказал речь %d раз", getName(), getSpeechCount());
        }
    }
}
