package pocketspace.metamanager.data.build.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import pocketspace.metamanager.data.build.Build;

@Dao
public interface BuildDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(BuildInfo build);

    @Query("DELETE FROM build_info")
    void deleteAll();

    @Query("SELECT * FROM build_info ORDER BY build_name ASC")
    LiveData<List<BuildInfo>> getAllBuilds();

}
