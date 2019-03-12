package pocketspace.metamanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class ChampionScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.champion_list_screen);

        addListenerOnButton();
    }

    public void addListenerOnButton() {
        ImageButton img = findViewById(R.id.jaxBttn);
        img.setOnClickListener(this::myFancyMethod);
    }

    public void myFancyMethod(View v) {
        // does something very interesting
        LayoutInflater inflator=getLayoutInflater();
        v = inflator.inflate(R.layout.builds_list_screen, null, false);
        v.startAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
        setContentView(v);
    }

}
