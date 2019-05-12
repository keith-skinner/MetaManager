package pocketspace.metamanager.screen_activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pocketspace.metamanager.R;
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


//        Toolbar toolbar = findViewById(R.id.app_toolbar);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);


        Intent intent = getIntent();
        game = intent.getStringExtra(getResources().getString(R.string.gameName));
        character = intent.getStringExtra(getResources().getString(R.string.characterName));
        role = intent.getStringExtra(getResources().getString(R.string.lolRole));




        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        adapter = new TabAdapter(getSupportFragmentManager());

        adapter.addFragment(new TabPrimeRuneFragment(), "PRIME");
        adapter.addFragment(new TabSecondaryRuneFragment(), "SECOND");
        adapter.addFragment(new TabSpellFragment(), "SPELL");
        adapter.addFragment(new TabItemFragment(), "ITEM");
        adapter.addFragment(new TabSkillFragment(), "SKILL");



        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}
