package pocketspace.metamanager.data.build.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {BuildInfo.class}, version = 1, exportSchema = false)
public abstract class BuildRoomDatabase extends RoomDatabase {

    public abstract BuildDao buildDao();

    private static volatile BuildRoomDatabase INSTANCE;

    static BuildRoomDatabase getDatabase(final Context context)
    {
        if (INSTANCE == null) {
            synchronized (BuildRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BuildRoomDatabase.class, "build_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
