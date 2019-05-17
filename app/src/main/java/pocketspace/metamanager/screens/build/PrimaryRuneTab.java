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
import pocketspace.metamanager.screens.build.runes.keystone.DominationKeystoneFragment;
import pocketspace.metamanager.screens.build.runes.keystone.InspirationKeystoneFragment;
import pocketspace.metamanager.screens.build.runes.keystone.PrecisionKeystoneFragment;
import pocketspace.metamanager.screens.build.runes.keystone.ResolveKeystoneFragment;
import pocketspace.metamanager.screens.build.runes.keystone.SorceryKeystoneFragment;
import pocketspace.metamanager.screens.build.runes.secondary.DominationSecondaryFragment;
import pocketspace.metamanager.screens.build.runes.secondary.InspirationSecondaryFragment;
import pocketspace.metamanager.screens.build.runes.secondary.PrecisionSecondaryFragment;
import pocketspace.metamanager.screens.build.runes.secondary.ResolveSecondaryFragment;
import pocketspace.metamanager.screens.build.runes.secondary.SorcerySecondaryFragment;

public class PrimaryRuneTab extends Fragment {
    private ViewBuildViewModel model;
    private Fragment runeFamilyFragment;
    private Fragment keystoneFragment;
    private Fragment secondaryRuneFragment;

    public static Fragment newInstance(FragmentActivity activity) {
        PrimaryRuneTab fragment = new PrimaryRuneTab();
        fragment.model = ViewModelProviders.of(activity).get(ViewBuildViewModel.class);
        return fragment;
    }


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.primary_rune_tab_layout, container, false);

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
                keystoneFragment = PrecisionKeystoneFragment.newInstance(getActivity());
                transaction.replace(R.id.keystone_fragment_container, keystoneFragment, ""/*TODO Look Later*/);
                secondaryRuneFragment = PrecisionSecondaryFragment.getInstance(getActivity());
                transaction.replace(R.id.secondary_fragment_container, secondaryRuneFragment, ""/*TODO look later*/);
                break;
            case RuneFamily.DOMINATION:
                transaction.replace(R.id.keystone_fragment_container, new DominationKeystoneFragment(), "");
                transaction.replace(R.id.secondary_fragment_container, new DominationSecondaryFragment(), "");
                break;
            case RuneFamily.SORCERY:
                transaction.replace(R.id.keystone_fragment_container, new SorceryKeystoneFragment(), "");
                transaction.replace(R.id.secondary_fragment_container, new SorcerySecondaryFragment(), "");
                break;
            case RuneFamily.RESOLVE:
                transaction.replace(R.id.keystone_fragment_container, new ResolveKeystoneFragment(), "");
                transaction.replace(R.id.secondary_fragment_container, new ResolveSecondaryFragment(), "");
                break;
            case RuneFamily.INSPIRATION:
                transaction.replace(R.id.keystone_fragment_container, new InspirationKeystoneFragment(), "");
                transaction.replace(R.id.secondary_fragment_container, new InspirationSecondaryFragment(), "");
                break;
            default:
                transaction.hide(keystoneFragment);
                transaction.hide(secondaryRuneFragment);
        }
        transaction.commit();
    }
}