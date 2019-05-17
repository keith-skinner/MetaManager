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

public class SorcerySecondaryFragment extends SecondaryFragment {

    AppCompatImageView sorcerySecondary11;
    AppCompatImageView sorcerySecondary12;
    AppCompatImageView sorcerySecondary13;
    AppCompatImageView sorcerySecondary21;
    AppCompatImageView sorcerySecondary22;
    AppCompatImageView sorcerySecondary23;
    AppCompatImageView sorcerySecondary31;
    AppCompatImageView sorcerySecondary32;
    AppCompatImageView sorcerySecondary33;

    public static Fragment getInstance(FragmentActivity activity) {
        SorcerySecondaryFragment fragment = new SorcerySecondaryFragment();
        fragment.model = ViewModelProviders.of(activity).get(ViewBuildViewModel.class);
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sorcery_secondary_runes, container, false);
        setupKeystone(view, sorcerySecondary11, R.id.sorcerySecondary11, 0);
        setupKeystone(view, sorcerySecondary12, R.id.sorcerySecondary12, 1);
        setupKeystone(view, sorcerySecondary13, R.id.sorcerySecondary13, 2);
        setupKeystone(view, sorcerySecondary21, R.id.sorcerySecondary21, 0);
        setupKeystone(view, sorcerySecondary22, R.id.sorcerySecondary22, 1);
        setupKeystone(view, sorcerySecondary23, R.id.sorcerySecondary23, 2);
        setupKeystone(view, sorcerySecondary31, R.id.sorcerySecondary31, 0);
        setupKeystone(view, sorcerySecondary32, R.id.sorcerySecondary32, 1);
        setupKeystone(view, sorcerySecondary33, R.id.sorcerySecondary33, 2);
        return view;
    }
}
