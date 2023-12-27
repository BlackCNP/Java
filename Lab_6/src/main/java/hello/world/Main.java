package hello.world;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        // Бронь місць
        int[] Book_1_1 = {2, 3, 4,15};
        cinema.bookSeats(0, 0, Book_1_1);

        cinema.bookSeats(0, 0, new int[]{4});
        cinema.bookSeats(15, 0, new int[]{4});

        cinema.bookSeats(0, 0, new int[]{0});

        int[] Book_1_2 = {2, 19, 7};
        cinema.bookSeats(0, 1, Book_1_2);

        int[] Book_5_10 = {2, 19, 7};
        cinema.bookSeats(4, 9, Book_5_10);

        // схеми
        System.out.println("Після бронювання:");

        System.out.println("Зал 1");
        cinema.printSeatingArrangement(0);

        //System.out.println("Зал 2");
        //cinema.printSeatingArrangement(1);

        //System.out.println("Зал 3");
        //cinema.printSeatingArrangement(2);

        //System.out.println("Зал 4");
        //cinema.printSeatingArrangement(3);

        System.out.println("Зал 5");
        cinema.printSeatingArrangement(4);

        //Скасування

        int[] seatsToCancel = {2, 3};
        cinema.cancelBooking(0, 0, seatsToCancel);

        System.out.println("Після скасування:");

        System.out.println("Зал 1");
        cinema.printSeatingArrangement(0);

        // System.out.println("Зал 2");
        //cinema.printSeatingArrangement(1);

        //System.out.println("Зал 3");
        //cinema.printSeatingArrangement(2);

        //System.out.println("Зал 4");
        //cinema.printSeatingArrangement(3);

        //System.out.println("Зал 5");
        //cinema.printSeatingArrangement(4);

    }
}
