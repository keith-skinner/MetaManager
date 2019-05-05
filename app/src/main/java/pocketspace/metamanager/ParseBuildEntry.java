package pocketspace.metamanager;

import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;


import pocketspace.metamanager.data.Build;


public class ParseBuildEntry {

    private static final String BUILD_LOG = "pocketspace.metamanager.build";

    public Build build = new Build();

    private static final String ns = null;



    public ParseBuildEntry(InputStream inStream) throws XmlPullParserException, IOException
    {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(inStream, null);
            parser.nextTag();

            readFeed(parser);

        } finally {
            inStream.close();
        }
    }

    // by nested section
    private void readFeed(XmlPullParser parser) throws XmlPullParserException, IOException {


        parser.require(XmlPullParser.START_TAG, ns, "build");
        while (parser.next() != XmlPullParser.END_TAG)
        {

            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }

            String name = parser.getName();

            if (name.equals("primary")) {
                readPrimary(parser);
            } else if (name.equals("secondary")) {
                readSecondary(parser);
            } else if (name.equals("tertiary")){
                readTertiary(parser);
            } else if (name.equals("summoners")){
                readSummoners(parser);
            } else if (name.equals("starting")){
                readStarting(parser);
//            } else if (name.equals("core")){
//                entries.add(readCore(parser));
//            } else if (name.equals("situational")){
//                entries.add(readSituational(parser));
            } else if (name.equals("skills")) {
                readSkills(parser);
            } else {
                skip(parser);
            }
        }
    }

    private void readPrimary(XmlPullParser parser) throws  IOException, XmlPullParserException
    {
        parser.require(XmlPullParser.START_TAG, ns, "primary");

        Log.d("clear",":primary START");
//        Log.d("clear", ":  attributes: "+parser.getAttributeCount() );
//        Log.d("clear", ":  :  Name: " + parser.getAttributeName(0));
//        Log.d("clear", ":  :  Value: " + parser.getAttributeValue(0));
//        Log.d("clear", ":  family = " + parser.getAttributeValue(null, "family"));
        build.runes.primary.family = build.strToRuneFamily(parser.getAttributeValue(ns, "family"));

        int runeCount = 0;
        while (parser.next() != XmlPullParser.END_TAG)
        {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            if (parser.getName().equals("keystone")) {
                parser.require(XmlPullParser.START_TAG, ns, "keystone");
                build.runes.primary.keystone = Integer.parseInt(parser.nextText());
                parser.require(XmlPullParser.END_TAG, ns, "keystone");
            }
            if (parser.getName().equals("rune")) {
                runeCount++;
                parser.require(XmlPullParser.START_TAG, ns, "rune");
                switch (runeCount){
                    case 1:
                        build.runes.primary.row1 = Integer.parseInt(parser.nextText());
                        break;
                    case 2:
                        build.runes.primary.row2 = Integer.parseInt(parser.nextText());
                        break;
                    case 3:
                        build.runes.primary.row3 = Integer.parseInt(parser.nextText());
                        break;
                }
                parser.require(XmlPullParser.END_TAG, ns, "rune");
            }
        }
        Log.d("clear",":primary END");

    }

    private void readSecondary(XmlPullParser parser) throws  IOException, XmlPullParserException
    {
        Log.d("clear",":secondary START");
        parser.require(XmlPullParser.START_TAG, ns, "secondary");
        int runeCount = 0;
        while (parser.next() != XmlPullParser.END_TAG)
        {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            if (parser.getName().equals("rune")) {
                runeCount++;
                parser.require(XmlPullParser.START_TAG, ns, "rune");
                switch (runeCount){
                    case 1:
                        build.runes.secondary.row1 = Integer.parseInt(parser.nextText());
                        break;
                    case 2:
                        build.runes.secondary.row2 = Integer.parseInt(parser.nextText());
                        break;
                    case 3:
                        build.runes.secondary.row3 = Integer.parseInt(parser.nextText());
                        break;
                }
                parser.require(XmlPullParser.END_TAG, ns, "rune");
            }
        }
        Log.d("clear",":secondary END");
    }

    private void readTertiary(XmlPullParser parser) throws  IOException, XmlPullParserException
    {
        Log.d("clear",":tertiary START");
        parser.require(XmlPullParser.START_TAG, ns, "tertiary");
        int runeCount = 0;
        while (parser.next() != XmlPullParser.END_TAG)
        {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            if (parser.getName().equals("rune")) {
                runeCount++;
                parser.require(XmlPullParser.START_TAG, ns, "rune");
                switch (runeCount){
                    case 1:
                        build.runes.tertiary.row1 = Integer.parseInt(parser.nextText());
                        break;
                    case 2:
                        build.runes.tertiary.row2 = Integer.parseInt(parser.nextText());
                        break;
                    case 3:
                        build.runes.tertiary.row3 = Integer.parseInt(parser.nextText());
                        break;
                }
                parser.require(XmlPullParser.END_TAG, ns, "rune");
            }
        }
        Log.d("clear",":tertiary END");

    }

    private void readSummoners(XmlPullParser parser) throws IOException, XmlPullParserException
    {
        Log.d("clear",":summoners START");
        while (parser.next() != XmlPullParser.END_TAG)
        {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            if (parser.getName().equals("spell"))
            {
                parser.require(XmlPullParser.START_TAG, ns, "spell");
                build.summoners.summoner1 = parser.getAttributeValue(ns, "name");
                Log.i("clear", ":  spell: " + build.summoners.summoner1);
                parser.nextTag();
                parser.require(XmlPullParser.END_TAG, ns, "spell");

                parser.nextTag();

                parser.require(XmlPullParser.START_TAG, ns, "spell");
                build.summoners.summoner2 = parser.getAttributeValue(ns, "name");
                Log.i("clear", ":  spell: " + build.summoners.summoner2);
                parser.nextTag();
                parser.require(XmlPullParser.END_TAG, ns, "spell");
            }
        }
        Log.d("clear",":summoners END");
    }

    private void readStarting(XmlPullParser parser) throws IOException, XmlPullParserException
    {
        Log.d("clear",":starting START");
        while (parser.next() != XmlPullParser.END_TAG)
        {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }

            if (parser.getName().equals("block"))
            {
                build.items = new Build.ItemSection();
                Build.ItemGroup starting;

                starting = new Build.ItemGroup();
                starting.name = parser.getAttributeValue(ns, "name");

                parser.nextTag();
                parser.require(XmlPullParser.START_TAG, ns, "item");
                //TODO: CRASH HERE -> items.add ... will finnish in morning.
                starting.items.add(parser.getAttributeValue(ns, "name"));
                starting.itemQuantities.add(Integer.parseInt(parser.getAttributeValue(ns, "quantity")));
                Log.i("clear", ":  item: " + starting.items.get(0));
                parser.nextTag();
                parser.require(XmlPullParser.END_TAG, ns, "item");

                parser.nextTag();
                parser.require(XmlPullParser.START_TAG, ns, "item");
                starting.items.add(parser.getAttributeValue(ns, "name"));
                starting.itemQuantities.add(Integer.parseInt(parser.getAttributeValue(ns, "quantity")));
                Log.i("clear", ":  item: " + starting.items.get(1));
                parser.nextTag();
                parser.require(XmlPullParser.END_TAG, ns, "item");
            }
        }
        Log.d("clear",":starting END");
    }

    private void readSkills(XmlPullParser parser) throws IOException, XmlPullParserException
    {
        Log.d("clear",":skills START");
        parser.require(XmlPullParser.START_TAG, ns, "skills");
        while (parser.next() != XmlPullParser.END_TAG)
        {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            if (parser.getName().equals("skill")) {
                parser.require(XmlPullParser.START_TAG, ns, "skill");
                char c = parser.nextText().charAt(0);
                Build.Skill s = build.charToSkill(c);
                build.skills.add(s);
                parser.require(XmlPullParser.END_TAG, ns, "skill");
            }
        }
        Log.d("clear",":skills END");
    }


    private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }

