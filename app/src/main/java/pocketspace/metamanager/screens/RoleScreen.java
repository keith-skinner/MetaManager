package pocketspace.metamanager.screens;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import pocketspace.metamanager.R;

public class RoleScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.role_screen);

        Intent intent = getIntent();
        String character = intent.getStringExtra(getResources().getString(R.string.characterName));
        String name = intent.getStringExtra(getResources().getString(R.string.gameName));

        ImageView img = this.findViewById(R.id.topRoleButton);
        img.setOnClickListener(view -> {
            Intent intent1 = new Intent(this, ViewBuildScreen.class);
            intent1.putExtra(view.getResources().getString(R.string.gameName), name);
            intent1.putExtra(view.getResources().getString(R.string.characterName), character);
            intent1.putExtra(view.getResources().getString(R.string.lolRole), getRole(view));
            view.getContext().startActivity(intent1);
        });

        ImageView img1 = this.findViewById(R.id.midRoleButton);
        img1.setOnClickListener(view -> {
            Intent intent1 = new Intent(this, ViewBuildScreen.class);
            intent1.putExtra(view.getResources().getString(R.string.gameName), name);
            intent1.putExtra(view.getResources().getString(R.string.characterName), character);
            intent1.putExtra(view.getResources().getString(R.string.lolRole), getRole(view));
            view.getContext().startActivity(intent1);
        });

        ImageView img2 = this.findViewById(R.id.botRoleButton);
        img2.setOnClickListener(view -> {
            Intent intent1 = new Intent(this, ViewBuildScreen.class);
            intent1.putExtra(view.getResources().getString(R.string.gameName), name);
            intent1.putExtra(view.getResources().getString(R.string.characterName), character);
            intent1.putExtra(view.getResources().getString(R.string.lolRole), getRole(view));
            view.getContext().startActivity(intent1);
        });

        ImageView img3 = this.findViewById(R.id.supportRoleButton);
        img3.setOnClickListener(view -> {
            Intent intent1 = new Intent(this, ViewBuildScreen.class);
            intent1.putExtra(view.getResources().getString(R.string.gameName), name);
            intent1.putExtra(view.getResources().getString(R.string.characterName), character);
            intent1.putExtra(view.getResources().getString(R.string.lolRole), getRole(view));
            view.getContext().startActivity(intent1);
        });

        ImageView img4 = this.findViewById(R.id.jungleRoleButton);
        img4.setOnClickListener(view -> {
            Intent intent1 = new Intent(this, ViewBuildScreen.class);
            intent1.putExtra(view.getResources().getString(R.string.gameName), name);
            intent1.putExtra(view.getResources().getString(R.string.characterName), character);
            intent1.putExtra(view.getResources().getString(R.string.lolRole), getRole(view));
            view.getContext().startActivity(intent1);
        });

    }

    private String getRole(View view) {
        String role;
        switch( view.getId()) {
            case R.id.topRoleButton:
                role = "TOP";
                break;
            case R.id.jungleRoleButton:
                role = "JUNGLE";
                break;
            case R.id.midRoleButton:
                role = "MID";
                break;
            case R.id.supportRoleButton:
                role = "SUPPORT";
                break;
            case R.id.botRoleButton:
                role = "BOT";
                break;
            default:
                role = "ERROR";
        }
        return role;
    }
}
