package pocketspace.metamanager.screen_activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import pocketspace.metamanager.R;
import pocketspace.metamanager.database.MetaManagerDatabaseHelper;

public class CreateScreen extends AppCompatActivity {

    MetaManagerDatabaseHelper db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_screen);
        db = new MetaManagerDatabaseHelper(this);
        System.out.println(db.getCharacterImageURI("Ashe"));
        System.out.println(db.getCharacterImageURI("Travis"));
        System.out.println("he");
    }
}
