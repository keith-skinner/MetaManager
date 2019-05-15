package pocketspace.metamanager.data.build.room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="build_info")
public class BuildInfo {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="build_name")
    private String buildName = "";

    @NonNull
    @ColumnInfo(name="build_champion")
    private String buildChampion = "";

    @NonNull
    @ColumnInfo(name="build_role")
    private String buildRole = "";

    @ColumnInfo(name="build_keystone_family")
    private String getBuildKeystoneFamily = "";

    @ColumnInfo(name="build_keystone")
    private String buildKeystone = "";

    @ColumnInfo(name="build_item1")
    private String buildItem1 = "";

    @ColumnInfo(name="build_item2")
    private String buildItem2 = "";

    @ColumnInfo(name="build_item3")
    private String buildItem3 = "";

    @ColumnInfo(name="build_item4")
    private String buildItem4 = "";

    @ColumnInfo(name="build_item5")
    private String buildItem5 = "";

    @ColumnInfo(name="build_item6")
    private String buildItem6 = "";

    @ColumnInfo(name="build_text")
    private String buildText = "";

    @NonNull
    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(@NonNull String buildName) {
        this.buildName = buildName;
    }

    @NonNull
    public String getBuildChampion() {
        return buildChampion;
    }

    public void setBuildChampion(@NonNull String buildChampion) {
        this.buildChampion = buildChampion;
    }

    @NonNull
    public String getBuildRole() {
        return buildRole;
    }

    public void setBuildRole(@NonNull String buildRole) {
        this.buildRole = buildRole;
    }

    public String getGetBuildKeystoneFamily() {
        return getBuildKeystoneFamily;
    }

    public void setGetBuildKeystoneFamily(String getBuildKeystoneFamily) {
        this.getBuildKeystoneFamily = getBuildKeystoneFamily;
    }

    public String getBuildKeystone() {
        return buildKeystone;
    }

    public void setBuildKeystone(String buildKeystone) {
        this.buildKeystone = buildKeystone;
    }

    public String getBuildItem1() {
        return buildItem1;
    }

    public void setBuildItem1(String buildItem1) {
        this.buildItem1 = buildItem1;
    }

    public String getBuildItem2() {
        return buildItem2;
    }

    public void setBuildItem2(String buildItem2) {
        this.buildItem2 = buildItem2;
    }

    public String getBuildItem3() {
        return buildItem3;
    }

    public void setBuildItem3(String buildItem3) {
        this.buildItem3 = buildItem3;
    }

    public String getBuildItem4() {
        return buildItem4;
    }

    public void setBuildItem4(String buildItem4) {
        this.buildItem4 = buildItem4;
    }

    public String getBuildItem5() {
        return buildItem5;
    }

    public void setBuildItem5(String buildItem5) {
        this.buildItem5 = buildItem5;
    }

    public String getBuildItem6() {
        return buildItem6;
    }

    public void setBuildItem6(String buildItem6) {
        this.buildItem6 = buildItem6;
    }

    public String getBuildText() {
        return buildText;
    }

    public void setBuildText(String buildText) {
        this.buildText = buildText;
    }



}
