package hello.world;

public class Cinema {
    private int[][][] cinemaHall = new int[5][10][20];

    public void bookSeats(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            if (cinemaHall[hallNumber][row][seat] == 0) {
                cinemaHall[hallNumber][row][seat] = 1;
            } else {
                System.out.println("Місце " + seat + " вже заброньовано.");
            }
        }
    }

    public void cancelBooking(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            if (cinemaHall[hallNumber][row][seat] == 1) {
                cinemaHall[hallNumber][row][seat] = 0;
            } else {
                System.out.println("Місце " + seat + " не було заброньовано.");
            }
        }
    }

    public void checkAvailability(int hallNumber, int numSeats) {
        for (int i = 0; i < 10; i++) {
            int availableSeats = 0;
            for (int j = 0; j < 20; j++) {
                if (cinemaHall[hallNumber][i][j] == 0) {
                    availableSeats++;
                    if (availableSeats == numSeats) {
                        System.out.println("Доступно " + numSeats + " місць в ряду " + i + " залу " + hallNumber);
                        return;
                    }
                } else {
                    availableSeats = 0;
                }
            }
        }
        System.out.println("Немає " + numSeats + " доступних місць в залі " + hallNumber);
    }

    public void printSeatingArrangement(int hallNumber) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(cinemaHall[hallNumber][i][j] + " ");
            }
            System.out.println();
        }
    }
}

