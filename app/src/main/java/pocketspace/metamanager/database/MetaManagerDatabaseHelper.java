package pocketspace.metamanager.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import pocketspace.metamanager.database.MetaManagerDatabaseSchema.CharacterTable;
import pocketspace.metamanager.database.MetaManagerDatabaseSchema.BuildTable;
import pocketspace.metamanager.database.MetaManagerDatabaseSchema.SkillTable;
import pocketspace.metamanager.database.MetaManagerDatabaseSchema.SummonerTable;
import pocketspace.metamanager.database.MetaManagerDatabaseSchema.BuildSummonerTable;
import pocketspace.metamanager.database.MetaManagerDatabaseSchema.RuneTable;
import pocketspace.metamanager.database.MetaManagerDatabaseSchema.BuildRunesTable;


public class MetaManagerDatabaseHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "LOL.db";
    private static final int VERSION = 2;

    public MetaManagerDatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table " + CharacterTable.NAME + "("
            + CharacterTable.Cols.NAME + " TEXT primary key, "
            + CharacterTable.Cols.DESCRIPTION + ", "
             + "Thumbnail integer, "
            + CharacterTable.Cols.SPLASH + ")");

        db.execSQL("create table " + BuildTable.NAME + "( _id integer primary key autoincrement, "
            + BuildTable.Cols.CHARACTER + ")");

        db.execSQL("create table " + SkillTable.NAME + "("
            + SkillTable.Cols.NAME + " TEXT primary key, "
            + SkillTable.Cols.SKILL_Q + ", "
            + SkillTable.Cols.SKILL_W + ", "
            + SkillTable.Cols.SKILL_E + ", "
            + SkillTable.Cols.SKILL_R + ")");

        db.execSQL("create table " + SummonerTable.NAME + "("
            + SummonerTable.Cols.NAME + " TEXT primary key, "
            + SummonerTable.Cols.DESCRIPTION + ", "
            + SummonerTable.Cols.IMAGE + ")");

        db.execSQL("create table " + BuildSummonerTable.NAME + "( _id integer primary key, "
            + BuildSummonerTable.Cols.SUMMONER_NAME + ")");

        db.execSQL("create table " + RuneTable.NAME + "("
            + RuneTable.Cols.NAME + " TEXT primary key, "
            + RuneTable.Cols.DESCRIPTION + ", "
            + RuneTable.Cols.IMAGE + ")");

        db.execSQL("create table " + BuildRunesTable.NAME + "( _id integer primary key, "
            + BuildRunesTable.Cols.RUNES_NAME + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + CharacterTable.NAME);
        db.execSQL("DROP TABLE IF EXISTS " + BuildTable.NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SkillTable.NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SummonerTable.NAME);
        db.execSQL("DROP TABLE IF EXISTS " + BuildSummonerTable.NAME);
        db.execSQL("DROP TABLE IF EXISTS " + RuneTable.NAME);
        db.execSQL("DROP TABLE IF EXISTS " + BuildRunesTable.NAME);

        onCreate(db);
    }
}
