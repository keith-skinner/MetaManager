package pocketspace.metamanager.data.build.room;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import pocketspace.metamanager.R;

public class BuildListAdapter extends RecyclerView.Adapter<BuildListAdapter.BuildViewHolder> {

    class BuildViewHolder extends RecyclerView.ViewHolder {
        private final AppCompatTextView summaryBuildName;
        private final AppCompatTextView summaryChamionName;
        private final AppCompatImageView summaryChampionImage;
        private final AppCompatImageView summaryPosition;
        private final AppCompatImageView summaryKeystone;
        private final View summaryItemsList;
        private final FloatingActionButton summaryDeleteButton;

        private BuildViewHolder(View buildView) {
            super(buildView);
            this.summaryBuildName = buildView.findViewById(R.id.summaryBuildName);
            this.summaryChamionName = buildView.findViewById(R.id.summaryChampionName);
            this.summaryChampionImage = buildView.findViewById(R.id.summaryChampionImage);
            this.summaryPosition = buildView.findViewById(R.id.summaryPosition);
            this.summaryKeystone = buildView.findViewById(R.id.summaryKeystone);
            this.summaryItemsList = buildView.findViewById(R.id.summaryItemsList);
            this.summaryDeleteButton = buildView.findViewById(R.id.summaryDeleteButton);
        }
    }

    private final LayoutInflater mInflater;
    private List<BuildInfo> mBuilds; //Cached copy of builds

    public BuildListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public BuildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View buildView = mInflater.inflate(R.layout.build_info, parent, false);
        return new BuildViewHolder(buildView);
    }

    @Override
    public void onBindViewHolder(@NonNull BuildViewHolder holder, int position) {
        if (mBuilds != null) {
            BuildInfo current = mBuilds.get(position);
            //TODO Set all values here.
        } else {
            Log.i("TAGGY", "BuildListAdapter.onBindViewHolder called while mBuilds was empty");
           //TODO Default values here.
        }
    }

    void setBuilds(List<BuildInfo> builds) {
        this.mBuilds = builds;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mBuilds != null)
            return mBuilds.size();
        return 0;
    }
}
