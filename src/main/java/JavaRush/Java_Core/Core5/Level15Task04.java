package JavaRush.Java_Core.Core5;
import java.util.LinkedList;
import java.util.List;

/*    Java_Core 5.2
ООП - книги
1. Создайте public static класс MarkTwainBook,
который наследуется от Book. Имя автора [Mark Twain].
Параметр конструктора - название книги (title).
2. В классе MarkTwainBook реализуйте все абстрактные методы.
3. Для метода getBook измените тип возвращаемого значения на
более подходящий.
4. Создайте по аналогии AgathaChristieBook. Имя автора
[Agatha Christie].
5. В классе Book реализуйте тело метода getOutputByBookType
так, чтобы он возвращал:
5.1. agathaChristieOutput для книг Агаты Кристи;
5.2. markTwainOutput для книг Марка Твена.
*/

public class Level15Task04 {
    public static void main(String[] args) {
        List<Book> books = new LinkedList<>();
        books.add(new MarkTwainBook("Tom Sawyer"));
        books.add(new AgathaChristieBook("Hercule Poirot"));
        System.out.println(books);
        System.out.println(books.get(0).getBook());
    }
    public static class MarkTwainBook extends Book {
        String title;
        public MarkTwainBook(String title) {
            super("Mark Twain");
            this.title = title;
        }

        public MarkTwainBook getBook() {
            return this;
        }
        public String getTitle() {
            return title;
        }
    }
    public static class AgathaChristieBook extends Book {
        String title;

        public AgathaChristieBook(String title) {
            super("Agatha Christie");
            this.title = title;
        }

        public AgathaChristieBook getBook() {
            return this;
        }
        public String getTitle() {
            return title;
        }

    }
    abstract static class Book {
        private String author;

        public Book(String author) {
            this.author = author;
        }

        public abstract Book getBook();

        public abstract String getTitle();

        private String getOutputByBookType() {
            String agathaChristieOutput = author + ": " + getBook().getTitle() + " is a detective";
            String markTwainOutput = getBook().getTitle() + " was written by " + author;

            String output = "output";
            //Add your code here
            if(author.equals("Mark Twain")) {
                output = markTwainOutput;
            } else if (author.equals("Agatha Christie")) {
                output = agathaChristieOutput;
            }
            return output;
        }

        public String toString() {
            return getOutputByBookType();
        }
    }

}
