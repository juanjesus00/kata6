package software.ulpgc.kata6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.stream;


public class TicTacToe {
    private static final char cross = 'X';
    private static final char circle = 'O';
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
        for (int i = 0; i < rows(); i++)
            result[i] = calculateNextState(i);
        return result;
    }
    private String calculateNextState(int row) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < cols(); i++)
            result.append(calculateNextState(row, i));
        return result.toString();
    }
    private char calculateNextState(int row, int col) {
        if(analizewin()){
            return board[row].charAt(col);
        }else{
            return anyRuleFor(row, col) ?  CalculateNextState(row, col) : board[row].charAt(col);
        }
    }

    private boolean analizewin() {
        return (Arrays.toString(board).chars().filter(c -> c == 'X').count() == 3) || (Arrays.toString(board).chars().filter(c -> c == 'O').count() == 3);
    }

    private char CalculateNextState(int row, int col) {
        Random random = new Random();
        int randomNumber = random.nextInt(2);
        return (randomNumber == 0) ? cross : circle;
    }
    private boolean anyRuleFor(int row, int col) {
        return rules.stream().anyMatch(rule -> rule.check(row, col));
    }
    private final List<Rule> rules = List.of(
            (i, j) -> isEmpty(i,j)
    );

    private boolean isEmpty(int row, int col) {
        return board[row].charAt(col) == '.';
    }

    private int rows() {
        return board.length;
    }

    private int cols() {
        return board[0].length();
    }


    private interface Rule {
        boolean check(int row, int col);
    }

}
