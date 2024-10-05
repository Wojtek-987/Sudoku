import java.util.List;

public class Solver {
    public static Board board;
    private static int solutionCount = 0;

    public static boolean hasUniqueSolution(Board board) {
        Solver.board = board;
        List<Tile> empty = board.getEmpty();
        solutionCount = 0;

        // If already solved
        if(empty.isEmpty()) return true;

        Tile firstEmptyTile = empty.getFirst();
        findSolutions(firstEmptyTile.x, firstEmptyTile.y, empty);

        // Reset the empty Tiles' value to 0
        for(Tile tile : empty) {
            tile.setValue(0);
        }

        return solutionCount == 1;
    }

    private static void findSolutions(int x, int y, List<Tile> empty) {
        // If board is filled
        if(y == 9) {
            solutionCount++;
            return;
        }

        List<Integer> validChoices = board.getValidChoices(x, y);

        // Try each valid choice
        for(int choice : validChoices) {
            board.board[x][y].setValue(choice);

            Tile nextTile = getNextEmptyTile(empty, x, y);

            // If no more empty Tiles
            if(nextTile == null) {
                solutionCount++;
            } else {
                findSolutions(nextTile.x, nextTile.y, empty);
            }

            // If failed
            board.board[x][y].setValue(0);

            if(solutionCount > 1) {
                return;
            }
        }
    }

    private static Tile getNextEmptyTile(List<Tile> empty, int x, int y) {
        for(Tile tile : empty) {
            if(tile.x > x || (tile.x == x && tile.y > y)) {
                return tile;
            }
        }

        return null;
    }
}