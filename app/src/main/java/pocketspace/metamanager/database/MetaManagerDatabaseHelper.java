package pocketspace.metamanager.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;

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
            + CharacterTable.Cols.SPLASH + ")"); //keep it this way b/c its not being used and is already populated as an empty string

        db.execSQL("create table " + SkillTable.NAME + "("
            + SkillTable.Cols.NAME + " TEXT primary key, "
            + SkillTable.Cols.DESCRIPTION + ", "
            + "Skill_Q integer, "
            + "Skill_W integer, "
            + "Skill_E integer, "
            + "Skill_R integer, "
            + "Passive integer)");

        db.execSQL("create table " + SummonerTable.NAME + "("
            + SummonerTable.Cols.NAME + " TEXT primary key, "
            + SummonerTable.Cols.DESCRIPTION + ", "
            + "Image integer)");

        db.execSQL("create table " + RuneTable.NAME + "("
            + RuneTable.Cols.NAME + " TEXT primary key, "
            + RuneTable.Cols.DESCRIPTION + ", "
            + "Image integer)");

        db.execSQL("create table " + ItemTable.NAME + "("
            + ItemTable.Cols.NAME + " TEXT primary key, "
            + ItemTable.Cols.DESCRIPTION + ", "
            + "Image integer)");
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

    public void insertSkillData(String name, int q, int w, int e, int r, int passive, String description)
    {
        SQLiteDatabase writeableDB = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SkillTable.Cols.NAME, name);
        cv.put(SkillTable.Cols.SKILL_Q, q);
        cv.put(SkillTable.Cols.SKILL_W, w);
        cv.put(SkillTable.Cols.SKILL_E, e);
        cv.put(SkillTable.Cols.SKILL_R, r);
        cv.put(SkillTable.Cols.PASSIVE, passive);
        cv.put(SkillTable.Cols.DESCRIPTION, description);
        writeableDB.insert(SkillTable.NAME, null, cv);
    }

    public void insertSummonerData(String name, String description, int image)
    {
        SQLiteDatabase writeableDB = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SummonerTable.Cols.NAME, name);
        cv.put(SummonerTable.Cols.DESCRIPTION, description);
        cv.put(SummonerTable.Cols.IMAGE, image);
        writeableDB.insert(SummonerTable.NAME, null, cv);
    }

    public void insertRuneData(String name, String description, int image)
    {
        SQLiteDatabase writeableDB = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(RuneTable.Cols.NAME, name);
        cv.put(RuneTable.Cols.DESCRIPTION, description);
        cv.put(RuneTable.Cols.IMAGE, image);
        writeableDB.insert(RuneTable.NAME, null, cv);
    }

    public void insertItemData(String name, String description, int image)
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

    public Cursor getAllDataFromRuneTable()
    {
        SQLiteDatabase writeableDB = getWritableDatabase();
        Cursor result = writeableDB.rawQuery("select * from " + RuneTable.NAME, null);
        return result;
    }

    public Cursor getAllDataFromItemTable()
    {
        SQLiteDatabase writeableDB = getWritableDatabase();
        Cursor result = writeableDB.rawQuery("select * from " + ItemTable.NAME, null);
        return result;
    }

    public Cursor getAllDataFromSkillTable()
    {
        SQLiteDatabase writeableDB = getWritableDatabase();
        Cursor result = writeableDB.rawQuery("select * from " + SkillTable.NAME, null);
        return result;
    }

    public Cursor getAllDataFromSummonerTable()
    {
        SQLiteDatabase writeableDB = getWritableDatabase();
        Cursor result = writeableDB.rawQuery("select * from " + SummonerTable.NAME, null);
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
        insertCharacterData("Bard", R.drawable.bard, "", "");
        insertCharacterData("Blitzcrank", R.drawable.blitzcrank, "", "");
        insertCharacterData("Brand", R.drawable.brand, "", "");
        insertCharacterData("Braum", R.drawable.braum, "", "");
        insertCharacterData("Caitlyn", R.drawable.caitlyn, "", "");
        insertCharacterData("Camille", R.drawable.camille, "", "");
        insertCharacterData("Cassiopeia", R.drawable.cassiopeia, "", "");
        insertCharacterData("Cho'Gath", R.drawable.chogath, "", "");
        insertCharacterData("Corki", R.drawable.corki, "", "");
        insertCharacterData("Darius", R.drawable.darius, "", "");
        insertCharacterData("Diana", R.drawable.diana, "", "");
        insertCharacterData("Dr_Mundo", R.drawable.drmundo, "", "");
        insertCharacterData("Draven", R.drawable.draven, "", "");
        insertCharacterData("Ekko", R.drawable.ekko, "", "");
        insertCharacterData("Elise", R.drawable.elise, "", "");
        insertCharacterData("Evelyn", R.drawable.evelynn, "", "");
        insertCharacterData("Ezreal", R.drawable.ezreal, "", "");
        insertCharacterData("Fiddlesticks", R.drawable.fiddlesticks, "", "");
        insertCharacterData("Fizz", R.drawable.fizz, "", "");
        insertCharacterData("Galio", R.drawable.galio, "", "");
        insertCharacterData("Gangplank", R.drawable.gangplank, "", "");
        insertCharacterData("Garen", R.drawable.garen, "", "");
        insertCharacterData("Gnar", R.drawable.gnar, "", "");
        insertCharacterData("Gragas", R.drawable.gragas, "", "");
        insertCharacterData("Graves", R.drawable.graves, "", "");
        insertCharacterData("Hecarim", R.drawable.hecarim, "", "");
        insertCharacterData("Heimerdinger", R.drawable.heimerdinger, "", "");
        insertCharacterData("Illaoi", R.drawable.illaoi, "", "");
        insertCharacterData("Irelia", R.drawable.irelia, "", "");
        insertCharacterData("Ivern", R.drawable.ivern, "", "");
        insertCharacterData("Janna", R.drawable.janna, "", "");
        insertCharacterData("Jarvan_IV", R.drawable.jarvaniv, "", "");
        insertCharacterData("Jax", R.drawable.jax, "", "");
        insertCharacterData("Jayce", R.drawable.jayce, "", "");
        insertCharacterData("Jhin", R.drawable.jhin, "", "");
        insertCharacterData("Jinx", R.drawable.jinx, "", "");
        insertCharacterData("Kai'sa", R.drawable.kaisa, "", "");
        insertCharacterData("Kalista", R.drawable.kalista, "", "");
        insertCharacterData("Karma", R.drawable.karma, "", "");
        insertCharacterData("Karthus", R.drawable.karthus, "", "");
        insertCharacterData("Kassadin", R.drawable.kassadin, "", "");
        insertCharacterData("Katarina", R.drawable.katarina, "", "");
        insertCharacterData("Kayle", R.drawable.kayle, "", "");
        insertCharacterData("Kayn", R.drawable.kayn, "", "");
        insertCharacterData("Kennen", R.drawable.kennen, "", "");
        insertCharacterData("Kha'Zix", R.drawable.khazix, "", "");
        insertCharacterData("Kindred", R.drawable.kindred, "", "");
        insertCharacterData("Kled", R.drawable.kled, "", "");
        insertCharacterData("Kog'Maw", R.drawable.kogmaw, "", "");
        insertCharacterData("LeBlanc", R.drawable.leblanc, "", "");
        insertCharacterData("Lee_Sin", R.drawable.leesin, "", "");
        insertCharacterData("Leona", R.drawable.leona, "", "");
        insertCharacterData("Lissandra", R.drawable.lissandra, "", "");
        insertCharacterData("Lucian", R.drawable.lucian, "", "");
        insertCharacterData("Lulu", R.drawable.lulu, "", "");
        insertCharacterData("Lux", R.drawable.lux, "", "");
        insertCharacterData("Malphite", R.drawable.malphite, "", "");
        insertCharacterData("Malzahar", R.drawable.malzahar, "", "");
        insertCharacterData("Maokai", R.drawable.maokai, "", "");
        insertCharacterData("Master_Yi", R.drawable.masteryi, "", "");
        insertCharacterData("Miss_Fortune", R.drawable.missfortune, "", "");
        insertCharacterData("Mordekaiser", R.drawable.mordekaiser, "", "");
        insertCharacterData("Morgana", R.drawable.morgana, "", "");
        insertCharacterData("Nami", R.drawable.nami, "", "");
        insertCharacterData("Nautilus", R.drawable.nautilus, "", "");
        insertCharacterData("Nidalee", R.drawable.nidalee, "", "");
        insertCharacterData("Nocturne", R.drawable.nocturne, "", "");
        insertCharacterData("Nunu&Willump", R.drawable.nunu, "", "");
        insertCharacterData("Olaf", R.drawable.olaf, "", "");
        insertCharacterData("Orianna", R.drawable.orianna, "", "");
        insertCharacterData("Ornn", R.drawable.ornn, "", "");
        insertCharacterData("Pantheon", R.drawable.pantheon, "", "");
        insertCharacterData("Poppy", R.drawable.poppy, "", "");
        insertCharacterData("Pyke", R.drawable.pyke, "", "");
        insertCharacterData("Quinn", R.drawable.quinn, "", "");
        insertCharacterData("Rakan", R.drawable.rakan, "", "");
        insertCharacterData("Rammus", R.drawable.rammus, "", "");
        insertCharacterData("Rek'Sai", R.drawable.reksai, "", "");
        insertCharacterData("Renekton", R.drawable.renekton, "", "");
        insertCharacterData("Rengar", R.drawable.rengar, "", "");
        insertCharacterData("Riven", R.drawable.riven, "", "");
        insertCharacterData("Rumble", R.drawable.rumble, "", "");
        insertCharacterData("Sejuani", R.drawable.sejuani, "", "");
        insertCharacterData("Shaco", R.drawable.shaco, "", "");
        insertCharacterData("Shen", R.drawable.shen, "", "");
        insertCharacterData("Shyvana", R.drawable.shyvana, "", "");
        insertCharacterData("Singed", R.drawable.singed, "", "");
        insertCharacterData("Sion", R.drawable.sion, "", "");
        insertCharacterData("Sivir", R.drawable.sivir, "", "");
        insertCharacterData("Skarner", R.drawable.skarner, "", "");
        insertCharacterData("Sona", R.drawable.sona, "", "");
        insertCharacterData("Soraka", R.drawable.soraka, "", "");
        insertCharacterData("Swain", R.drawable.swain, "", "");
        insertCharacterData("Syndra", R.drawable.syndra, "", "");
        insertCharacterData("Tahm_Kench", R.drawable.tahmkench, "", "");
        insertCharacterData("Taliyah", R.drawable.taliyah, "", "");
        insertCharacterData("Talon", R.drawable.talon, "", "");
        insertCharacterData("Taric", R.drawable.taric, "", "");
        insertCharacterData("Teemo", R.drawable.teemo, "", "");
        insertCharacterData("Thresh", R.drawable.thresh, "", "");
        insertCharacterData("Tristana", R.drawable.tristana, "", "");
        insertCharacterData("Trundle", R.drawable.trundle, "", "");
        insertCharacterData("Tryndamere", R.drawable.tryndamere, "", "");
        insertCharacterData("Twisted_Fate", R.drawable.twistedfate, "", "");
        insertCharacterData("Twitch", R.drawable.twitch, "", "");
        insertCharacterData("Udyr", R.drawable.udyr, "", "");
        insertCharacterData("Urgot", R.drawable.urgot, "", "");
        insertCharacterData("Varus", R.drawable.varus, "", "");
        insertCharacterData("Vayne", R.drawable.vayne, "", "");
        insertCharacterData("Veigar", R.drawable.veigar, "", "");
        insertCharacterData("Vel'Koz", R.drawable.velkoz, "", "");
        insertCharacterData("Vi", R.drawable.vi, "", "");
        insertCharacterData("Viktor", R.drawable.viktor, "", "");
        insertCharacterData("Vladimir", R.drawable.vladimir, "", "");
        insertCharacterData("Volibear", R.drawable.volibear, "", "");
        insertCharacterData("Warwick", R.drawable.warwick, "", "");
        insertCharacterData("Wukong", R.drawable.monkeyking, "", "");
        insertCharacterData("Xayah", R.drawable.xayah, "", "");
        insertCharacterData("Xerath", R.drawable.xerath, "", "");
        insertCharacterData("Xin_Zhao", R.drawable.xinzhao, "", "");
        insertCharacterData("Yasuo", R.drawable.yasuo, "", "");
        insertCharacterData("Yorick", R.drawable.yorick, "", "");
        insertCharacterData("Zac", R.drawable.zac, "", "");
        insertCharacterData("Zed", R.drawable.zed, "", "");
        insertCharacterData("Ziggs", R.drawable.ziggs, "", "");
        insertCharacterData("Zilean", R.drawable.zilean, "", "");
        insertCharacterData("Zoe", R.drawable.zoe, "", "");
        insertCharacterData("Zyra", R.drawable.zyra, "", "");
    }

    public void hardCodeSkillTable()
    {

    }

    public void hardCodeRuneTable()
    {

    }

    //todo later 
    public void hardCodeItemTable()
    {

    }

    public void hardCodeSummonerTable()
    {

    }

}
