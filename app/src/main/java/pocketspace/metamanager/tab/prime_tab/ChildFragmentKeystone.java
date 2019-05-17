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

public class ChildFragmentKeystone extends Fragment implements View.OnClickListener {


    Fragment fragmentTwo, frag2;
    ChildFragmentSecondary secondaryFragment;
    Build build;


    private OnChildFragmentToActivityInteractionListener mActivityListener;

    //TODO: for altering the build Obj.
//    BuildScreen buildScreen = (BuildScreen) this.getActivity();
//    Build build = buildScreen.build;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState); // Not sure if we need this...
        View v = inflater.inflate(R.layout.fragment_prime_child_rune_keystone, container, false);

        ImageButton key1 = v.findViewById(R.id.family1); // this would be a keystone
        key1.setOnClickListener(this);

        ImageButton key2 = v.findViewById(R.id.family2);
        key2.setOnClickListener(this);

        build = ((BuildScreen)this.getActivity()).getBuild();
        Log.d("clear","Build Name:" + build.name);
        Log.d("clear","Build Chapion:" + build.champion);



        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        insertNestedFragment();
    }

    // Embeds the child fragment dynamically
    private void insertNestedFragment() {
        secondaryFragment = new ChildFragmentSecondary();

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.child_fragment_container_secondary, secondaryFragment).commit();
    }


        @Override
    public void onClick(View v) { // event for clicking keystone

        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();



        switch (v.getId()) {
                case R.id.family1:
                    fragmentTwo = new ChildChildFPrimaryAss();
                    fragmentTransaction.replace(R.id.child_fragment_container_secondary, fragmentTwo);
                    mActivityListener.messageFromChildFragmentToActivity("Hello, Activity. I am the child fragment.");

//              TODO: when a keystone is selected, update family:

//                    build.runes.primary.family.setFamily(1);

                    break;
                case R.id.family2:
                    frag2 = new ChildFragmentSecondary();
                    fragmentTransaction.replace(R.id.child_fragment_container_secondary, frag2);
                    break;
        }

        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // check if Activity implements listener
        if (context instanceof OnChildFragmentToActivityInteractionListener) {
            mActivityListener = (OnChildFragmentToActivityInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnChildFragmentToActivityInteractionListener");
        }
    }


    public interface OnChildFragmentToActivityInteractionListener {
        void messageFromChildFragmentToActivity(String myString);
    }

    public interface OnChildFragmentInteractionListener {
        void messageFromChildToParent(String myString);
    }


}
