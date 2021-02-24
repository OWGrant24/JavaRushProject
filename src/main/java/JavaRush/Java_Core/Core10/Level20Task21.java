package JavaRush.Java_Core.Core10;

import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* Сериализация под запретом
Запрети сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя.
 */
public class Level20Task21 implements Serializable {
     public static class SubSolution extends Level20Task21 {
        private void writeObject (ObjectOutputStream oos) throws NotSerializableException {
            throw new NotSerializableException();
        }
         private void readObject (ObjectInputStream ois) throws NotSerializableException {
             throw new NotSerializableException();
         }
     }

    public static void main(String[] args) {

    }
}