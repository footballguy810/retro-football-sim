package io.retrofootballfuture.sim;

public class TimeBlockManager {
    private int blocks = 10;

    public boolean useBlock() {
        if (blocks > 0) {
            blocks--;
            return true;
        }
        return false;
    }
}