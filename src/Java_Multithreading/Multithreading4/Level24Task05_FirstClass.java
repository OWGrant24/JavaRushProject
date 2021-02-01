package Java_Multithreading.Multithreading4;

public abstract class Level24Task05_FirstClass implements Level24Task05_Action {
    protected Level24Task05_FirstClass() {
        Level24Task05.countActionObjects++;
    }

    public void someAction() {
        System.out.println("class FirstClass, method someAction");
    }

    public abstract Level24Task05_Action getDependantAction();
}