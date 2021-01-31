package Core.Core10;

import java.io.*;

/*
Externalizable для апартаментов
Реализуй интерфейс Externalizable в классе Apartment.
*/
public class Level20Task11 {
    public static class Apartment implements Externalizable {
        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() {
            super();
        }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        /**
         * Prints out the fields used for testing!
         */
        public String toString() {
            return ("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(address);
            out.writeInt(year);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            address = (String) in.readObject();
            year = in.readInt();
        }
    }

    public static void main(String[] args) {
            Apartment apartment = new Apartment("Греция", 1990);
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(
                "Exp\\2011.dat"))){
            apartment.writeExternal(objectOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
            Apartment apartment1 = new Apartment("Италия",888);

        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(
                "Exp\\2011.dat"))) {
            apartment1.readExternal(objectInputStream);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(apartment1.toString());

    }
}
