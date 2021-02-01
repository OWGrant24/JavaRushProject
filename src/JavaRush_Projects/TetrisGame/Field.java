package JavaRush_Projects.TetrisGame;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private int width; // ширина
    private int height; // высота
    private int[][] matrix;
    // Первой координатой в массиве будет номер строки, а второй столбца
    // Другими словами ячейка с координатами x,y - это matrix[y][x]

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new int[height][width];
    }

    void print() {
        // объект будет отрисовывать на экран свое текущее состояние
        // Кол-во строк = height
        // Кол-во символов в строке - width
        int[][] array = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                array[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (array[i][j] == 0) {
                    System.out.print(" . ");
                } else {
                    System.out.print(" X ");
                }
            }
            System.out.print("\n");
        }
    }

    void removeFullLines() {
        // будет удалять из матрицы полностью заполненые строки
        // и сдвигать выщележащие строки вниз
        List<int[]> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            int count = 0;
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                }
            }
            if (count != height) {
                lines.add(matrix[i]);
            }
        }
        int diff = width - lines.size();
        for(int i = 0 ; i < diff; i++){
            lines.add(0,new int[width]);
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i] = lines.get(i);
            }
        }
    }

    Integer getValue(int x, int y) {
        // Возвращает значение которое находится в матрице с коорднатами x, y

        return 0;
    }

    void setValue(int x, int y, int value) {
        // Устанавливает переданное значение в ячейку массива (матрицы) с координатами x, y

    }


}
