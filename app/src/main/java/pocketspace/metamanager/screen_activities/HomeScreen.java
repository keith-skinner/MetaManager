package pocketspace.metamanager.screen_activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import pocketspace.metamanager.R;
import pocketspace.metamanager.data.build.Build;
import pocketspace.metamanager.data.build.serialize.BuildParser;
import pocketspace.metamanager.data.build.serialize.BuildSerializer;

public class HomeScreen extends AppCompatActivity {

    private static final int READ_REQUEST_CODE = 42;
    public static final String BUILDS_DIR = "/builds";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        CardView homeViewBuilds = this.findViewById(R.id.homeViewBuilds);
        homeViewBuilds.setOnClickListener(view -> {
            Intent intent = new Intent(this, ViewBuildsScreen.class);
            view.getContext().startActivity(intent);
        });

        CardView homeCreateBuild = this.findViewById(R.id.homeCreateBuild);
        homeCreateBuild.setOnClickListener(view -> {
            //TODO Change this to the appropriate page.
            Toast.makeText(this, "Create Build Button Pressed", Toast.LENGTH_SHORT).show();
        });

        CardView homeImportBuild = this.findViewById(R.id.homeImportBuild);
        homeImportBuild.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("*/*");
            startActivityForResult(intent, READ_REQUEST_CODE);
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData) {
        super.onActivityResult(requestCode, resultCode, resultData);
        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            if (resultData != null && resultData.getData() != null) {

                FileDescriptor fileDescriptor = getResult(resultData.getData());
                Build build = getBuildFromFile(fileDescriptor);

                ensureBuildsDir();
                File file = new File(getBuildsDir(), "/build.xml" /* TODO FILE NAME GOES HERE */);
                try (PrintStream out = new PrintStream(file)) {
                    out.print(BuildSerializer.serialize(build));
                    /* TODO ADD BUILD TO DB*/
                }
                catch (FileNotFoundException e) {
                    Log.i("HELLO", "File not found: " + file.getAbsolutePath());
                }
            }
        }
    }

    private Build getBuildFromFile(FileDescriptor fileDescriptor) {
        try {
            BuildParser parser = new BuildParser(new FileInputStream(fileDescriptor));
            return parser.build;
        }
        catch (IOException e) {
            e.printStackTrace();
            return new Build();
        }
    }

    private FileDescriptor getResult(Uri uri) {
        try {
            ParcelFileDescriptor fileDescriptor = this.getContentResolver().openFileDescriptor(uri, "r");
            if (fileDescriptor != null)
                return fileDescriptor.getFileDescriptor();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public File getBuildsDir() {
        return new File(this.getFilesDir(), BUILDS_DIR);
    }

    private void ensureBuildsDir() {
        File file = getBuildsDir();
        if (!file.exists()) {
            if (!file.mkdir())
                Log.e("TAGGY", "Could not create directory: " + file.getAbsolutePath());
        }
    }
}
