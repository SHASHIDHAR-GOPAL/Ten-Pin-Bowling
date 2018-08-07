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
        this.total += frame.total();
    }

    private boolean checkAndHandleStrike(Frame frame, int index) {
        if(frame.isStrike()){
            handleStrike(index);
            return true;
        }
        return false;
    }

    private boolean checkAndHandleSpare(Frame frame, int index) {
        if(frame.isSpare()){
            handleSpare(index);
            return true;
        }
        return false;
    }

    private void handleStrike(int index) {
        this.total += 10;
        addFrameTotalToScoreBoardTotal(frames.get(index + 1), index+1);
    }

    private void handleSpare(int index) {
        this.total += 10 + frames.get(index + 1).firstRoll();
    }
}
