package lld2.prototype.game.v3;

public class RankedGameConfig extends GameConfig {
    private int rankedPointMultiplier;
    private boolean antiCheatEnabled;

    public RankedGameConfig() {
    }

    public RankedGameConfig(RankedGameConfig source) {
        super(source);
        this.rankedPointMultiplier = source.rankedPointMultiplier;
        this.antiCheatEnabled = source.antiCheatEnabled;
    }

    @Override
    public RankedGameConfig clone() {
        return new RankedGameConfig(this);
    }

    public boolean isAntiCheatEnabled() {
        return antiCheatEnabled;
    }

    public void setAntiCheatEnabled(boolean antiCheatEnabled) {
        this.antiCheatEnabled = antiCheatEnabled;
    }

    public int getRankedPointMultiplier() {
        return rankedPointMultiplier;
    }

    public void setRankedPointMultiplier(int rankedPointMultiplier) {
        this.rankedPointMultiplier = rankedPointMultiplier;
    }
}
