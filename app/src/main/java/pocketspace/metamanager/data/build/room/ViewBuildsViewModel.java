package pocketspace.metamanager.data.build.room;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import pocketspace.metamanager.data.build.Build;

public class ViewBuildsViewModel extends AndroidViewModel {
    private BuildRepository repository;
    private LiveData<List<BuildInfo>> allBuilds;

    public ViewBuildsViewModel(Application application) {
        super(application);
        repository = new BuildRepository(application);
        allBuilds = repository.getAllBuilds();
    }

    public void insert(BuildInfo build) { repository.insert(build); }
}
