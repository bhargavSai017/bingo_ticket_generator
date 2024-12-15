import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BingoTester {

    // Unit test for ticket generation
    public void unitTest() {
        TicketGenerator tg = new TicketGenerator();
        List<int[][]> tickets = tg.generateTickets();

        // Test to check for duplicate numbers across the strip
        Set<Integer> allNumbers = new HashSet<>();
        for (int[][] ticket : tickets) {
            for (int row = 0; row < TicketGenerator.ROW_COUNT; row++) {
                for (int col = 0; col < TicketGenerator.COLUMN_COUNT; col++) {
                    if (ticket[row][col] != 0) {
                        if (!allNumbers.add(ticket[row][col])) {
                            throw new AssertionError("Duplicate number found!");
                        }
                    }
                }
            }
        }
        System.out.println("Unit Test Passed: No duplicates across tickets.");
    }
}
