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

    public static String makeBuildXML() {
        return "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
                "<build name=\"A new build\" champion=\"Aatrox\" role=\"TOP\">\n" +
                "    <primary family=\"PRECISION\">\n" +
                "        <keystone>1</keystone>\n" +
                "        <rune>1</rune>\n" +
                "        <rune>0</rune>\n" +
                "        <rune>2</rune>\n" +
                "    </primary>\n" +
                "    <secondary family=\"INSPIRATION\">\n" +
                "        <rune>1</rune>\n" +
                "        <rune>0</rune>\n" +
                "        <rune>-1</rune>\n" +
                "    </secondary>\n" +
                "    <tertiary>\n" +
                "        <rune>1</rune>\n" +
                "        <rune>0</rune>\n" +
                "        <rune>2</rune>\n" +
                "    </tertiary>\n" +
                "    <summoners>\n" +
                "        <spell name=\"FLASH\"/>\n" +
                "        <spell name=\"TELEPORT\"/>\n" +
                "    </summoners>\n" +
                "    <skills>\n" +
                "        <skill>Q</skill><skill>W</skill><skill>E</skill>\n" +
                "        <skill>Q</skill><skill>W</skill><skill>E</skill>\n" +
                "        <skill>Q</skill><skill>W</skill><skill>E</skill>\n" +
                "        <skill>Q</skill><skill>W</skill><skill>E</skill>\n" +
                "        <skill>Q</skill><skill>W</skill><skill>E</skill>\n" +
                "        <skill>R</skill><skill>R</skill><skill>R</skill>\n" +
                "    </skills>\n" +
                "    <items>\n" +
                "        <block name=\"Core\">\n" +
                "            <item name=\"Big Damage Item 1\"/>\n" +
                "            <item name=\"Big Damage Item 2\"/>\n" +
                "            <item name=\"Big Damage Item 3\"/>\n" +
                "        </block>\n" +
                "        <block name=\"Starting\">\n" +
                "            <item name=\"Starting Item\"/>\n" +
                "            <item name=\"Health Potion\" quantity=\"2\"/>\n" +
                "            <item name=\"Trinket\"/>\n" +
                "        </block>\n" +
                "        <block name=\"Situational\">\n" +
                "            <item name=\"Tanky Item 1\"/>\n" +
                "            <item name=\"Tanky Item 2\"/>\n" +
                "            <item name=\"Tanky Item 3\"/>\n" +
                "        </block>\n" +
                "    </items>\n" +
                "</build>\n";
    }
}
