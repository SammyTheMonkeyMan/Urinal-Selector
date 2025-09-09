package model;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestUrinal {
    private Urinal urinal;

    @BeforeEach
    void runBefore() {
        urinal = new Urinal(false);
    }

    @Test
    void constuctorTest() {
        assertFalse(urinal.isOccupied());
    }

    @Test
    void setOccupiedTest() {
        urinal.setOccupied(true);
        assertTrue(urinal.isOccupied());
        urinal.setOccupied(false);
        assertFalse(urinal.isOccupied());
    }


    @Test
    void switchOccupiedTest() {
        urinal.switchOccupied();
        assertTrue(urinal.isOccupied());
        urinal.switchOccupied();
        assertFalse(urinal.isOccupied());
    }
}
