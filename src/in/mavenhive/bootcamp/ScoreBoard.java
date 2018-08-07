package in.mavenhive.bootcamp;

import java.util.ArrayList;

//Represents the scoring for a line of American Ten-Pin Bowling.
class ScoreBoard {

    private static final int NEXT = 1;
    private static final int NUMBER_OF_TURNS = 10;
    private ArrayList<Frame> frames = new ArrayList<>();
    private int total;

    ScoreBoard(String sequenceOfFrames) {
        String[] arrayOfFrames = sequenceOfFrames.split(" ");
        constructFrames(arrayOfFrames);
        this.total = 0;
    }

    private void constructFrames(String[] arrayOfFrames) {
        for (String rolls : arrayOfFrames) {
            frames.add(new Frame(rolls));
        }
    }

    int total() {
        for (int frame_index = 0; frame_index < NUMBER_OF_TURNS; frame_index++) {
            addFrameScoreToScoreBoardTotal(frames.get(frame_index), frame_index);
        }
        return this.total;
    }

    private void addFrameScoreToScoreBoardTotal(Frame frame, int frame_index) {
        if (checkAndHandleStrike(frame, frame_index)) return;
        if (checkAndHandleSpare(frame, frame_index)) return;
        this.total += getScore(frame_index);
    }

    private boolean checkAndHandleStrike(Frame frame, int frame_index) {
        if (frame.isStrike()) {
            handleStrike(frame_index);
            return true;
        }
        return false;
    }

    private boolean checkAndHandleSpare(Frame frame, int frame_index) {
        if (frame.isSpare()) {
            handleSpare(frame_index);
            return true;
        }
        return false;
    }

    private void handleStrike(int frame_index) {
        this.total += getScore(frame_index);
        if (frames.get(NEXT + frame_index).isStrike()) {
            this.total += getScore(NEXT + frame_index) + getFirstRoll(NEXT + NEXT + frame_index);
            return;
        }
        this.total += getScore(NEXT + frame_index);
    }

    private void handleSpare(int frame_index) {
        this.total += getScore(frame_index) + getFirstRoll(NEXT + frame_index);
    }

    private int getScore(int frame_index) {
        return frames.get(frame_index).score();
    }

    private int getFirstRoll(int frame_index) {
        return frames.get(frame_index).firstRoll();
    }
}
