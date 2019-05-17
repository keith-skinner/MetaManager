package pocketspace.metamanager.screens;

import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import pocketspace.metamanager.R;
import pocketspace.metamanager.data.build.Build;
import pocketspace.metamanager.screens.build.TabAdapter;
import pocketspace.metamanager.screens.build.PrimaryRuneTab;
import pocketspace.metamanager.screens.build.SecondaryRuneFragment;

public class EditBuildScreen extends AppCompatActivity {

    public Build build;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.build_screen);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        TabAdapter adapter = new TabAdapter(getSupportFragmentManager());
//        adapter.addFragment(TabPrimeRuneFragment.newInstance(MockBuild.makeBuildObject().runes.primary), "PRIME");
        adapter.addFragment(new PrimaryRuneTab(),"PRIME");
        adapter.addFragment(new SecondaryRuneFragment(), "SECOND");

//        adapter.addFragment(new TabSpellFragment(), "SPELL");
//        adapter.addFragment(new TabItemFragment(), "ITEM");
//        adapter.addFragment(new TabSkillFragment(), "SKILL");

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }



    public Build getBuild(){
        return this.build;
    }
}
