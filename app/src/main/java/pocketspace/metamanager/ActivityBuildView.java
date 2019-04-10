package pocketspace.metamanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityBuildView extends AppCompatActivity {

    String game;
    String character;
    String role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_view);

        Intent intent = getIntent();
        game = intent.getStringExtra(getResources().getString(R.string.gameName));
        character = intent.getStringExtra(getResources().getString(R.string.characterName));
        role = intent.getStringExtra(getResources().getString(R.string.lolRole));

        TextView gameView = findViewById(R.id.Game);
        gameView.setText(game);

        TextView characterView = findViewById(R.id.Character);
        characterView.setText(character);

        TextView roleView = findViewById(R.id.Role);
        roleView.setText(role);
    }
}
