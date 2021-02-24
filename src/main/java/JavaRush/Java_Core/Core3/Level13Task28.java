package JavaRush.Java_Core.Core3;

public class Level13Task28 {
    public static void main(String[] args) {
        Level13Task28_Robot amigo = new Level13Task28_Robot("Амиго");
        Level13Task28_Robot enemy = new Level13Task28_Robot("Сгибальщик-02");

        doMove(amigo, enemy);
        doMove(amigo, enemy);
        doMove(enemy, amigo);
        doMove(amigo, enemy);
        doMove(enemy, amigo);
        doMove(amigo, enemy);
        doMove(enemy, amigo);
        doMove(amigo, enemy);
    }

    public static void doMove(Level13Task28_AbstractRobot robotFirst, Level13Task28_AbstractRobot robotSecond) {
        Level13Task28_BodyPart attacked = robotFirst.attack();
        Level13Task28_BodyPart defenced = robotFirst.defense();
        System.out.println(String.format("%s атаковал робота %s, атакована %s, защищена %s",
                robotFirst.getName(), robotSecond.getName(), attacked, defenced));
    }
}
