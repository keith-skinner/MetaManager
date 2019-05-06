package pocketspace.metamanager.screen_activities;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import pocketspace.metamanager.R;

import pocketspace.metamanager.ParseBuildEntry;


public class ViewBuildsScreen extends AppCompatActivity {

    private static final int REQUEST_WRITE_PERMISSION = 777; //786

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_builds_screen);

        //START TEST
//        grantPower();
        
        createFile(getBuildsDir(),
                "/newBuild.xml",
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
                "       <block name=\"MAIN CORE\">\n" +
                "           <item name=\"trinity_force\" quantity=\"1\"/>\n" +
                "       </block>\n" +
                "    </core>\n" +
                "\n" +
                "    <situational>\n" +
                "        <block name=\"Heavy AP\">\n" +
                "            <item name=\"spirit_visage\" quantity=\"1\"/>\n" +
                "            <item name=\"abyssal_mask\" quantity=\"1\"/>\n" +
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
                "</build>");

        FileInputStream inputstream = null;
        try {
            inputstream = new FileInputStream(getBuildsDir().getAbsolutePath() + "/newBuild.xml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ParseBuildEntry parseBuildEntry = null;
        try {
            parseBuildEntry = new ParseBuildEntry(inputstream);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (parseBuildEntry != null)
            Log.d("clear", parseBuildEntry.build.runes.primary.family.toString());

        //END TEST

        CardView cardView = this.findViewById(R.id.build_card_0);
        cardView.setOnClickListener(view -> {
            Intent intent = new Intent(this, BuildScreen.class);
            view.getContext().startActivity(intent);
        });
    }
    

    // For creating a new file...
    public void createFile(File directory, String fname, String buildContent)
    {
        String fileContents = buildContent;

        if(!directory.exists() && !directory.mkdirs()){
            Log.e("clear","Could not make directory");
        }

        try {
            File textFile = new File(directory, fname);
            FileWriter writer = new FileWriter(textFile);
            writer.append(fileContents);
            writer.flush();
            writer.close();
        } catch (Exception e){
            Log.d("createFile","fail:"+e);
            e.printStackTrace();
        }
    }
    
    public boolean grantPower() {
        requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_PERMISSION);
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUEST_WRITE_PERMISSION && grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            Log.d("t","granted");
        }
    }

    File getBuildsDir() {
        return new File( this.getFilesDir(), "/builds" );
    }

}
