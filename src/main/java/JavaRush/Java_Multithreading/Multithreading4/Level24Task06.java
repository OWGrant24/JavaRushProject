package JavaRush.Java_Multithreading.Multithreading4;

import java.math.BigDecimal;
/*
Наследование от внутреннего класса
Внутри класса Solution создай 2 внутренних public класса Apt3Bedroom, BigHall.
Унаследуй их от Apartments и Hall.
*/

public class Level24Task06 {
    public class Building {
        public class Hall {
            private BigDecimal square;

            public Hall(BigDecimal square) {
                this.square = square;
            }
        }

        public class Apartments {
        }
    }
    public class Apt3Bedroom extends Building.Apartments{
        public Apt3Bedroom(Building apt3Bedroom) {
            apt3Bedroom.super();
        }
    }

    public class BigHall extends Building.Hall{
        public BigHall(Building hall,BigDecimal square) {
            hall.super(square);
        }

    }

    public static void main(String[] args) {

    }
}