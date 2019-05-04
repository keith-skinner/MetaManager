package pocketspace.metamanager;

import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import pocketspace.metamanager.data.Build;


public class ParseBuildEntry {

    public final Build build = new Build();
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


        parser.require(XmlPullParser.START_TAG, ns, "leagueoflegends");
        while (parser.next() != XmlPullParser.END_TAG)
        {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            if (parser.getName().equals("primary")) {
                readPrimary(parser);
//            } else if (name.equals("secondary")) {
//                entries.add(readSecondary(parser));
//            } else if (name.equals("tertiary")){
//                entries.add(readTertiary(parser));
//            } else if (name.equals("summoners")){
//                entries.add(readSummoners(parser));
//            } else if (name.equals("starting")){
//                entries.add(readStarting(parser));
//            } else if (name.equals("core")){
//                entries.add(readCore(parser));
//            } else if (name.equals("situational")){
//                entries.add(readSituational(parser));
            } else if (parser.getName().equals("skills")) {
                readSkills(parser);
            } else {
                skip(parser);
            }
        }
    }

    private void readPrimary(XmlPullParser parser) throws  IOException, XmlPullParserException
    {
        parser.require(XmlPullParser.START_TAG, ns, "primary");
        Log.d("key",""+parser.getAttributeValue(ns,"family"));
        build.runes.primary.family = build.strToRuneFamily(parser.getAttributeValue(ns,"family"));
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
    }

    private void readSkills(XmlPullParser parser) throws IOException, XmlPullParserException
    {
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
