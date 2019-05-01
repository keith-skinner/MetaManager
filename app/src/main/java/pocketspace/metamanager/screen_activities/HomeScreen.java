package pocketspace.metamanager.screen_activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import pocketspace.metamanager.R;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);


        CardView cardView = this.findViewById(R.id.view_builds);
        cardView.setOnClickListener(view -> {
            Intent intent = new Intent(this, ViewBuildsScreen.class);
            view.getContext().startActivity(intent);
        });

        CardView cardView1 = this.findViewById(R.id.create_build);
        cardView1.setOnClickListener(view -> {
            Intent intent = new Intent(this, CreateScreen.class);
            view.getContext().startActivity(intent);
        });

        CardView cardView2 = this.findViewById(R.id.importt);
        cardView2.setOnClickListener(view -> {
            Intent intent = new Intent(this, ImportScreen.class);
            view.getContext().startActivity(intent);
        });


    }
}