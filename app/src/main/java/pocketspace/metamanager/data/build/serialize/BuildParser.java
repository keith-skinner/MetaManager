package pocketspace.metamanager.data.build.serialize;

import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;


import pocketspace.metamanager.data.build.Build;
import pocketspace.metamanager.data.build.item.Item;
import pocketspace.metamanager.data.build.item.ItemBlock;
import pocketspace.metamanager.data.build.skill.Skill;


public class BuildParser
{
    public Build build = new Build();
    private static final String ns = null;

    //parent tag
    private static final String BUILD_TAG = "build";

    //depth 1 tags
    private static final String PRIMARY_TAG = "primary";
    private static final String SECONDARY_TAG = "secondary";
    private static final String TERTIARY_TAG = "tertiary";
    private static final String SUMMONERS_TAG = "summoners";
    private static final String SKILLS_TAG = "skills";
    private static final String ITEMS_TAG = "items";

    //depth 2 tags
    private static final String KEYSTONE_TAG = "keystone";
    private static final String SPELL_TAG = "spell";
    private static final String SKILL_TAG = "skill";
    private static final String RUNE_TAG = "rune";
    private static final String BLOCK_TAG = "block";

    //depth 3 tags
    private static final String ITEM_TAG = "item";

    //attributes
    private static final String NAME_ATTR = "name";
    private static final String CHAMPION_ATTR = "champion";
    private static final String ROLE_ATTR = "role";
    private static final String FAMILY_ATTR = "family";
    private static final String QUANTITY_ATTR = "quantity";

