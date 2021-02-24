package JavaRush.Java_Multithreading.Multithreading4;
/*
Black box
1. Восстанови логику метода someAction для поля solutionAction.
2. Пример вывода смотри в комментарии к методу main.
3. Подсказка: метод someAction анонимного класса поля solutionAction
должен вызвать метод сабкласса FirstClass, если param > 0, иначе вызвать метод
сабкласса SecondClass.

Не изменяй метод main!
- Поле children должно быть расположено в классе Human,
и не должно быть расположено в классах Teacher и Student.
- Сеттер и геттер для поля children должны быть расположены в классе Human,
и не должны быть расположены в классах Teacher и Student.
- Метод getChildren в классе Human должен возвращать Collections.unmodifiableList(children).
- Необходимо удалить метод setChildren из класса Human.
- Необходимо добавить методы addChild (Human) и removeChild (Human)
в класс Human, и реализовать их.
*/
public class Level24Task05 implements Level24Task05_Action {
        public static int countActionObjects;

        private int param;

        private Level24Task05_Action solutionAction = new Level24Task05_Action() {
            //напишите тут ваш код

            public void someAction() {
                //напишите тут ваш код
                for(int i = 5; i>0; i--) {
                    System.out.println(i);
                }
                if(param>0){
                    Level24Task05_FirstClass firstClass = new Level24Task05_FirstClass() {
                        @Override
                        public Level24Task05_Action getDependantAction() {
                            return null;
                        }
                    };
                }
            }
        };


    public Level24Task05( int param ){
        this.param = param;
    }

        @Override
        public void someAction () {
        solutionAction.someAction();
    }

        /**
         * 5
         * 4
         * 3
         * 2
         * 1
         * class FirstClass, method someAction
         * class SecondClass, method someAction
         * Specific action for anonymous SecondClass, param = 0
         * Count of created Action objects is 2
         * class SecondClass, method someAction
         * Specific action for anonymous SecondClass, param = -1
         * Count of created Action objects is 3
         */
        public static void main (String[] args){
        Level24Task05 solution = new Level24Task05(5);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);

        solution = new Level24Task05(-1);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);
    }
}