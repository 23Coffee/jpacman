package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * A square to test occupation.
     */
    private Square square1;
    private Square square2;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
        square1 = new BasicSquare();
        square2 = new BasicSquare();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        // Check if the unit has no initial square assigned
        assertThat(unit.hasSquare()).isFalse();
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {
        // Let the unit occupy square1
        unit.occupy(square1);

        // Check if the unit's current square is square1
        assertThat(unit.getSquare()).isEqualTo(square1);

        // Check if the square is occupied by the unit
        assertThat(square1.getOccupants()).contains(unit);
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {
        // Let the unit occupy square1
        unit.occupy(square1);

        // Now reoccupy the unit to square2
        unit.occupy(square2);

        // Check if the unit's current square is square2
        assertThat(unit.getSquare()).isEqualTo(square2);

        // Check if the unit is no longer in square1
        assertThat(square1.getOccupants()).doesNotContain(unit);

        // Check if square2 is now occupied by the unit
        assertThat(square2.getOccupants()).contains(unit);
    }
}
