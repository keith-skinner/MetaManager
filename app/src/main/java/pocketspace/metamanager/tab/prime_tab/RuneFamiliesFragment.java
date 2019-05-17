package pocketspace.metamanager.tab.prime_tab;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import pocketspace.metamanager.R;
import pocketspace.metamanager.data.build.Build;
import pocketspace.metamanager.screen_activities.BuildScreen;

public class RuneFamiliesFragment extends Fragment implements View.OnClickListener {


    Build build; //TODO: getBuild, object to modify and update

    private IPrimaryRuneTabFragment iPrimaryRuneTabFragment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState); // Not sure if we need this...
        View v = inflater.inflate(R.layout.layout_family_runes_active, container, false);

        ImageButton key1 = v.findViewById(R.id.family1); // this would be a keystone
        key1.setOnClickListener(this);

        ImageButton key2 = v.findViewById(R.id.family2);
        key2.setOnClickListener(this);

        ImageButton key3 = v.findViewById(R.id.family3);
        key3.setOnClickListener(this);

        ImageButton key4 = v.findViewById(R.id.family4);
        key4.setOnClickListener(this);

        ImageButton key5 = v.findViewById(R.id.family5);
        key5.setOnClickListener(this);


        build = ((BuildScreen)this.getActivity()).getBuild();
        Log.d("clear","Build Name:" + build.name);
        Log.d("clear","Build Champion:" + build.champion);

        return v;
    }


        @Override
    public void onClick(View v) { // event for clicking keystone

        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        switch (v.getId()) {
                case R.id.family1:
                    iPrimaryRuneTabFragment.setKeystone("famOneFragment","");
                    break;
                case R.id.family2:
                    iPrimaryRuneTabFragment.setKeystone("famTwoFragment","");
                    break;
                case R.id.family3:
                    iPrimaryRuneTabFragment.setKeystone("famThreeFragment","");
                    break;
                case R.id.family4:
                    iPrimaryRuneTabFragment.setKeystone("famFourFragment","");
                    break;
                case R.id.family5:
                    iPrimaryRuneTabFragment.setKeystone("famFiveFragment","");
                    break;
        }
    }

    @Override
    public void onAttach(Context c){
        super.onAttach(c);
        iPrimaryRuneTabFragment = (IPrimaryRuneTabFragment) getActivity();
//        build = (BuildScreen) getActivity();

    }


}
