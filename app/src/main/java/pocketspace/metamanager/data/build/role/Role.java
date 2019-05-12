package pocketspace.metamanager.data.build.role;

public class Role {
    private static final int INVALID = -1;
    private static final int TOP = 0;
    private static final int JUNGLE = 1;
    private static final int MID = 2;
    private static final int SUPPORT = 3;
    private static final int BOT = 4;

    private int role = INVALID;

    public Role() {

    }
    public Role(Role role) {
        this.role = role.role;
    }
    public Role(int role) {
        setRole(role);
    }
    public Role(String role) {
        setRole(role);
    }

    public int getRole() {
        return role;
    }
    public void setRole(int role) {
        this.role = fromInt(role);
    }
    public void setRole(String role) {
        this.role = fromString(role);
    }

    private static int fromInt(int role) {
        if (TOP <= role && role <= BOT )
            return role;
        return INVALID;
    }
    private static int fromString(String role) {
        switch (role) {
            case "TOP":
                return TOP;
            case "JUNGLE":
                return JUNGLE;
            case "MID":
                return MID;
            case "SUPPORT":
                return SUPPORT;
            case "BOT":
                return BOT;
            default:
                return INVALID;
        }
    }

    @Override
    public String toString() {
        switch (role) {
            case TOP:
                return "TOP";
            case JUNGLE:
                return "JUNGLE";
            case MID:
                return "MID";
            case SUPPORT:
                return "SUPPORT";
            case BOT:
                return "BOT";

            default:
                return "INVALID";
        }
    }
    public int toInt() {
        return getRole();
    }
}
