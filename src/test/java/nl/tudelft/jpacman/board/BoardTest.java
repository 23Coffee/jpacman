package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 * Test cases for the Board class.
 */
public class BoardTest {

    /**
     * Tests the creation of a valid board with a non-null square.
     */
    @Test
    public void createBoardTest() {
        BasicSquare[][] bs = new BasicSquare[1][1];
        bs[0][0] = new BasicSquare();

        Board b = new Board(bs);

        // Assert that the board and the square are valid
        assertThat(b.invariant()).isTrue();
        assertThat(b.squareAt(0, 0)).isNotNull();
        assertThat(b.squareAt(0, 0).invariant()).isTrue();
    }

    /**
     * Tests the creation of a board with a null square, expecting the board invariant to be false.
     */
//    @Test
//    public void createNullBoardTest() {
//        BasicSquare[][] bs = new BasicSquare[1][1];
//        bs[0][0] = null;
//        Board b = new Board(bs);
//
//        // Assert that the board invariant is false due to null square
//        assertThat(b.invariant()).isFalse();
//
//        // Verify that squareAt(0, 0) returns null when accessed
//        assertThat(b.squareAt(0, 0)).isNull();
//    }

}
