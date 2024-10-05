import java.util.List;

public class Tile {
    public int value;
    private List<Integer> pencil;

    public Tile(int value, List<Integer> pencil, int requiredValue) {
        // Value
        checkValue(value, "Constructor: value");
        checkValue(value, "Constructor: requiredValue");
        this.value = value;

        // List of temporary notes by User
        if(pencil.size() > 9) {
            throw new IllegalArgumentException("pencil[] size must be between 0 and 9");
        }
        this.pencil = pencil;
    }

    public void toggleNote(int value) {
        checkValue(value, "toggleNote: value");

        if(this.pencil.contains(value)) {
            this.pencil.remove(value);
        } else {
            this.pencil.add(value);
        }
    }

    public void setValue(int value) {
        checkValue(value, "setValue: value");
        this.value = value;
    }

    private void checkValue(int value, String name) {
        if(value < 0 || value >= 9) {
            throw new IllegalArgumentException("Invalid value for "+name);
        }
    }
}
