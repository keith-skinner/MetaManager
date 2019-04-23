package pocketspace.metamanager.list;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pocketspace.metamanager.R;
import pocketspace.metamanager.screen_activities.ActivityGameList;

public class AdapterGameList extends RecyclerView.Adapter<AdapterGameList.ViewHolder>
{

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView gameLogoIcon;
        TextView gameName;
        LinearLayoutCompat gameListRow;

        ViewHolder(View view) {
            super(view);
            gameLogoIcon = view.findViewById(R.id.gameLogoIcon);
            gameName = view.findViewById(R.id.gameName);
            gameListRow = view.findViewById(R.id.gameListRow);
        }
    }

    private List<ActivityGameList.Game> games;

    public AdapterGameList(List<ActivityGameList.Game> games) {
        super();
        this.games = games;
    }

    @Override
    @NonNull
    public AdapterGameList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Get the inflater from the parent
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View contactView = inflater.inflate(R.layout.game_list_row, parent, false);
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterGameList.ViewHolder viewHolder, int position) {
        final ActivityGameList.Game game = this.games.get(position);

        TextView gameName = viewHolder.gameName;
        gameName.setText(game.gameName);

        ImageView gameLogoIcon = viewHolder.gameLogoIcon;
        gameLogoIcon.setImageResource(game.gameImageResource);

        LinearLayoutCompat gameListRow = viewHolder.gameListRow;
        gameListRow.setOnClickListener((View view)->{
            Intent intent = new Intent(view.getContext(), game.nextActivity);
            intent.putExtra(view.getResources().getResourceName(R.string.gameName), game.gameName);
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return this.games.size();
    }
}
