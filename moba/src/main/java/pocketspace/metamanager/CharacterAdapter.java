package pocketspace.metamanager;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pocketspace.metamanager.moba.R;

public class CharacterAdapter extends ArrayAdapter<Character> {


    private Context mContext;
    private List<Character> characterList = new ArrayList<>();


    public CharacterAdapter(@NonNull Context context, @LayoutRes ArrayList<Character> list) {
        super(context, 0 , list);
        mContext = context;
        characterList = list;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItem = convertView;

        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent,false);

        Character currentCharacter = characterList.get(position);

        ImageView image = (ImageView)listItem.findViewById(R.id.character_img);
        image.setImageResource(currentCharacter.getCharacter_img());


        TextView name = (TextView) listItem.findViewById(R.id.character_name);
        name.setText(currentCharacter.getCharacter_name());



        return listItem;
    }


}
