package pocketspace.metamanager.screens;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import pocketspace.metamanager.R;


public class ViewBuildListScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_builds_screen);

        CardView cardView = this.findViewById(R.id.build_card_0);
        cardView.setOnClickListener(view -> {
            Intent intent = new Intent(this, ViewBuildScreen.class);
            view.getContext().startActivity(intent);
        });
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
