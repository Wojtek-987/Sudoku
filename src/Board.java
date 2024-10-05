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
                this.board[x][y] = new Tile(0, Collections.emptyList());
            }
        }
    }

    public void saveValidValues() {
        for(int y = 0; y < 9; y++) {
            for(int x = 0; x < 9; x++) {
                this.board[x][y].requiredValue = this.board[x][y].getValue();
            }
        }
    }

    public void printBoard() {
        for(int y = 0; y < 9; y++) {
            for(int x = 0; x < 9; x++) {
                // Print board values
                if(this.board[x][y].getValue() > 0) {
                    System.out.print(this.board[x][y].getValue() + " ");
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
        // Recursively fill board with backtracking
        fillTile(0, 0);
        saveValidValues();
    }

    private boolean fillTile(int x, int y) {
        // If board is filled
        if (y == 9) return true;

        Random random = new Random();
        List<Integer> validChoices = getValidChoices(x, y);

        // Try valid numbers for Tile
        while (!validChoices.isEmpty()) {
            int randomIndex = random.nextInt(validChoices.size());
            this.board[x][y].setValue(validChoices.remove(randomIndex));

            // If next Tile is fillable
            int nextX = (x + 1) % 9;
            int nextY = (x + 1) == 9 ? y + 1 : y;

            if(fillTile(nextX, nextY)) {
                return true;
            }

            // Backtrack if next Tile is not fillable
            this.board[x][y].setValue(0);
        }

        // No valid value for Tile
        return false;
    }

    private List<Integer> getValidChoices(int col, int row) {
        List<Integer> choices = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        // Clear choices from other values in the row
        for(int i = 0; i < 9; i++) {
            choices.remove((Integer) this.board[i][row].getValue());
        }

        List<Integer> columnChoices = new ArrayList<>(choices);
        // Clear choices from other values in the column
        for(int y = 0; y < 9; y++) {
            columnChoices.remove((Integer) this.board[col][y].getValue());
        }

        // Clear choices for the 3x3
        int initValueForI = (col / 3) * 3;
        int initValueForJ = (row / 3) * 3;
        for(int i = initValueForI; i < initValueForI + 3; i++) {
            for(int j = initValueForJ; j < initValueForJ + 3; j++) {
                columnChoices.remove((Integer) this.board[i][j].getValue());
            }
        }

        return columnChoices;
    }

    public void removeValues(int count) {
        Random random = new Random();

        while(count > 0) {
            int randX = random.nextInt(9);
            int randY = random.nextInt(9);

            if(this.board[randX][randY].getValue() > 0) {
                this.board[randX][randY].setValue(0);

                // If is solvable (always returns true for now - solver not implemented)
                if(Solver.canSolve(this)) {
                    count--;
                } else {
                    this.board[randX][randY].setValue(this.board[randX][randY].requiredValue);
                }
            }
        }
    }
}