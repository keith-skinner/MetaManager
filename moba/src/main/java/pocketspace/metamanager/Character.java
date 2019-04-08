package pocketspace.metamanager;

import android.graphics.Bitmap;
import android.media.Image;
import android.widget.ImageView;

import java.net.URI;

public class Character {

    public int character_id;
//    public URI character_uri;
    public int character_img;
    public String character_name;

    public Character( int img, String name){
        character_img = img;
//        character_id = id;
//        character_uri = imgURI;
        character_name = name;
    }


    //  Setters:
    public void setCharacter_id(int character_id) {
        this.character_id = character_id;
    }
    public void setCharacter_img(int character_img) {
        this.character_img = character_img;
    }
    public void setCharacter_name(String character_name) {
        this.character_name = character_name;
    }



    //  Getters:
    public int getCharacter_id() {
        return character_id;
    }
    public int getCharacter_img() {
        return character_img;
    }
    public String getCharacter_name() {
        return character_name;
    }

}
