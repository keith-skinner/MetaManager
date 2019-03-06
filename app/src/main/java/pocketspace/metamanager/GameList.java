package pocketspace.metamanager;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;

import static pocketspace.metamanager.R.id.gameImgBttn;

public class GameList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_list_screen);

        addListenerOnButton();

    }

    public void addListenerOnButton() {

        ImageButton img = (ImageButton) findViewById(R.id.gameImgBttn);

        img.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                myFancyMethod(v);
            }
        });
    }

// some more code

    public void myFancyMethod(View v) {
        // does something very interesting


        boolean isFirstXml=evaluatingConditionFunction();
        LayoutInflater inflator=getLayoutInflater();
//        View view=inflator.inflate(isFirstXml?R.layout.myfirstxml:R.layout.myseconxml, null, false);
        v = inflator.inflate(isFirstXml?R.layout.game_builds_list_screen:R.layout.game_list_screen, null, false);
        v.startAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right));
        setContentView(v);

        // old sol:
//        setContentView(R.layout.game_builds_list_screen);
    }

    private boolean evaluatingConditionFunction() {
        //View currentView = this.findViewById(android.R.id.content)
        //if(currentView == first layout)
        return true;
    }


}
