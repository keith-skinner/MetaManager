package pocketspace.metamanager.data.build.skill;

public class Skill {
    private static final int INVALID = -1;
    private static final int Q = 0;
    private static final int W = 1;
    private static final int E = 2;
    public static final int R = 3;

    private int skill = INVALID;

    public Skill() {
    }
    public Skill(Skill skill) {
        this.skill = skill.skill;
    }
    public Skill(int skill) {
        setSkill(skill);
    }
    public Skill(String skill) {
        setSkill(skill);
    }

    private int getSkill() {
        return skill;
    }
    private void setSkill(int skill) {
        this.skill = fromInt(skill);
    }
    private void setSkill(String skill) {
        this.skill = fromString(skill);
    }

    private static int fromInt(int skill) {
        if (INVALID <= skill && skill <= R)
            return skill;
        return INVALID;
    }
    private static int fromString(String skill) {
        switch (skill){
            case "Q":
                return Q;
            case "W":
                return W;
            case "E":
                return E;
            case "R":
                return R;
            default:
                return INVALID;
        }
    }

    @Override
    public String toString() {
        switch (skill){
            case Q:
                return "Q";
            case W:
                return "W";
            case E:
                return "E";
            case R:
                return "R";
            default:
                return "INVALID";
        }
    }
    public int toInt() {
        return getSkill();
    }
}
