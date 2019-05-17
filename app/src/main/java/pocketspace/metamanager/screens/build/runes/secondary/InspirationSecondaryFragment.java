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

public class InspirationSecondaryFragment extends SecondaryFragment {
    ViewBuildViewModel model;

    AppCompatImageView inspirationSecondary11;
    AppCompatImageView inspirationSecondary12;
    AppCompatImageView inspirationSecondary13;
    AppCompatImageView inspirationSecondary21;
    AppCompatImageView inspirationSecondary22;
    AppCompatImageView inspirationSecondary23;
    AppCompatImageView inspirationSecondary31;
    AppCompatImageView inspirationSecondary32;
    AppCompatImageView inspirationSecondary33;

    public static Fragment getInstance(FragmentActivity activity) {
        InspirationSecondaryFragment fragment = new InspirationSecondaryFragment();
        fragment.model = ViewModelProviders.of(activity).get(ViewBuildViewModel.class);
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_inspiration_secondary_runes, container, false);
        setupKeystone(view, inspirationSecondary11, R.id.inspirationSecondary11, 0);
        setupKeystone(view, inspirationSecondary12, R.id.inspirationSecondary12, 1);
        setupKeystone(view, inspirationSecondary13, R.id.inspirationSecondary13, 2);
        setupKeystone(view, inspirationSecondary21, R.id.inspirationSecondary21, 0);
        setupKeystone(view, inspirationSecondary22, R.id.inspirationSecondary22, 1);
        setupKeystone(view, inspirationSecondary23, R.id.inspirationSecondary23, 2);
        setupKeystone(view, inspirationSecondary31, R.id.inspirationSecondary31, 0);
        setupKeystone(view, inspirationSecondary32, R.id.inspirationSecondary32, 1);
        setupKeystone(view, inspirationSecondary33, R.id.inspirationSecondary33, 2);
        return view;
    }

}
