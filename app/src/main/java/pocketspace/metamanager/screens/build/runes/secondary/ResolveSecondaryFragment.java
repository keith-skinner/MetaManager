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

public class ResolveSecondaryFragment extends SecondaryFragment {
    ViewBuildViewModel model;

    AppCompatImageView resolveSecondary11;
    AppCompatImageView resolveSecondary12;
    AppCompatImageView resolveSecondary13;
    AppCompatImageView resolveSecondary21;
    AppCompatImageView resolveSecondary22;
    AppCompatImageView resolveSecondary23;
    AppCompatImageView resolveSecondary31;
    AppCompatImageView resolveSecondary32;
    AppCompatImageView resolveSecondary33;

    public static Fragment getInstance(FragmentActivity activity) {
        ResolveSecondaryFragment fragment = new ResolveSecondaryFragment();
        fragment.model = ViewModelProviders.of(activity).get(ViewBuildViewModel.class);
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.resolve_secondary_runes_layout, container, false);
        setupKeystone(view, resolveSecondary11, R.id.resolveSecondary11, 0);
        setupKeystone(view, resolveSecondary12, R.id.resolveSecondary12, 1);
        setupKeystone(view, resolveSecondary13, R.id.resolveSecondary13, 2);
        setupKeystone(view, resolveSecondary21, R.id.resolveSecondary21, 0);
        setupKeystone(view, resolveSecondary22, R.id.resolveSecondary22, 1);
        setupKeystone(view, resolveSecondary23, R.id.resolveSecondary23, 2);
        setupKeystone(view, resolveSecondary31, R.id.resolveSecondary31, 0);
        setupKeystone(view, resolveSecondary32, R.id.resolveSecondary32, 1);
        setupKeystone(view, resolveSecondary33, R.id.resolveSecondary33, 2);
        return view;
    }
}
