package pocketspace.metamanager;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.content.Intent;

public class GameList extends AppCompatActivity {

    ImageButton img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_list_screen);

        //addListenerOnButton();

        img = findViewById(R.id.gameImgBttn);

        img.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                OpenChampionSelection();
            }
        });


    }

    public void OpenChampionSelection()
    {
        Intent championIntent = new Intent(this, ChampionScreen.class);
        startActivity(championIntent);
    }

    /*public void addListenerOnButton() {

        ImageButton img = findViewById(R.id.gameImgBttn);
        img.setOnClickListener(this::myFancyMethod);
    }*/

// some more code

    /*public void myFancyMethod(View v) {
        // does something very interesting
        LayoutInflater inflator=getLayoutInflater();
        v = inflator.inflate(R.layout.champion_list_screen, null, false);
        v.startAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
        setContentView(v);

        // old sol:
//        setContentView(R.layout.builds_list_screen);
    }*/


}
