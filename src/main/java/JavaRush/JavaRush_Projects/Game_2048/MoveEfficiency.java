package JavaRush.JavaRush_Projects.Game_2048;
/*
Осталось совсем немного! У нас есть способ вычислить эффективность любого хода, а также мы можем их сравнивать между собой.

Давай реализуем метод autoMove в классе Model, который будет выбирать лучший из возможных ходов и выполнять его.

Сделаем так:
1) Создадим локальную PriorityQueue с параметром Collections.reverseOrder() (для того, чтобы вверху очереди всегда был максимальный элемент) и размером равным четырем.
2) Заполним PriorityQueue четырьмя объектами типа MoveEfficiency (по одному на каждый вариант хода).
3) Возьмем верхний элемент и выполним ход связанный с ним.

После реализации метода autoMove добавим его вызов в метод keyPressed класса Controller по нажатию на клавишу A (код - KeyEvent.VK_A).

P.S. В качестве факультативного задания можешь почитать про указатели на методы
и попробовать передать аргумент в метод getMoveEfficiency используя оператор "::".
Для метода left должно получиться getMoveEfficiency(this::left).
Альтернативно можешь использовать внутренний анонимный класс.
 */
public class MoveEfficiency implements Comparable<MoveEfficiency> {
    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public int compareTo(MoveEfficiency o) {
        if(this.numberOfEmptyTiles < o.numberOfEmptyTiles){
            return -1;
        } else if (this.numberOfEmptyTiles > o.numberOfEmptyTiles) {
            return 1;
        } else {
            if(this.score < o.score){
                return -1;
            } else if(this.score > o.score){
                return 1;
            }
        }
        return 0;
    }
}
