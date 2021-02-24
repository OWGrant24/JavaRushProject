package JavaRush.Java_Collections.Collections2.RMI.task3212;

import JavaRush.Java_Collections.Collections2.RMI.task3212.contex.InitialContext;
import JavaRush.Java_Collections.Collections2.RMI.task3212.service.Service;
/*
Прочитать о паттерне Service locator.

Реализуй логику метода getService(String jndiName) в ServiceLocator.
В нем будет реализована работа с контекстом и кэшем.

1) Верни из кэша нужный сервис.
2) Если в кэше нет нужного сервиса то:
2.1) Создай контекст.
2.2) Возьми у контекста нужный сервис.
2.3) Добавь сервис в кеш и верни его.

Требования:
Класс ServiceLocator должен содержать метод Service getService(String jndiName).
Если нужный сервис находится в кэше, метод getService(String jndiName) должен возвращать сервис из кэша.
Если нужный сервис НЕ находится в кэше, метод getService(String jndiName) должен создавать контекст.
Если нужный сервис НЕ находится в кэше, метод getService(String jndiName) должен искать нужный сервис в контексте.
Если нужный сервис НЕ находится в кэше, метод getService(String jndiName) должен добавлять в кэш сервис,
найденный в контексте и возвращать его.
 */
public class ServiceLocator {
    private static Cache cache;

    static {
        cache = new Cache();
    }

    /**
     * First, check for a service object in the cache
     * If a service object is not in the cache, perform a lookup using
     * the JNDI initial context and get the service object. Add it to
     * the cache for future use.
     *
     * @param jndiName The name of the service object in the context
     * @return Object mapped to the name in context
     */

    public static Service getService(String jndiName) {
        // Первым делом проерка кеша на экземпляр службы
        Service service = cache.getService(jndiName);
        if(service != null){
            // Если обьект есть в кеше он его и вернет
            return service;
        }
         // А если нет - то произойдет логика инициализации
        InitialContext context = new InitialContext();
        Service service1 = (Service) context.lookup(jndiName);
        cache.addService(service1);
        return service1;
    }
}