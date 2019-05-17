package pocketspace.metamanager.screens.build.runes.family;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;

import pocketspace.metamanager.R;
import pocketspace.metamanager.data.build.runes.RuneFamily;
import pocketspace.metamanager.screens.build.ViewBuildViewModel;
import pocketspace.metamanager.screens.build.runes.keystone.PrecisionKeystoneFragment;

public class RuneFamilyFragment extends Fragment {

    ViewBuildViewModel model;

    AppCompatImageView family1;
    AppCompatImageView family2;
    AppCompatImageView family3;
    AppCompatImageView family4;
    AppCompatImageView family5;

    public static Fragment newInstance(FragmentActivity activity) {
        RuneFamilyFragment fragment = new RuneFamilyFragment();
        fragment.model = ViewModelProviders.of(activity).get(ViewBuildViewModel.class);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.family_runes, container, false);
        setupKeystone(view,family1, R.id.family1, 0);
        setupKeystone(view,family2, R.id.family2, 1);
        setupKeystone(view,family3, R.id.family3, 2);
        setupKeystone(view,family4, R.id.family4, 3);
        setupKeystone(view,family5, R.id.family5, 4);
        return view;
    }

    void setupKeystone(View view, AppCompatImageView keystoneView, int keystoneId, int position) {
        keystoneView = view.findViewById(keystoneId);
        keystoneView.setOnClickListener( v-> Toast.makeText(v.getContext(), "Keystone " + position + " Clicked", Toast.LENGTH_SHORT).show());
    }


}
