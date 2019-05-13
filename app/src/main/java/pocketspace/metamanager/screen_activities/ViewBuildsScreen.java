package pocketspace.metamanager.screen_activities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

    LinearLayout lnr_expanded_search;
    View topLineView;
    ImageView iv_search ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_builds_screen);

        //START_TEST
//        FileInputStream inputstream = null;
//        try {
//            inputstream = new FileInputStream(getBuildsDir().getAbsolutePath() + "/newBuild.xml");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

//        BuildParser parser = null;
//        try {
//            parser = new BuildParser(inputstream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //END TEST

        topLineView = this.findViewById(R.id.view_topLine);
        lnr_expanded_search = this.findViewById(R.id.lnr_expanded_search);
        iv_search = this.findViewById(R.id.iv_search_minimized);
        iv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lnr_expanded_search.getVisibility() == View.GONE)
                    iv_search.setVisibility(View.GONE);
                    topLineView.setVisibility(View.GONE);
                    lnr_expanded_search.setVisibility(View.VISIBLE);
            }
        });

        CardView cardView = this.findViewById(R.id.build_card_0);
        cardView.setOnClickListener(view -> {
            Intent intent = new Intent(this, BuildScreen.class);
            view.getContext().startActivity(intent);
        });
    }


    // For creating a new file...
    public void createFile(File directory, String fname, String buildContent) {

        if (!directory.exists() && !directory.mkdirs()) {
            Log.e("clear", "Could not make directory");
        }

        try {
            File textFile = new File(directory, fname);
            FileWriter writer = new FileWriter(textFile);
            writer.append(buildContent);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            Log.d("createFile", "fail:" + e);
            e.printStackTrace();
        }
    }

    File getBuildsDir() {
        return new File(this.getFilesDir(), "/builds");
    }

    @Override
    protected void onResume() {
        super.onResume();
        lnr_expanded_search.setVisibility(View.GONE);
        iv_search.setVisibility(View.VISIBLE);
        topLineView.setVisibility(View.VISIBLE);
    }
}
