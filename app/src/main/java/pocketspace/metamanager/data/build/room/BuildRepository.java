package pocketspace.metamanager.data.build.room;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import pocketspace.metamanager.data.build.Build;

public class BuildRepository {
    private BuildDao buildDao;
    private LiveData<List<BuildInfo>> allBuilds;

    BuildRepository(Application application) {
        BuildRoomDatabase db = BuildRoomDatabase.getDatabase(application);
        buildDao = db.buildDao();
        allBuilds = buildDao.getAllBuilds();
    }

    LiveData<List<BuildInfo>> getAllBuilds() {
        return allBuilds;
    }

    public void insert(BuildInfo build) {
        new insertAsyncTask(buildDao).execute(build);
    }
    private static class insertAsyncTask extends AsyncTask<BuildInfo, Void, Void> {
        private BuildDao asyncBuildDao;

        insertAsyncTask(BuildDao dao) {
            asyncBuildDao = dao;
        }

        @Override
        protected Void doInBackground(final BuildInfo... params) {
            asyncBuildDao.insert(params[0]);
            return null;
        }
    }

}
