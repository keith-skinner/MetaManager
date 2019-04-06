package pocketspace.metamanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class HomeActivity extends AppCompatActivity {

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);

        setContentView(R.layout.home);

        Button gameButton = (Button) findViewById(R.id.butt);

//        gameButton.setOnClickListener(v -> {
//            startActivity( new Intent(HomeActivity.this, pocketspace.metamanager.CharacterSelectActivity.class));
//        });

        gameButton.setOnClickListener(v-> {
            Intent box = new Intent(HomeActivity.this, pocketspace.metamanager.CharacterSelectActivity.class);
            box.putExtra("gameName","lol");
            startActivity(box);
        });
    }

}
