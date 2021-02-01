package Java_Multithreading.Multithreading4;
/*
В работе вам иногда будет нужно закастить класс к какому-нибудь интерфейсу (тут Sayable),
который не реализован в текущем классе
 */

public class Level24Task07_Cat implements Level24Task07_Pet {
    private String name;

    public Level24Task07_Cat(String name) {
        this.name = name;
    }


    /**
     * Это - механизм адаптирования к другому интерфейсу - Sayable
     * Внутри метода toSayable создайте class CatPet, реализующий интерфейс Sayable
     * Логика метода say:
     * Если i < 1, то вывести на экран, что кот спит. Пример, "Васька спит."
     * Иначе вывести фразу: "имя_кота говорит мяу!". Пример для i=3, "Васька говорит мяяяу!"
     * <p/>
     * <b>Пример вывода:</b>
     * Мурзик спит.
     * Васька говорит мяяу!
     * Кошка говорит мяяяяяу!
     * Мышь пищит.
     * Томас говорит мяу!
     * <p/>
     *
     * @param i количество букв 'я' в слове мяу
     * @return экземпляр класса CatPet
     */
    public Level24Task07_Sayable toSayable(final int i) {

        class CatPet implements Level24Task07_Sayable {

            @Override
            public String say() {
                if(i<1){
                    return name + " спит.";
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(name);
                    sb.append(" говорит м");
                    for(int j = i; j>0; j--){
                        sb.append("я");
                    }
                    sb.append("у!");
                    return sb.toString();
                }
            }
        }
        return new CatPet();
    }
}