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
    MetaManagerDatabaseHelper dbHelper;

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

        dbHelper = new MetaManagerDatabaseHelper(this);

        dbHelper.hardCodeCharacterTable();
        dbHelper.hardCodeSkillTable();
        dbHelper.hardCodeRuneTable();

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
}
