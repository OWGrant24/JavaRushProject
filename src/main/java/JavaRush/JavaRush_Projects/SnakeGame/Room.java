package JavaRush.JavaRush_Projects.SnakeGame;

import java.awt.event.KeyEvent;

public class Room {
    public static Room game;
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;


    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
        game = this;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Snake getSnake() {
        return snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    /**
     * Основной цикл программы.
     * Тут происходят все важные действия
     */
    public void run() throws InterruptedException {
        //Создаем объект "наблюдатель за клавиатурой" и стартуем его.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //пока змея жива
        while (snake.isAlive()) {
            //"наблюдатель" содержит события о нажатии клавиш?
            if (keyboardObserver.hasKeyEvents()) {
                KeyEvent event = keyboardObserver.getEventFromTop();
                //Если равно символу 'q' - выйти из игры.
                if (event.getKeyChar() == 'q') return;

                //Если "стрелка влево" - сдвинуть фигурку влево
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    snake.setDirection(SnakeDirection.LEFT);
                    //Если "стрелка вправо" - сдвинуть фигурку вправо
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    snake.setDirection(SnakeDirection.RIGHT);
                    //Если "стрелка вверх" - сдвинуть фигурку вверх
                else if (event.getKeyCode() == KeyEvent.VK_UP)
                    snake.setDirection(SnakeDirection.UP);
                    //Если "стрелка вниз" - сдвинуть фигурку вниз
                else if (event.getKeyCode() == KeyEvent.VK_DOWN)
                    snake.setDirection(SnakeDirection.DOWN);
            }

            snake.move();   //двигаем змею
            print();        //отображаем текущее состояние игры
            sleep();        //пауза между ходами
        }

        System.out.println("Game Over!");
    }

    public void print() {
        int[][] matrix = new int[height][width];
        matrix[snake.getY()][snake.getX()] = 2;
        for(int i=1; i<snake.getSections().size(); i++){
            matrix[snake.getSections().get(i).getY()][snake.getSections().get(i).getX()] = 1;
        }
        matrix[mouse.getY()][mouse.getX()]=3; // Мышь
        for(int i = 0; i < height; i++){
            for(int j = 0; j< width; j++){
                if (matrix[i][j] == 1) System.out.print('x');
                else if (matrix[i][j] == 2) System.out.print("X");
                else if (matrix[i][j] == 3) System.out.print("^");
                else System.out.print(".");
            }
            System.out.println();
        }
        //Рисуем мышь
        //Выводим все это на экран
    }
    public void sleep() throws InterruptedException {
        if((game.getSnake().getSections().size())<15){
            Thread.sleep(500-20*(game.getSnake().getSections().size()-1));
        } else if(game.getSnake().getSections().size()-1>=15){
            Thread.sleep(200);
        }

    }
    public void createMouse(){
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);
        mouse = new Mouse(x,y);
    }
    public void eatMouse(){
        createMouse();
    }


    public static void main(String[] args) throws InterruptedException {
        Snake snake = new Snake(0,0);
        game = new Room(1,1, snake);
        snake.setDirection(SnakeDirection.DOWN);
        game.createMouse();
        game.run();
        game.sleep();
    }
}
