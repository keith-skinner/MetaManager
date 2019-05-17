package pocketspace.metamanager.tab.prime_tab;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

import pocketspace.metamanager.R;
import pocketspace.metamanager.data.build.Build;
import pocketspace.metamanager.data.build.runes.PrimaryRunes;
import pocketspace.metamanager.screen_activities.BuildScreen;

public class TabPrimeFragment extends Fragment {

    // currently in a List of Fragments within the tabAdapter class,
    // being displayed with : TabLayout.
    // now the question is, can we have the fragment that is in a list have nested fragments in it?
    // These nested fragments will have to display on the fragment parents layout.

    private static final String BUNDLE_PRIMARY_RUNE_FAMILY = "BUNDLE_PRIMARY_RUNE_FAMILY";
    private static final String BUNDLE_PRIMARY_RUNE_KEY_STONE = "BUNDLE_PRIMARY_RUNE_KEY_STONE";
    private static final String BUNDLE_PRIMARY_RUNE_ROW1 = "BUNDLE_PRIMARY_RUNE_ROW1";
    private static final String BUNDLE_PRIMARY_RUNE_ROW2 = "BUNDLE_PRIMARY_RUNE_ROW2";
    private static final String BUNDLE_PRIMARY_RUNE_ROW3 = "BUNDLE_PRIMARY_RUNE_ROW3";

    TabPrimeFragment fragment;
//    BuildScreen buildScreen = (BuildScreen) this.getActivity();
    Build build;


    // CUSTOM FUNCTION: Creats a new instance of this fragment and passes it to the TabLayout (with args)
    public Fragment newInstance(PrimaryRunes runes)
    {
//        Bundle args = new Bundle();
//        args.putInt(BUNDLE_PRIMARY_RUNE_FAMILY, runes.family.getFamily()); //this is going to be a fragment...
//        args.putInt(BUNDLE_PRIMARY_RUNE_FAMILY, runes.family.getFamily());
//        args.putInt(BUNDLE_PRIMARY_RUNE_KEY_STONE, runes.keystone);
//        args.putInt(BUNDLE_PRIMARY_RUNE_ROW1, runes.row1);
//        args.putInt(BUNDLE_PRIMARY_RUNE_ROW2, runes.row2);
//        args.putInt(BUNDLE_PRIMARY_RUNE_ROW3, runes.row3);

//        fragment.setArguments(args); TODO: sending selection of Runes to Obj Build


        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        int layout = pocketspace.metamanager.lol.R.layout.fragment_prime_parent_layout;
        View view = inflater.inflate(layout, container, false);

//      Here is how we alter the build object inside of the tabFragment:
//        BuildScreen buildScreen = (BuildScreen) this.getActivity();
//        Build build = buildScreen.build;

        build = ((BuildScreen)this.getActivity()).getBuild();
        build.champion = "Maggie";
        Log.d("clear","" + build.name);


//        if (getArguments() != null)
//        {
//            makeFamiliesInactive(view);
//            makeKeystonesInactive(view);
//            makePrimaryRunesInactive(view);
//        }
        return view;
    }


    ChildFragmentKeystone keystoneFragment;
//    ChildFragmentSecondary secondaryFragment;

     @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        insertNestedFragment();
    }

    // Embeds the child fragment dynamically
    private void insertNestedFragment()
    {
        keystoneFragment = new ChildFragmentKeystone();

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.child_fragment_container_keystone, keystoneFragment).commit();

    }



    private void makeFamiliesInactive(View view)
    {
        List<ImageView> families = new ArrayList<>();
        families.add(view.findViewById(pocketspace.metamanager.lol.R.id.family1));
        families.add(view.findViewById(pocketspace.metamanager.lol.R.id.family2));
        families.add(view.findViewById(pocketspace.metamanager.lol.R.id.family3));
        families.add(view.findViewById(pocketspace.metamanager.lol.R.id.family4));
        families.add(view.findViewById(pocketspace.metamanager.lol.R.id.family5));

        assert getArguments() != null;
        families.remove(getArguments().getInt(BUNDLE_PRIMARY_RUNE_FAMILY));
        families.forEach(this::makeInactive);
    }

    private void makeKeystonesInactive(View view)
    {
        assert getArguments() != null;
        int runeFamily = getArguments().getInt(BUNDLE_PRIMARY_RUNE_FAMILY);
//
//        TODO: get the images by a hardcoded class
        List<ImageView> keystones = new ArrayList<>();
        keystones.add(view.findViewById(pocketspace.metamanager.lol.R.id.precisionKeystone1));
        keystones.add(view.findViewById(pocketspace.metamanager.lol.R.id.precisionKeystone2));
        keystones.add(view.findViewById(pocketspace.metamanager.lol.R.id.precisionKeystone3));
        keystones.add(view.findViewById(pocketspace.metamanager.lol.R.id.precisionKeystone4));

        keystones.remove(getArguments().getInt(BUNDLE_PRIMARY_RUNE_KEY_STONE));
        keystones.forEach(this::makeInactive);
    }

//    private void makePrimaryRunesInactive(View view)
//    {
//        List<ImageView> primaryRunesR1 = new ArrayList<>();
//        primaryRunesR1.add(view.findViewById(pocketspace.metamanager.lol.R.id.precisionSecondary11));
//        primaryRunesR1.add(view.findViewById(pocketspace.metamanager.lol.R.id.precisionSecondary12));
//        primaryRunesR1.add(view.findViewById(pocketspace.metamanager.lol.R.id.precisionSecondary13));
//        primaryRunesR1.remove(getArguments().getInt(BUNDLE_PRIMARY_RUNE_ROW1));
//        primaryRunesR1.forEach(this::makeInactive);
//
//        List<ImageView> primaryRunesR2 = new ArrayList<>();
//        primaryRunesR2.add(view.findViewById(pocketspace.metamanager.lol.R.id.precisionSecondary21));
//        primaryRunesR2.add(view.findViewById(pocketspace.metamanager.lol.R.id.precisionSecondary22));
//        primaryRunesR2.add(view.findViewById(pocketspace.metamanager.lol.R.id.precisionSecondary23));
//        primaryRunesR2.remove(getArguments().getInt(BUNDLE_PRIMARY_RUNE_ROW2));
//        primaryRunesR2.forEach(this::makeInactive);
//
//        List<ImageView> primaryRunesR3 = new ArrayList<>();
//        primaryRunesR3.add(view.findViewById(pocketspace.metamanager.lol.R.id.precisionSecondary31));
//        primaryRunesR3.add(view.findViewById(pocketspace.metamanager.lol.R.id.precisionSecondary32));
//        primaryRunesR3.add(view.findViewById(pocketspace.metamanager.lol.R.id.precisionSecondary33));
//        primaryRunesR3.remove(getArguments().getInt(BUNDLE_PRIMARY_RUNE_ROW3));
//        primaryRunesR3.forEach(this::makeInactive);
//    }

    private void makeInactive(ImageView view)
    {
        view.setImageAlpha(127);
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
        view.setColorFilter(filter);
    }

}