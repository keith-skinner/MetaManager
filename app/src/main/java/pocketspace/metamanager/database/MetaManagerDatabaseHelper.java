package pocketspace.metamanager.database;
import pocketspace.metamanager.database.MetaManagerDatabaseSchema.*;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MetaManagerDatabaseHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "LOL.db";
    //if rebuilding/adding stuff to db, you must increment the db version number or wipe phone data
    private static final int VERSION = 7;

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

        /*hardCodeCharacterTable();
        hardCodeSkillTable();
        hardCodeRuneTable();
        hardCodeSummonerTable();*/

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

    //insert methods for tables:

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

    public void insertSummonerData(String name, String image, String description)
    {
        SQLiteDatabase writeableDB = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SummonerTable.Cols.NAME, name);
        cv.put(SummonerTable.Cols.IMAGE, image);
        cv.put(SummonerTable.Cols.DESCRIPTION, description);
        writeableDB.insert(SummonerTable.NAME, null, cv);
    }

    public void insertRuneData(String name, String image, String description)
    {
        SQLiteDatabase writeableDB = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(RuneTable.Cols.NAME, name);
        cv.put(RuneTable.Cols.IMAGE, image);
        cv.put(RuneTable.Cols.DESCRIPTION, description);
        writeableDB.insert(RuneTable.NAME, null, cv);
    }

    public void insertItemData(String name, String image, String description)
    {
        SQLiteDatabase writeableDB = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ItemTable.Cols.NAME, name);
        cv.put(ItemTable.Cols.IMAGE, image);
        cv.put(ItemTable.Cols.DESCRIPTION, description);
        writeableDB.insert(ItemTable.NAME, null, cv);
    }

    //methods that return a cursor to entire tables

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

    //methods to grab image uri's:

    //character table:
    public String getCharacterImageURI(String character_name)
    {
        Cursor cursor = getAllDataFromCharacterTable();
        while (cursor.moveToNext())
        {
            if (cursor.getString(cursor.getColumnIndex(CharacterTable.Cols.NAME)).equals(character_name))
            {
                String uri = cursor.getString(cursor.getColumnIndex(CharacterTable.Cols.THUMBNAIL));
                cursor.close();
                return uri;
            }
        }
        return "uri not found";
    }

    //Skill table:
    public String getQSkillURI(String character_name)
    {
        Cursor cursor = getAllDataFromSkillTable();
        while (cursor.moveToNext())
        {
            if (cursor.getString(cursor.getColumnIndex(SkillTable.Cols.NAME)).equals(character_name))
            {
                String uri = cursor.getString(cursor.getColumnIndex(SkillTable.Cols.SKILL_Q));
                cursor.close();
                return uri;
            }
        }
        return "uri not found";
    }

    public String getWSkillURI(String character_name)
    {
        Cursor cursor = getAllDataFromSkillTable();
        while (cursor.moveToNext())
        {
            if (cursor.getString(cursor.getColumnIndex(SkillTable.Cols.NAME)).equals(character_name))
            {
                String uri = cursor.getString(cursor.getColumnIndex(SkillTable.Cols.SKILL_W));
                cursor.close();
                return uri;
            }
        }
        return "uri not found";
    }

    public String getESkillURI(String character_name)
    {
        Cursor cursor = getAllDataFromSkillTable();
        while (cursor.moveToNext())
        {
            if (cursor.getString(cursor.getColumnIndex(SkillTable.Cols.NAME)).equals(character_name))
            {
                String uri = cursor.getString(cursor.getColumnIndex(SkillTable.Cols.SKILL_E));
                cursor.close();
                return uri;
            }
        }
        return "placeholder.png";
    }

    public String getRSkillURI(String character_name)
    {
        Cursor cursor = getAllDataFromSkillTable();
        while (cursor.moveToNext())
        {
            if (cursor.getString(cursor.getColumnIndex(SkillTable.Cols.NAME)).equals(character_name))
            {
                String uri = cursor.getString(cursor.getColumnIndex(SkillTable.Cols.SKILL_R));
                cursor.close();
                return uri;
            }
        }
        return "placeholder.png";
    }

    //Rune table:
    public String getRuneURI(String rune_name)
    {
        Cursor cursor = getAllDataFromRuneTable();
        while (cursor.moveToNext())
        {
            if (cursor.getString(cursor.getColumnIndex(RuneTable.Cols.NAME)).equals(rune_name))
            {
                String uri = cursor.getString(cursor.getColumnIndex(RuneTable.Cols.IMAGE));
                cursor.close();
                return uri;
            }
        }
        return "placeholder.png";
    }

    //Summoner table:
    public String getSummonerURI(String summoner_name)
    {
        Cursor cursor = getAllDataFromSummonerTable();
        while (cursor.moveToNext())
        {
            if (cursor.getString(cursor.getColumnIndex(SummonerTable.Cols.NAME)).equals(summoner_name))
            {
                String uri = cursor.getString(cursor.getColumnIndex(SummonerTable.Cols.IMAGE));
                cursor.close();
                return uri;
            }
        }
        return "placeholder.png";
    }

    //Item table:
    public String getItemURI(String item_name)
    {
        Cursor cursor = getAllDataFromItemTable();
        while (cursor.moveToNext())
        {
            if (cursor.getString(cursor.getColumnIndex(ItemTable.Cols.NAME)).equals(item_name));
            {
                String uri = cursor.getString(cursor.getColumnIndex(ItemTable.Cols.IMAGE));
                cursor.close();
                return uri;
            }
        }
        return "placeholder.png";
    }

    //methods to hardcode populate tables:

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
        //precision
        insertRuneData("Precision", "rune/precision.png", "");
        insertRuneData("Press_The_Attack", "rune/press_the_attack.png", "");
        insertRuneData("Lethal_Tempo", "rune/lethal_tempo.png", "");
        insertRuneData("Fleet_Footwork", "rune/fleet_footwork.png", "");
        insertRuneData("Conqueror", "rune/conqueror.png", "");
        insertRuneData("Overheal", "rune/overheal.png", "");
        insertRuneData("Triumph", "rune/triumph.png", "");
        insertRuneData("Presence_Of_Mind", "rune/presence_of_mind.png", "");
        insertRuneData("Legend_Alacrity", "rune/legend_alacrity.png", "");
        insertRuneData("Legend_Bloodline", "rune/legend_bloodline.png", "");
        insertRuneData("Legend_Tenacity", "rune/legend_tenacity.png", "");
        insertRuneData("Coup_De_Grace", "rune/coup_de_grace.png", "");
        insertRuneData("Cut_Down", "rune/cut_down.png", "");
        insertRuneData("Last_Stand", "rune/last_stand.png", "");

        //domination
        insertRuneData("Domination", "rune/domination.png", "");
        insertRuneData("Electrocute", "rune/electrocute.png", "");
        insertRuneData("Predator", "rune/predator.png", "");
        insertRuneData("Dark_Harvest", "rune/dark_harvest.png", "");
        insertRuneData("Hail_Of_Blades", "rune/hail_of_blades.png", "");
        insertRuneData("Cheap_Shot", "rune/cheap_shot.png", "");
        insertRuneData("Taste_Of_Blood", "rune/taste_of_blood.png", "");
        insertRuneData("Sudden_Impact", "rune/sudden_impact.png", "");
        insertRuneData("Zombie_Ward", "rune/zombie_ward.png", "");
        insertRuneData("Ghost_Poro", "rune/ghost_poro.png", "");
        insertRuneData("Eyeball_Collection", "rune/eyeball_collection.png", "");
        insertRuneData("Ravenous_Hunter", "rune/ravenous_hunter.png", "");
        insertRuneData("Ingenious_Hunter", "rune/ingenious_hunter.png", "");
        insertRuneData("Relentless_Hunter", "rune/relentless_hunter.png", "");
        insertRuneData("Ultimate_Hunter", "rune/ultimate_hunter.png", "");

        //sorcery
        insertRuneData("Sorcery", "rune/sorcery.png", "");
        insertRuneData("Summon_Aery", "rune/summon_aery.png", "");
        insertRuneData("Arcane_Comet", "rune/arcane_comet.png", "");
        insertRuneData("Phase_Rush", "rune/phase_rush.png", "");
        insertRuneData("Nullifying_Orb", "rune/nullifying_orb.png", "");
        insertRuneData("Manaflow_Band", "rune/manaflow_band.png", "");
        insertRuneData("Nimbus_Cloak", "rune/nimbus_cloak.png", "");
        insertRuneData("Transcendence", "rune/transcendence.png", "");
        insertRuneData("Celerity", "rune/celerity.png", "");
        insertRuneData("Absolute_Focus", "rune/absolute_focus.png", "");
        insertRuneData("Scorch", "rune/scorch.png", "");
        insertRuneData("Waterwalking", "rune/waterwalking.png", "");
        insertRuneData("Gathering_Storm", "rune/gathering_storm.png", "");

        //resolve
        insertRuneData("Resolve", "rune/resolve.png", "");
        insertRuneData("Grasp_Of_The_Undying", "rune/grasp_of_the_undying.png", "");
        insertRuneData("Aftershock", "rune/aftershock.png", "");
        insertRuneData("Guardian", "rune/guardian.png", "");
        insertRuneData("Demolish", "rune/demolish.png", "");
        insertRuneData("Font_Of_Life", "rune/font_of_life.png", "");
        insertRuneData("Shield_Bash", "rune/shield_bash.png", "");
        insertRuneData("Conditioning", "rune/conditioning.png", "");
        insertRuneData("Second_Wind", "rune/second_wind.png", "");
        insertRuneData("Bone_Plating", "rune/bone_plating.png", "");
        insertRuneData("Overgrowth", "rune/overgrowth.png", "");
        insertRuneData("Revitalize", "rune/revitalize.png", "");
        insertRuneData("Unflinching", "rune/unflinching.png", "");

        //inspiration
        insertRuneData("Inspiration", "rune/inspiration.png", "");
        insertRuneData("Unsealed_Spellbook", "rune/unsealed_spellbook.png", "");
        insertRuneData("Glacial_Augment", "rune/glacial_augment.png", "");
        insertRuneData("Kleptomancy", "rune/kleptomancy.png", "");
        insertRuneData("Hextech_Flashtraption", "rune/hextech_flashtraption.png", "");
        insertRuneData("Magical_Footwear", "rune/magical_footwear.png", "");
        insertRuneData("Perfect_Timing", "rune/perfect_timing.png", "");
        insertRuneData("Futures_Market", "rune/futures_market.png", "");
        insertRuneData("Minion_Dematerializer", "rune/minion_dematerializer.png", "");
        insertRuneData("Biscuit_Delivery", "rune/biscuit_delivery.png", "");
        insertRuneData("Cosmic_Insight", "rune/cosmic_insight.png", "");
        insertRuneData("Approach_Velocity", "rune/approach_velocity.png", "");
        insertRuneData("Time_Warp_Tonic", "rune/time_warp_tonic.png", "");

        //tertiary
        insertRuneData("Diamond", "rune/diamond.png", "");
        insertRuneData("Axe", "rune/axe.png", "");
        insertRuneData("Time", "rune/time.png", "");
        insertRuneData("Shield", "rune/shield.png", "");
        insertRuneData("Circle", "rune/circle.png", "");
        insertRuneData("Heart", "rune/heart.png", "");
    }

    //todo later sprint 3
    public void hardCodeItemTable()
    {
        // :(
    }

    public void hardCodeSummonerTable()
    {
        insertSummonerData("Barrier", "summoner/barrier.png", "");
        insertSummonerData("Cleanse", "summoner/cleanse.png", "");
        insertSummonerData("Exhaust", "summoner/exhaust.png", "");
        insertSummonerData("Flash", "summoner/flash.png", "");
        insertSummonerData("Ghost", "summoner/ghost.png", "");
        insertSummonerData("Heal", "summoner/heal.png", "");
        insertSummonerData("Ignite", "summoner/ignite.png", "");
        insertSummonerData("Smite", "summoner/smite.png", "");
        insertSummonerData("Teleport", "summoner/teleport.png", "");
    }

}