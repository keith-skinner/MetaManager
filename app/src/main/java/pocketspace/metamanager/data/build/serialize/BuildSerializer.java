package pocketspace.metamanager.data.build.serialize;

import android.annotation.SuppressLint;

import java.util.List;

import pocketspace.metamanager.data.build.Build;
import pocketspace.metamanager.data.build.item.Item;
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

    private static final String XML_DECL = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>";

    private static final String BUILD_START_TAG = "<build name=\"%s\" champion=\"%s\" role=\"%s\">\n";
    private static final String BUILD_END_TAG = "</build>\n";

    private static final String RUNE_START_TAG = "    <rune>";
    private static final String RUNE_END_TAG = "</rune>\n";
    private static final String RUNE_TAG_FORMAT = RUNE_START_TAG + "%d" + RUNE_END_TAG;

    private static final String KEYSTONE_START_TAG = "    <keystone>";
    private static final String KEYSTONE_END_TAG =   "</keystone>\n";
    private static final String KEYSTONE_TAG_FORMAT = KEYSTONE_START_TAG + "%d" + KEYSTONE_END_TAG;

    private static final String PRIMARY_START_TAG =  "  <primary family=\"%s\">\n";
    private static final String PRIMARY_END_TAG =    "  </primary>\n";
    private static final String PRIMARY_TAG_FORMAT = PRIMARY_START_TAG + KEYSTONE_TAG_FORMAT + RUNE_TAG_FORMAT + RUNE_TAG_FORMAT + RUNE_TAG_FORMAT + PRIMARY_END_TAG;

    private static final String SECONDARY_START_TAG = "  <secondary family=\"%s\">\n";
    private static final String SECONDARY_END_TAG = "  </secondary>\n";
    private static final String SECONDARY_TAG_FORMAT = SECONDARY_START_TAG + RUNE_TAG_FORMAT + RUNE_TAG_FORMAT + RUNE_TAG_FORMAT + SECONDARY_END_TAG;

    private static final String TERTIARY_START_TAG = "  <tertiary>\n";
    private static final String TERTIARY_END_TAG = "  </tertiary>\n";
    private static final String TERTIARY_TAG_FORMAT = TERTIARY_START_TAG + RUNE_TAG_FORMAT + RUNE_TAG_FORMAT + RUNE_TAG_FORMAT + TERTIARY_END_TAG;

    private static final String SUMMONERS_START_TAG = "  <summoners>\n";
    private static final String SUMMONERS_END_TAG = "  </summoners>\n";
    private static final String SUMMONER_TAG_FORMAT = "    <spell name=\"%s\"/>\n";
    private static final String SUMMONERS_TAG_FORMAT = SUMMONERS_START_TAG + SUMMONER_TAG_FORMAT + SUMMONER_TAG_FORMAT + SUMMONERS_END_TAG;

    private static final String SKILLS_START_TAG = "  <skills>\n";
    private static final String SKILLS_END_TAG = "  </skills>\n";

    private static final String SKILL_START_TAG = "    <skill>";
    private static final String SKILL_END_TAG = "</skill>\n";
    private static final String SKILL_TAG_FORMAT = SKILL_START_TAG + "%s" + SKILL_END_TAG;

    private static final String ITEMS_START_TAG = "  <items>\n";
    private static final String ITEMS_END_TAG = "  </items>\n";

    private static final String BLOCK_START_TAG = "    <block name=\"%s\">\n";
    private static final String BLOCK_END_TAG = "    </block>\n";

    public static String serialize(Build build) {

        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",
                XML_DECL,
                buildStartTag(build.name, build.champion, build.role),

                serialize(build.runes.primary),
                serialize(build.runes.secondary),
                serialize(build.runes.tertiary),
                serialize(build.summoner1, build.summoner2),
                serializeSkills(build.skills),
                serializeItems(build.items),

                buildEndTag()
        );
    }

    private static String buildStartTag(String name, String champion, Role role) {
        return String.format(BUILD_START_TAG, name, champion, role);
    }
    private static String buildEndTag() {
        return BUILD_END_TAG;
    }

    private static String serialize(Item item) {
        String serial;
        if (item.getQuantity() > 1) {
            String itemFormat = "      <item name=\"%s\" quantity=\"%d\"/>\n";
            serial = String.format(itemFormat, item.getName(), item.getQuantity());
        }
        else {
            String itemFormat = "      <item name\"%s\"/>\n";
            serial = String.format(itemFormat, item.getName());
        }
        return serial;
    }

    private static String serialize(ItemBlock itemBlock) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(BLOCK_START_TAG, itemBlock.getTitle()));
        for (Item item : itemBlock.getItems())
            builder.append(serialize(item));
        builder.append(BLOCK_END_TAG);
        return builder.toString();
    }

    private static String serializeItems(List<ItemBlock> items) {
        StringBuilder builder = new StringBuilder();
        builder.append(ITEMS_START_TAG);
        for (ItemBlock block : items)
            builder.append(serialize(block));
        builder.append(ITEMS_END_TAG);
        return builder.toString();
    }

    private static String serialize(Skill skill) {
        return String.format(SKILL_TAG_FORMAT, skill.toString());
    }

    private static String serializeSkills(List<Skill> skills) {
        StringBuilder builder = new StringBuilder();
        builder.append(SKILLS_START_TAG);
        for (Skill skill : skills)
            builder.append(serialize(skill));
        builder.append(SKILLS_END_TAG);
        return builder.toString();
    }

    private static String serialize(Summoner summoner1, Summoner summoner2) {
        return String.format(SUMMONERS_TAG_FORMAT,
                summoner1.toString(),
                summoner2.toString()
        );
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

    private static String serialize(TertiaryRunes tertiary) {
        return String.format(TERTIARY_TAG_FORMAT,
                tertiary.row1,
                tertiary.row2,
                tertiary.row3
        );
    }

}
