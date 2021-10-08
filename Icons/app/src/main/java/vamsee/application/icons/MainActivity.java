package vamsee.application.icons;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    GridView grid;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid = findViewById(R.id.gridView);
        list = findViewById(R.id.list);

        int[] icons = {R.drawable.chrome, R.drawable.google, R.drawable.instagram,
                R.drawable.netflix, R.drawable.phone, R.drawable.photo,
                R.drawable.security, R.drawable.settings, R.drawable.whatsapp,
                R.drawable.youtube, R.drawable.music, R.drawable.amazon,
                R.drawable.prime, R.drawable.amazon_music, R.drawable.beach,
                R.drawable.pubg, R.drawable.clash, R.drawable.telegram,
                R.drawable.twitch, R.drawable.vlc, R.drawable.go, R.drawable.github};

        String[] names = {"Chrome", "Google", "Instagram", "Netflix", "Phone",
                "photo", "Security", "Settings", "whatsapp",
                "Youtube", "music", "Amazon", "Prime", "Prime Music",
                "Buggy Racing", "pubg", "Clash Royale", "Telegram", "Twitch", "Vlc",
                "Pokemon GO", "github"};

        IconAdapter adaper = new IconAdapter(MainActivity.this, icons, names);

        grid.setAdapter(adaper);
        list.setAdapter(adaper);

        FloatingActionButton listBtn = findViewById(R.id.listbtn);
        FloatingActionButton gridBtn = findViewById(R.id.gridbtn);
            listBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    grid.setVisibility(View.GONE);
                    list.setVisibility(View.VISIBLE);
                    listBtn.setVisibility(View.GONE);
                    gridBtn.setVisibility(View.VISIBLE);

                }
            });



        gridBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grid.setVisibility(View.VISIBLE);
                list.setVisibility(View.GONE);
                listBtn.setVisibility(View.VISIBLE);
                gridBtn.setVisibility(View.GONE);

            }
        });




    }

}