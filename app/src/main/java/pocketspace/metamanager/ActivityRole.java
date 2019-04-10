package pocketspace.metamanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ActivityRole extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);

        Intent intent = getIntent();
        String character = intent.getStringExtra(getResources().getString(R.string.characterName));
        String name = intent.getStringExtra(getResources().getString(R.string.gameName));

        ImageView img = this.findViewById(R.id.topRoleButton);
        img.setOnClickListener(view -> {
            Intent intent1 = new Intent(this, ActivityBuildView.class);
            intent1.putExtra(view.getResources().getString(R.string.gameName), name);
            intent1.putExtra(view.getResources().getString(R.string.characterName), character);
            intent1.putExtra(view.getResources().getString(R.string.lolRole), getRole(view));
            view.getContext().startActivity(intent1);
        });

        ImageView img1 = this.findViewById(R.id.midRoleButton);
        img1.setOnClickListener(view -> {
            Intent intent1 = new Intent(this, ActivityBuildView.class);
            intent1.putExtra(view.getResources().getString(R.string.gameName), name);
            intent1.putExtra(view.getResources().getString(R.string.characterName), character);
            intent1.putExtra(view.getResources().getString(R.string.lolRole), getRole(view));
            view.getContext().startActivity(intent1);
        });

        ImageView img2 = this.findViewById(R.id.botRoleButton);
        img2.setOnClickListener(view -> {
            Intent intent1 = new Intent(this, ActivityBuildView.class);
            intent1.putExtra(view.getResources().getString(R.string.gameName), name);
            intent1.putExtra(view.getResources().getString(R.string.characterName), character);
            intent1.putExtra(view.getResources().getString(R.string.lolRole), getRole(view));
            view.getContext().startActivity(intent1);
        });

        ImageView img3 = this.findViewById(R.id.supportRoleButton);
        img3.setOnClickListener(view -> {
            Intent intent1 = new Intent(this, ActivityBuildView.class);
            intent1.putExtra(view.getResources().getString(R.string.gameName), name);
            intent1.putExtra(view.getResources().getString(R.string.characterName), character);
            intent1.putExtra(view.getResources().getString(R.string.lolRole), getRole(view));
            view.getContext().startActivity(intent1);
        });

        ImageView img4 = this.findViewById(R.id.jungleRoleButton);
        img4.setOnClickListener(view -> {
            Intent intent1 = new Intent(this, ActivityBuildView.class);
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
                Toast.makeText(getApplicationContext(),role,Toast.LENGTH_SHORT).show();
                break;
            case R.id.jungleRoleButton:
                role = "JUNGLE";
                Toast.makeText(getApplicationContext(),role,Toast.LENGTH_SHORT).show();
                break;
            case R.id.midRoleButton:
                role = "MID";
                Toast.makeText(getApplicationContext(),role,Toast.LENGTH_SHORT).show();
                break;
            case R.id.supportRoleButton:
                role = "SUPPORT";
                Toast.makeText(getApplicationContext(),role,Toast.LENGTH_SHORT).show();
                break;
            case R.id.botRoleButton:
                role = "BOT";
                Toast.makeText(getApplicationContext(),role,Toast.LENGTH_SHORT).show();
                break;
            default:
                role = "ERROR";
                Toast.makeText(getApplicationContext(),role,Toast.LENGTH_SHORT).show();
        }
        return role;
    }
}
