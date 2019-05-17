package pocketspace.metamanager.screens.build;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import pocketspace.metamanager.R;
import pocketspace.metamanager.data.build.runes.RuneFamily;
import pocketspace.metamanager.screens.build.runes.family.RuneFamilyFragment;
import pocketspace.metamanager.screens.build.runes.secondary.DominationSecondaryFragment;
import pocketspace.metamanager.screens.build.runes.secondary.InspirationSecondaryFragment;
import pocketspace.metamanager.screens.build.runes.secondary.PrecisionSecondaryFragment;
import pocketspace.metamanager.screens.build.runes.secondary.ResolveSecondaryFragment;
import pocketspace.metamanager.screens.build.runes.secondary.SorcerySecondaryFragment;

public class SecondaryRuneTab extends Fragment {

    private ViewBuildViewModel model;
    private Fragment runeFamilyFragment;
    private Fragment secondaryRuneFragment;
    private Fragment tertiaryRuneFragment;

    public static Fragment newInstance(FragmentActivity activity) {
        SecondaryRuneTab fragment = new SecondaryRuneTab();
        fragment.model = ViewModelProviders.of(activity).get(ViewBuildViewModel.class);
        return fragment;
    }


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.secondary_rune_tab_layout, container, false);

        runeFamilyFragment = RuneFamilyFragment.newInstance(getActivity());
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.family_fragment_container, runeFamilyFragment)
                .commit();
        if (model.build.getValue() != null)
            changeRuneFamily(model.build.getValue().runes.primary.family.toInt());
        return view;
    }

    public void changeRuneFamily(int family)
    {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        RuneFamily runeFamily = new RuneFamily(family);
        switch (runeFamily.getFamily()){
            case RuneFamily.PRECISION:
                secondaryRuneFragment = PrecisionSecondaryFragment.getInstance(getActivity());
                transaction.replace(R.id.secondary_fragment_container, secondaryRuneFragment, ""/*TODO look later*/);
                break;
            case RuneFamily.DOMINATION:
                secondaryRuneFragment = DominationSecondaryFragment.getInstance(getActivity());
                transaction.replace(R.id.secondary_fragment_container, secondaryRuneFragment, ""/*TODO look later*/);
                break;
            case RuneFamily.SORCERY:
                secondaryRuneFragment = SorcerySecondaryFragment.getInstance(getActivity());
                transaction.replace(R.id.secondary_fragment_container, secondaryRuneFragment, ""/*TODO look later*/);
                break;
            case RuneFamily.RESOLVE:
                secondaryRuneFragment = ResolveSecondaryFragment.getInstance(getActivity());
                transaction.replace(R.id.secondary_fragment_container, secondaryRuneFragment, ""/*TODO look later*/);
                break;
            case RuneFamily.INSPIRATION:
                secondaryRuneFragment = InspirationSecondaryFragment.getInstance(getActivity());
                transaction.replace(R.id.secondary_fragment_container, secondaryRuneFragment, ""/*TODO look later*/);
                break;
            default:
                transaction.hide(secondaryRuneFragment);
        }
        transaction.commit();
    }
}
