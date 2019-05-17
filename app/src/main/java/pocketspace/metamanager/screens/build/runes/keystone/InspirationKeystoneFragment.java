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

public class InspirationKeystoneFragment extends KeyStoneFragment {
    private AppCompatImageView inspirationKeystone1;
    private AppCompatImageView inspirationKeystone2;
    private AppCompatImageView inspirationKeystone3;

    public static Fragment newInstance(FragmentActivity activity) {
        PrecisionKeystoneFragment fragment = new PrecisionKeystoneFragment();
        fragment.model = ViewModelProviders.of(activity).get(ViewBuildViewModel.class);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.inspiration_keystone_runes, container, false);
        setupKeystone(view, inspirationKeystone1, R.id.inspirationKeystone1, 0);
        setupKeystone(view, inspirationKeystone2, R.id.inspirationKeystone2, 1);
        setupKeystone(view,inspirationKeystone3, R.id.inspirationKeystone3, 2);
        return view;
    }
}
