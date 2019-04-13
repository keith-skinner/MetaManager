package pocketspace.metamanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.google.android.flexbox.AlignContent;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;

import static com.google.android.flexbox.FlexWrap.WRAP;

import pocketspace.metamanager.database.MetaManagerDatabaseHelper;
import pocketspace.metamanager.database.MetaManagerDatabaseSchema.CharacterTable;

public class ActivityCharacterList extends AppCompatActivity {

    SQLiteDatabase writeableDB;
    SQLiteDatabase readableDB;
    Context appContext;

    public enum ROLE_TAG
    {
        Assassin, Fighter, Mage, Marksman, Support, Tank;
    }

    static class Character {
        String name;
        int image;
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
        setContentView(R.layout.activity_character_list);

        appContext = getApplicationContext();

        writeableDB = new MetaManagerDatabaseHelper(appContext).getWritableDatabase();
        readableDB = new MetaManagerDatabaseHelper(appContext).getReadableDatabase();

        RecyclerView recyclerView = findViewById(R.id.characterListRecycler);
        characters = createCharacterList();

        AdapterCharacterList adapter = new AdapterCharacterList(characters);
        recyclerView.setAdapter(adapter);

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(ActivityCharacterList.this);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setFlexWrap(WRAP);
        layoutManager.setJustifyContent(JustifyContent.SPACE_AROUND);
        layoutManager.setAlignItems(AlignItems.FLEX_START);
        recyclerView.setLayoutManager(layoutManager);
    }

    public Cursor getAllDataFromCharacterTable()
    {
        Cursor result = writeableDB.rawQuery("select * from " + CharacterTable.NAME, null);
        return result;
    }

    private List<Character> createCharacterList() {
        int indexOfCharacterName;
        int indexOfCharacterThumbnail;

        List<Character> characters = new ArrayList<>();

        Cursor cursor = getAllDataFromCharacterTable();

        indexOfCharacterName = cursor.getColumnIndex(CharacterTable.Cols.NAME);
        indexOfCharacterThumbnail = cursor.getColumnIndex(CharacterTable.Cols.THUMBNAIL);

        while (cursor.moveToNext())
        {
            characters.add(new Character(cursor.getString(indexOfCharacterName), cursor.getInt(indexOfCharacterThumbnail)));
        }

        cursor.close();

        /*characters.add(new Character("Aatrox", R.drawable.aatrox_thumbnail));
        characters.add(new Character("Ahri", R.drawable.ahri_thumbnail));
        characters.add(new Character("Akali", R.drawable.akali_thumbnail));
        characters.add(new Character("Alistar", R.drawable.alistar_thumbnail));
        characters.add(new Character("Amumu", R.drawable.amumu_thumbnail));
        characters.add(new Character("Anivia", R.drawable.anivia_thumbnail));
        characters.add(new Character("Annie", R.drawable.annie_thumbnail));
        characters.add(new Character("Ashe", R.drawable.ashe_thumbnail));
        characters.add(new Character("Aurelion Sol", R.drawable.aurelion_sol_thumbnail));
        characters.add(new Character("Azir", R.drawable.azir_thumbnail));*/
        return characters;
    }

}
