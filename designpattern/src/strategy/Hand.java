package strategy;

public enum Hand {
    GUU(0, "グー"),
    CHOKI(1, "チョキ"),
    PAA(2, "パー");

    private int value;
    private String name;

    Hand(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static Hand getHand(int value) {
        Hand[] values = values();
        return values[value];
    }

    public boolean isStrongerThan(Hand h) {
        return fight(h) == 1;
    }

    public boolean isWeakerThan(Hand h) {
        return fight(h) == -1;
    }

    private int fight(Hand h) {
        if (this == h) {
            return 0;
        } else if ((value + 1) % 3 == h.value) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}