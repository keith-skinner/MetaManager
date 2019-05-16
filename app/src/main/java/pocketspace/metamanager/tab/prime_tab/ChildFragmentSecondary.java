package pocketspace.metamanager.tab.prime_tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import pocketspace.metamanager.R;

public class ChildFragmentSecondary extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.domination_primary_runes, container, false);
        return v;
    }

}
