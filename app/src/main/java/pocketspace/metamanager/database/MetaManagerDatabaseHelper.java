package pocketspace.metamanager.database;

import android.content.ClipData;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;

import pocketspace.metamanager.R;
import pocketspace.metamanager.data.Build;
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
            + CharacterTable.Cols.THUMBNAIL + ")");

        db.execSQL("create table " + SkillTable.NAME + "("
            + SkillTable.Cols.NAME + " TEXT primary key, "
            + SkillTable.Cols.DESCRIPTION + ", "
            + SkillTable.Cols.SKILL_Q + ", "
            + SkillTable.Cols.SKILL_W + ", "
            + SkillTable.Cols.SKILL_E + ", "
            + SkillTable.Cols.SKILL_R + ", "
            + SkillTable.Cols.PASSIVE + ")");

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

    public void insertCharacterData(String name, String thumbnail, String description)
    {
        SQLiteDatabase writeableDB = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(CharacterTable.Cols.NAME, name);
        cv.put(CharacterTable.Cols.THUMBNAIL, thumbnail);
        cv.put(CharacterTable.Cols.DESCRIPTION, description);

        writeableDB.insert(CharacterTable.NAME, null, cv);
    }

    public void insertSkillData(String name, String q, String w, String e, String r, String passive, String description)
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
        insertCharacterData("Aatrox", "character_thumbnail/aatrox_thumbnail.png", "");
        insertCharacterData("Ahri", "character_thumbnail/ahri_thumbnail.png", "");
        insertCharacterData("Akali", "character_thumbnail/akali_thumbnail.png", "");
        insertCharacterData("Alistar", "character_thumbnail/alistar_thumbnail.png", "");
        insertCharacterData("Amumu", "character_thumbnail/amumu_thumbnail.png", "");
        insertCharacterData("Anivia", "character_thumbnail/anivia_thumbnail.png", "");
        insertCharacterData("Annie", "character_thumbnail/annie_thumbnail.png", "");
        insertCharacterData("Ashe", "character_thumbnail/ashe_thumbnail.png", "");
        insertCharacterData("Aurelion_Sol", "character_thumbnail/aurelion_sol_thumbnail.png", "");
        insertCharacterData("Azir", "character_thumbnail/azir_thumbnail.png", "");
    }

    public void hardCodeSkillTable()
    {
        insertSkillData("Aatrox", "character_skill/aatrox_q.png", "character_skill/aatrox_w.png", "character_skill/aatrox_e.png", "character_skill/aatrox_r.png", "character_skill/aatrox_passive.png", "");
        insertSkillData("Ahri", "character_skill/ahri_q.png", "character_skill/ahri_w.png", "character_skill/ahri_e.png", "character_skill/ahri_r.png", "character_skill/ahri_passive.png", "");
        insertSkillData("Akali", "character_skill/akali_q.png", "character_skill/ahri_w.png", "character_skill/akali_e.png", "character_skill/akali_r.png", "character_skill/akali_passive.png", "");
        insertSkillData("Alistar", "character_skill/alistar_q.png", "character_skill/alistar_w.png", "character_skill/alistar_e.png", "character_skill/alistar_r.png", "character_skill/alistar_passive.png", "");
        insertSkillData("Amumu", "character_skill/amumu_q.png", "character_skill/amumu_w.png", "character_skill/amumu_e.png", "character_skill/amumu_r.png", "character_skill/amumu_passive.png", "");
        insertSkillData("Anivia", "character_skill/anivia_q.png", "character_skill/anivia_w.png", "character_skill/anivia_e.png", "character_skill/anivia_r.png", "character_skill/anivia_passive.png", "");
        insertSkillData("Annie", "character_skill/annie_q.png", "character_skill/annie_w.png", "character_skill/annie_e.png", "character_skill/annie_r.png", "character_skill/annie_passive.png", "");
        insertSkillData("Ashe", "character_skill/ashe_q.png", "character_skill/ashe_w.png", "character_skill/ashe_e.png", "character_skill/ashe_r.png", "character_skill/ashe_passive.png", "");
        insertSkillData("Aurelion_Sol", "character_skill/aurelionsol_q.png", "character_skill/aurelionsol_w.png", "character_skill/aurelionsol_e.png", "character_skill/aurelionsol_r.png", "character_skill/aurelionsol_passive.png", "");
        insertSkillData("Azir", "character_skill/azir_q.png", "character_skill/azir_w.png", "character_skill/azir_e.png", "character_skill/azir_r.png", "character_skill/azir_passive.png", "");
    }

    public void hardCodeRuneTable()
    {
        /*insertRuneData("Absolute_Focus", "", R.drawable.absolute_focus);
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
        insertRuneData("Zombie_Ward", "", R.drawable.zombie_ward); */
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
