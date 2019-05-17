package pocketspace.metamanager.screens.build.runes.secondary;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import pocketspace.metamanager.data.build.runes.RuneRows;
import pocketspace.metamanager.data.build.runes.SecondaryRunes;
import pocketspace.metamanager.screens.build.ViewBuildViewModel;

public class SecondaryFragment extends Fragment {
    ViewBuildViewModel model;

    void makeSelectable() {
        //TODO: None selected means all available.
    }

    void makeSelected() {
        //TODO: Make selected circled.
    }

    void makeUnselected() {
        //TODO: Make unselected ones grey.
    }

    public SecondaryFragment() { super(); }
    public SecondaryFragment(ViewBuildViewModel model) { super(); this.model = model; }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    void setupKeystone(View view, AppCompatImageView keystoneView, int keystoneId, int position) {
        keystoneView = view.findViewById(keystoneId);
        keystoneView.setOnClickListener( v-> Toast.makeText(v.getContext(), "Keystone " + position + " Clicked", Toast.LENGTH_SHORT).show());
    }
}
