package pocketspace.metamanager.data.build;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pocketspace.metamanager.data.build.item.ItemBlock;
import pocketspace.metamanager.data.build.role.Role;
import pocketspace.metamanager.data.build.runes.Runes;
import pocketspace.metamanager.data.build.skill.Skill;
import pocketspace.metamanager.data.build.summoner.Summoner;

public class Build {

    public String name = "";
    public String champion = ""; //TBD
    public Role role = new Role();
    public Runes runes = new Runes();
    public Summoner summoner1 = new Summoner();
    public Summoner summoner2 = new Summoner();
    public List<ItemBlock> items = new ArrayList<>();
    public List<Skill> skills = new ArrayList<>();

    public Build() {
    }

    public Build(String name, String champion,
                 Runes runes, Summoner summoner1, Summoner summoner2,
                 List<ItemBlock> items, List<Skill> skills)
    {
        this.name = name;
        this.champion = champion;
        this.runes = runes;
        this.summoner1 = summoner1;
        this.summoner2 = summoner2;
        this.items = items;
        this.skills = skills;
    }
}
