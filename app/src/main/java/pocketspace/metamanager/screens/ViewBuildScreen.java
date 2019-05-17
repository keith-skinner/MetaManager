package pocketspace.metamanager.screens;

import com.google.android.material.tabs.TabLayout;

import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import pocketspace.metamanager.R;
import pocketspace.metamanager.data.build.Build;
import pocketspace.metamanager.screens.build.TabAdapter;
import pocketspace.metamanager.screens.build.PrimaryRuneTab;
import pocketspace.metamanager.screens.build.TabItemFragment;
import pocketspace.metamanager.screens.build.TabSkillFragment;
import pocketspace.metamanager.screens.build.TabSpellFragment;
import pocketspace.metamanager.screens.build.ViewBuildViewModel;
import pocketspace.metamanager.screens.build.SecondaryRuneFragment;

public class ViewBuildScreen extends AppCompatActivity {

    public ViewBuildViewModel buildViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.build_screen);
        buildViewModel = ViewModelProviders.of(this).get(ViewBuildViewModel.class);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        TabAdapter adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(PrimaryRuneTab.newInstance(this), "PRIME");
        adapter.addFragment(SecondaryRuneFragment.newInstance(this), "SECOND");

        adapter.addFragment(new TabSpellFragment(), "SPELL");
        adapter.addFragment(new TabItemFragment(), "ITEM");
        adapter.addFragment(new TabSkillFragment(), "SKILL");

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
