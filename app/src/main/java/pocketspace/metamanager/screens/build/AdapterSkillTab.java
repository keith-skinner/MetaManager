package pocketspace.metamanager.screens.build;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import pocketspace.metamanager.R;

public class AdapterSkillTab extends RecyclerView.Adapter<AdapterSkillTab.ViewHolder>
{


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView skillQ;
        TextView skillW;
        TextView skillE;
        TextView skillR;

        ViewHolder(View view) {
            super(view);
            skillQ = view.findViewById(R.id.skillQ);
            skillW = view.findViewById(R.id.skillW);
            skillE = view.findViewById(R.id.skillE);
            skillR = view.findViewById(R.id.skillR);
        }
    }

    private List<String> skills;

    AdapterSkillTab(List<String> skills) {
        super();
        this.skills = skills;
    }

    @NonNull
    @Override
    public AdapterSkillTab.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View contactView = inflater.inflate(R.layout.activity_skill_containers, parent, false);
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final String skill = this.skills.get(position);

        viewHolder.skillQ.setBackgroundResource(R.color.box);
        viewHolder.skillW.setBackgroundResource(R.color.box);
        viewHolder.skillE.setBackgroundResource(R.color.box);
        viewHolder.skillR.setBackgroundResource(R.color.box);

        viewHolder.skillQ.setText("");
        viewHolder.skillW.setText("");
        viewHolder.skillE.setText("");
        viewHolder.skillR.setText("");

        TextView activeSkill = null;
        if (skill.equals("Q"))
            activeSkill = viewHolder.skillQ;
        else if (skill.equals("W"))
            activeSkill = viewHolder.skillW;
        else if (skill.equals("E"))
            activeSkill = viewHolder.skillE;
        else if (skill.equals("R"))
            activeSkill = viewHolder.skillR;

        if (activeSkill != null) {
            activeSkill.setBackgroundResource(R.drawable.numbered);
            activeSkill.setText(""+(position+1));
        }
    }
    @Override
    public int getItemCount() {
        return skills.size();
    }
}