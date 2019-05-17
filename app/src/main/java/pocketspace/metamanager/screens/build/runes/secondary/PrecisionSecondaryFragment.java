package pocketspace.metamanager.screens.build.runes.secondary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;

import pocketspace.metamanager.R;
import pocketspace.metamanager.screens.build.ViewBuildViewModel;

public class PrecisionSecondaryFragment extends SecondaryFragment {

    ViewBuildViewModel model;

    AppCompatImageView precisionSecondary11;
    AppCompatImageView precisionSecondary12;
    AppCompatImageView precisionSecondary13;
    AppCompatImageView precisionSecondary21;
    AppCompatImageView precisionSecondary22;
    AppCompatImageView precisionSecondary23;
    AppCompatImageView precisionSecondary31;
    AppCompatImageView precisionSecondary32;
    AppCompatImageView precisionSecondary33;

    public static Fragment getInstance(FragmentActivity activity) {
        PrecisionSecondaryFragment fragment = new PrecisionSecondaryFragment();
        fragment.model = ViewModelProviders.of(activity).get(ViewBuildViewModel.class);
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.precision_secondary_runes_layout, container, false);
        setupKeystone(view,precisionSecondary11, R.id.precisionSecondary11, 0);
        setupKeystone(view,precisionSecondary12, R.id.precisionSecondary12, 1);
        setupKeystone(view,precisionSecondary13, R.id.precisionSecondary13, 2);
        setupKeystone(view,precisionSecondary21, R.id.precisionSecondary21, 0);
        setupKeystone(view,precisionSecondary22, R.id.precisionSecondary22, 1);
        setupKeystone(view,precisionSecondary23, R.id.precisionSecondary23, 2);
        setupKeystone(view,precisionSecondary31, R.id.precisionSecondary31, 0);
        setupKeystone(view,precisionSecondary32, R.id.precisionSecondary32, 1);
        setupKeystone(view,precisionSecondary33, R.id.precisionSecondary33, 2);
        return view;
    }
}
