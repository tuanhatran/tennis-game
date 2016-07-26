class Side {
    private final String playerNames;
    private Integer pointScore;
    private Integer gameScore;
    private Integer setScore;

    public Side(String playerNames) {
        this.playerNames = playerNames;
        pointScore = 0;
        gameScore = 0;
        setScore = 0;
    }

    public String getPlayerNames() {
        return playerNames;
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

    public void setSetScore(Integer setScore) {
        this.setScore = setScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Side side = (Side) o;

        if (playerNames != null ? !playerNames.equals(side.playerNames) : side.playerNames != null) return false;
        if (pointScore != null ? !pointScore.equals(side.pointScore) : side.pointScore != null) return false;
        if (gameScore != null ? !gameScore.equals(side.gameScore) : side.gameScore != null) return false;
        return setScore != null ? setScore.equals(side.setScore) : side.setScore == null;

    }

    @Override
    public int hashCode() {
        int result = playerNames != null ? playerNames.hashCode() : 0;
        result = 31 * result + (pointScore != null ? pointScore.hashCode() : 0);
        result = 31 * result + (gameScore != null ? gameScore.hashCode() : 0);
        result = 31 * result + (setScore != null ? setScore.hashCode() : 0);
        return result;
    }
}
