package pocketspace.metamanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

import pocketspace.metamanager.database.MetaManagerDatabaseHelper;

import pocketspace.metamanager.database.MetaManagerDatabaseSchema.*;


public class ActivityGameList extends AppCompatActivity
{
    SQLiteDatabase writeableDB;
    SQLiteDatabase readableDB;
    MetaManagerDatabaseHelper dbHelper;
    Context appContext;

    static class Game {
        int gameImageResource;
        String gameName;
        Class<? extends AppCompatActivity> nextActivity;

        Game(String gameName, int gameImageResource, Class<? extends AppCompatActivity> nextActivity){
            this.gameImageResource = gameImageResource;
            this.gameName = gameName;
            this.nextActivity = nextActivity;
        }
    }

    List<Game> games;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);

        appContext = getApplicationContext();

        writeableDB = new MetaManagerDatabaseHelper(appContext).getWritableDatabase();
        readableDB = new MetaManagerDatabaseHelper(appContext).getReadableDatabase();

        hardCodeCharacterTable();

        RecyclerView recyclerView = findViewById(R.id.gameListRecycler);
        games = createGameList();
        AdapterGameList adapter = new AdapterGameList(games);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private List<Game> createGameList() {
        List<Game> gameList = new ArrayList<>();


        gameList.add(new Game(
                "League Of Legends", R.drawable.game_icon_league_of_legends,
                ActivityCharacterList.class));

        gameList.add(new Game(
                "Smite", R.drawable.game_icon_smite,
                ActivityAboutPage.class
        ));

        gameList.add(new Game(
                "Dota2", R.drawable.game_icon_dota2,
                ActivityAboutPage.class
        ));

        return gameList;
    }

    //Database methods:

    public void insertCharacterData(String name, int thumbnail, String splash, String description)
    {
        ContentValues cv = new ContentValues();
        cv.put(CharacterTable.Cols.NAME, name);
        cv.put(CharacterTable.Cols.THUMBNAIL, thumbnail);
        cv.put(CharacterTable.Cols.SPLASH, splash);
        cv.put(CharacterTable.Cols.DESCRIPTION, description);

        writeableDB.insert(CharacterTable.NAME, null, cv);
    }

    public void hardCodeCharacterTable()
    {
        insertCharacterData("Aatrox", R.drawable.aatrox_thumbnail, "", "");
        insertCharacterData("Ahri", R.drawable.ahri_thumbnail, "", "");
        insertCharacterData("Akali", R.drawable.akali_thumbnail, "", "");
        insertCharacterData("Alistar", R.drawable.alistar_thumbnail, "", "");
        insertCharacterData("Amumu", R.drawable.amumu_thumbnail, "", "");
        insertCharacterData("Anivia", R.drawable.anivia_thumbnail, "", "");
        insertCharacterData("Annie", R.drawable.annie_thumbnail, "", "");
        insertCharacterData("Ashe", R.drawable.ashe_thumbnail, "", "");
        insertCharacterData("Aurelion_Sol", R.drawable.aurelion_sol_thumbnail, "", "");
        insertCharacterData("Azir", R.drawable.azir_thumbnail, "", "");
    }

    public void insertBuildData(String character)
    {
        ContentValues cv = new ContentValues();
        cv.put(BuildTable.Cols.CHARACTER, character);
        writeableDB.insert(BuildTable.NAME, null, cv);
    }

    public void insertSkillData(String name, String q, String w, String e, String r, String description)
    {
        ContentValues cv = new ContentValues();
        cv.put(SkillTable.Cols.NAME, name);
        cv.put(SkillTable.Cols.SKILL_Q, q);
        cv.put(SkillTable.Cols.SKILL_W, w);
        cv.put(SkillTable.Cols.SKILL_E, e);
        cv.put(SkillTable.Cols.SKILL_R, r);
        cv.put(SkillTable.Cols.DESCRIPTION, description);
        writeableDB.insert(SkillTable.NAME, null, cv);
    }

    public void insertSummonerData(String name, String description, String image)
    {
        ContentValues cv = new ContentValues();
        cv.put(SummonerTable.Cols.NAME, name);
        cv.put(SummonerTable.Cols.DESCRIPTION, description);
        cv.put(SummonerTable.Cols.IMAGE, image);
    }

    public void insertBuildSummonerData(String summonerName)
    {
        ContentValues cv = new ContentValues();
        cv.put(BuildSummonerTable.NAME, summonerName);
        writeableDB.insert(BuildSummonerTable.NAME, null, cv);
    }

    public void insertRuneData(String name, String description, String image)
    {
        ContentValues cv = new ContentValues();
        cv.put(RuneTable.Cols.NAME, name);
        cv.put(RuneTable.Cols.DESCRIPTION, description);
        cv.put(RuneTable.Cols.IMAGE, image);
        writeableDB.insert(RuneTable.NAME, null, cv);
    }

    public void insertBuildRunesData(String runeName, String image)
    {
        ContentValues cv = new ContentValues();
        cv.put(RuneTable.Cols.NAME, runeName);
        cv.put(RuneTable.Cols.IMAGE, image);
        writeableDB.insert(BuildRunesTable.NAME, null, cv);
    }

}
