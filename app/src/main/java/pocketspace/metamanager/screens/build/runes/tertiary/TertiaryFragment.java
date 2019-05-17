package pocketspace.metamanager.screens.build.runes.tertiary;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import pocketspace.metamanager.data.build.runes.RuneRows;

public class TertiaryFragment extends Fragment {

    private static final String TAG_ROW1 = "SecondaryFragment.Selection.Row1";
    private static final String TAG_ROW2 = "SecondaryFragment.Selection.Row2";
    private static final String TAG_ROW3 = "SecondaryFragment.Selection.Row3";
    RuneRows runes;

    void makeSelectable() {
        //TODO: None selected means all available.
    }

    void makeSelected() {
        //TODO: Make selected circled.
    }

    void makeUnselected() {
        //TODO: Make unselected ones grey.
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            runes = new RuneRows(
                    bundle.getInt(TAG_ROW1),
                    bundle.getInt(TAG_ROW2),
                    bundle.getInt(TAG_ROW3)
            );
        }
    }

    void setupKeystone(View view, AppCompatImageView keystoneView, int keystoneId, int position) {
        keystoneView = view.findViewById(keystoneId);
        keystoneView.setOnClickListener( v-> Toast.makeText(v.getContext(), "Keystone " + position + " Clicked", Toast.LENGTH_SHORT).show());
    }
}
