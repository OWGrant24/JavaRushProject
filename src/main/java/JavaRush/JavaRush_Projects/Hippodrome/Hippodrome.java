package JavaRush.JavaRush_Projects.Hippodrome;
import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }
    public List<Horse> getHorses() {
        return horses;
    }

    public void run() {
        for(int i = 1; i<=100 ; i++){
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void move() {
        for(Horse horse : horses){
            horse.move();
        }

    }
    public void print() {
        for(Horse horse : horses){
            horse.print();
        }
        for(int i = 0; i<10; i++){
            System.out.println();
        }
    }
    public Horse getWinner(){ // должен возвращать лощадь прибежавшую самую большую дистанцию
        double temp = 0;
        for (Horse horse : horses) {
            double dis = horse.distance;
            if (dis > temp) {
                temp = dis;
            }
        }
        for (Horse horse2 : horses) {
            if (temp == horse2.distance) {
                return horse2;
            }
        }
        return null;
    }
    public void printWinner(){ // выводит на экран имя победителя
        System.out.println("Winner is " + getWinner().name);
    }
    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>());

        Horse grace = new Horse("Грейс",3,0);
        Horse luna = new Horse("Луна",3,0);
        Horse romboy = new Horse("Ромбой",3,0);

        game.getHorses().add(grace);
        game.getHorses().add(luna);
        game.getHorses().add(romboy);
        Hippodrome.game.move();
        game.run();
        game.printWinner();
    }

}
