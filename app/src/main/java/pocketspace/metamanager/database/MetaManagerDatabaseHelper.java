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
    //if rebuilding/adding stuff to db, you must increment the db version number or wipe phone data
    private static final int VERSION = 6;

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
        cv.put(ItemTable.Cols.NAME, name);
        cv.put(ItemTable.Cols.DESCRIPTION, description);
        cv.put(ItemTable.Cols.IMAGE, image);
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
        insertCharacterData("Fiora", R.drawable.fiora, "", "");
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
        insertCharacterData("Nasus", R.drawable.nasus, "", "");
        insertCharacterData("Nautilus", R.drawable.nautilus, "", "");
        insertCharacterData("Neeko", R.drawable.neeko, "", "");
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
        insertCharacterData("Ryze", R.drawable.ryze, "", "");
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
        insertSkillData("Aatrox", R.drawable.aatrox_q, R.drawable.aatrox_w, R.drawable.aatrox_e, R.drawable.aatrox_r, R.drawable.aatrox_passive, "");
        insertSkillData("Ahri", R.drawable.aatrox_q, R.drawable.ahri_w, R.drawable.ahri_e, R.drawable.ahri_r, R.drawable.aatrox_passive, "");
        insertSkillData("Akali", R.drawable.akali_q, R.drawable.akali_w, R.drawable.akali_e, R.drawable.akali_r, R.drawable.akali_passive, "");
        insertSkillData("Alistar", R.drawable.alistar_q, R.drawable.alistar_w, R.drawable.alistar_e, R.drawable.alistar_r, R.drawable.alistar_passive, "");
        insertSkillData("Amumu", R.drawable.amumu_q, R.drawable.amumu_w, R.drawable.amumu_e, R.drawable.amumu_r, R.drawable.amumu_passive, "");
        insertSkillData("Anivia", R.drawable.anivia_q, R.drawable.anivia_w, R.drawable.anivia_e, R.drawable.anivia_r, R.drawable.anivia_passive, "");
        insertSkillData("Annie", R.drawable.annie_q, R.drawable.annie_w, R.drawable.annie_e, R.drawable.annie_r, R.drawable.annie_passive, "");
        insertSkillData("Ashe", R.drawable.ashe_q, R.drawable.ashe_w, R.drawable.ashe_e, R.drawable.ashe_r, R.drawable.ashe_passive, "");
        insertSkillData("Aurelion_Sol", R.drawable.aurelionsol_q, R.drawable.aurelionsol_w, R.drawable.aurelionsol_e, R.drawable.aurelionsol_r, R.drawable.aurelionsol_passive, "");
        insertSkillData("Azir", R.drawable.azir_q, R.drawable.azir_w, R.drawable.azir_e, R.drawable.azir_r, R.drawable.azir_passive, "");
        insertSkillData("Bard", R.drawable.bard_q, R.drawable.bard_w, R.drawable.bard_e, R.drawable.bard_r, R.drawable.bard_passive, "");
        insertSkillData("Blitzcrank", R.drawable.blitzcrank_q, R.drawable.blitzcrank_w, R.drawable.blitzcrank_e, R.drawable.blitzcrank_r, R.drawable.blitzcrank_passive, "");
        insertSkillData("Brand", R.drawable.brand_q, R.drawable.brand_w, R.drawable.brand_e, R.drawable.brand_r, R.drawable.brand_passive, "");
        insertSkillData("Braum", R.drawable.braum_q, R.drawable.braum_w, R.drawable.braum_e, R.drawable.braum_r, R.drawable.braum_passive, "");
        insertSkillData("Caitlyn", R.drawable.caitlyn_q, R.drawable.caitlyn_w, R.drawable.caitlyn_e, R.drawable.caitlyn_r, R.drawable.caitlyn_passive, "");
        insertSkillData("Camille", R.drawable.camille_q, R.drawable.camille_w, R.drawable.camille_e, R.drawable.camille_r, R.drawable.camille_passive, "");
        insertSkillData("Cassiopeia", R.drawable.cassiopeia_q, R.drawable.cassiopeia_w, R.drawable.cassiopeia_e, R.drawable.cassiopeia_r, R.drawable.cassiopeia_passive, "");
        insertSkillData("Cho'Gath", R.drawable.chogath_q, R.drawable.chogath_w, R.drawable.chogath_e, R.drawable.chogath_r, R.drawable.chogath_passive, "");
        insertSkillData("Corki", R.drawable.corki_q, R.drawable.corki_w, R.drawable.corki_e, R.drawable.corki_r, R.drawable.corki_passive, "");
        insertSkillData("Darius", R.drawable.darius_q, R.drawable.darius_w, R.drawable.darius_e, R.drawable.darius_r, R.drawable.darius_passive, "");
        insertSkillData("Diana", R.drawable.diana_q, R.drawable.diana_w, R.drawable.diana_e, R.drawable.diana_r, R.drawable.diana_passive, "");
        insertSkillData("Dr_Mundo", R.drawable.drmundo_q, R.drawable.drmundo_w, R.drawable.drmundo_e, R.drawable.drmundo_r, R.drawable.drmundo_passive, "");
        insertSkillData("Draven", R.drawable.draven_q, R.drawable.draven_w, R.drawable.draven_e, R.drawable.draven_r, R.drawable.drmundo_passive, "");
        insertSkillData("Ekko", R.drawable.ekko_q, R.drawable.ekko_w, R.drawable.ekko_e, R.drawable.ekko_r, R.drawable.ekko_passive, "");
        insertSkillData("Elise", R.drawable.elise_q, R.drawable.elise_w, R.drawable.elise_e, R.drawable.elise_r, R.drawable.elise_passive, "");
        insertSkillData("Evelynn", R.drawable.evelynn_q, R.drawable.evelynn_w, R.drawable.evelynn_e, R.drawable.evelynn_r, R.drawable.evelynn_passive, "");
        insertSkillData("Ezreal", R.drawable.ezreal_q, R.drawable.ezreal_w, R.drawable.ezreal_e, R.drawable.ezreal_r, R.drawable.ezreal_, "");
        insertSkillData("Fiddlesticks", R.drawable.fiddlesticks_q, R.drawable.fiddlesticks_w, R.drawable.fiddlesticks_e, R.drawable.fiddlesticks_r, R.drawable.fiddlesticks_passive, "");
        insertSkillData("Fiora", R.drawable.fiora_q, R.drawable.fiora_w, R.drawable.fiora_e, R.drawable.fiddlesticks_r, R.drawable.fiora_passive, "");
        insertSkillData("Fizz", R.drawable.fizz_q, R.drawable.fizz_w, R.drawable.fizz_e, R.drawable.fizz_r, R.drawable.fizz_passive, "");
        insertSkillData("Galio", R.drawable.galio_q, R.drawable.galio_w, R.drawable.galio_e, R.drawable.galio_r, R.drawable.galio_passive, "");
        insertSkillData("Gangplank", R.drawable.gangplank_q, R.drawable.gangplank_w, R.drawable.gangplank_e, R.drawable.gangplank_r, R.drawable.gangplank_passive, "");
        insertSkillData("Garen", R.drawable.garen_q, R.drawable.garen_w, R.drawable.garen_e, R.drawable.garen_r, R.drawable.garen_passive, "");
        insertSkillData("Gnar", R.drawable.gnar_q, R.drawable.gnar_w, R.drawable.gnar_e, R.drawable.gnar_r, R.drawable.gnar_passive, "");
        insertSkillData("Gragas", R.drawable.gragas_q, R.drawable.gragas_w, R.drawable.gragas_e, R.drawable.gragas_r, R.drawable.gragas_passive, "");
        insertSkillData("Graves", R.drawable.graves_q, R.drawable.graves_w, R.drawable.graves_e, R.drawable.graves_r, R.drawable.graves_passive, "");
        insertSkillData("Hecarim", R.drawable.hecarim_q, R.drawable.hecarim_w, R.drawable.hecarim_e, R.drawable.hecarim_r, R.drawable.hecarim_passive, "");
        insertSkillData("Heimerdinger", R.drawable.heimerdinger_q, R.drawable.heimerdinger_w, R.drawable.heimerdinger_e, R.drawable.heimerdinger_r, R.drawable.heimerdinger_passive, "");
        insertSkillData("Illaoi", R.drawable.illaoi_q, R.drawable.illaoi_w, R.drawable.illaoi_e, R.drawable.illaoi_r, R.drawable.illaoi_passive, "");
        insertSkillData("Irelia", R.drawable.irelia_q, R.drawable.irelia_w, R.drawable.irelia_e, R.drawable.irelia_r, R.drawable.irelia_passive, "");
        insertSkillData("Ivern", R.drawable.ivern_q, R.drawable.ivern_w, R.drawable.ivern_e, R.drawable.ivern_r, R.drawable.ivern_passive, "");
        insertSkillData("Janna", R.drawable.janna_q, R.drawable.janna_w, R.drawable.janna_e, R.drawable.janna_r, R.drawable.janna_passive, "");
        insertSkillData("Jarvan_IV", R.drawable.jarvaniv_q, R.drawable.jarvaniv_w, R.drawable.jarvaniv_e, R.drawable.jarvaniv_r, R.drawable.jarvaniv_passive, "");
        insertSkillData("Jax", R.drawable.jax_q, R.drawable.jax_w, R.drawable.jax_e, R.drawable.jax_r, R.drawable.jax_passive, "");
        insertSkillData("Jayce", R.drawable.jayce_q, R.drawable.jayce_w, R.drawable.jayce_e, R.drawable.jayce_r, R.drawable.jayce_passive, "");
        insertSkillData("Jhin", R.drawable.jhin_q, R.drawable.jhin_w, R.drawable.jhin_e, R.drawable.jhin_r, R.drawable.jhin_passive, "");
        insertSkillData("Jinx", R.drawable.jinx_q, R.drawable.jinx_w, R.drawable.jinx_e, R.drawable.jinx_r, R.drawable.jinx_passive, "");
        insertSkillData("Kai'Sa", R.drawable.kaisa_q, R.drawable.kaisa_w, R.drawable.kaisa_e, R.drawable.kaisa_r, R.drawable.kaisa_passive, "");
        insertSkillData("Kalista", R.drawable.kalista_q, R.drawable.kaisa_w, R.drawable.kaisa_e, R.drawable.kalista_r, R.drawable.kalista_passive, "");
        insertSkillData("Karma", R.drawable.karma_q, R.drawable.karma_w, R.drawable.karma_e, R.drawable.karma_r, R.drawable.karma_passive, "");
        insertSkillData("Karthus", R.drawable.karthus_q, R.drawable.karthus_w, R.drawable.karthus_e, R.drawable.karthus_r, R.drawable.karthus_passive, "");
        insertSkillData("Kassadin", R.drawable.kassadin_q, R.drawable.kassadin_w, R.drawable.kassadin_e, R.drawable.kassadin_r, R.drawable.kassadin_passive, "");
        insertSkillData("Katarina", R.drawable.katarina_q, R.drawable.katarina_w, R.drawable.katarina_e, R.drawable.katarina_r, R.drawable.katarina_passive, "");
        insertSkillData("Kayle", R.drawable.kayle_q, R.drawable.kayle_w, R.drawable.kayle_e, R.drawable.kayle_r, R.drawable.kayle_passive, "");
        insertSkillData("Kayn", R.drawable.kayn_q, R.drawable.kayn_w, R.drawable.kayn_e, R.drawable.kayn_r, R.drawable.kayn_passivep, "");
        insertSkillData("Kennen", R.drawable.kennen_q, R.drawable.kennen_w, R.drawable.kennen_e, R.drawable.kennen_r, R.drawable.kennen_passive, "");
        insertSkillData("Kha'Zix", R.drawable.khazix_q, R.drawable.khazix_w, R.drawable.khazix_e, R.drawable.khazix_r, R.drawable.khazix_passive, "");
        insertSkillData("Kindred", R.drawable.kindred_q, R.drawable.kindred_w, R.drawable.kindred_e, R.drawable.kindred_r, R.drawable.kindred_passive, "");
        insertSkillData("Kled", R.drawable.kled_q, R.drawable.kled_w, R.drawable.kled_e, R.drawable.kled_r, R.drawable.kled_passive, "");
        insertSkillData("Kog'Maw", R.drawable.kogmaw_q, R.drawable.kogmaw_w, R.drawable.kogmaw_e, R.drawable.kogmaw_r, R.drawable.kogmaw_passive, "");
        insertSkillData("LeBlanc", R.drawable.leblanc_q, R.drawable.leblanc_w, R.drawable.leblanc_e, R.drawable.leblanc_r, R.drawable.leblanc_passive, "");
        insertSkillData("Lee_Sin", R.drawable.leesin_q, R.drawable.leesin_w, R.drawable.leesin_e, R.drawable.leesin_r, R.drawable.leesin_passive, "");
        insertSkillData("Leona", R.drawable.leona_q, R.drawable.leona_w, R.drawable.leona_e, R.drawable.leona_r, R.drawable.leona_pasive, "");
        insertSkillData("Lissandra", R.drawable.lissandra_q, R.drawable.lissandra_w, R.drawable.lissandra_e, R.drawable.lissandra_r, R.drawable.lissandra_passive, "");
        insertSkillData("Lucian", R.drawable.lucian_q, R.drawable.lucian_w, R.drawable.lucian_e, R.drawable.lucian_r, R.drawable.lucian_passive, "");
        insertSkillData("Lulu", R.drawable.lulu_q, R.drawable.lulu_w, R.drawable.lulu_e, R.drawable.lulu_r, R.drawable.lulu_passive, "");
        insertSkillData("Lux", R.drawable.lux_q, R.drawable.lux_w, R.drawable.lux_e, R.drawable.lux_r, R.drawable.lux_passive, "");
        insertSkillData("Malphite", R.drawable.malphite_q, R.drawable.malphite_w, R.drawable.malphite_e, R.drawable.malphite_r, R.drawable.malphite_passive, "");
        insertSkillData("Malzahar", R.drawable.malzahar_q, R.drawable.malzahar_w, R.drawable.malzahar_e, R.drawable.malzahar_r, R.drawable.malzahar_passive, "");
        insertSkillData("Maokai", R.drawable.maokai_q, R.drawable.maokai_w, R.drawable.maokai_e, R.drawable.maokai_r, R.drawable.maokai_passive, "");
        insertSkillData("Master_Yi", R.drawable.masteryi_q, R.drawable.masteryi_w, R.drawable.masteryi_e, R.drawable.masteryi_r, R.drawable.masteryi_passive, "");
        insertSkillData("Miss_Fortune", R.drawable.missfortune_q, R.drawable.missfortune_w, R.drawable.missfortune_e, R.drawable.missfortune_r, R.drawable.missfortune_passive, "");
        insertSkillData("Mordekaiser", R.drawable.mordekaiser_q, R.drawable.mordekaiser_w, R.drawable.mordekaiser_e, R.drawable.mordekaiser_r, R.drawable.mordekaiser_passive, "");
        insertSkillData("Morgana", R.drawable.morgana_q, R.drawable.morgana_w, R.drawable.morgana_e, R.drawable.morgana_r, R.drawable.morgana_passive, "");
        insertSkillData("Nami", R.drawable.nami_q, R.drawable.nami_w, R.drawable.nami_e, R.drawable.nami_r, R.drawable.nami_passive, "");
        insertSkillData("Nasus", R.drawable.nasus_q, R.drawable.nasus_w, R.drawable.nasus_e, R.drawable.nasus_r, R.drawable.nasus_passive, "");
        insertSkillData("Nautilus", R.drawable.nautilus_q, R.drawable.nautilus_w, R.drawable.nautilus_e, R.drawable.nautilus_r, R.drawable.nautilus_passive, "");
        insertSkillData("Neeko", R.drawable.neeko_q, R.drawable.neeko_w, R.drawable.neeko_e, R.drawable.neeko_r, R.drawable.neeko_passive, "");
        insertSkillData("Nidalee", R.drawable.nidalee_q, R.drawable.nidalee_w, R.drawable.nidalee_e, R.drawable.nidalee_r, R.drawable.nidalee_passive, "");
        insertSkillData("Nocturne", R.drawable.nocturne_q, R.drawable.nocturne_w, R.drawable.nocturne_e, R.drawable.nocturne_r, R.drawable.nocturne_passive, "");
        insertSkillData("Nunu&Willump", R.drawable.nunu_q, R.drawable.nunu_w, R.drawable.nunu_e, R.drawable.nunu_r, R.drawable.nunu_passive, "");
        insertSkillData("Olaf", R.drawable.olaf_q, R.drawable.olaf_w, R.drawable.olaf_e, R.drawable.olaf_r, R.drawable.olaf_passive, "");
        insertSkillData("Orianna", R.drawable.orianna_q, R.drawable.orianna_w, R.drawable.oriana_e, R.drawable.orianna_r, R.drawable.orianna_passive, "");
        insertSkillData("Ornn", R.drawable.ornn_q, R.drawable.ornn_w, R.drawable.ornn_e, R.drawable.ornn_r, R.drawable.ornn_passive, "");
        insertSkillData("Pantheon", R.drawable.pantheon_q, R.drawable.pantheon_w, R.drawable.pantheon_e, R.drawable.pantheon_r, R.drawable.pantheon_passive, "");
        insertSkillData("Poppy", R.drawable.poppy_q, R.drawable.poppy_w, R.drawable.poppy_e, R.drawable.poppy_r, R.drawable.poppy_passive, "");
        insertSkillData("Pyke", R.drawable.pyke_q, R.drawable.pyke_w, R.drawable.pyke_e, R.drawable.pyke_r, R.drawable.pyke_passive, "");
        insertSkillData("Quinn", R.drawable.quinn_q, R.drawable.quinn_w, R.drawable.quinn_e, R.drawable.quinn_r, R.drawable.quinn_passive, "");
        insertSkillData("Rakan", R.drawable.rakan_q, R.drawable.rakan_w, R.drawable.rakan_e, R.drawable.rakan_r, R.drawable.rakan_passive, "");
        insertSkillData("Rammus", R.drawable.rammus_q, R.drawable.rammus_w, R.drawable.rammus_e, R.drawable.rammus_r, R.drawable.rammus_passive, "");
        insertSkillData("Rek'Sai", R.drawable.reksai_q, R.drawable.reksai_w, R.drawable.reksai_e, R.drawable.reksai_r, R.drawable.reksai_passive, "");
        insertSkillData("Renekton", R.drawable.renekton_q, R.drawable.renekton_w, R.drawable.renekton_e, R.drawable.renekton_r, R.drawable.renekton_passive, "");
        insertSkillData("Rengar", R.drawable.rengar_q, R.drawable.rengar_w, R.drawable.rengar_e, R.drawable.rengar_r, R.drawable.rengar_passive, "");
        insertSkillData("Riven", R.drawable.riven_q, R.drawable.riven_w, R.drawable.riven_e, R.drawable.riven_r, R.drawable.riven_passive, "");
        insertSkillData("Rumble", R.drawable.rumble_q, R.drawable.rumble_w, R.drawable.rumble_e, R.drawable.rumble_r, R.drawable.rumble_passive, "");
        insertSkillData("Ryze", R.drawable.ryze_q, R.drawable.ryze_w, R.drawable.ryze_e, R.drawable.ryze_r, R.drawable.ryze_passive, "");
        insertSkillData("Sejuani", R.drawable.sejuani_q, R.drawable.sejuani_w, R.drawable.sejuani_e, R.drawable.sejuani_r, R.drawable.sejuani_passive, "");
        insertSkillData("Shaco", R.drawable.shaco_q, R.drawable.shaco_w, R.drawable.shaco_e, R.drawable.shaco_r, R.drawable.shaco_passive, "");
        insertSkillData("Shen", R.drawable.shen_q, R.drawable.shen_w, R.drawable.shen_e, R.drawable.shen_r, R.drawable.shen_passive, "");
        insertSkillData("Shyvana", R.drawable.shyvana_q, R.drawable.shyvana_w, R.drawable.shyvana_e, R.drawable.shyvana_r, R.drawable.shyvana_passive, "");
        insertSkillData("Singed", R.drawable.singed_q, R.drawable.singed_w, R.drawable.singed_e, R.drawable.singed_r, R.drawable.singed_passive, "");
        insertSkillData("Sion", R.drawable.sion_q, R.drawable.sion_w, R.drawable.sion_e, R.drawable.sion_r, R.drawable.sion_passive, "");
        insertSkillData("Sivir", R.drawable.sivir_q, R.drawable.sivir_w, R.drawable.sivir_e, R.drawable.sivir_r, R.drawable.sivir_passive, "");
        insertSkillData("Skarner", R.drawable.skarner_q, R.drawable.skarner_w, R.drawable.skarner_e, R.drawable.skarner_r, R.drawable.skarner_passive, "");
        insertSkillData("Sona", R.drawable.sona_q, R.drawable.sona_w, R.drawable.sona_e, R.drawable.sona_r, R.drawable.sona_passive, "");
        insertSkillData("Soraka", R.drawable.soraka_q, R.drawable.soraka_w, R.drawable.soraka_e, R.drawable.soraka_r, R.drawable.soraka_passive, "");
        insertSkillData("Swain", R.drawable.swain_q, R.drawable.swain_w, R.drawable.swain_e, R.drawable.swain_r, R.drawable.swain_passive, "");
        insertSkillData("Sylas", R.drawable.sylas_q, R.drawable.sylas_w, R.drawable.sylas_e, R.drawable.sylas_r, R.drawable.sylas_passive, "");
        insertSkillData("Syndra", R.drawable.syndra_q, R.drawable.syndra_w, R.drawable.syndra_e, R.drawable.syndra_r, R.drawable.syndra_passive, "");
        insertSkillData("Tahm_Kench", R.drawable.tahmkench_q, R.drawable.tahmkench_w, R.drawable.tahmkench_e, R.drawable.tahmkench_r, R.drawable.tahmkench_passive, "");
        insertSkillData("Taliyah", R.drawable.taliyah_q, R.drawable.taliyah_w, R.drawable.taliyah_e, R.drawable.taliyah_r, R.drawable.taliyah_passive, "");
        insertSkillData("Talon", R.drawable.talon_q, R.drawable.talon_w, R.drawable.talon_e, R.drawable.talon_r, R.drawable.talon_passive, "");
        insertSkillData("Taric", R.drawable.taric_q, R.drawable.taric_w, R.drawable.taric_e, R.drawable.taric_r, R.drawable.taric_passive, "");
        insertSkillData("Teemo", R.drawable.teemo_q, R.drawable.teemo_w, R.drawable.teemo_e, R.drawable.teemo_r, R.drawable.teemo_passive, "");
        insertSkillData("Thresh", R.drawable.thresh_q, R.drawable.thresh_w, R.drawable.thresh_e, R.drawable.thresh_r, R.drawable.thresh_passive, "");
        insertSkillData("Tristana", R.drawable.tristana_q, R.drawable.tristana_w, R.drawable.tristana_e, R.drawable.tristana_r, R.drawable.tristana_passive, "");
        insertSkillData("Trundle", R.drawable.trundle_q, R.drawable.trundle_w, R.drawable.trundle_e, R.drawable.trundle_r, R.drawable.trundle_passive, "");
        insertSkillData("Tryndamere", R.drawable.tryndamere_q, R.drawable.tryndamere_w, R.drawable.tryndamere_e, R.drawable.tryndamere_r, R.drawable.tryndamere_passive, "");
        insertSkillData("Twisted_Fate", R.drawable.cardmaster_q, R.drawable.cardmaster_w, R.drawable.cardmaster_e, R.drawable.cardmaster_r, R.drawable.cardmaster_passive, "");
        insertSkillData("Twitch", R.drawable.twitch_q, R.drawable.twitch_w, R.drawable.twitch_e, R.drawable.twitch_r, R.drawable.twitch_passive, "");
        insertSkillData("Udyr", R.drawable.udyr_q, R.drawable.udyr_w, R.drawable.udyr_e, R.drawable.udyr_r, R.drawable.udyr_passive, "");
        insertSkillData("Urgot", R.drawable.urgot_q, R.drawable.urgot_w, R.drawable.urgot_e, R.drawable.urgot_r, R.drawable.urgot_passive, "");
        insertSkillData("Varus", R.drawable.varus_q, R.drawable.varus_w, R.drawable.varus_e, R.drawable.varus_r, R.drawable.varus_passive, "");
        insertSkillData("Vayne", R.drawable.vayne_q, R.drawable.vayne_w, R.drawable.vayne_e, R.drawable.vayne_r, R.drawable.vayne_passive, "");
        insertSkillData("Veigar", R.drawable.veigar_q, R.drawable.veigar_w, R.drawable.veigar_e, R.drawable.veigar_r, R.drawable.veigar_passive, "");
        insertSkillData("Vel'Koz", R.drawable.velkoz_q, R.drawable.velkoz_w, R.drawable.velkoz_e, R.drawable.velkoz_r, R.drawable.velkoz_passive, "");
        insertSkillData("Vi", R.drawable.vi_q, R.drawable.vi_w, R.drawable.vi_e, R.drawable.vi_r, R.drawable.vi_passive, "");
        insertSkillData("Viktor", R.drawable.viktor_q, R.drawable.viktor_w, R.drawable.viktor_e, R.drawable.viktor_r, R.drawable.viktor_passive, "");
        insertSkillData("Vladimir", R.drawable.vladimir_q, R.drawable.vladimir_w, R.drawable.vladimir_e, R.drawable.vladimir_r, R.drawable.vladimir_passive, "");
        insertSkillData("Volibear", R.drawable.volibear_q, R.drawable.volibear_w, R.drawable.volibear_e, R.drawable.volibear_r, R.drawable.volibear_passive, "");
        insertSkillData("Warwick", R.drawable.warwick_q, R.drawable.warwick_w, R.drawable.warwick_e, R.drawable.warwick_r, R.drawable.warwick_passive, "");
        insertSkillData("Wukong", R.drawable.monkeyking_q, R.drawable.monkeyking_w, R.drawable.monkeyking_e, R.drawable.monkeyking_r, R.drawable.monkeyking_passive, "");
        insertSkillData("Xayah", R.drawable.xayah_q, R.drawable.xayah_w, R.drawable.xayah_e, R.drawable.xayah_r, R.drawable.xayah_passive, "");
        insertSkillData("Xerath", R.drawable.xerath_q, R.drawable.xerath_w, R.drawable.xerath_e, R.drawable.xerath_r, R.drawable.xerath_passive, "");
        insertSkillData("Xin_Zhao", R.drawable.xinzhao_q, R.drawable.xinzhao_w, R.drawable.xinzhao_e, R.drawable.xinzhao_r, R.drawable.xinzhao_passive, "");
        insertSkillData("Yasuo", R.drawable.yasuo_q, R.drawable.yasuo_w, R.drawable.yasuo_e, R.drawable.yasuo_r, R.drawable.yasuo_passive, "");
        insertSkillData("Yorick", R.drawable.yorick_q, R.drawable.yorick_w, R.drawable.yorick_e, R.drawable.yorick_r, R.drawable.yorick_passive, "");
        insertSkillData("Zac", R.drawable.zac_q, R.drawable.zac_w, R.drawable.zac_e, R.drawable.zac_r, R.drawable.zac_passive, "");
        insertSkillData("Zed", R.drawable.shadowninja_q, R.drawable.shadowninja_w, R.drawable.shadowninja_e, R.drawable.shadowninja_r, R.drawable.shadowninja_passive, "");
        insertSkillData("Ziggs", R.drawable.ziggs_q, R.drawable.ziggs_w, R.drawable.ziggs_e, R.drawable.ziggs_r, R.drawable.zac_passive, "");
        insertSkillData("Zilean", R.drawable.zilean_q, R.drawable.zilean_w, R.drawable.zilean_e, R.drawable.zilean_r, R.drawable.zilean_passive, "");
        insertSkillData("Zoe", R.drawable.zoe_q, R.drawable.zoe_w, R.drawable.zoe_e, R.drawable.zoe_r, R.drawable.zoe_passive, "");
        insertSkillData("Zyra", R.drawable.zyra_q, R.drawable.zyra_w, R.drawable.zyra_e, R.drawable.zyra_r, R.drawable.zyra_passive, "");
    }

    public void hardCodeRuneTable()
    {
        insertRuneData("Absolute_Focus", "", R.drawable.absolute_focus);
        insertRuneData("Aftershock", "", R.drawable.aftershock);
        insertRuneData("Approach_Velocity", "", R.drawable.approach_velocity);
        insertRuneData("Arcane_Comet", "", R.drawable.arcane_comet);
        insertRuneData("Axe", "", R.drawable.axe);
        insertRuneData("Barrier", "", R.drawable.barrier);
        insertRuneData("Biscuit_Delivery", "", R.drawable.biscuit_delivery);
        insertRuneData("Bone_Plating", "", R.drawable.bone_plating);
        insertRuneData("Celerity", "", R.drawable.celerity);
        insertRuneData("Cheap_Shot", "", R.drawable.cheap_shot);
        insertRuneData("Circle", "", R.drawable.circle);
        insertRuneData("Cleanse", "", R.drawable.cleanse);
        insertRuneData("Conditioning", "", R.drawable.conditioning);
        insertRuneData("Conqueror", "", R.drawable.conqueror);
        insertRuneData("Cosmic_Insight", "", R.drawable.cosmic_insight);
        insertRuneData("Coup_De_Grace", "", R.drawable.coup_de_grace);
        insertRuneData("Cut_Down", "", R.drawable.cut_down);
        insertRuneData("Dark_Harvest", "", R.drawable.dark_harvest);
        insertRuneData("Demolish", "", R.drawable.demolish);
        insertRuneData("Diamond", "", R.drawable.diamond);
        insertRuneData("Domination", "", R.drawable.domination);
        insertRuneData("Electrocute", "", R.drawable.electrocute);
        insertRuneData("Exhaust", "", R.drawable.exhaust);
        insertRuneData("Eyeball_Collection", "", R.drawable.eyeball_collection);
        insertRuneData("Flash", "", R.drawable.flash);
        insertRuneData("Fleet_Footwork", "", R.drawable.fleet_footwork);
        insertRuneData("Font_Of_Life", "", R.drawable.font_of_life);
        insertRuneData("Futures_Market", "", R.drawable.futures_market);
        insertRuneData("Gathering_Storm", "", R.drawable.gathering_storm);
        insertRuneData("Ghost", "", R.drawable.ghost);
        insertRuneData("Ghost_Poro", "", R.drawable.ghost_poro);
        insertRuneData("Glacial_Augment", "", R.drawable.glacial_augment);
        insertRuneData("Grasp_Of_The_Undying", "", R.drawable.grasp_of_the_undying);
        insertRuneData("Guardian", "", R.drawable.guardian);
        insertRuneData("Hail_Of_Blades", "", R.drawable.hail_of_blades);
        insertRuneData("Heal", "", R.drawable.heal);
        insertRuneData("Heart", "", R.drawable.heart);
        insertRuneData("Hextech_Flashtraption", "", R.drawable.hextech_flashtraption);
        insertRuneData("Ignite", "", R.drawable.ignite);
        insertRuneData("Ingenious_Hunter", "", R.drawable.ingenious_hunter);
        insertRuneData("Inspiration", "", R.drawable.inspiration);
        insertRuneData("Kleptomancy", "", R.drawable.kleptomancy);
        insertRuneData("Last_Stand", "", R.drawable.last_stand);
        insertRuneData("Legend_Alacrity", "", R.drawable.legend_alacrity);
        insertRuneData("Legend_Bloodline", "", R.drawable.legend_bloodline);
        insertRuneData("Legend_Tenacity", "", R.drawable.legend_tenacity);
        insertRuneData("Lethal_Tempo", "", R.drawable.lethal_tempo);
        insertRuneData("Magical_Footwear", "", R.drawable.magical_footwear);
        insertRuneData("Manaflow_Band", "", R.drawable.manaflow_band);
        insertRuneData("Minion_Dematerializer", "", R.drawable.minion_dematerializer);
        insertRuneData("Nimbus_Cloak", "", R.drawable.nimbus_cloak);
        insertRuneData("Nullifying_Orb", "", R.drawable.nullifying_orb);
        insertRuneData("Overgrowth", "", R.drawable.overgrowth);
        insertRuneData("Overheal", "", R.drawable.overheal);
        insertRuneData("Perfect_Timing", "", R.drawable.perfect_timing);
        insertRuneData("Phase_Rush", "", R.drawable.phase_rush);
        insertRuneData("Precision", "", R.drawable.precision);
        insertRuneData("Predator", "", R.drawable.predator);
        insertRuneData("Presence_Of_Mind", "", R.drawable.presence_of_mind);
        insertRuneData("Press_The_Attack", "", R.drawable.press_the_attack);
        insertRuneData("Ravenous_Hunter", "", R.drawable.ravenous_hunter);
        insertRuneData("Relentless_Hunter", "", R.drawable.relentless_hunter);
        insertRuneData("Resolve", "", R.drawable.resolve);
        insertRuneData("Revitalize", "", R.drawable.revitalize);
        insertRuneData("Scorch", "", R.drawable.scorch);
        insertRuneData("Second_Wind", "", R.drawable.second_wind);
        insertRuneData("Shield", "", R.drawable.shield);
        insertRuneData("Shield_Bash", "", R.drawable.shield_bash);
        insertRuneData("Smite", "", R.drawable.smite);
        insertRuneData("Sorcery", "", R.drawable.sorcery);
        insertRuneData("Sudden_Impact", "", R.drawable.sudden_impact);
        insertRuneData("Summon_Aery", "", R.drawable.summon_aery);
        insertRuneData("Taste_Of_Blood", "", R.drawable.taste_of_blood);
        insertRuneData("Teleport", "", R.drawable.teleport);
        insertRuneData("Time", "", R.drawable.time);
        insertRuneData("Time_Warp_Tonic", "", R.drawable.time_warp_tonic);
        insertRuneData("Transcendence", "", R.drawable.transcendence);
        insertRuneData("Triumph", "", R.drawable.triumph);
        insertRuneData("Ultimate_Hunter", "", R.drawable.ultimate_hunter);
        insertRuneData("Unflinching", "", R.drawable.unflinching);
        insertRuneData("Unsealed_Spellbook", "", R.drawable.unsealed_spellbook);
        insertRuneData("Waterwalking", "", R.drawable.waterwalking);
        insertRuneData("Zombie_Ward", "", R.drawable.zombie_ward);
    }

    //todo later sprint 3
    public void hardCodeItemTable()
    {

    }
    //todo later sprint 3
    public void hardCodeSummonerTable()
    {

    }

}
