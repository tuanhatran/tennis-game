import com.sun.tools.javac.util.Pair;

public class TennisGame {
    private final Side firstSide;
    private final Side secondSide;
    private Pair<Integer, Integer> pointScore;
    private Pair<Integer, Integer> gameScore;
    private Pair<Integer, Integer> setScore;

    public TennisGame(String firstSideNames, String secondSideNames) {
        firstSide = new Side(firstSideNames);
        secondSide = new Side(secondSideNames);
        pointScore = new Pair<>(0, 0);
        gameScore = new Pair<>(0, 0);
        setScore = new Pair<>(0, 0);
    }

    public Side getFirstSide() {
        return firstSide;
    }

    public Side getSecondSide() {
        return secondSide;
    }

    public Pair<Integer, Integer> getPointScore() {
        return pointScore;
    }

    public void setPointScore(Pair<Integer, Integer> pointScore) {
        this.pointScore = pointScore;
    }

    public Pair<Integer, Integer> getGameScore() {
        return gameScore;
    }

    public void setGameScore(Pair<Integer, Integer> gameScore) {
        this.gameScore = gameScore;
    }

    public Pair<Integer, Integer> getSetScore() {
        return setScore;
    }

    public void setSetScore(Pair<Integer, Integer> setScore) {
        this.setScore = setScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TennisGame that = (TennisGame) o;

        if (firstSide != null ? !firstSide.equals(that.firstSide) : that.firstSide != null) return false;
        if (secondSide != null ? !secondSide.equals(that.secondSide) : that.secondSide != null) return false;
        if (pointScore != null ? !pointScore.equals(that.pointScore) : that.pointScore != null) return false;
        if (gameScore != null ? !gameScore.equals(that.gameScore) : that.gameScore != null) return false;
        return setScore != null ? setScore.equals(that.setScore) : that.setScore == null;

    }

    @Override
    public int hashCode() {
        int result = firstSide != null ? firstSide.hashCode() : 0;
        result = 31 * result + (secondSide != null ? secondSide.hashCode() : 0);
        result = 31 * result + (pointScore != null ? pointScore.hashCode() : 0);
        result = 31 * result + (gameScore != null ? gameScore.hashCode() : 0);
        result = 31 * result + (setScore != null ? setScore.hashCode() : 0);
        return result;
    }
}
