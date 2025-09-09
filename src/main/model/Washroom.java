package model;
import java.util.ArrayList;

import model.exceptions.NoAvailableUrinalException;

public class Washroom extends ArrayList<Urinal> {
    public Washroom() {
        super();
    }

    public Urinal addNewUrinal() {
        Urinal urinal = new Urinal(false);
        add(urinal);
        return urinal;
    }
    
    public int chooseUrinal() throws NoAvailableUrinalException {
        int bestUrinalIndex = -1;
        int minCrowding = Integer.MAX_VALUE;
        int crowding;

        for (int i = 0; i < size(); i++) {
            if (!get(i).isOccupied()) {
                crowding = calculateCrowding(i);
                if (crowding < minCrowding) {
                    bestUrinalIndex = i;
                    minCrowding = crowding;
                }
            }
        }

        if (bestUrinalIndex < 0)
            throw new NoAvailableUrinalException();

        return bestUrinalIndex;
    }

    private int calculateCrowding(int index) {
        int result = 0;

        for (int i = 0; i < size(); i++) {
            if (get(i).isOccupied()) {
                result += (Integer.MIN_VALUE >>> (2 * Math.abs(index - i)));
            }
        }

        return result;
    }
}
