package pocketspace.metamanager.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import pocketspace.metamanager.R;
import pocketspace.metamanager.database.MetaManagerDatabaseSchema.*;

public class MetaManagerDatabaseHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "LOL.db";
    private static final int VERSION = 5;

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

        db.execSQL("create table " + SkillTable.NAME + "("
            + SkillTable.Cols.NAME + " TEXT primary key, "
            + SkillTable.Cols.DESCRIPTION + ", "
            + SkillTable.Cols.SKILL_Q + ", "
            + SkillTable.Cols.SKILL_W + ", "
            + SkillTable.Cols.SKILL_E + ", "
            + SkillTable.Cols.SKILL_R + ")");

        db.execSQL("create table " + SummonerTable.NAME + "("
            + SummonerTable.Cols.NAME + " TEXT primary key, "
            + SummonerTable.Cols.DESCRIPTION + ", "
            + SummonerTable.Cols.IMAGE + ")");

        db.execSQL("create table " + RuneTable.NAME + "("
            + RuneTable.Cols.NAME + " TEXT primary key, "
            + RuneTable.Cols.DESCRIPTION + ", "
            + RuneTable.Cols.IMAGE + ")");

        db.execSQL("create table " + ItemTable.NAME + "("
            + ItemTable.Cols.NAME + " TEXT primary key, "
            + ItemTable.Cols.DESCRIPTION + ", "
            + ItemTable.Cols.IMAGE + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + CharacterTable.NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SkillTable.NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SummonerTable.NAME);
        db.execSQL("DROP TABLE IF EXISTS " + RuneTable.NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ItemTable.NAME);

        onCreate(db);
    }

    public void insertCharacterData(String name, int thumbnail, String splash, String description)
    {
        SQLiteDatabase writeableDB = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(CharacterTable.Cols.NAME, name);
        cv.put(CharacterTable.Cols.THUMBNAIL, thumbnail);
        cv.put(CharacterTable.Cols.SPLASH, splash);
        cv.put(CharacterTable.Cols.DESCRIPTION, description);

        writeableDB.insert(CharacterTable.NAME, null, cv);
    }

    public void insertSkillData(String name, String q, String w, String e, String r, String description)
    {
        SQLiteDatabase writeableDB = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SkillTable.Cols.NAME, name);
        cv.put(SkillTable.Cols.SKILL_Q, q);
        cv.put(SkillTable.Cols.SKILL_W, w);
        cv.put(SkillTable.Cols.SKILL_E, e);
        cv.put(SkillTable.Cols.SKILL_R, r);
        cv.put(SkillTable.Cols.DESCRIPTION, description);
        writeableDB.insert(SkillTable.NAME, null, cv);
    }

    public void insertSummonerData(String name, String description, String image)
    {
        SQLiteDatabase writeableDB = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SummonerTable.Cols.NAME, name);
        cv.put(SummonerTable.Cols.DESCRIPTION, description);
        cv.put(SummonerTable.Cols.IMAGE, image);
        writeableDB.insert(SummonerTable.NAME, null, cv);
    }

    public void insertRuneData(String name, String description, String image)
    {
        SQLiteDatabase writeableDB = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(RuneTable.Cols.NAME, name);
        cv.put(RuneTable.Cols.DESCRIPTION, description);
        cv.put(RuneTable.Cols.IMAGE, image);
        writeableDB.insert(RuneTable.NAME, null, cv);
    }

    public void insertItemData(String name, String description, String image)
    {
        SQLiteDatabase writeableDB = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(RuneTable.Cols.NAME, name);
        cv.put(RuneTable.Cols.DESCRIPTION, description);
        cv.put(RuneTable.Cols.IMAGE, image);
        writeableDB.insert(ItemTable.NAME, null, cv);
    }

    public Cursor getAllDataFromCharacterTable()
    {
        SQLiteDatabase writeableDB = getWritableDatabase();
        Cursor result = writeableDB.rawQuery("select * from " + CharacterTable.NAME, null);
        return result;
    }

    public void hardCodeCharacterTable()
    {
        insertCharacterData("Aatrox", R.drawable.aatrox_thumbnail, "", "");
        insertCharacterData("Ahri", R.drawable.ahri_thumbnail, "", "");
        insertCharacterData("Akali", R.drawable.akali_thumbnail, "", "");
        insertCharacterData("Alistar", R.drawable.alistar_thumbnail, "", "");
        insertCharacterData("Amumu", R.drawable.amumu_thumbnail, "", "");
        insertCharacterData("Anivia", R.drawable.anivia_thumbnail, "", "");
        insertCharacterData("Annie", R.drawable.annie_thumbnail, "", "");
        insertCharacterData("Ashe", R.drawable.ashe_thumbnail, "", "");
        insertCharacterData("Aurelion_Sol", R.drawable.aurelion_sol_thumbnail, "", "");
        insertCharacterData("Azir", R.drawable.azir_thumbnail, "", "");
    }

}
