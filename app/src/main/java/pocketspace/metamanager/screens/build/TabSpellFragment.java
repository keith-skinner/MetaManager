package pocketspace.metamanager.screens.build;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pocketspace.metamanager.R;

public class TabSpellFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(, container, false);

        return view;
    }



//    List<ImageView> getSpells(View view)
//    {
//        List<ImageView> spells = new ArrayList<>();
//        spells.add(view.findViewById(R.id.summoner11));
//        spells.add(view.findViewById(R.id.summoner12));
//        spells.add(view.findViewById(R.id.summoner13));
//        spells.add(view.findViewById(R.id.summoner21));
//        spells.add(view.findViewById(R.id.summoner22));
//        spells.add(view.findViewById(R.id.summoner23));
//        spells.add(view.findViewById(R.id.summoner31));
//        spells.add(view.findViewById(R.id.summoner32));
//        spells.add(view.findViewById(R.id.summoner33));
//        return spells;
//    }
//
//    List<Integer> getActive()
//    {
//        //mock filtered response from database.
//        List<Integer> integers = new ArrayList<>();
//        integers.add(3); //flash
//        integers.add(7); //ignite
//        return integers;
//    }
//
//    List<ImageView> getInactive(List<ImageView> views, List<Integer> active)
//    {
//        for (Integer i : active)
//            views.remove(i-1);
//        return views;
//    }


}
