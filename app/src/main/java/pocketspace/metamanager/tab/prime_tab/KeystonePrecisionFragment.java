package pocketspace.metamanager.tab.prime_tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import pocketspace.metamanager.R;

public class KeystonePrecisionFragment extends Fragment {

    private static final String TAG = "PrecisionFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(pocketspace.metamanager.lol.R.layout.precision_primary_runes_layout, container, false);
        return v;
    }

}
