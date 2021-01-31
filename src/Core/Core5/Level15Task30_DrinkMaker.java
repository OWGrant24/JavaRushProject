package Core.Core5;

public abstract class Level15Task30_DrinkMaker {
    public abstract void getRightCup();   //выбрать подходящую чашку

    public abstract void putIngredient();  //положить ингредиенты

    public abstract void pour();   //залить жидкостью

    public void makeDrink(){
        getRightCup();
        putIngredient();
        pour();
    }
}
