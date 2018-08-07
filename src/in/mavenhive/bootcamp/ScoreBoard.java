package in.mavenhive.bootcamp;

import java.util.ArrayList;

//Represents the scoring for a line of American Ten-Pin Bowling.
class ScoreBoard {

    private ArrayList<Frame> frames = new ArrayList<>();
    private int total;

    ScoreBoard(String sequenceOfFrames) {
        String[] arrayOfFrames = sequenceOfFrames.split(" ");
        for (int frame_index = 0; frame_index < 10; frame_index++) {
            frames.add(new Frame(arrayOfFrames[frame_index]));
        }
        this.total = 0;
    }

    int total() {
        for (int index = 0; index < frames.size(); index++) {
            addFrameTotalToScoreBoardTotal(frames.get(index), index);
        }
        return this.total;
    }

    private void addFrameTotalToScoreBoardTotal(Frame frame, int index) {
        if (checkAndHandleStrike(frame, index)) return;
        if (checkAndHandleSpare(frame, index)) return;
        this.total += Integer.parseInt(frame.firstRoll) + Integer.parseInt(frame.secondRoll);
    }

    private boolean checkAndHandleStrike(Frame frame, int index) {
        if(frame.firstRoll.equals("X")){
            strike(index);
            return true;
        }
        return false;
    }

    private boolean checkAndHandleSpare(Frame frame, int index) {
        if(frame.secondRoll.equals("/")){
            spare(index);
            return true;
        }
        return false;
    }

    private void strike(int index) {
        this.total += 10;
        addFrameTotalToScoreBoardTotal(frames.get(index + 1), index+1);
    }

    private void spare(int index) {
        this.total += 10 + Integer.parseInt(frames.get(index + 1).firstRoll);
    }
}
