package pocketspace.metamanager.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pocketspace.metamanager.R;

public class Build {

    public enum ROLE {
        TOP,
        JUNGLE,
        MID,
        SUPPORT,
        BOT
    }

    String name;
    String characterId;
    String characterName;
    ROLE role;

    public enum RuneFamily {
        PRECISION,
        DOMINATION,
        SORCERY,
        RESOLVE,
        INSPIRATION
    }
    public static class Runes {
        public static class Primary {
            public RuneFamily family;
            public int keystone;
            public int row1;
            public int row2;
            public int row3;
        }
        public Primary primary;

        public static class Secondary {
            public RuneFamily family;
            public int row1;
            public int row2;
            public int row3;
        }
        public Secondary secondary;

        public static class Tertiary {
            public int row1;
            public int row2;
            public int row3;
        }
        public Tertiary tertiary;
    }
    public Runes runes;

    enum Summoner {

    }
    public static class Summoners {
        public String summoner1;
        public String summoner2;
    }
    public Summoners summoners;

    public enum Skill {
        Q, W, E, R
    }
    List<Skill> skills;

    public static class ItemGroup {
        String name = "";
        List<String> items;
    }

    public static class ItemSection {
        List<ItemGroup> starting;
        List<ItemGroup> core;
        List<ItemGroup> situational;
    }
    ItemSection items;

    public static Build testing()
    {
        Build build = new Build();
        build.name = "A new build";
        build.characterId = "aatrox";
        build.characterName = "Aatrox";

        ///RUNES
        build.runes = new Runes();
        build.runes.primary = new Runes.Primary();
        build.runes.primary.family = RuneFamily.PRECISION;
        build.runes.primary.keystone = 3;//"conqueror";
        build.runes.primary.row1 = 1;//"triumph";
        build.runes.primary.row2 = 1;//"tenacity";
        build.runes.primary.row3 = 2;//"coup_de_grace";

        build.runes.secondary = new Runes.Secondary();
        build.runes.secondary.family = RuneFamily.DOMINATION;
        build.runes.secondary.row1 = 0;//"taste_of_blood";
        build.runes.secondary.row2 = 0;//"ravenous_hunter";
        build.runes.secondary.row3 = -1;//nothing

        build.runes.tertiary = new Runes.Tertiary();
        build.runes.tertiary.row1 = 0;
        build.runes.tertiary.row2 = 0;
        build.runes.tertiary.row3 = 2;

        build.summoners = new Summoners();
        build.summoners.summoner1 = "flash";
        build.summoners.summoner2 = "ignite";

        ///SKILLS
        build.skills = Arrays.asList(
            Skill.Q, Skill.E, Skill.W, Skill.Q, Skill.Q, Skill.R,
            Skill.Q, Skill.E, Skill.Q, Skill.E, Skill.R, Skill.E,
            Skill.E, Skill.W, Skill.W, Skill.R, Skill.W, Skill.W
        );

        ///ITEMS: STARTING ITEMS
        build.items = new ItemSection();
        build.items.starting = new ArrayList<>();
        build.items.core = new ArrayList<>();
        build.items.situational = new ArrayList<>();

        ItemGroup starting = new Build.ItemGroup();
        starting.items = Arrays.asList(
                "dorans_sheild",
                "health_potion"
        );

        build.items.starting.add(starting);

        ///ITEMS: CORE ITEMS
        ItemGroup core = new Build.ItemGroup();
        starting.items = Arrays.asList(
                "the_black_cleaver",
                "youmuus_ghostblade",
                "steraks_gage"
        );
        build.items.core.add(core);

        ///ITEMS: SITUATIONAL ITEMS.
        ItemGroup situational;

        situational = new ItemGroup();
        situational.name = "Boots";
        situational.items = Arrays.asList(
                "ninja_tabi",
                "mercurys_treads",
                "boots_of_mobility"
        );
        build.items.situational.add(situational);

        situational = new ItemGroup();
        situational.name = "Others";
        situational.items = Arrays.asList(
                "maw_of_malmortius",
                "duskblade_of_draktharr"
        );
        build.items.situational.add(situational);

        return build;
    }
}
