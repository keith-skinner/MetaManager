package pocketspace.metamanager.screens.build.runes.secondary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;

import pocketspace.metamanager.R;
import pocketspace.metamanager.screens.build.ViewBuildViewModel;

public class DominationSecondaryFragment extends SecondaryFragment {

    ViewBuildViewModel model;

    AppCompatImageView dominationSecondary11;
    AppCompatImageView dominationSecondary12;
    AppCompatImageView dominationSecondary13;
    AppCompatImageView dominationSecondary21;
    AppCompatImageView dominationSecondary22;
    AppCompatImageView dominationSecondary23;
    AppCompatImageView dominationSecondary31;
    AppCompatImageView dominationSecondary32;
    AppCompatImageView dominationSecondary33;
    AppCompatImageView dominationSecondary34;

    public static Fragment getInstance(FragmentActivity activity) {
        DominationSecondaryFragment fragment = new DominationSecondaryFragment();
        fragment.model = ViewModelProviders.of(activity).get(ViewBuildViewModel.class);
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.domination_secondary_runes, container, false);
        setupKeystone(view, dominationSecondary11, R.id.dominationSecondary11, 0);
        setupKeystone(view, dominationSecondary12, R.id.dominationSecondary12, 1);
        setupKeystone(view, dominationSecondary13, R.id.dominationSecondary13, 2);
        setupKeystone(view, dominationSecondary21, R.id.dominationSecondary21, 0);
        setupKeystone(view, dominationSecondary22, R.id.dominationSecondary22, 1);
        setupKeystone(view, dominationSecondary23, R.id.dominationSecondary23, 2);
        setupKeystone(view, dominationSecondary31, R.id.dominationSecondary31, 0);
        setupKeystone(view, dominationSecondary32, R.id.dominationSecondary32, 1);
        setupKeystone(view, dominationSecondary33, R.id.dominationSecondary33, 2);
        setupKeystone(view, dominationSecondary34, R.id.dominationSecondary34, 3);
        return view;
    }

}
