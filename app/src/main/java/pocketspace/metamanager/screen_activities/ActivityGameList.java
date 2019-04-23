package pocketspace.metamanager.screen_activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pocketspace.metamanager.list.AdapterGameList;
import pocketspace.metamanager.R;

public class ActivityGameList extends AppCompatActivity
{
    public static class Game {
        public int gameImageResource;
        public String gameName;
        public Class<? extends AppCompatActivity> nextActivity;

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
        setContentView(R.layout.game_list);
        RecyclerView recyclerView = findViewById(R.id.gameListRecycler);
        games = createGameList();
        AdapterGameList adapter = new AdapterGameList(games);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private static List<Game> createGameList() {
        List<Game> gameList = new ArrayList<>();

        gameList.add(new Game(
                "League Of Legends", R.drawable.game_icon_league_of_legends,
                ActivityCharacterList.class));

        gameList.add(new Game(
                "Smite", R.drawable.game_icon_smite,
                ActivityAboutScreen.class
        ));

        gameList.add(new Game(
                "Dota2", R.drawable.game_icon_dota2,
                ActivityAboutScreen.class
        ));

        return gameList;
    }
}
