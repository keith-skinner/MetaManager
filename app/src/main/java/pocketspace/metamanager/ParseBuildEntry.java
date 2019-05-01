package pocketspace.metamanager;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;


public class ParseBuildEntry {
    public final String title;
    public final String role;

    private ParseBuildEntry(String title, String role) {
        this.title = title;
        this.role = role;
    }


    // Parses the contents of an entry. If it encounters a title, summary, or link tag, hands them off
    // to their respective "read" methods for processing. Otherwise, skips the tag.

    private ParseBuildEntry readEntry(XmlPullParser parser) throws XmlPullParserException, IOException
    {
        parser.require(XmlPullParser.START_TAG, "ns", "entry");

        String leagueoflegends = null;
        String buildName = null;

        String primary = null;
        String secondary = null;
        String tertiary = null;

        String keystone = null;
        String summoners = null;
        String spell = null;

        String starting = null;
        String core = null;
        String situational = null;

        while (parser.next() != XmlPullParser.END_TAG)
        {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();

            if (name.equals("leagueoflegends")){
                leagueoflegends = readlol(parser);
            }
              else if (name.equals("buildName")) {
                buildName = readBuildName(parser);
            } else if (name.equals("primary")) {
                primary = readRole(parser);
            } else if (name.equals("")){
                skip(parser);
            }
        }
        return new ParseBuildEntry(title, role);
    }


    private String readlol(XmlPullParser parser) throws IOException, XmlPullParserException
    {
        parser.require(XmlPullParser.START_TAG, null, "buildName");
        String name = readText(parser);
        parser.require(XmlPullParser.END_TAG, null, "buildName");
        return name;
    }

    // Processes title tags in the feed.
    private String readBuildName(XmlPullParser parser) throws IOException, XmlPullParserException
    {
        parser.require(XmlPullParser.START_TAG, null, "title");
        String title = readText(parser);
        parser.require(XmlPullParser.END_TAG, null, "title");
        return title;
    }

    private String readRole(XmlPullParser parser) throws  IOException, XmlPullParserException
    {
        parser.require(XmlPullParser.START_TAG, null, "role");
        String role = readText(parser);
        parser.require(XmlPullParser.END_TAG, null, "role");
        return role;
    }

    private String readP(XmlPullParser parser) throws IOException, XmlPullParserException {

    }


    // Pulls tags out of XML file
    private String readText(XmlPullParser parser) throws IOException, XmlPullParserException
    {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT)
         {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }


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
