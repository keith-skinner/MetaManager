package pocketspace.metamanager.tab;

import android.content.Context;
import android.database.Cursor;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import pocketspace.metamanager.R;
import pocketspace.metamanager.database.MetaManagerDatabaseHelper;
import pocketspace.metamanager.database.MetaManagerDatabaseSchema;

public class TabSpellFragment extends Fragment {

    MetaManagerDatabaseHelper db;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        db = new MetaManagerDatabaseHelper(getActivity());

        //setViews();

        View view = inflater.inflate(R.layout.summoner_spells_container, container, false);
        makeInactive(view);
        return view;
    }

    public void setViews()
    {
        Cursor cursor = db.getAllDataFromSummonerTable();
        int indexOfSummonerName = cursor.getColumnIndex(MetaManagerDatabaseSchema.SummonerTable.Cols.NAME);
        int indexOfSummonerImage = cursor.getColumnIndex(MetaManagerDatabaseSchema.SummonerTable.Cols.IMAGE);

        View view = new View(getActivity());
        ImageView image1 = view.findViewById(R.id.summoner11);

        //Picasso.get().load("file:///android_asset/barrier.png").into(image1);
    }

    void makeInactive(View view)
    {
        for (ImageView image : getInactive(getSpells(view), getActive()))
        {
            image.setImageAlpha(127);
            ColorMatrix matrix = new ColorMatrix();
            matrix.setSaturation(0);
            ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
            image.setColorFilter(filter);
        }
    }

    List<ImageView> getSpells(View view)
    {
        List<ImageView> spells = new ArrayList<>();
        spells.add(view.findViewById(R.id.summoner11));
        spells.add(view.findViewById(R.id.summoner12));
        spells.add(view.findViewById(R.id.summoner13));
        spells.add(view.findViewById(R.id.summoner21));
        spells.add(view.findViewById(R.id.summoner22));
        spells.add(view.findViewById(R.id.summoner23));
        spells.add(view.findViewById(R.id.summoner31));
        spells.add(view.findViewById(R.id.summoner32));
        spells.add(view.findViewById(R.id.summoner33));
        return spells;
    }

    List<Integer> getActive()
    {
        //mock filtered response from database.
        List<Integer> integers = new ArrayList<>();
        integers.add(3); //flash
        integers.add(7); //ignite
        return integers;
    }

    List<ImageView> getInactive(List<ImageView> views, List<Integer> active)
    {
        for (Integer i : active)
            views.remove(i-1);
        return views;
    }


}
