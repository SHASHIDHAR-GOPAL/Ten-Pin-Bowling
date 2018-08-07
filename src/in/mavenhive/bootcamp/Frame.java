package in.mavenhive.bootcamp;

//Represents each turn.
class Frame {

    String firstRoll = "";
    String secondRoll = "";

    Frame(String rolls){
        if(rolls.equals("X")) this.firstRoll += "X";
        else {
            this.firstRoll += rolls.charAt(0);
            this.secondRoll += rolls.charAt(1);
        }
    }

    boolean isStrike() {
        return (firstRoll.equals("X"));
    }

    boolean isSpare() {
        return secondRoll.equals("/");
    }

    int total() {
        return Integer.parseInt(this.firstRoll) + Integer.parseInt(this.secondRoll);
    }

    int firstRoll() {
        return Integer.parseInt(this.firstRoll);
    }
}
