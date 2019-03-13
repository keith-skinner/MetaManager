package pocketspace.metamanager;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.Toast;
import android.content.Intent;

public class ChampionScreen extends AppCompatActivity {

    ImageButton img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.champion_list_screen);

        //addListenerOnButton();
        img = findViewById(R.id.jaxBtn);

        img.setOnClickListener(v->OpenBuildSelection());
    }



    public void OpenBuildSelection()
    {
        Intent intent = new Intent(this, BuildList.class);
        startActivity(intent);
    }

}
