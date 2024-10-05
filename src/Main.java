public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.initEmptyBoard();
        board.fillBoard();
        board.removeValues(35);
        board.printBoard();
    }
}