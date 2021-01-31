package _2048;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4; //определяющая ширину игрового поля.
    private Tile[][] gameTiles; // Приватный двумерный массив gameTiles состоящий из объектов класса Tile.
    int score = 0;
    int maxTile = 2;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    public void autoMove() {
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue<>(4, Collections.reverseOrder());
        priorityQueue.offer(getMoveEfficiency(this::left));
        priorityQueue.offer(getMoveEfficiency(this::up));
        priorityQueue.offer(getMoveEfficiency(this::down));
        priorityQueue.offer(getMoveEfficiency(this::right));
        assert priorityQueue.peek() != null;
        priorityQueue.peek().getMove().move();
    }

    private boolean hasBoardChanged() {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value != previousStates.peek()[i][j].value) {
                    return true;
                }
            }
        }
        return false;
    }

    private MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency moveEfficiency = new MoveEfficiency(-1, 0, move);
        move.move();
        if (hasBoardChanged()) {
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        }
        rollback();
        return moveEfficiency;
    }

    private void saveState(Tile[][] tile) {
        Tile[][] pS = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {     //идём по строкам
            for (int j = 0; j < FIELD_WIDTH; j++) {
                pS[i][j] = new Tile(tile[i][j].value);
            }
        }
        previousStates.push(pS);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 0:
                left();
            case 1:
                right();
            case 2:
                up();
            case 3:
                down();
        }
    }

    public void rollback() {
        if (!previousStates.empty()) {
            gameTiles = previousStates.pop();
        }
        if (!previousScores.empty()) {
            score = previousScores.pop();
        }
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public boolean canMove() {
        for (int i = 0; i < FIELD_WIDTH; i++) {     //идём по строкам
            for (int j = 0; j < FIELD_WIDTH; j++) {     //идём по столбцам
                if (gameTiles[i][j].isEmpty()) return true;
                if (i != 0 && gameTiles[i - 1][j].value == gameTiles[i][j].value)
                    return true;
                if (j != 0 && gameTiles[i][j - 1].value == gameTiles[i][j].value)
                    return true;
            }
        }
        return false;
    }

    public Model() {
        resetGameTiles();
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> list = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {     //идём по строкам
            for (int j = 0; j < FIELD_WIDTH; j++) {     //идём по столбцам
                if (gameTiles[i][j].isEmpty()) {
                    list.add(gameTiles[i][j]);
                }
            }
        }
        return list;
    }

    private void addTile() {
        List<Tile> list = getEmptyTiles();
        if (list.size() > 0) {
            int a = (int) (list.size() * Math.random() * 1); // Выбор клетки случайным образом
            list.get(a).value = Math.random() < 0.9 ? 2 : 4; // Задание нового веса плитки
        }
    }

    void resetGameTiles() {
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {     //идём по строкам
            for (int j = 0; j < FIELD_WIDTH; j++) {     //идём по столбцам
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    void resetGameTilesExp() {
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        this.gameTiles[0][0] = new Tile(4096);
        this.gameTiles[0][1] = new Tile(1024);
        this.gameTiles[0][2] = new Tile(1024);
        this.gameTiles[0][3] = new Tile(1024);
        this.gameTiles[1][0] = new Tile(1024);
        this.gameTiles[1][1] = new Tile(1024);
        this.gameTiles[1][2] = new Tile(1024);
        this.gameTiles[1][3] = new Tile(1024);
        this.gameTiles[2][0] = new Tile(1024);
        this.gameTiles[2][1] = new Tile(1024);
        this.gameTiles[2][2] = new Tile(1024);
        this.gameTiles[2][3] = new Tile(1024);
        this.gameTiles[3][0] = new Tile(1024);
        this.gameTiles[3][1] = new Tile(1024);
        this.gameTiles[3][2] = new Tile(1024);
        this.gameTiles[3][3] = new Tile(2);
    }

    private Tile[][] rotateClockwise(Tile[][] tiles) {
        final int N = tiles.length;
        Tile[][] result = new Tile[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                result[c][N - 1 - r] = tiles[r][c];
            }
        }
        return result;
    }

    public void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        int check = 0;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                check = 1;
            }
        }
        if (check > 0) {
            addTile();
            System.out.println("Добавил");
        }
        for (int i = 0; i < gameTiles.length; i++)
            for (int j = 0; j < gameTiles.length; j++)
                System.out.println(gameTiles[i][j].value);
        isSaveNeeded = true;
    }

    public void right() {
        saveState(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        left();
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
    }

    public void up() {
        saveState(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        left();
        gameTiles = rotateClockwise(gameTiles);
    }

    public void down() {
        saveState(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        left();
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
    }

    private boolean compressTiles(Tile[] tiles) { // сжатие
        int insertPosition = 0;
        boolean result = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (!tiles[i].isEmpty()) {
                if (i != insertPosition) {
                    tiles[insertPosition] = tiles[i];
                    tiles[i] = new Tile();
                    result = true;
                }
                insertPosition++;
            }
        }
        return result;
    }


    private boolean mergeTiles(Tile[] tiles) { // слияние
        boolean result = false;
        List<Tile> tilesList = new ArrayList<>(4);
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (tiles[i].isEmpty()) {
                continue;
            }

            if (i < FIELD_WIDTH - 1 && tiles[i].value == tiles[i + 1].value) {
                int updatedValue = tiles[i].value * 2;
                if (updatedValue > maxTile) {
                    maxTile = updatedValue;
                }
                score += updatedValue;
                tilesList.add(new Tile(updatedValue));
                tiles[i + 1].value = 0;
                result = true;
            } else {
                tilesList.add(new Tile(tiles[i].value));
            }
            tiles[i].value = 0;
        }

        for (int i = 0; i < tilesList.size(); i++) {
            tiles[i] = tilesList.get(i);
        }
        return result;
    }
}
//private boolean hasBoardChanged(){
//        return Arrays.equals(gameTiles, previousStates.peek());
//    }