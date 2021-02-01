package Java_Multithreading.Multithreading2;

/*
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
 */
public class Level22Task02 {
    public static void main(String[] args) {
        System.out.println(getPartOfString("Java the Best of World"));
    }

    public static String getPartOfString(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        try{
            String[] strings = string.split(" ");
            if (strings.length>4) {
                for (int i = 1; i < 5; i++) {
                    stringBuilder.append(strings[i]);
                    stringBuilder.append(" ");
                }
            } else
                throw new TooShortStringException();
        } catch (Exception e){
            throw new TooShortStringException();
        }
        return stringBuilder.toString().trim();
    }
    public static class TooShortStringException extends RuntimeException{

    }
}

//        if (string == null || string.isEmpty() || string.split(" ").length<4) {
//            throw new TooShortStringException();
//        }
//        String[] strings = string.split(" ");
//        System.out.println(Arrays.toString(strings));
//            StringBuilder stringBuilder = new StringBuilder();
//            for (int i = 1; i < 5; i++) {
//                stringBuilder.append(strings[i]);
//                stringBuilder.append(" ");
//            }
//            String str = stringBuilder.toString();
//            return str.trim();