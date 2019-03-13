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
}
