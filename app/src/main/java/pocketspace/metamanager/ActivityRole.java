package pocketspace.metamanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ActivityRole extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);

        Intent intent = getIntent();
        String character = intent.getStringExtra(getResources().getString(R.string.characterName));
        String name = intent.getStringExtra(getResources().getString(R.string.gameName));

        ImageView img = this.findViewById(R.id.botRoleButton);
        img.setOnClickListener(view -> {
            Intent intent1 = new Intent();
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
            case R.id.jungleRoleButton:
                role = "JUNGLE";
            case R.id.midRoleButton:
                role = "MID";
            case R.id.supportRoleButton:
                role = "SUPPORT";
            case R.id.botRoleButton:
                role = "BOT";
            default:
                role = "ERROR";
        }
        return role;
    }
}
