package pocketspace.metamanager;

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

public class TabSkillFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.skill_page, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.levelRecyclerView);
        List<String> skillOrder = makeSkillList();
        AdapterSkillTab adapter = new AdapterSkillTab(skillOrder);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        return view;
    }

    private List<String> makeSkillList() {
        List<String> skillOrder = new ArrayList<String>();

        skillOrder.add("Q");
        skillOrder.add("E");
        skillOrder.add("W");
        skillOrder.add("Q");
        skillOrder.add("Q");
        skillOrder.add("R");

        skillOrder.add("Q");
        skillOrder.add("E");
        skillOrder.add("Q");
        skillOrder.add("E");
        skillOrder.add("R");
        skillOrder.add("E");

        skillOrder.add("E");
        skillOrder.add("W");
        skillOrder.add("W");
        skillOrder.add("R");
        skillOrder.add("W");
        skillOrder.add("W");

        return skillOrder;
    }
}
