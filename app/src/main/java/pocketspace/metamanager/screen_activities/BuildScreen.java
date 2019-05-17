package pocketspace.metamanager.screen_activities;

import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import pocketspace.metamanager.R;
import pocketspace.metamanager.data.build.Build;
import pocketspace.metamanager.data.build.MockBuild;
import pocketspace.metamanager.tab.TabAdapter;
import pocketspace.metamanager.tab.TabItemFragment;
import pocketspace.metamanager.tab.prime_tab.TabPrimeFragment;
import pocketspace.metamanager.tab.TabSecondaryRuneFragment;
import pocketspace.metamanager.tab.TabSkillFragment;
import pocketspace.metamanager.tab.TabSpellFragment;

public class BuildScreen extends AppCompatActivity {

    String game;
    String character;
    String role;

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public Build build;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.build_screen);

        build = new Build();
        build.name = "Dogo";

//        Intent intent = getIntent();
//        character = intent.getStringExtra(getResources().getString(R.string.characterName));
//        role = intent.getSt
//        ringExtra(getResources().getString(R.string.lolRole));

        character = "aatrox";
        role = "TOP";

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        adapter = new TabAdapter(getSupportFragmentManager());
//        adapter.addFragment(TabPrimeRuneFragment.newInstance(MockBuild.makeBuildObject().runes.primary), "PRIME");
        adapter.addFragment(new TabPrimeFragment(),"PRIME");
        adapter.addFragment(new TabSecondaryRuneFragment(), "SECOND");
//        adapter.addFragment(new TabSpellFragment(), "SPELL");
//        adapter.addFragment(new TabItemFragment(), "ITEM");
//        adapter.addFragment(new TabSkillFragment(), "SKILL");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public Build getBuild(){
        return this.build;
    }

}
