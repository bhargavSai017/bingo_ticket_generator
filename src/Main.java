import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        TicketGenerator tg = new TicketGenerator();
        List<int[][]> bingoTickets = tg.generateTickets();

        System.out.println("\033[4;1mNote: 0's present in each ticket below represent empty values\033[0m");

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        IntStream.range(0, bingoTickets.size()).forEach(index-> {
            int[][] ticket = bingoTickets.get(index);
            System.out.println("\033[4;1mTicket "+(index+1)+ ":\033[0m");
            for(int row = 0; row< TicketGenerator.ROW_COUNT; row++) {
                for(int col = 0; col<TicketGenerator.COLUMN_COUNT; col++) {
                    System.out.printf("%2d ",ticket[row][col]);
                }
                System.out.println();
            }
            System.out.println("--------------------------");
        });
        System.out.println("Time taken to generate 1 strip: " + duration + " ms");

        BingoTester tester = new BingoTester();
        tester.unitTest();
    }
}