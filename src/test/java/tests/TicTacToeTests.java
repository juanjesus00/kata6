package tests;

import org.junit.Test;
import software.ulpgc.kata6.TicTacToe;
import static org.assertj.core.api.Assertions.assertThat;
public class TicTacToeTests {
    @Test
    public void should_return_empty_board_given_empty_board(){
        TicTacToe ticTacToe = new TicTacToe("").next();
        assertThat(ticTacToe.state()).isEqualTo("");

    }
    @Test
    public void should_return_3x3_empty_board_given_3x3_empty_board(){
        TicTacToe ticTacToe = new TicTacToe("""
                ...
                ...
                ...
                """.trim()).next();
        assertThat(ticTacToe.state()).isEqualTo("""
                ...
                ...
                ...
                """.trim());
    }
    @Test
    public void name(){
        TicTacToe ticTacToe = new TicTacToe("""
                ...
                ...
                ...
                """.trim()).next();
    }

    public static class Cases{
        static final String  cross_horizontal_row_0= """
                XXX
                ...
                ...
                """.trim();
        static final String cross_horizontal_row_1 = """
                ...
                XXX
                ...
                """.trim();
        static final String cross_horizontal_row_2 = """
                ...
                ...
                XXX
                """.trim();
        static final String  cross_vertical_row_0= """
                X..
                X..
                X..
                """.trim();
        static final String cross_vertical_row_1 = """
                .X.
                .X.
                .X.
                """.trim();
        static final String cross_vertical_row_2 = """
                ..X
                ..X
                ..X
                """.trim();
        static final String cross_diagonal_1 = """
                X..
                .X.
                ..X
                """.trim();
        static final String cross_diagonal_2 = """
                ..X
                .X.
                X..
                """.trim();
        static final String  circle_horizontal_row_0= """
                OOO
                ...
                ...
                """.trim();
        static final String circle_horizontal_row_1 = """
                ...
                OOO
                ...
                """.trim();
        static final String circle_horizontal_row_2 = """
                ...
                ...
                OOO
                """.trim();
        static final String  circle_vertical_row_0= """
                O..
                O..
                O..
                """.trim();
        static final String circle_vertical_row_1 = """
                .O.
                .O.
                .O.
                """.trim();
        static final String circle_vertical_row_2 = """
                ..O
                ..O
                ..O
                """.trim();
        static final String circle_diagonal_1 = """
                O..
                .O.
                ..O
                """.trim();
        static final String circle_diagonal_2 = """
                ..O
                .O.
                O..
                """.trim();
    }

}
