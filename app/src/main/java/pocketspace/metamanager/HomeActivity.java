package pocketspace.metamanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class HomeActivity extends Activity {

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);

        setContentView(R.layout.home);

        Button gameButton = (Button) findViewById(R.id.butt);
        gameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, .character_select.class));
            }
        });

    }

}
