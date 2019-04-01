package pocketspace.metamanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
    //Column names for Champion table
    private static final String database_name = "LOL.db";
    private static final String table_name = "Champion";
    private static final String id = "ID";
    private static final String name = "NAME";
    private static final String skill_p = "SKILL_P";
    private static final String skill_q = "SKILL_Q";
    private static final String skill_w = "SKILL_Q";
    private static final String skill_e = "SKILL_E";
    private static final String skill_r = "SKILL_R";
    private static final String thumbnail = "THUMBNAIL";
    private static final String splash = "SPLASH";

    public DatabaseHelper(Context context)
    {
        super(context, database_name, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String createTable = "CREATE TABLE " + table_name + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, SKILL_P TEXT, SKILL_Q TEXT, SKILL_W TEXT" +
                ", SKILL_E TEXT, SKILL_R TEXT, THUMBNAIL TEXT, SPLASH TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + table_name);
        onCreate(db);
    }
}
