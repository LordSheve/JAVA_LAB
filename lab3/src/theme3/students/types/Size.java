package theme3.students.types;

public enum Size {
    SMALL(10), MIDELE(20), LARGE(100);

    private int value;

    Size(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
