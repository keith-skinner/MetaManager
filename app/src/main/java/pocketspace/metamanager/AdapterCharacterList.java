package pocketspace.metamanager;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterCharacterList extends RecyclerView.Adapter<AdapterCharacterList.ViewHolder>
{

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView characterThumbnail;
        TextView characterName;
        LinearLayoutCompat characterLayout;

        ViewHolder(View view) {
            super(view);
            characterThumbnail = view.findViewById(R.id.characterThumbnail);
            characterName = view.findViewById(R.id.characterName);
            characterLayout = view.findViewById(R.id.characterElementLayout);
        }
    }

    private List<ActivityCharacterList.Character> characters;

    AdapterCharacterList(List<ActivityCharacterList.Character> characters) {
        this.characters = characters;
    }

    @Override
    @NonNull
    public AdapterCharacterList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View contactView = inflater.inflate(R.layout.activity_character_element, parent, false);
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCharacterList.ViewHolder viewHolder, int position) {
        final ActivityCharacterList.Character character = this.characters.get(position);

        TextView characterName = viewHolder.characterName;
        characterName.setText(character.name);

        ImageView characterThumbnail = viewHolder.characterThumbnail;
        characterThumbnail.setBackgroundResource(character.image);

        LinearLayoutCompat characterLayout = viewHolder.characterLayout;
        characterLayout.setOnClickListener((View view)->{
            Intent intent = new Intent(view.getContext(), ActivityRole.class);
            intent.putExtra(view.getResources().getString(R.string.characterName), character.name);
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() { return this.characters.size(); }
}
