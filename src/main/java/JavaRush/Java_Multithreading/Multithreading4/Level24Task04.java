package JavaRush.Java_Multithreading.Multithreading4;
/*
В классе Rectangle:
1. Измени методы getHeight и getWidth, чтобы они возвращали объекты типов
HasHeight и HasWidth соответственно. +
2. Для этого внутри методов getHeight и getWidth создай локальные классы -
реализации интерфейсов.
3. Переименуй getHeight в castToHasHeight, getWidth в castToHasWidth
(на имени метода нажми Shift+F6).
4. Убери наследование интерфейсов в классе Rectangle.

P.S. Ожидается, что после внесения требуемых изменений,
закомментированный код в методе станет рабочим и должен быть раскомментирован.
 */
public class Level24Task04 {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(1, 2, 3, 4);
//        System.out.println(getHeight(rectangle));
//        System.out.println(getWidth(rectangle));
        /////////////////////expected//////////////////
        System.out.println(getHeight(rectangle.castToHasHeight()));
        System.out.println(getWidth(rectangle.castToHasWidth()));
    }

    public static double getHeight(Level24Task04_HasHeight rectangle) {
        return rectangle.getHeight();
    }

    public static double getWidth(Level24Task04_HasWidth rectangle) {
        return rectangle.getWidth();
    }


    public static class Rectangle {
        private Level24Task04_Point point1;
        private Level24Task04_Point point2;

        public Rectangle(double x1, double y1, double x2, double y2) {
            point1 = new Level24Task04_Point(x1, y1);
            point2 = new Level24Task04_Point(x2, y2);
        }

        public Level24Task04_HasHeight castToHasHeight(){
            return new Level24Task04_HasHeight() {
                @Override
                public double getHeight() {
                    return Math.abs(point1.getY() - point2.getY());
                }
            };
        }

        public Level24Task04_HasWidth castToHasWidth() {
            return new Level24Task04_HasWidth() {
                @Override
                public double getWidth() {
                    return Math.abs(point1.getX() - point2.getX());
                }
            };
        }
    }
}