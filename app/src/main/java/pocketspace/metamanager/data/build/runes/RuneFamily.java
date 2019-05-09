package pocketspace.metamanager.data.build.runes;

public class RuneFamily {

    private static final int INVALID = -1;
    public static final int PRECISION = 0;
    private static final int DOMINATION = 1;
    private static final int SORCERY = 2;
    private static final int RESOLVE = 3;
    public static final int INSPIRATION = 4;

    private int family = INVALID;

    RuneFamily() { }
    public RuneFamily(RuneFamily family) {
        this.family = family.family;
    }
    public RuneFamily(int family) {
        setFamily(family);
    }
    public RuneFamily(String family) {
        setFamily(family);
    }

    public int getFamily() {
        return family;
    }
    public void setFamily(int family) {
        this.family = fromInt(family);
    }
    private void setFamily(String family) {
        this.family = fromString(family);
    }

    private static int fromInt(int family) {
        if (PRECISION <= family && family <= INSPIRATION )
            return family;
        return INVALID;
    }
    private static int fromString(String family) {
        if (family.equals("PRECISION"))
            return PRECISION;
        if (family.equals("DOMINATION"))
            return DOMINATION;
        if (family.equals("SORCERY"))
            return SORCERY;
        if (family.equals("RESOLVE"))
            return RESOLVE;
        if (family.equals("INSPIRATION"))
            return INSPIRATION;

        return INVALID;
    }

    @Override
    public String toString(){
        switch(family) {
            case PRECISION:
                return "PRECISION";
            case DOMINATION:
                return "DOMINATION";
            case SORCERY:
                return "SORCERY";
            case RESOLVE:
                return "RESOLVE";
            case INSPIRATION:
                return "INSPIRATION";
            default:
                return "INVALID";
        }
    }
    public int toInt() {
        return getFamily();
    }
}
