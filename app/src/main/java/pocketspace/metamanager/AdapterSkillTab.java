package pocketspace.metamanager;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdapterSkillTab extends RecyclerView.Adapter<AdapterSkillTab.ViewHolder>
{

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView lvlNumber;
        View skillQ;
        View skillW;
        View skillE;
        View skillR;

        ViewHolder(View view) {
            super(view);
            lvlNumber = view.findViewById(R.id.lvlNumber);
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
        View contactView = inflater.inflate(R.layout.skill_page_level, parent, false);
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final String skill = this.skills.get(position);

        TextView lvlNumber = viewHolder.lvlNumber;
        lvlNumber.setText(String.valueOf(position+1));

        viewHolder.skillQ.setBackgroundResource(R.drawable.outline_square);
        viewHolder.skillW.setBackgroundResource(R.drawable.outline_square);
        viewHolder.skillE.setBackgroundResource(R.drawable.outline_square);
        viewHolder.skillR.setBackgroundResource(R.drawable.outline_square);

        View activeSkill = null;
        if (skill.equals("Q"))
            activeSkill = viewHolder.skillQ;
        else if (skill.equals("W"))
            activeSkill = viewHolder.skillW;
        else if (skill.equals("E"))
            activeSkill = viewHolder.skillE;
        else if (skill.equals("R"))
            activeSkill = viewHolder.skillR;

        if (activeSkill != null)
            activeSkill.setBackgroundResource(R.color.darkPurple);
    }

    @Override
    public int getItemCount() {
        return skills.size();
    }
}