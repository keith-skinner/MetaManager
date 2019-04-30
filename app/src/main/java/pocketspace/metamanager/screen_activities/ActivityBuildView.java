package pocketspace.metamanager.screen_activities;

import android.content.Intent;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import pocketspace.metamanager.R;
import pocketspace.metamanager.data.Build;
import pocketspace.metamanager.tab.TabAdapter;
import pocketspace.metamanager.tab.TabItemFragment;
import pocketspace.metamanager.tab.TabPrimeRuneFragment;
import pocketspace.metamanager.tab.TabSecondaryRuneFragment;
import pocketspace.metamanager.tab.TabSkillFragment;
import pocketspace.metamanager.tab.TabSpellFragment;

public class ActivityBuildView extends AppCompatActivity {

    String game;
    String character;
    String role;

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.build_screen);

        Intent intent = getIntent();
        //character = intent.getStringExtra(getResources().getString(R.string.characterName));
        //role = intent.getStringExtra(getResources().getString(R.string.lolRole));

        game = "league_of_legends";
        character = "aatrox";
        role = "TOP";

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        adapter = new TabAdapter(getSupportFragmentManager());

        adapter.addFragment(TabPrimeRuneFragment.newInstance(Build.testing().runes.primary), "PRIME");
        adapter.addFragment(new TabSecondaryRuneFragment(), "SECOND");
        adapter.addFragment(new TabSpellFragment(), "SPELL");
        adapter.addFragment(new TabItemFragment(), "ITEM");
        adapter.addFragment(new TabSkillFragment(), "SKILL");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}
