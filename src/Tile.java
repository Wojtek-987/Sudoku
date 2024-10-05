import java.util.List;

public class Tile {
    public int x, y;
    public int requiredValue = 0;
    private int value;

    public Tile(int x, int y, int value, List<Integer> pencil) {
        // Value
        checkValue(value, "Constructor: value");
        checkValue(value, "Constructor: requiredValue");
        this.value = value;
    }

    public void setValue(int value) {
        checkValue(value, "setValue: value");
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    private void checkValue(int value, String name) {
        if(value < 0 || value > 9) {
            throw new IllegalArgumentException("Invalid value for "+name);
        }
    }
}
