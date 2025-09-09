package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.exceptions.NoAvailableUrinalException;

public class TestWashroom {
    Washroom washroom;

    @BeforeEach
    void runBefore() {
        washroom = new Washroom();
    }

    @Test
    void constructorTest() {
        assertTrue(washroom.isEmpty());
    }

    @Test
    void addUrinalTest() {
        washroom.addNewUrinal();
        assertEquals(1, washroom.size());
        washroom.addNewUrinal();
        assertEquals(2, washroom.size());
    }

    @Test
    void chooseUrinalTest() {
        washroom.addNewUrinal();

        try {
            assertEquals(0, washroom.chooseUrinal());
        } catch (NoAvailableUrinalException e) {
            fail();
        }
    }

    @Test
    void chooseUrinalCatchTest() {
        washroom.add(new Urinal(true));
        washroom.add(new Urinal(true));
        washroom.add(new Urinal(true));

        try {
            washroom.chooseUrinal();
            fail();
        } catch (NoAvailableUrinalException e) {
            // Expected
        }
    }

    @Test
    void chooseUrinalAdvancedTest() {
        washroom.add(new Urinal(true));
        washroom.add(new Urinal(true));
        washroom.add(new Urinal(false));
        washroom.add(new Urinal(false));
        washroom.add(new Urinal(false));
        washroom.add(new Urinal(true));

        try {
            assertEquals(3, washroom.chooseUrinal());
        } catch (NoAvailableUrinalException e) {
            fail();
        }
    }
}