//    private void readPrimary(XmlPullParser parser) throws  IOException, XmlPullParserException
//    {
//        parser.require(XmlPullParser.START_TAG, null, "primary");
//
//        while (parser.next() != XmlPullParser.END_TAG) {
//            if (parser.getEventType() != XmlPullParser.START_TAG) {
//                continue;
//            }
//            String name = parser.getName();
//            //go through nest:
//            //...
//        }
//        return new ParseBuildEntry(title, role);
//
//        parser.require(XmlPullParser.END_TAG, null, "primary");
//    }


//      Pulls tags out of XML file
//    private void readText(XmlPullParser parser) throws IOException, XmlPullParserException
//    {
//        String result = "";
//        if (parser.next() == XmlPullParser.TEXT)
//         {
//            result = parser.getText();
//            parser.nextTag();
//        }
//        return result;
//    }

//    private List<Integer> readSkills(XmlPullParser parser){
//        List<Integer> list = new ArrayList<>();
//
//        parser.require(XmlPullParser.START_TAG, ns, "summary");
//
//        while (parser.next() != XmlPullParser.END_TAG){
//
//
//        }
//
//
//        parser.require(XmlPullParser.END_TAG, ns, "summary");
//
//        return list;
//    }


    private void skip(XmlPullParser parser) throws XmlPullParserException, IOException
    {
        if (parser.getEventType() != XmlPullParser.START_TAG)
        {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0)
        {
            switch (parser.next())
            {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }

}
