package pocketspace.metamanager.screens.build.runes.keystone;

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
import pocketspace.metamanager.screens.build.ViewBuildViewModel;

public class DominationKeystoneFragment extends KeyStoneFragment {

    private AppCompatImageView  dominationKeystone1;
    private AppCompatImageView  dominationKeystone2;
    private AppCompatImageView  dominationKeystone3;
    private AppCompatImageView  dominationKeystone4;

    public static Fragment newInstance(FragmentActivity activity) {
        PrecisionKeystoneFragment fragment = new PrecisionKeystoneFragment();
        fragment.model = ViewModelProviders.of(activity).get(ViewBuildViewModel.class);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.domination_keystone_runes, container, false);
        setupKeystone(view,dominationKeystone1, R.id.dominationKeystone1, 0);
        setupKeystone(view,dominationKeystone2, R.id.dominationKeystone2, 1);
        setupKeystone(view,dominationKeystone3, R.id.dominationKeystone3, 2);
        setupKeystone(view,dominationKeystone4, R.id.dominationKeystone4, 3);
        return view;
    }
}