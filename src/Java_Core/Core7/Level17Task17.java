package Core7;
/*
synchronized существенно замедляет программу, поэтому убери избыточность synchronized внутри методов.
 */
public class Level17Task17 {
    char[] value;
    int count;

    public Level17Task17 append(CharSequence s) {
        //synchronized (Level17Task17.class) {
            if (s == null) {
                //synchronized (this) {
                    s = "null";
                //}
            }

            if (s instanceof String) {
                //synchronized (this) {
                    return this.append((String) s);
                //}
            }

            if (s instanceof Level17Task17) {
                //synchronized (this) {
                    return this.appendThis((Level17Task17) s);
                //}
            }
        //}
        return this.append(s);
    }

    public synchronized Level17Task17 appendThis(Level17Task17 s) {
        //do something here....
        return this;
    }

    private static final java.io.ObjectStreamField[] serialPersistentFields =
            {
                    new java.io.ObjectStreamField("value", char[].class),
                    new java.io.ObjectStreamField("count", Integer.TYPE),
                    new java.io.ObjectStreamField("shared", Boolean.TYPE),
            };

    private synchronized void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        java.io.ObjectOutputStream.PutField fields = s.putFields();
        // synchronized (fields) {
            fields.put("value", value);
            fields.put("count", count);
            fields.put("shared", false);
        //}
        //synchronized (s) {
            s.writeFields();
        //}
    }

    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
        //synchronized (new java.io.IOException()) {
            java.io.ObjectInputStream.GetField fields = s.readFields();
            value = (char[]) fields.get("value", null);
            count = fields.get("count", 0);
        //}
    }

    public static void main(String[] args) {

    }
}
