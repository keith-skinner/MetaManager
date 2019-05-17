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

public class ResolveKeystoneFragment extends KeyStoneFragment {

    private AppCompatImageView resolveKeystone1;
    private AppCompatImageView resolveKeystone2;
    private AppCompatImageView resolveKeystone3;

    public static Fragment newInstance(FragmentActivity activity) {
        PrecisionKeystoneFragment fragment = new PrecisionKeystoneFragment();
        fragment.model = ViewModelProviders.of(activity).get(ViewBuildViewModel.class);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.resolve_keystone_runes, container, false);
        setupKeystone(view,resolveKeystone1, R.id.resolveKeystone1, 0);
        setupKeystone(view,resolveKeystone2, R.id.resolveKeystone2, 1);
        setupKeystone(view,resolveKeystone3, R.id.resolveKeystone3, 2);
        return view;
    }
}
