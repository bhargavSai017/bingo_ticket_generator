import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TicketGenerator {
    private static final int STRIP_TICKETS_COUNT = 6;
    public static final int COLUMN_COUNT = 9;
    public static final int ROW_COUNT = 3;
    public static final int NUMBERS_IN_TICKET = 15;
    public  static final int NUMBERS_PER_ROW = 5;

    /*
    * Generates the Ticket strip (6 tickets) without any duplication
     */
    public List<int[][]> generateTickets() {
        Set<Integer> usedNos = new HashSet<>();
        List<int[][]> tickets = new ArrayList<>();
        Random rand = new Random();
        for (int tNum = 0; tNum < STRIP_TICKETS_COUNT; tNum++) {
            int[][] ticket = new int[ROW_COUNT][COLUMN_COUNT];
            int numbersInserted = 0;
            // Random positions list is created for better number distribution
            List<Integer> positions = createRandomPositions();
            for (Integer position : positions) {
                int rowIndex = generateIndices(position, true);
                int colIndex = generateIndices(position, false);
                Set<Integer> rowSet = Arrays.stream(ticket[rowIndex]).boxed().collect(Collectors.toSet());
                // Check for the number of integers per row/ column and fill the spaces accordingly.
                if ((rowSet.size() - 1) < NUMBERS_PER_ROW && isColumnFilled(colIndex, ticket)) {
                    int rangeStart = colIndex > 0 ? (colIndex * 10) : 1;
                    int rangeEnd = (colIndex == COLUMN_COUNT - 1) ? 90 : ((colIndex + 1) * 10) + 1;
                    int numToInsert = getRandomNumber(rangeEnd, rangeStart, usedNos);
                    ticket[rowIndex][colIndex] = numToInsert;
                    usedNos.add(numToInsert);
                    numbersInserted++;
                }
                if (numbersInserted == NUMBERS_IN_TICKET) {
                    break;
                }
            }
            tickets.add(ticket);
        }

        return tickets;
    }

    /*
    * Generates the row index/ column index based on the parameters position and isRow
     */
    private int generateIndices(int position, Boolean isRow) {
        int index;
        if(position >= 0 && position < 9) {
            index = isRow ? 0 : position;
        } else if (position >=9 && position < 18) {
            index = isRow ? 1 : position - 9;
        } else {
            index = isRow? 2 : position - 18;
        }
        return index;
    }

    /*
    * Creates random positions list for each Ticket
     */
    private List<Integer> createRandomPositions() {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < 27; i++) {
            positions.add(i);
        }
        Collections.shuffle(positions);
        return positions;
    }

    /*
    * Checks if each column is filled with atleast one integer based on the column index and the ticket array
     */
    private  boolean isColumnFilled(int index, int[][] ticket) {
        int count = 0;
        for(int row =0; row<ROW_COUNT; row++) {
            if(ticket[row][index]!=0) {
                count++;
            }
        }
        return count < 2;
    }


    /*
    * Generates random integers within the range of start and end and checks against
    * usedNumbers set, so that no duplicates are returned.
     */
    private int getRandomNumber(int end, int start, Set<Integer> usedNumbers) {
        if(usedNumbers.isEmpty()) {
            return start;
        }else {
            int generatedNum = 0;
            List<Integer> randomNumbersInRange = IntStream.range(start, end-1)
                    .boxed()
                    .collect(Collectors.toList());
            Collections.shuffle(randomNumbersInRange);
            for(int item : randomNumbersInRange) {
                if(!usedNumbers.contains(item)){
                    return item;
                }
            }
            return generatedNum;
        }
    }
}
