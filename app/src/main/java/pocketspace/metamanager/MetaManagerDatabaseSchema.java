package pocketspace.metamanager;

public class MetaManagerDatabaseSchema
{
    public static final class CharacterTable
    {
        public static final String NAME = "Character";

        public static final class Cols
        {
            public static final String NAME = "Name";
            public static final String THUMBNAIL = "Thumbnail";
            public static final String SPLASH = "Splash";
            public static final String DESCRIPTION = "Description";
        }
    }

    public static final class BuildTable
    {
        public static final String NAME = "Build";

        public static final class Cols
        {
            public static final String ID = "ID";
            public static final String CHARACTER = "Character";
        }
    }

    public static final class SkillTable
    {
        public static final String NAME = "Skill";

        public static final class Cols
        {

        }
    }
}
