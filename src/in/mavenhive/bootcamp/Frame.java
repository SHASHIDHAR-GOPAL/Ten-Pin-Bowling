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
}
