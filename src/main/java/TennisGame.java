import com.sun.tools.javac.util.Pair;

import java.util.List;
import java.util.stream.Collectors;

public class TennisGame {
    private final Side firstSide;
    private final Side secondSide;
    private Pair<Integer, Integer> pointScore;
    private Pair<Integer, Integer> gameScore;
    private Pair<Integer, Integer> setScore;

    public TennisGame(String firstSideNames, String secondSideNames) {
        firstSide = new Side(firstSideNames);
        secondSide = new Side(secondSideNames);
        pointScore = Pair.of(0, 0);
        gameScore = Pair.of(0, 0);
        setScore = Pair.of(0, 0);
    }

    public Side getFirstSide() {
        return firstSide;
    }

    public Side getSecondSide() {
        return secondSide;
    }

    public Pair<Integer, Integer> getPointScore() {
        return new Pair<>(firstSide.getPointScore(), secondSide.getPointScore());
    }

    public void setPointScore(Pair<Integer, Integer> pointScore) {
        this.pointScore = pointScore;
    }


    public void setGameScore(Pair<Integer, Integer> gameScore) {
        this.gameScore = gameScore;
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

    public void markPoint(Side winSide) {
        final Pair<Integer, Integer> actualPointScore = getPointScore();
        if (firstSideCanWin(winSide, actualPointScore)) {
            firstSideWinGame();
        } else if (secondSideCanWin(winSide, actualPointScore)) {
            secondSideWinGame();
        } else if (deuce(actualPointScore)) {
            gameWhenDeuce(winSide);
        } else {
            gameWhenNoSideCanWin(winSide);
        }
    }

    private void gameWhenNoSideCanWin(Side winSide) {
        if (firstSideWin(winSide)) {
            firstSideMarkPoint();
        } else {
            secondSideMarkPoint();
        }
    }

    private void gameWhenDeuce(Side winSide) {
        if (firstSide.hasAdvantage() && firstSideWin(winSide)) {
            firstSideWinGame();
        } else if (secondSide.hasAdvantage() && secondSideWin(winSide)) {
            secondSideWinGame();
        } else {
            if (firstSideWin(winSide)) {
                firstSide.setAdvantage(true);
            } else {
                secondSide.setAdvantage(true);
            }
        }
    }

    private void secondSideMarkPoint() {
        secondSide.markPoint();
        setPointScore(Pair.of(firstSide.getPointScore(), secondSide.getPointScore()));
    }

    private void firstSideMarkPoint() {
        firstSide.markPoint();
        setPointScore(Pair.of(firstSide.getPointScore(), secondSide.getPointScore()));
    }

    private void secondSideWinGame() {
        secondSide.markPoint();
        secondSide.resetAdvantage();
        firstSide.resetPointScore();
        setPointScore(Pair.of(0, 0));
        setGameScore(Pair.of(0, secondSide.getGameScore()));
    }

    private void firstSideWinGame() {
        firstSide.markPoint();
        firstSide.resetAdvantage();
        secondSide.resetPointScore();
        setPointScore(Pair.of(0, 0));
        setGameScore(Pair.of(firstSide.getGameScore(), 0));
    }

    private boolean secondSideWin(Side winSide) {
        return winSide == secondSide;
    }

    private boolean firstSideWin(Side winSide) {
        return winSide == firstSide;
    }

    private boolean deuce(Pair<Integer, Integer> actualPointScore) {
        return actualPointScore.snd == 40 && actualPointScore.fst == 40;
    }

    private boolean secondSideCanWin(Side winSide, Pair<Integer, Integer> actualPointScore) {
        return actualPointScore.snd == 40 && actualPointScore.fst < 40 && secondSideWin(winSide);
    }

    private boolean firstSideCanWin(Side winSide, Pair<Integer, Integer> actualPointScore) {
        return actualPointScore.fst == 40 && actualPointScore.snd < 40 && firstSideWin(winSide);
    }

    public String status() {
        final List<String> firstSidePlayerNames = firstSide.getPlayers().stream().map(Player::getPlayerName).collect(Collectors.toList());
        final List<String> secondSidePlayerNames = secondSide.getPlayers().stream().map(Player::getPlayerName).collect(Collectors.toList());
        return "Tennis game between ".concat(String.join(", ", firstSidePlayerNames)).concat(" & ")
                .concat(String.join(", ", secondSidePlayerNames)).concat("\n")
                .concat("The actual score is :\n")
                .concat(pointScore != Pair.of(0, 0) ? "Point " + toScore(pointScore) : "")
                .concat(gameScore != Pair.of(0, 0) ? "Game " + toScore(gameScore) : "")
                .concat(setScore != Pair.of(0, 0) ? "Set " + toScore(setScore) : "");
    }

    private String toScore(Pair<Integer, Integer> score) {
        return score.fst + " - " + score.snd + "\n";
    }
}
