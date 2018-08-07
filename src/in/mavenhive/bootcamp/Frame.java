package in.mavenhive.bootcamp;

//Represents each turn.
class Frame {

    private static final int ALL_PINS_DOWN = 10;
    private String firstRoll = "";
    private String secondRoll = "";

    Frame(String rolls) {
        this.firstRoll += rolls.equals("X") ? "X" : rolls.charAt(0);
        this.secondRoll += rolls.length() == 2 ? rolls.charAt(1) : "";
    }

    boolean isStrike() {
        return firstRoll.equals("X");
    }

    boolean isSpare() {
        return secondRoll.equals("/");
    }

    int firstRoll() {
        return this.isStrike() ? ALL_PINS_DOWN : points(this.firstRoll);
    }

    int score() {
        if(isSpare() || isStrike()) return ALL_PINS_DOWN;
        return points(this.firstRoll) + points(this.secondRoll);
    }

    private int points(String roll) {
        return Integer.parseInt(roll);
    }
}
