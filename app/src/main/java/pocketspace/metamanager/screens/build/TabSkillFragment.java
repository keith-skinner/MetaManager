package pocketspace.metamanager.screens.build;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pocketspace.metamanager.R;

public class TabSkillFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.activity_skill, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.levelRecyclerView);

        List<String> skillOrder = makeSkillList();
        AdapterSkillTab adapter = new AdapterSkillTab(skillOrder);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }

    private List<String> makeSkillList() {
        List<String> skillOrder = new ArrayList<>();


        return skillOrder;
    }
}