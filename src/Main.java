public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.initEmptyBoard();
        board.fillBoard();

        board.removeValues(35);

        System.out.println("Board for solving:");
        board.printBoard(true);

        System.out.println("\nSolution:");
        board.printBoard(false);
    }
}