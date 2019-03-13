package pocketspace.metamanager;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Button;
import android.support.v7.widget.Toolbar;

public class BuildList extends AppCompatActivity
{
    Button buildButton;

    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.build_list_screen);

        buildButton = findViewById(R.id.demojungle);
        buildButton.setOnClickListener(v -> OpenBuildPage());

        Toolbar toolbar = findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.build_list_activity_header);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_nav_menu);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener( (MenuItem menuItem) -> {
            mDrawerLayout.closeDrawer(Gravity.RIGHT);
            //Add code to expand favorites and search overlay.
            return true;
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(Gravity.RIGHT);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(Gravity.RIGHT)) {
            drawer.closeDrawer(Gravity.RIGHT);
        } else {
            finish();
        }
    }

    public void OpenBuildPage()
    {
        Intent buildIntent = new Intent(this, BuildPage.class);
        startActivity(buildIntent);
    }

    public void OpenCustomPage()
    {
        Intent customIntent = new Intent(this, CustomBuild.class);
        startActivity(customIntent);
    }
}
