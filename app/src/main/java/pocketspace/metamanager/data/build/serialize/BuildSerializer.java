package pocketspace.metamanager.data.build.serialize;

import java.util.List;

import pocketspace.metamanager.data.build.Build;
import pocketspace.metamanager.data.build.item.ItemBlock;
import pocketspace.metamanager.data.build.role.Role;
import pocketspace.metamanager.data.build.runes.PrimaryRunes;
import pocketspace.metamanager.data.build.runes.SecondaryRunes;
import pocketspace.metamanager.data.build.runes.TertiaryRunes;
import pocketspace.metamanager.data.build.skill.Skill;
import pocketspace.metamanager.data.build.summoner.Summoner;

public class BuildSerializer {

    private static final String XML_DECL = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
    private static final String BUILD_START_TAG = "<build name=\"%s\" champion=\"%s\" role=\"%s\">\n";
    private static final String BUILD_END_TAG = "</build>\n";

    public static String serialize(Build build) {

        return XML_DECL +
                buildStartTag(build.name, build.champion, build.role) +
                buildPrimaryRunes(build.runes.primary) +
                '\n' +
                buildSecondaryRunes(build.runes.secondary) +
                '\n' +
                buildTertiaryRunes(build.runes.tertiary) +
                '\n' +
                buildSummoners(build.summoner1, build.summoner2) +
                '\n' +
                buildSkills(build.skills) +
                '\n' +
                buildItems(build.items) +
                buildEndTag();
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

    private static String buildSecondaryRunes(SecondaryRunes secondary) {
        return null; //TODO
    }

    private static String buildPrimaryRunes(PrimaryRunes primary) {
        return null; //TODO
    }
}
