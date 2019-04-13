package pocketspace.metamanager.database;

public class MetaManagerDatabaseSchema
{
    public static final class CharacterTable
    {
        public static final String NAME = "Character";

        public static final class Cols
        {
            public static final String NAME = "Character_Name";
            public static final String DESCRIPTION = "Description";
            public static final String THUMBNAIL = "Thumbnail";
            public static final String SPLASH = "Splash";
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
            public static final String NAME = "Skill_Name";
            public static final String SKILL_Q = "Skill_Q";
            public static final String SKILL_W = "Skill_W";
            public static final String SKILL_E = "Skill_E";
            public static final String SKILL_R = "Skill_R";
            public static final String DESCRIPTION = "Description";
        }
    }

    public static final class SummonerTable
    {
        public static final String NAME = "Summoner";

        public static final class Cols
        {
            public static final String NAME = "Summoner_Name";
            public static final String DESCRIPTION = "Description";
            public static final String IMAGE = "Image";
        }
    }

    public static final class BuildSummonerTable
    {
        public static final String NAME = "Build_Summoner";

        public static final class Cols
        {
            public static final String BUILD_ID = "Build_ID";
            public static final String SUMMONER_NAME = "Summoner_Name";
        }
    }

    public static final class RuneTable
    {
        public static final String NAME = "Rune";

        public static final class Cols
        {
            public static final String NAME = "Rune_Name";
            public static final String DESCRIPTION = "Description";
            public static final String IMAGE = "Image";
        }
    }

    public static final class BuildRunesTable
    {
        public static final String NAME = "Build_Runes";

        public static final class Cols
        {
            public static final String ID = "ID";
            public static final String RUNES_NAME = "Runes_Name";
        }

    }
}
