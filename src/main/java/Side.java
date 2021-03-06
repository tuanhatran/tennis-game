import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Side {
    private final List<Player> players;
    private Integer pointScore;
    private Integer gameScore;
    private Integer setScore;
    private boolean advantage;

    public Side(String... players) {
        this.players = new ArrayList<>();
        Arrays.stream(players).forEach(playerName -> this.players.add(new Player(playerName)));
        pointScore = 0;
        gameScore = 0;
        setScore = 0;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Integer getPointScore() {
        return pointScore;
    }

    public void setPointScore(Integer pointScore) {
        this.pointScore = pointScore;
    }

    public Integer getGameScore() {
        return gameScore;
    }

    public void setGameScore(Integer gameScore) {
        this.gameScore = gameScore;
    }

    public Integer getSetScore() {
        return setScore;
    }

    public boolean hasAdvantage() {
        return advantage;
    }

    public void setAdvantage(boolean advantage) {
        this.advantage = advantage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Side side = (Side) o;

        if (advantage != side.advantage) return false;
        if (players != null ? !players.equals(side.players) : side.players != null) return false;
        if (pointScore != null ? !pointScore.equals(side.pointScore) : side.pointScore != null) return false;
        if (gameScore != null ? !gameScore.equals(side.gameScore) : side.gameScore != null) return false;
        return setScore != null ? setScore.equals(side.setScore) : side.setScore == null;

    }

    @Override
    public int hashCode() {
        int result = players != null ? players.hashCode() : 0;
        result = 31 * result + (pointScore != null ? pointScore.hashCode() : 0);
        result = 31 * result + (gameScore != null ? gameScore.hashCode() : 0);
        result = 31 * result + (setScore != null ? setScore.hashCode() : 0);
        result = 31 * result + (advantage ? 1 : 0);
        return result;
    }

    public void markPoint() {
        if (pointScore == 0) {
            pointScore = 15;
        } else if (pointScore == 15) {
            pointScore = 30;
        } else if (pointScore == 30) {
            pointScore = 40;
        } else if (pointScore == 40) {
            gameScore++;
            pointScore = 0;
        }
    }

    public void resetAdvantage() {
        advantage = false;
    }

    public void resetPointScore() {
        pointScore = 0;
    }
}