    public BuildParser(InputStream inStream) throws IOException
    {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(inStream, null);
            parser.nextTag();
            parseBuild(parser);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } finally {
            if (inStream != null)
                inStream.close();
        }
    }

    private void parseTopLevelBuild(XmlPullParser parser) throws XmlPullParserException, IOException
    {
        switch (parser.getName()) {
            case "primary":
                readPrimary(parser);
                break;
            case "secondary":
                readSecondary(parser);
                break;
            case "tertiary":
                readTertiary(parser);
                break;
            case "summoners":
                readSummoners(parser);
                break;
            case "skills":
                readSkills(parser);
                break;
            case "items":
                readItems(parser);
                break;
            default:
                break;
        }
    }

    private void parseBuild(XmlPullParser parser) throws XmlPullParserException, IOException
    {
        parser.require(XmlPullParser.START_TAG, ns, BUILD_TAG);
        build.name = parser.getAttributeValue(ns, NAME_ATTR);
        build.champion = parser.getAttributeValue(ns, CHAMPION_ATTR);
        build.role.setRole(parser.getAttributeValue(ns, ROLE_ATTR));
        while (parser.nextTag() != XmlPullParser.END_DOCUMENT) {
            if (parser.getEventType() == XmlPullParser.END_TAG)
                if (parser.getName().equals(BUILD_TAG))
                    break;
            if (parser.getEventType() != XmlPullParser.START_TAG)
                continue;
            parseTopLevelBuild(parser);
        }
        parser.require(XmlPullParser.END_TAG, ns, BUILD_TAG);
    }

    private static int readKeyStone(XmlPullParser parser) throws  IOException, XmlPullParserException
    {
        parser.nextTag();
        parser.require(XmlPullParser.START_TAG, ns, KEYSTONE_TAG);
        int keystone = Integer.parseInt(parser.nextText());
        parser.require(XmlPullParser.END_TAG, ns, KEYSTONE_TAG);
        return keystone;
    }

    private static int readRune(XmlPullParser parser) throws  IOException, XmlPullParserException {
        parser.nextTag();
        parser.require(XmlPullParser.START_TAG, ns, RUNE_TAG);
        int rune = Integer.parseInt(parser.nextText());
        parser.require(XmlPullParser.END_TAG, ns, RUNE_TAG);
        return rune;
    }

    private void readPrimary(XmlPullParser parser) throws  IOException, XmlPullParserException
    {
        parser.require(XmlPullParser.START_TAG, ns, PRIMARY_TAG);
        build.runes.primary.family.setFamily(parser.getAttributeValue(ns, FAMILY_ATTR));
        build.runes.primary.keystone = readKeyStone(parser);
        build.runes.primary.row1 = readRune(parser);
        build.runes.primary.row2 = readRune(parser);
        build.runes.primary.row3 = readRune(parser);
        parser.nextTag();
        parser.require(XmlPullParser.END_TAG, ns, PRIMARY_TAG);
    }

    private void readSecondary(XmlPullParser parser) throws  IOException, XmlPullParserException
    {
        parser.require(XmlPullParser.START_TAG, ns, SECONDARY_TAG);
        build.runes.secondary.family.setFamily(parser.getAttributeValue(ns, FAMILY_ATTR));
        build.runes.secondary.row1 = readRune(parser);
        build.runes.secondary.row2 = readRune(parser);
        build.runes.secondary.row3 = readRune(parser);
        parser.nextTag();
        parser.require(XmlPullParser.END_TAG, ns, SECONDARY_TAG);
    }

    private void readTertiary(XmlPullParser parser) throws  IOException, XmlPullParserException
    {
        parser.require(XmlPullParser.START_TAG, ns, TERTIARY_TAG);
        build.runes.tertiary.row1 = readRune(parser);
        build.runes.tertiary.row2 = readRune(parser);
        build.runes.tertiary.row3 = readRune(parser);
        parser.nextTag();
        parser.require(XmlPullParser.END_TAG, ns, TERTIARY_TAG);
    }

    private static String readSpell(XmlPullParser parser) throws IOException, XmlPullParserException
    {
        parser.nextTag();
        parser.require(XmlPullParser.START_TAG, ns, SPELL_TAG);
        String summoner = parser.getAttributeValue(ns, NAME_ATTR);
        parser.nextTag();
        parser.require(XmlPullParser.END_TAG, ns, SPELL_TAG);
        return summoner;
    }

    private void readSummoners(XmlPullParser parser) throws IOException, XmlPullParserException
    {
        parser.require(XmlPullParser.START_TAG, ns, SUMMONERS_TAG);
        build.summoner1.setSummoner(readSpell(parser));
        build.summoner2.setSummoner(readSpell(parser));
        parser.nextTag();
        parser.require(XmlPullParser.END_TAG, ns, SUMMONERS_TAG);
    }

    private Item readItem(XmlPullParser parser) throws IOException, XmlPullParserException
    {
        parser.require(XmlPullParser.START_TAG, ns, ITEM_TAG);
        Item item = new Item (parser.getAttributeValue(ns, NAME_ATTR));
        if (parser.getAttributeCount() == 2)
            item.setQuantity(Integer.parseInt(parser.getAttributeValue(ns, QUANTITY_ATTR)));
        parser.nextTag();
        parser.require(XmlPullParser.END_TAG, ns, ITEM_TAG);
        return item;
    }

    private ItemBlock readBlock(XmlPullParser parser) throws IOException, XmlPullParserException
    {
        parser.require(XmlPullParser.START_TAG, ns, BLOCK_TAG);
        ItemBlock block = new ItemBlock(parser.getAttributeValue(ns, NAME_ATTR));
        while (parser.nextTag() != XmlPullParser.END_TAG)
            block.add(readItem(parser));
        parser.require(XmlPullParser.END_TAG, ns, BLOCK_TAG);
        return block;
    }

    private void readItems(XmlPullParser parser) throws IOException, XmlPullParserException
    {
        parser.require(XmlPullParser.START_TAG, ns, ITEMS_TAG);
        while (parser.nextTag() != XmlPullParser.END_TAG)
            build.items.add(readBlock(parser));
        parser.require(XmlPullParser.END_TAG, ns, ITEMS_TAG);
    }

    private Skill readSkill(XmlPullParser parser) throws IOException, XmlPullParserException
    {
        parser.nextTag();
        parser.require(XmlPullParser.START_TAG, ns, SKILL_TAG);
        Skill skill = new Skill(parser.nextText());
        parser.require(XmlPullParser.END_TAG, ns, SKILL_TAG);
        return skill;
    }

    private void readSkills(XmlPullParser parser) throws IOException, XmlPullParserException
    {
        parser.require(XmlPullParser.START_TAG, ns, SKILLS_TAG);
        for (int i=0; i<18; ++i)
            build.skills.add(readSkill(parser));
        parser.nextTag();
        parser.require(XmlPullParser.END_TAG, ns, SKILLS_TAG);
    }
}
