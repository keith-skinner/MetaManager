package pocketspace.metamanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ActivityAboutPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_content);
        Log.println(Log.INFO, "metamanager", "Hello World");
    }
}
