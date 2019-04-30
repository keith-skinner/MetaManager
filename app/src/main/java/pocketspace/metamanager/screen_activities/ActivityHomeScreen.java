package pocketspace.metamanager.screen_activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import pocketspace.metamanager.R;

public class ActivityHomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);


        CardView cardView = this.findViewById(R.id.view_builds);
        cardView.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityViewBuildsScreen.class);
            view.getContext().startActivity(intent);
        });

        CardView cardView1 = this.findViewById(R.id.create_build);
        cardView1.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityCreateScreen.class);
            view.getContext().startActivity(intent);
        });

        CardView cardView2 = this.findViewById(R.id.importt);
        cardView2.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityImportScreen.class);
            view.getContext().startActivity(intent);
        });


    }
}
