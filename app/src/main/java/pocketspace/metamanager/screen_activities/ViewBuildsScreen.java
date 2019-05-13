package pocketspace.metamanager.screen_activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import pocketspace.metamanager.R;
import pocketspace.metamanager.database.MetaManagerDatabaseHelper;
import pocketspace.metamanager.model.Champion;


public class ViewBuildsScreen extends AppCompatActivity {

    LinearLayout lnr_expanded_search;
    View topLineView; // The line that is between the first build and the top right search icon (prior to clicking)
    ImageView iv_search;

    MetaManagerDatabaseHelper db;
    ArrayList<Champion> championData = new ArrayList<>();

    EditText search_text;
    private ChampionAdapter championAdapter;

    PopupWindow view_builds_search_popup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_builds_screen);

        db = new MetaManagerDatabaseHelper(this);
        search_text = (EditText) findViewById(R.id.search_text);


        //START_TEST
//        FileInputStream inputstream = null;
//        try {
//            inputstream = new FileInputStream(getBuildsDir().getAbsolutePath() + "/newBuild.xml");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

//        BuildParser parser = null;
//        try {
//            parser = new BuildParser(inputstream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //END TEST

        topLineView = this.findViewById(R.id.view_topLine);
        lnr_expanded_search = this.findViewById(R.id.lnr_expanded_search);
        iv_search = this.findViewById(R.id.iv_search_minimized);
        iv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lnr_expanded_search.getVisibility() == View.GONE)
                    iv_search.setVisibility(View.GONE);
                topLineView.setVisibility(View.GONE);
                lnr_expanded_search.setVisibility(View.VISIBLE);
            }
        });

        CardView cardView = this.findViewById(R.id.build_card_0);
        cardView.setOnClickListener(view -> {
            Intent intent = new Intent(this, BuildScreen.class);
            view.getContext().startActivity(intent);
        });

        setChampionData();
    }

    private void setChampionData() {
        championData.clear();
        championData = db.getAllFromChampionTable();

        // If there were any champions stored in the database
        if (championData != null && championData.size() > 0) {
            // inflating the layout of the popup window
            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View popupView = inflater.inflate(R.layout.popup_search_list, null);

            // create the popup window
            int width = LinearLayout.LayoutParams.MATCH_PARENT;
            int height = LinearLayout.LayoutParams.WRAP_CONTENT;
            view_builds_search_popup = new PopupWindow(popupView, width, height, false);

            view_builds_search_popup.setOutsideTouchable(false);

            // setting the custom dialog components
            RecyclerView recycler = popupView.findViewById(R.id.recycler);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recycler.setLayoutManager(mLayoutManager);
            recycler.setItemAnimator(new DefaultItemAnimator());
            championAdapter = new ChampionAdapter(championData);

            // setting the adapter for the recycler view
            recycler.setAdapter(championAdapter);
        }

        search_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence inputCharacters, int start, int before, int count) {

                if (view_builds_search_popup != null && championAdapter != null) {

                    if (inputCharacters.toString().length() > 0) {
                        if (!view_builds_search_popup.isShowing())
                            view_builds_search_popup.showAsDropDown(search_text);
                            championAdapter.getFilter().filter(inputCharacters);

                    } else {
                        if (inputCharacters.toString().length() == 0 && view_builds_search_popup != null && view_builds_search_popup.isShowing()) {
                            view_builds_search_popup.dismiss();
                        }
                    }
                } else {
                    Toast.makeText(ViewBuildsScreen.this, "No results were found for that champion or build name", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public class ChampionAdapter extends RecyclerView.Adapter<ChampionAdapter.ChampionViewHolder> implements Filterable {
        private List<Champion> championList;
        private List<Champion> filteredChampionList;


        public class ChampionViewHolder extends RecyclerView.ViewHolder {
            public TextView tv_champion_name;
            public ImageView iv_champion_image;
            public LinearLayout lnr_main;

            public ChampionViewHolder(View view) {
                super(view);
                lnr_main = (LinearLayout) view.findViewById(R.id.lnr_main);
                tv_champion_name = (TextView) view.findViewById(R.id.tv_champion_name);
                iv_champion_image = (ImageView) view.findViewById(R.id.iv_champion_image);
            }
        }

        // For working with the list of champions
        public ChampionAdapter(List<Champion> MessagesList) {
            this.championList = MessagesList;
            this.filteredChampionList = MessagesList;
        }

        @Override
        public int getItemCount() {
            return filteredChampionList.size();
        }

        @Override
        public ChampionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_build_search_bar, parent, false);
            return new ChampionViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final ChampionViewHolder holder, final int position) {
            Champion model = filteredChampionList.get(position);

            holder.tv_champion_name.setText(model.getName());


            if (model.getThumbnail() != null && !model.getThumbnail().isEmpty() && !model.getThumbnail().equalsIgnoreCase("null")) {
                AssetManager assetManager = getAssets();
                InputStream is = null;
                try {
                    is = assetManager.open(model.getThumbnail());
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    holder.iv_champion_image.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            holder.lnr_main.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    search_text.setText(model.getName());
                    search_text.setSelection(model.getName().length());

                    if (view_builds_search_popup != null && view_builds_search_popup.isShowing())
                        view_builds_search_popup.dismiss();

                    hideKeyboard();

                }
            });
        }

        // Method for returning search results of builds and champions
        public Filter buildSearchFilter() {
            return new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence charSequence) {
                    String charString = charSequence.toString();

                    if (charString == null || charString.isEmpty()) {
                        filteredChampionList = championList;

                    } else {
                        ArrayList<Champion> championList = new ArrayList<>();
                        for (Champion row : championList) {
                            if (row.getName() != null && row.getName().toLowerCase().startsWith(charString.toLowerCase())) {
                                championList.add(row);
                            }
                        }
                        filteredChampionList = championList;
                    }

                    FilterResults buildSearchResults = new FilterResults();
                    buildSearchResults.values = filteredChampionList;
                    return buildSearchResults;
                }

                @Override
                protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                    filteredChampionList = (ArrayList<Champion>) filterResults.values;
                    notifyDataSetChanged();
                }
            };
        }

        @Override
        public Filter getFilter() {
            return new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence charSequence) {
                    String charString = charSequence.toString();

                    if (charString == null || charString.isEmpty()) {
                        filteredChampionList = championList;

                    } else {

                        ArrayList<Champion> filteredList = new ArrayList<>();
                        for (Champion row : championList) {

                            // name match condition. this might differ depending on your requirement
                            // here we are looking for name or phone number match
                            if (row.getName() != null && row.getName().toLowerCase().startsWith(charString.toLowerCase())) {
                                filteredList.add(row);
                            }
                        }
                        Log.e("filteredList===", filteredList + "");

                        filteredChampionList = filteredList;
                    }

                    FilterResults filterResults = new FilterResults();
                    filterResults.values = filteredChampionList;
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                    filteredChampionList = (ArrayList<Champion>) filterResults.values;
                    notifyDataSetChanged();
                }
            };
        }
    }

    // For creating a new file...
    public void createFile(File directory, String fname, String buildContent) {

        if (!directory.exists() && !directory.mkdirs()) {
            Log.e("clear", "Could not make directory");
        }

        try {
            File textFile = new File(directory, fname);
            FileWriter writer = new FileWriter(textFile);
            writer.append(buildContent);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            Log.d("createFile", "fail:" + e);
            e.printStackTrace();
        }
    }

    File getBuildsDir() {
        return new File(this.getFilesDir(), "/builds");
    }

    @Override
    protected void onResume() {
        super.onResume();
        lnr_expanded_search.setVisibility(View.GONE);
        iv_search.setVisibility(View.VISIBLE);
        topLineView.setVisibility(View.VISIBLE);
    }

    // Method for hiding the keyboard after clicking on a champion or build in search results
    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        View newView = getCurrentFocus(); // For the currently focused view

        //If no view currently has focus, create a new view so that we can grab a window token from it
        if (newView == null) {
            newView = new View(ViewBuildsScreen.this);
        }
        imm.hideSoftInputFromWindow(newView.getWindowToken(), 0);
    }
}
