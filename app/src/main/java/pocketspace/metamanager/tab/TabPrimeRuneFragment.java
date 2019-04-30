package pocketspace.metamanager.tab;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import pocketspace.metamanager.R;
import pocketspace.metamanager.data.Build;

import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TabPrimeRuneFragment extends Fragment {
    public static final String BUNDLE_PRIMARY_RUNE_FAMILY = "BUNDLE_PRIMARY_RUNE_FAMILY";
    public static final String BUNDLE_PRIMARY_RUNE_KEY_STONE = "BUNDLE_PRIMARY_RUNE_KEY_STONE";
    public static final String BUNDLE_PRIMARY_RUNE_ROW1 = "BUNDLE_PRIMARY_RUNE_ROW1";
    public static final String BUNDLE_PRIMARY_RUNE_ROW2 = "BUNDLE_PRIMARY_RUNE_ROW2";
    public static final String BUNDLE_PRIMARY_RUNE_ROW3 = "BUNDLE_PRIMARY_RUNE_ROW3";


    public static TabPrimeRuneFragment newInstance(Build.Runes.Primary runes) {
        TabPrimeRuneFragment fragment = new TabPrimeRuneFragment();
        Bundle args = new Bundle();
        args.putInt(BUNDLE_PRIMARY_RUNE_FAMILY, runes.family.ordinal());
        args.putInt(BUNDLE_PRIMARY_RUNE_KEY_STONE, runes.keystone);
        args.putInt(BUNDLE_PRIMARY_RUNE_ROW1, runes.row1);
        args.putInt(BUNDLE_PRIMARY_RUNE_ROW2, runes.row2);
        args.putInt(BUNDLE_PRIMARY_RUNE_ROW3, runes.row3);

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int layout = pocketspace.metamanager.lol.R.layout.fragment_primary_rune;
        View view = inflater.inflate(layout, container, false);

        if (getArguments() != null) {
            makeFamiliesInactive(view);
            makeKeystonesInactive(view);
            makePrimaryRunesInactive(view);
        }

        return view;
    }

    void makeFamiliesInactive(View view) {
        List<ImageView> families = new ArrayList<>();
        families.add(view.findViewById(pocketspace.metamanager.lol.R.id.family1));
        families.add(view.findViewById(pocketspace.metamanager.lol.R.id.family2));
        families.add(view.findViewById(pocketspace.metamanager.lol.R.id.family3));
        families.add(view.findViewById(pocketspace.metamanager.lol.R.id.family4));
        families.add(view.findViewById(pocketspace.metamanager.lol.R.id.family5));

        families.remove(getArguments().getInt(BUNDLE_PRIMARY_RUNE_FAMILY));
        families.forEach(this::makeInactive);
    }

    void makeKeystonesInactive(View view) {
        int runeFamily = getArguments().getInt(BUNDLE_PRIMARY_RUNE_FAMILY);

        //Todo get the images by a hardcoded class
        List<ImageView> keystones = new ArrayList<>();
        keystones.add(view.findViewById(pocketspace.metamanager.lol.R.id.precisionKeystone1));
        keystones.add(view.findViewById(pocketspace.metamanager.lol.R.id.precisionKeystone2));
        keystones.add(view.findViewById(pocketspace.metamanager.lol.R.id.precisionKeystone3));
        keystones.add(view.findViewById(pocketspace.metamanager.lol.R.id.precisionKeystone4));

        keystones.remove(getArguments().getInt(BUNDLE_PRIMARY_RUNE_KEY_STONE));
        keystones.forEach(this::makeInactive);
    }

    void makePrimaryRunesInactive(View view)
    {
        List<ImageView> primaryRunesR1 = new ArrayList<>();
        primaryRunesR1.add(view.findViewById(pocketspace.metamanager.lol.R.id.precisionSecondary11));
        primaryRunesR1.add(view.findViewById(pocketspace.metamanager.lol.R.id.precisionSecondary12));
        primaryRunesR1.add(view.findViewById(pocketspace.metamanager.lol.R.id.precisionSecondary13));
        primaryRunesR1.remove(getArguments().getInt(BUNDLE_PRIMARY_RUNE_ROW1));
        primaryRunesR1.forEach(this::makeInactive);

        List<ImageView> primaryRunesR2 = new ArrayList<>();
        primaryRunesR2.add(view.findViewById(pocketspace.metamanager.lol.R.id.precisionSecondary21));
        primaryRunesR2.add(view.findViewById(pocketspace.metamanager.lol.R.id.precisionSecondary22));
        primaryRunesR2.add(view.findViewById(pocketspace.metamanager.lol.R.id.precisionSecondary23));
        primaryRunesR2.remove(getArguments().getInt(BUNDLE_PRIMARY_RUNE_ROW2));
        primaryRunesR2.forEach(this::makeInactive);

        List<ImageView> primaryRunesR3 = new ArrayList<>();
        primaryRunesR3.add(view.findViewById(pocketspace.metamanager.lol.R.id.precisionSecondary31));
        primaryRunesR3.add(view.findViewById(pocketspace.metamanager.lol.R.id.precisionSecondary32));
        primaryRunesR3.add(view.findViewById(pocketspace.metamanager.lol.R.id.precisionSecondary33));
        primaryRunesR3.remove(getArguments().getInt(BUNDLE_PRIMARY_RUNE_ROW3));
        primaryRunesR3.forEach(this::makeInactive);
    }

    void makeInactive(ImageView view)
    {
        view.setImageAlpha(127);
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
        view.setColorFilter(filter);
    }
}
