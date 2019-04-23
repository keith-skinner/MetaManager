package pocketspace.metamanager.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;


import java.util.ArrayList;
import java.util.List;

import pocketspace.metamanager.R;


public class FragmentRune extends Fragment {

    static List<String> skills = new ArrayList<String>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_primary_rune, container, false);
    }
}
