package pocketspace.metamanager.screen_activities;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import pocketspace.metamanager.R;
import pocketspace.metamanager.data.build.room.BuildListAdapter;
import pocketspace.metamanager.data.build.serialize.BuildParser;


public class ViewBuildsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_builds_screen);

        RecyclerView recyclerView = findViewById(R.id.buildsRecylerView);
        final BuildListAdapter adapter = new BuildListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton button = findViewById(R.id.buildsAddButton);
        button.setOnClickListener((View v) -> Toast.makeText(this, "Add Build Button Clicked", Toast.LENGTH_SHORT).show());
    }
    

    // For creating a new file...
    public void createFile(File directory, String fname, String buildContent)
    {

        if(!directory.exists() && !directory.mkdirs()){
            Log.e("clear","Could not make directory");
        }

        try {
            File textFile = new File(directory, fname);
            FileWriter writer = new FileWriter(textFile);
            writer.append(buildContent);
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
