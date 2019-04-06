package pocketspace.metamanager;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import pocketspace.metamanager.moba.R;

public class CharacterSelectActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);

        setContentView(R.layout.character_select);

//        Bundle b = getIntent().getExtras();
        String value=getIntent().getStringExtra("gameName");

        TextView txtView = (TextView)findViewById(R.id.text);
        txtView.setText(value);

        RelativeLayout character = this.findViewById(R.id.character_select_list);


        // Begin the transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.character_placeholder, new FragmentCharacter());
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Complete the changes added above
        ft.commit();


    }


}
