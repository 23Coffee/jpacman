package nl.tudelft.jpacman.board;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for the Board.
 */
public class BoardTest {

    /**
     * Tests creating a valid 1x1 board with a BasicSquare.
     */
    @Test
    void testValidBoardCreation() {
        // Create a 1x1 grid with a BasicSquare
        Square[][] grid = {{new BasicSquare()}};

        // Create a new Board with the 1x1 grid
        Board board = new Board(grid);

        // Check that the board has the correct dimensions
        assertThat(board.getWidth()).isEqualTo(1);
        assertThat(board.getHeight()).isEqualTo(1);

        // Check that the square at (0, 0) is not null
        Square square = board.squareAt(0, 0);
        assertThat(square).isNotNull();
    }

    /**
     * Tests creating a board with a null square.
     * The squareAt method should throw an AssertionError when accessing a null square.
     */
    @Test
    void testBoardWithNullSquare() {
        // Create a 1x1 grid with a null square
        Square[][] grid = {{null}};

        // Create a new Board with the null grid
        assertThrows(AssertionError.class, () -> {
            new Board(grid);
        });
    }
}
