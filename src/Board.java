//
// Working generating but leaves blanks. To be rewritten with backtracking (recursion)
//
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;

public class Board {
    public Board() {
        this.board = new Tile[9][9];
    }

    public Tile[][] board;

    public void initEmptyBoard() {
        for(int y = 0; y < 9; y++) {
            for(int x = 0; x < 9; x++) {
                this.board[x][y] = new Tile(0, Collections.emptyList(), 0);
            }
        }
    }

    public void printBoard() {
        for(int y = 0; y < 9; y++) {
            for(int x = 0; x < 9; x++) {
                // Print board values
                if(this.board[x][y].value > 0) {
                    System.out.print(this.board[x][y].value + " ");
                } else {
                    System.out.print("- ");
                }

                // Vertical separator
                if((x + 1) % 3 == 0 && (x + 1) < 9) {
                    System.out.print("| ");
                }
            }

            // Horizontal separator
            System.out.println();

            if((y + 1) % 3 == 0 && (y + 1) < 9) {
                for(int i = 0; i < 21; i++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }
    }

    public void fillBoard() {
        List<Integer> choices = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        // Generate the first row
        for(int y = 0; y < 9; y++) {
            fillRow(new ArrayList<>(choices), y);
        }
    }

    private void fillRow(List<Integer> choices, int row) {
        Random random = new Random();

        for(int x = 0; x < 9; x++) {
            List<Integer> columnChoices = getValidChoices(x, row, choices);

            // Take out random number from the list
            if(columnChoices.isEmpty()) {
                System.out.println("Can't generate tile (x:y) - " + (x+1) + ":" + (row+1));
            } else {
                int randomIndex = random.nextInt(columnChoices.size());
                this.board[x][row].value = columnChoices.remove(randomIndex);
            }
        }
    }

    private List<Integer> getValidChoices(int col, int row, List<Integer> choices) {
        // Clear choices from other values in the row
        for(int i = 0; i < 9; i++) {
            choices.remove((Integer) this.board[i][row].value);
        }

        List<Integer> columnChoices = new ArrayList<>(choices);
        // Clear choices from other values in the column
        for(int y = 0; y < 9; y++) {
            columnChoices.remove((Integer) this.board[col][y].value);
        }

        // Clear choices for the 3x3
        int initValueForI = (col / 3) * 3;
        int initValueForJ = (row / 3) * 3;
        for(int i = initValueForI; i < initValueForI + 3; i++) {
            for(int j = initValueForJ; j < initValueForJ + 3; j++) {
                columnChoices.remove((Integer) this.board[i][j].value);
            }
        }

        return columnChoices;
    }
}