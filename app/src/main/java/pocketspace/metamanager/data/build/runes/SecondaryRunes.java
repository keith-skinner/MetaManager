package pocketspace.metamanager.data.build.runes;

public class SecondaryRunes extends RuneRows {
    public RuneFamily family = new RuneFamily();
    public SecondaryRunes() {
        super();
    }
    public SecondaryRunes(RuneFamily family) {
        super();
        this.family = family;
    }
    public SecondaryRunes(RuneFamily family, int row1, int row2, int row3) {
        super(row1, row2, row3);
        this.family = family;
    }
}
