package pocketspace.metamanager;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import pocketspace.metamanager.moba.R;

public class CharacterSelectActivity extends AppCompatActivity{


    private ListView listView;
    private CharacterAdapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);

        setTheme(pocketspace.metamanager.common.R.style.MainAppTheme);
        setContentView(R.layout.character_select);


//        Bundle b = getIntent().getExtras();
        String value = getIntent().getStringExtra("gameName");

        TextView txtView = (TextView)findViewById(R.id.text);
        txtView.setText(value);

//        int numberOfCharacters = 30;
//        Character[] arrayOfCharacters = new Character[numberOfCharacters];

//        for (int i = 0; i < numberOfCharacters; i++){
//            arrayOfCharacters[i].setCharacter_id(i);
////            Uri selectedImage = R.drawable.neeko; ... need the uri library for this part...
////            arrayOfCharacters[i].setCharacter_uri(uri);
////            arrayOfCharacters[i].setCharacter_name( server.getName(uri) ); // something like this???
//        }


    listView = (ListView) findViewById(R.id.character_list);

    String name = "Neeko";

    ArrayList<Character> characterList = new ArrayList<>();
    characterList.add( new Character(R.drawable.neeko, name) );
        characterList.add( new Character(R.drawable.neeko, name) );
        characterList.add( new Character(R.drawable.neeko, name) );
        characterList.add( new Character(R.drawable.neeko, name) );
        characterList.add( new Character(R.drawable.neeko, name) );


    mAdapter = new CharacterAdapter(this, characterList);
    listView.setAdapter(mAdapter);




        // Begin the transaction
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//
//        // Replace the contents of the container with the new fragment
//        ft.add(R.id.character_placeholder, new FragmentCharacter());
//
//        // ft.replace(R.id.character_placeholder, new FragmentCharacter());
//        // or ft.add(R.id.your_placeholder, new FooFragment());
//
//        // Complete the changes added above
//        ft.commit();

    }


}
