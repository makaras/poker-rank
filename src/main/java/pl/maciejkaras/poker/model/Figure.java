package pl.maciejkaras.poker.model;

public enum Figure {
    ACE(12),
    KING(11),
    QUEEN(10),
    JACK(9),
    TEN(8),
    NINE(7),
    EIGHT(6),
    SEVEN(5),
    SIX(4),
    FIVE(3),
    FOUR(2),
    THREE(1),
    TWO(0);

    private int value;

    Figure(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
