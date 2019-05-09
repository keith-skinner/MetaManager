package pocketspace.metamanager.data.build;

import java.util.Arrays;

import pocketspace.metamanager.data.build.item.Item;
import pocketspace.metamanager.data.build.item.ItemBlock;
import pocketspace.metamanager.data.build.runes.RuneFamily;
import pocketspace.metamanager.data.build.skill.Skill;
import pocketspace.metamanager.data.build.summoner.Summoner;

public class MockBuild {
    public static Build makeBuildObject() {
        {
            Build build = new Build();
            build.champion = "Aatrox";
            build.name = "A new build";

            //RUNES
            build.runes.primary.family.setFamily(RuneFamily.PRECISION);
            build.runes.primary.keystone = 1;
            build.runes.primary.row1 = 1;
            build.runes.primary.row2 = 0;
            build.runes.primary.row3 = 2;
            build.runes.secondary.family.setFamily(RuneFamily.INSPIRATION);
            build.runes.secondary.row1 = 1;
            build.runes.secondary.row2 = 0;
            build.runes.secondary.row3 = -1;
            build.runes.tertiary.row1 = 1;
            build.runes.tertiary.row2 = 0;
            build.runes.tertiary.row3 = 2;

            //SUMMONERS
            build.summoner1 = new Summoner(Summoner.FLASH);
            build.summoner2 = new Summoner(Summoner.TELEPORT);

            //SKILLS
            build.skills.addAll(Arrays.asList(
                    new Skill("Q"), new Skill("Q"), new Skill("Q"),
                    new Skill("Q"), new Skill("Q"), new Skill("Q"), //6
                    new Skill("Q"), new Skill("Q"), new Skill("Q"),
                    new Skill("Q"), new Skill("Q"), new Skill("Q"), //12
                    new Skill("Q"), new Skill("Q"), new Skill("Q"),
                    new Skill("Q"), new Skill("Q"), new Skill("Q")) //18
            );

            ///ITEMS
            ItemBlock starting = new ItemBlock("Starting");
            starting.addAll(Arrays.asList(
                    new Item("Starting Item"),
                    new Item("Health Potion", 2),
                    new Item("Trinket"))
            );

            ItemBlock core = new ItemBlock("Core");
            core.addAll(Arrays.asList(
                    new Item("Big Damage Item 1"),
                    new Item("Big Damage Item 2"),
                    new Item("Big Damage Item 3"))
            );

            ItemBlock situational = new ItemBlock("Situational");
            situational.addAll(Arrays.asList(
                    new Item("Tanky Item 1"),
                    new Item("Tanky Item 2"),
                    new Item("Tanky Item 3"))
            );
            build.items.add(starting);
            build.items.add(core);
            build.items.add(situational);

            return build;
        }
    }

    public String makeBuildXML() {
        return
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "\n" +
                "<build buildName=\"dick\" character=\"Aatrox\" role=\"Top\">\n" +
                "\n" +
                "    <primary family=\"precision\">\n" +
                "        <keystone>0</keystone>\n" +
                "        <rune>1</rune>\n" +
                "        <rune>2</rune>\n" +
                "        <rune>0</rune>\n" +
                "    </primary>\n" +
                "\n" +
                "    <secondary family=\"domination\">\n" +
                "        <rune>1</rune>\n" +
                "        <rune>2</rune>\n" +
                "        <rune>-1</rune>\n" +
                "    </secondary>\n" +
                "\n" +
                "    <tertiary>\n" +
                "        <rune>1</rune>\n" +
                "        <rune>1</rune>\n" +
                "        <rune>1</rune>\n" +
                "    </tertiary>\n" +
                "\n" +
                "    <summoners>\n" +
                "        <spell name=\"flash\"/>\n" +
                "        <spell name=\"teleport\"/>\n" +
                "    </summoners>\n" +
                "\n" +
                "    <starting>\n" +
                "        <block name=\"OFFENSIVE START\">\n" +
                "           <item name=\"dorans_sheild\" quantity=\"3\"/>\n" +
                "           <item name=\"cloth_armour\" quantity=\"1\"/>\n" +
                "        </block>\n"+
                "        <block name=\"DEFENSIVE START\">\n" +
                "           <item name=\"dorans_sheild\" quantity=\"3\"/>\n" +
                "           <item name=\"cloth_armour\" quantity=\"1\"/>\n" +
                "        </block>\n"+
                "    </starting>\n" +
                "\n" +
                "    <core>\n" +
                "        <item name=\"trinity_force\"/>\n" +
                "    </core>\n" +
                "\n" +
                "    <situational>\n" +
                "        <block name=\"Heavy AP\">\n" +
                "            <item name=\"spirit_visage\"/>\n" +
                "            <item name=\"abyssal_mask\"/>\n" +
                "        </block>\n" +
                "    </situational>\n" +
                "\n" +
                "    <skills>\n" +
                "        <skill>Q</skill> <!-- level 1 -->\n" +
                "        <skill>W</skill> <!-- level 2 -->\n" +
                "        <skill>E</skill> <!-- level 3 -->\n" +
                "        <skill>Q</skill> <!-- level 4 -->\n" +
                "        <skill>Q</skill> <!-- level 5 -->\n" +
                "        <skill>R</skill> <!-- level 6 -->\n" +
                "        <skill>E</skill> <!-- level 7 -->\n" +
                "        <skill>W</skill> <!-- level 8 -->\n" +
                "        <skill>W</skill> <!-- level 9 -->\n" +
                "        <skill>W</skill> <!-- level 10 -->\n" +
                "        <skill>W</skill> <!-- level 11 -->\n" +
                "        <skill>W</skill> <!-- level 12 -->\n" +
                "        <skill>W</skill> <!-- level 13 -->\n" +
                "        <skill>W</skill> <!-- level 14 -->\n" +
                "        <skill>W</skill> <!-- level 15 -->\n" +
                "        <skill>W</skill> <!-- level 16 -->\n" +
                "        <skill>W</skill> <!-- level 17 -->\n" +
                "        <skill>W</skill> <!-- level 18 -->\n" +
                "    </skills>\n" +
                "\n" +
                "</build>";
    }
}
