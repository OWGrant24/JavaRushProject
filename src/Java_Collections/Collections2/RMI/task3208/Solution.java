package Java_Collections.Collections2.RMI.task3208;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/*
RMI-2
Реализуй логику метода run в SERVER_THREAD. В нем будет имитироваться серверная часть:
1) Инициализируй поле registry, которое будет принимать и обрабатывать запросы на 2099 порту.
2) Создай два объекта - Cat и Dog.
3) Используй класс UnicastRemoteObject, чтобы создать Remote объекты для созданных Cat и Dog.
Remote объекты будут в состоянии принимать обращения к своим методам используя выбранный порт (2099).
4) Для Cat и Dog добавь в registry связь уникального текстового ключа и Remote объекта. Текстовый ключ придумай сам.
5) При возникновении любого исключения выведи его стек-трейс в поток System.err.
Метод main не участвует в тестировании.

Требования:
В методе run() необходимо инициализировать поле registry. Для этого используй LocateRegistry.createRegistry (2099).
В методе run() необходимо создать два объекта - Cat и Dog.
В методе run() необходимо создать Remote объекты для созданных Cat и Dog используя UnicastRemoteObject.exportObject (Remote, int).
Для Cat и Dog нужно добавить в registry связь уникального текстового ключа и Remote объекта используя registry.bind (String, Remote).
При возникновении любого исключения нужно вывести его стек-трейс в поток System.err используя метод printStackTrace ().
*/

public class Solution {
    public static final String UNIC_BINDING_NAME_CAT = "CatMeow"; // Уникальное имя удаленного объекта
    public static final String UNIC_BINDING_NAME_DOG = "CatWoof"; // Уникальное имя удаленного объекта
    public static Registry registry;

    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.speak();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    // Pretend we're starting an RMI server as the SERVER_THREAD thread
    public static Thread SERVER_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            //напишите тут ваш код
            Remote stubCat = null;
            Remote stubDog = null;
            try {
                registry = LocateRegistry.createRegistry(2099);
                //  Создание два объекта - Cat и Dog.
                final Cat cat = new Cat("Барсик");
                final Dog dog = new Dog("Песик");
                // Cоздание Remote объекты для созданных Cat и Dog используя UnicastRemoteObject.exportObject (Remote, int).
                stubCat = UnicastRemoteObject.exportObject(cat, 0);
                stubDog = UnicastRemoteObject.exportObject(dog, 0);
                // Для Cat и Dog нужно добавить в registry связь уникального текстового ключа и Remote объекта используя registry.bind (String, Remote).
                registry.bind(UNIC_BINDING_NAME_CAT, stubCat);
                registry.bind(UNIC_BINDING_NAME_DOG, stubDog);
            } catch (RemoteException | AlreadyBoundException e) {
                e.printStackTrace();
            }
        }
    });


    public static void main(String[] args) throws InterruptedException {
        // Starting an RMI server thread
        SERVER_THREAD.start();
        Thread.sleep(1000);
        // Start the client
        CLIENT_THREAD.start();
    }
}
