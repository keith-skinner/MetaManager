package pocketspace.metamanager;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class TabSecondaryRuneFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate(pocketspace.metamanager.lol.R.layout.fragment_secondary_rune, container, false);


    }

    private void makeRuneUnselected(View view)
    {
        //make opaque
        ImageView myImage = (ImageView) view.findViewById(R.id.botRoleButton);
        myImage.setAlpha(127);
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);

        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
        myImage.setColorFilter(filter);
    }

}
