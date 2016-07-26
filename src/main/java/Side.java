class Side {
    private final String playerNames;
    public Side(String playerNames) {
        this.playerNames = playerNames;
    }

    public String getPlayerNames() {
        return playerNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Side side = (Side) o;

        return playerNames != null ? playerNames.equals(side.playerNames) : side.playerNames == null;

    }

    @Override
    public int hashCode() {
        return playerNames != null ? playerNames.hashCode() : 0;
    }
}
