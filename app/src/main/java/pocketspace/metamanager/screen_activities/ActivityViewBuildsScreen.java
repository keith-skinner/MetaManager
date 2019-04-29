package pocketspace.metamanager.screen_activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;


import androidx.cardview.widget.CardView;
import pocketspace.metamanager.R;

public class ActivityViewBuildsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_builds_screen);

        CardView cardView = this.findViewById(R.id.build_card_0);
        cardView.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityBuildView.class);
            view.getContext().startActivity(intent);
        });
    }

}
