package software.ulpgc.kata6;

public class TicTacToe {
    private static final String cross = "X";
    private static final String circle = "O";
    private final String[] board;


    public TicTacToe(String[] board) {
        this.board = board;
    }
    public TicTacToe(String state){
        this(state.split("\n"));
    }

    public String state(){
        return String.join("\n", board);
    }

    public TicTacToe next() {
        return new TicTacToe(calculateNextSate());
    }

    private String[] calculateNextSate() {
        String[] result = new String[rows()];
        for (int i=0; i < rows(); i++){
            result[i] = calculateNextState(i);
        }
        return result;
    }

    private String calculateNextState(int row) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < cols(); i++){
            result.append(calculateNextSate(row, i));
        }
        System.out.println(result);
        return result.toString();
    }

    private char calculateNextSate(int row, int col) {
        return '.';
    }

    private int rows() {
        return board.length;
    }

    private int cols() {
        return board[0].length();
    }
}
