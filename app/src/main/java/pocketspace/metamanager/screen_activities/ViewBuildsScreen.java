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
import pocketspace.metamanager.data.build.serialize.BuildParser;


public class ViewBuildsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_builds_screen);

        //START_TEST
        FileInputStream inputstream = null;
        try {
            inputstream = new FileInputStream(getBuildsDir().getAbsolutePath() + "/newBuild.xml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BuildParser parser = null;
        try {
            parser = new BuildParser(inputstream);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    File getBuildsDir() {
        return new File(this.getFilesDir(), "/builds");
    }

}
