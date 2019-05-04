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
    private String pathToBuilds = Environment.getExternalStorageDirectory() + "/Builds";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_builds_screen);


        //START TEST
//        grantPower();

        FileInputStream inputstream = null;
        try {
            inputstream = new FileInputStream(pathToBuilds + "/newBuild.xml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            ParseBuildEntry parseBuildEntry = new ParseBuildEntry(inputstream);
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


    

    // For creating new folders... if needed ...
    public void createFolder(String fname) {

        File mediaStorageDir = new File(Environment.getExternalStorageDirectory()+ "/" + fname);

        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Toast.makeText(this,"failed to make directory",Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this, "created directory", Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(this,"directory exists", Toast.LENGTH_LONG).show();
        }
    }

    // For creating a new file...
    public void createFile(String fname, String buildContent)
    {
        String fileContents = buildContent;

        File directory = new File(Environment.getExternalStorageDirectory() + "/Builds");
        if(!directory.exists()){
            directory.mkdir();
        }

        try{
            File textFile = new File(directory, fname);
            FileWriter writer = new FileWriter(textFile);
            writer.append(fileContents);
            writer.flush();
            writer.close();

        }catch (Exception e){
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

}
