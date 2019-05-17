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
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;

import pocketspace.metamanager.R;
import pocketspace.metamanager.data.build.Build;
import pocketspace.metamanager.screens.build.PrimaryRuneTab;
import pocketspace.metamanager.screens.build.ViewBuildViewModel;

public class PrecisionKeystoneFragment extends KeyStoneFragment {

    private AppCompatImageView  precisionKeystone1;
    private AppCompatImageView  precisionKeystone2;
    private AppCompatImageView  precisionKeystone3;
    private AppCompatImageView  precisionKeystone4;

    public static Fragment newInstance(FragmentActivity activity) {
        PrecisionKeystoneFragment fragment = new PrecisionKeystoneFragment();
        fragment.model = ViewModelProviders.of(activity).get(ViewBuildViewModel.class);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.precision_keystone_runes, container, false);
        setupKeystone(view,precisionKeystone1, R.id.precisionKeystone1, 0);
        setupKeystone(view,precisionKeystone2, R.id.precisionKeystone2, 1);
        setupKeystone(view,precisionKeystone3, R.id.precisionKeystone3, 2);
        setupKeystone(view,precisionKeystone4, R.id.precisionKeystone4, 3);
        return view;
    }
}