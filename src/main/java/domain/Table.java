package domain;

public class Table {
    private final int number;
    private boolean isSeatEmpty = true;

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public boolean isSeatEmpty() {
        return isSeatEmpty;
    }

    public void isSeatEmpty(boolean isSeatEmpty) {
        this.isSeatEmpty = isSeatEmpty;
    }
}
