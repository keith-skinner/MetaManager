package pocketspace.metamanager.screens.build.runes.keystone;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;

import pocketspace.metamanager.R;
import pocketspace.metamanager.data.build.Build;
import pocketspace.metamanager.data.build.runes.RuneFamily;
import pocketspace.metamanager.screens.build.ViewBuildViewModel;

public class KeyStoneFragment extends Fragment {

    ViewBuildViewModel model;

    void makeSelectable(AppCompatImageView image) {
        //TODO: None selected means all available.
        image.setImageAlpha(255);
        image.clearColorFilter();
    }

    void makeSelected() {
        //TODO: Make selected circled.

    }

    void makeUnselected(AppCompatImageView image) {
        //TODO: Make unselected ones grey.
        image.setImageAlpha(127);
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
        image.setColorFilter(filter);
    }

    public KeyStoneFragment() { super(); }
    public KeyStoneFragment(ViewBuildViewModel model) { super(); this.model = model; }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    void setupKeystone(View view, AppCompatImageView keystoneView, int keystoneId, int position) {
        keystoneView = view.findViewById(keystoneId);
        keystoneView.setOnClickListener( v-> Toast.makeText(v.getContext(), "Keystone " + position + " Clicked", Toast.LENGTH_SHORT).show());
    }
}
