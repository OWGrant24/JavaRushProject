package Multithreading.Multithreading4;
/* отправляй
1. Создай интерфейс-маркер SelfInterfaceMarker.  +
2. Создай класс SelfInterfaceMarkerImpl, который реализует SelfInterfaceMarker. +
3. Добавь в SelfInterfaceMarkerImpl минимум 2 любых public метода. +
4. Создай исключение UnsupportedInterfaceMarkerException, унаследуй его от класса Exception. +
5. В методе testClass класса Util: если параметр == null,
то выбросьте UnsupportedInterfaceMarkerException.
 */
public class Level24Task01 {
    public static void main(String[] args) throws Level24Task01_UnsupportedInterfaceMarkerException {
        Level24Task01_SelfInterfaceMarkerImpl obj = new Level24Task01_SelfInterfaceMarkerImpl();
        Level24Task01_Util.testClass(obj);
    }
}
