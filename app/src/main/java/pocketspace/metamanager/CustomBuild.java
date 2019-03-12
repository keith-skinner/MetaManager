package pocketspace.metamanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;


public class CustomBuild extends AppCompatActivity
{
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_build);

        button = findViewById(R.id.demo);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenRuneSelection();
            }
        });
    }

    public void OpenRuneSelection()
    {
        Intent intent = new Intent(this, RuneSelect.class);
        startActivity(intent);
    }


}
