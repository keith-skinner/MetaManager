package pocketspace.metamanager;

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
        img = findViewById(R.id.jaxBttn);

        img.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                OpenBuildSelection();
            }
        });
    }

    public void OpenBuildSelection()
    {
        Intent intent = new Intent(this, BuildList.class);
        startActivity(intent);
    }

    /*public void addListenerOnButton() {
        Toast toast = Toast.makeText(getApplicationContext(), "some message", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();

        ImageButton img = findViewById(R.id.jaxBttn);
        img.setOnClickListener(this::myFancyMethod);
    }

    public void myFancyMethod(View v) {
        // does something very interesting
        LayoutInflater inflator=getLayoutInflater();
        v = inflator.inflate(R.layout.builds_list_screen, null, false);
        v.startAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
        setContentView(v);
    }*/

}
