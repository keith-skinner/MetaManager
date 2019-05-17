package pocketspace.metamanager.tab.prime_tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import pocketspace.metamanager.R;

public class PrimaryRuneTabFragment extends Fragment implements IPrimaryRuneTabFragment{

    // currently in a List of Fragments within the tabAdapter class,
    // being displayed with : TabLayout.
    // now the question is, can we have the fragment that is in a list have nested fragments in it?
    // These nested fragments will have to display on the fragment parents layout.


    private IPrimaryRuneTabFragment mIPrimaryRuneTabFragment;
    private Fragment runeFamilyFragment;
    private Fragment keystoneFragment;
    private Fragment secondaryRuneFragment;


//    RuneFamiliesFragment runeFamilyFragment;
//    PrimaryRuneTabFragment fragment;
    //    BuildScreen buildScreen = (BuildScreen) this.getActivity();
    //    Build build;
    // CUSTOM FUNCTION: Creats a new instance of this fragment and passes it to the TabLayout (with args)
//    public Fragment newInstance(PrimaryRunes runes)
//    {
////        Bundle args = new Bundle();
////        args.putInt(BUNDLE_PRIMARY_RUNE_FAMILY, runes.family.getFamily()); //this is going to be a fragment...
////        args.putInt(BUNDLE_PRIMARY_RUNE_FAMILY, runes.family.getFamily());
////        args.putInt(BUNDLE_PRIMARY_RUNE_KEY_STONE, runes.keystone);
////        args.putInt(BUNDLE_PRIMARY_RUNE_ROW1, runes.row1);
////        args.putInt(BUNDLE_PRIMARY_RUNE_ROW2, runes.row2);
////        args.putInt(BUNDLE_PRIMARY_RUNE_ROW3, runes.row3);
//
////        fragment.setArguments(args); TODO: sending selection of Runes to Obj Build
//
//
//        return fragment;
//    }
//    @Override
//    public void onCreate(@Nullable Bundle savedInstance){
//        super.onCreate(savedInstance);
//    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.primary_rune_tab_layout, container, false);



        return view;
    }



    @Override
    public void changeRuneFamily(String keystoneTag, String message) {

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//        transaction.replace(R.id.family_fragment_container, fragment, tag);


        switch (keystoneTag){
            case "famOneFragment":
                transaction.replace(R.id.keystone_fragment_container, keystonePrecisionFragment);
                break;

            case "famTwoFragment":
                transaction.replace(R.id.keystone_fragment_container, keystoneDominationFragment);
                break;

            case "famThreeFragment":
                transaction.replace(R.id.keystone_fragment_container, keystoneDominationFragment);
                break;
        }
        transaction.commit();

    }

}