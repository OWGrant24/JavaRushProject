package JavaRush_Projects.TetrisGame;

public class Figure { // Класс описывает подающую фигуру
    // Координаты
    private int x;
    private int y;
    private int[][] matrix; // Состоит из 0, 1;
    // 1- клетка есть 0 - пустая

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public Figure(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }
    void left(){ // Для движения фигурки влево
        x--;
        if(!isCurrentPositionAvailable()){
            x++;
        }
    }
    void right(){ // Для движения фигурки вправо
        x++;
        if(!isCurrentPositionAvailable()){
            x--;
        }
    }
    void down(){ // Для движения фигурки вниз
        y++;
    }
    void up(){ // Для движения фигурки вверх
        y--;
    }
    void rotate(){ // Для поворота фигурки вокруг главной диагонали

    }
    void downMaximum(){ // Падение фигурки вниз до дна

    }

    boolean isCurrentPositionAvailable(){ // Проверка, может ли фигурка быть помещена в текущую позицию
        return true;
    }
    void landed(){  // Вызывается, когда фигурка достигла дна или уперлась в другую фигурку.
        // Все её занятые клетки должны добавиться в Field

    }


}
