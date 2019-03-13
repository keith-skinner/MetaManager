package pocketspace.metamanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BuildList extends AppCompatActivity
{
    Button buildButton;
    Button customButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.builds_list_screen);

        buildButton = findViewById(R.id.demojungle);

        buildButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                OpenBuildPage();
            }
        });

        customButton = findViewById(R.id.customdemo);

        customButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                OpenCustomPage();
            }
        });
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
