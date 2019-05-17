package pocketspace.metamanager.data.build.runes;

public class PrimaryRunes extends SecondaryRunes {
    public int keystone = -1;
    public PrimaryRunes() {
        super();
    }
    public PrimaryRunes(RuneFamily family) {
        super(family);
    }
    public PrimaryRunes(RuneFamily family, int keystone, int row1, int row2, int row3) {
        super(family, row1, row2, row3);
        this.keystone = keystone;
    }
}