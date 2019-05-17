package pocketspace.metamanager.screens;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;

import pocketspace.metamanager.list.AdapterCharacterList;
import pocketspace.metamanager.R;

import static com.google.android.flexbox.FlexWrap.WRAP;

public class CharacterListScreen extends AppCompatActivity {

    public enum ROLE_TAG
    {
        Assassin, Fighter, Mage, Marksman, Support, Tank;
    }

    public static class Character {
        public String name;
        public int image;
        int role_tag;

        Character(String name, int image) {
            this.image = image;
            this.name = name;
        }
    }

    List<Character> characters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_list);

        RecyclerView recyclerView = findViewById(R.id.characterListRecycler);
        characters = createCharacterList();

        AdapterCharacterList adapter = new AdapterCharacterList(characters);
        recyclerView.setAdapter(adapter);

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(CharacterListScreen.this);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setFlexWrap(WRAP);
        layoutManager.setJustifyContent(JustifyContent.SPACE_AROUND);
        layoutManager.setAlignItems(AlignItems.FLEX_START);
        recyclerView.setLayoutManager(layoutManager);
    }


    private static List<Character> createCharacterList() {
        List<Character> characters = new ArrayList<>();
        characters.add(new Character("Aatrox", R.drawable.aatrox_icon));
        characters.add(new Character("Aatrox", R.drawable.aatrox_icon));
        characters.add(new Character("Aatrox", R.drawable.aatrox_icon));
        characters.add(new Character("Aatrox", R.drawable.aatrox_icon));

//        characters.add(new Character("Ahri", R.drawable.ahri_thumbnail));
//        characters.add(new Character("Akali", R.drawable.akali_thumbnail));
//        characters.add(new Character("Alistar", R.drawable.alistar_thumbnail));
//        characters.add(new Character("Amumu", R.drawable.amumu_thumbnail));
//        characters.add(new Character("Anivia", R.drawable.anivia_thumbnail));
//        characters.add(new Character("Annie", R.drawable.annie_thumbnail));
//        characters.add(new Character("Ashe", R.drawable.ashe_thumbnail));
//        characters.add(new Character("Aurelion Sol", R.drawable.aurelion_sol_thumbnail));
//        characters.add(new Character("Azir", R.drawable.azir_thumbnail));
        return characters;
    }
}