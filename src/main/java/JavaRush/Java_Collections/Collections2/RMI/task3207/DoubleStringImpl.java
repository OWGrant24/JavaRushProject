package JavaRush.Java_Collections.Collections2.RMI.task3207;
import java.rmi.RemoteException;

public class DoubleStringImpl implements DoubleString {
    public String doubleString(String str) throws RemoteException {
        return str + str;
    }
}
