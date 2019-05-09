package pocketspace.metamanager.data.build.summoner;

public class Summoner {
    private static final int INVALID = -1;
    private static final int CLEANSE = 0;
    private static final int EXHAUST = 1;
    public static final int FLASH = 2;
    private static final int GHOST = 3;
    private static final int HEAL = 4;
    private static final int SMITE = 5;
    public static final int TELEPORT = 6;
    private static final int IGNITE = 7;
    private static final int BARRIER = 8;

    private int summoner = INVALID;

    public Summoner() {

    }
    public Summoner(Summoner summoner) { this.summoner = summoner.summoner; }
    public Summoner(int summoner) {
        setSummoner(summoner);
    }
    public Summoner(String summoner) {
        setSummoner(summoner);
    }

    private int getSummoner() {
        return summoner;
    }
    private void setSummoner(String summoner) {
        this.summoner = fromString(summoner);
    }
    private void setSummoner(int summoner) {
        this.summoner = fromInt(summoner);
    }

    private static int fromInt(int summoner) {
        if (INVALID <= summoner && summoner <= BARRIER)
            return summoner;
        return INVALID;
    }
    private static int fromString(String summoner) {
        switch (summoner) {
            case "CLEANSE":
                return CLEANSE;
            case "EXHAUST":
                return EXHAUST;
            case "FLASH":
                return FLASH;
            case "GHOST":
                return GHOST;
            case "HEAL":
                return HEAL;
            case "SMITE":
                return SMITE;
            case "TELEPORT":
                return TELEPORT;
            case "IGNITE":
                return IGNITE;
            case "BARRIER":
                return BARRIER;
            default:
                return INVALID;
        }
    }

    @Override
    public String toString() {
        switch (summoner) {
            case CLEANSE:
                return "CLEANSE";
            case EXHAUST:
                return "EXHAUST";
            case FLASH:
                return "FLASH";
            case GHOST:
                return "GHOST";
            case HEAL:
                return "HEAL";
            case SMITE:
                return "SMITE";
            case TELEPORT:
                return "TELEPORT";
            case IGNITE:
                return "IGNITE";
            case BARRIER:
                return "BARRIER";
            default:
                return "INVALID";
        }
    }
    public int toInt() {
        return getSummoner();
    }
}
