package in.mavenhive.bootcamp;

class ScoreBoard {
    private final String[] frames;
    private int total;

    ScoreBoard(String sequenceOfRolls) {
        this.frames = sequenceOfRolls.split(" ");
        this.total = 0;
    }

    int total() {
        for (int index = 0; index < frames.length; index++) {
            if (checkAndHandleStrike(index)) continue;
            if (checkAndHandleSpare(index)) continue;
            addFrameTotalToScoreBoardTotal(frames[index]);
        }
        return this.total;
    }

    private boolean checkAndHandleStrike(int index) {
        if (frames[index].equals("X")) {
            strike(frames[index + 1]);
            return true;
        }
        return false;
    }

    private boolean checkAndHandleSpare(int index) {
        if (frames[index].charAt(1) == '/') {
            spare();
            return true;
        }
        return false;
    }

    private void strike(String nextFrame) {
        this.total += 10;
        addFrameTotalToScoreBoardTotal(nextFrame);
    }

    private void spare() {
        this.total += 10;
    }

    private void addFrameTotalToScoreBoardTotal(String frame) {
        for (String roll : frame.split("")) {
            this.total += getScore(roll);
        }
    }

    private int getScore(String roll) {
        return Integer.parseInt(roll);
    }
}
