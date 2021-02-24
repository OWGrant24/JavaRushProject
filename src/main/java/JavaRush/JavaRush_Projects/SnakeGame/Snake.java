package JavaRush.JavaRush_Projects.SnakeGame;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }
    public void move(){
        if (isAlive) {
            if(direction == SnakeDirection.UP) {
                move(0,-1);
            } else if (direction == SnakeDirection.RIGHT){
                move(1,0);
            } else if (direction == SnakeDirection.DOWN){
                move(0,1);
            } else if (direction == SnakeDirection.LEFT){
                move(-1,0);
            }
        }
    }
    public void move(int x, int y) {
        SnakeSection head = new SnakeSection(sections.get(0).getX() + x,sections.get(0).getX() + y);
        checkBorders(head);
        checkBody(head);
        if (isAlive){
            sections.add(0,head);
            sections.remove(sections.size()-1);
        }
        if(head.getX() == Room.game.getMouse().getX() && head.getY() == Room.game.getMouse().getY()) {
            Room.game.eatMouse();
            sections.add(0,head);
        }
    }

    public void checkBorders(SnakeSection head){
        if(head.getX()>=Room.game.getWidth() || head.getY()>=Room.game.getHeight() ||
           head.getX()<0 || head.getY()<0){
            isAlive = false;
        }
    }
    public void checkBody(SnakeSection head){
        if(sections.contains(head)){
            isAlive = false;
        }
    }
    public int getX(){
        return sections.get(0).getX();
    }
    public int getY(){
        return sections.get(0).getY();
    }

    public Snake(int x, int y) { // Координаты головы змеи
        this.sections  = new ArrayList<>();
        this.isAlive = true;
        SnakeSection section = new SnakeSection(x,y); // Создание первого кусочка змеи
        sections.add(section);
    }






}
