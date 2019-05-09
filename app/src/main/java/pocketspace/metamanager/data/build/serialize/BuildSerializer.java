package pocketspace.metamanager.data.build.serialize;

import android.annotation.SuppressLint;

import java.util.List;

import pocketspace.metamanager.data.build.Build;
import pocketspace.metamanager.data.build.item.ItemBlock;
import pocketspace.metamanager.data.build.role.Role;
import pocketspace.metamanager.data.build.runes.PrimaryRunes;
import pocketspace.metamanager.data.build.runes.RuneRows;
import pocketspace.metamanager.data.build.runes.SecondaryRunes;
import pocketspace.metamanager.data.build.runes.TertiaryRunes;
import pocketspace.metamanager.data.build.skill.Skill;
import pocketspace.metamanager.data.build.summoner.Summoner;

@SuppressLint("DefaultLocale")
public class BuildSerializer {

    private static final String XML_DECL = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";

    private static final String BUILD_START_TAG = "<build name=\"%s\" champion=\"%s\" role=\"%s\">\n";
    private static final String BUILD_END_TAG = "</build>\n";

    private static final String RUNE_START_TAG = "<rune>";
    private static final String RUNE_END_TAG = "</rune>\n";
    private static final String RUNE_TAG_FORMAT = RUNE_START_TAG + "%d" + RUNE_END_TAG;

    private static final String KEYSTONE_START_TAG = "<keystone>";
    private static final String KEYSTONE_END_TAG =   "</keystone>\n";
    private static final String KEYSTONE_TAG_FORMAT = KEYSTONE_START_TAG + "%d" + KEYSTONE_END_TAG;

    private static final String PRIMARY_START_TAG =  "<primary family=\"%s\">\n";
    private static final String PRIMARY_END_TAG =    "</primary>\n";
    private static final String PRIMARY_TAG_FORMAT = PRIMARY_START_TAG + KEYSTONE_TAG_FORMAT + RUNE_TAG_FORMAT + RUNE_TAG_FORMAT + RUNE_TAG_FORMAT + PRIMARY_END_TAG;

    private static final String SECONDARY_START_TAG = "<secondary family=\"%s\">\n";
    private static final String SECONDARY_END_TAG = "</secondary>";
    private static final String SECONDARY_TAG_FORMAT = SECONDARY_START_TAG + RUNE_TAG_FORMAT + RUNE_TAG_FORMAT + RUNE_TAG_FORMAT + SECONDARY_END_TAG



    public static String serialize(Build build) {

        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",
                XML_DECL,
                buildStartTag(build.name, build.champion, build.role),

                serialize(build.runes.primary),
                serialize(build.runes.secondary),
                buildTertiaryRunes(build.runes.tertiary),
                buildSummoners(build.summoner1, build.summoner2),
                buildSkills(build.skills),
                buildItems(build.items),

                buildEndTag()
        );
    }

    private static String buildStartTag(String name, String champion, Role role) {
        return String.format(BUILD_START_TAG, name, champion, role);
    }
    private static String buildEndTag() {
        return BUILD_END_TAG;
    }

    private static String buildItems(List<ItemBlock> items) {
        return null; //TODO
    }

    private static String buildSkills(List<Skill> skills) {
        return null; //TODO
    }

    private static String buildSummoners(Summoner summoner1, Summoner summoner2) {
        return null; //TODO
    }

    private static String buildTertiaryRunes(TertiaryRunes tertiary) {
        return null; //TODO
    }


    private static String serialize(PrimaryRunes primary) {

        return String.format(PRIMARY_TAG_FORMAT,
                primary.family.toString(),
                primary.keystone,
                primary.row1,
                primary.row2,
                primary.row3
        );
    }

    private static String serialize(SecondaryRunes secondary) {
        return String.format(SECONDARY_TAG_FORMAT,
                secondary.family.toString(),
                secondary.row1,
                secondary.row2,
                secondary.row3
        );
    }

}
