package com.example.app4;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView textView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    CircleImageView profileImageView;
    LinearLayout linearLayout1;
    LinearLayout linearLayout2;
    LinearLayout linearLayout3;
    MediaPlayer music;
    Button play;
    Button pause;
    Button stop;
    int idl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolBar();
        SetUpNavigationDrawerIcon();
        bindViews();
        setUpIntialListerer();
        setUpListerner();
    }

    private void bindViews()
    {
        linearLayout1 = findViewById(R.id.gazabLinear);
        linearLayout2 = findViewById(R.id.rosesLinear);
        linearLayout3 = findViewById(R.id.namoLinear);

        play = findViewById(R.id.playButton);
        pause = findViewById(R.id.pauseButton);
        stop = findViewById(R.id.stopButton);

        navigationView = findViewById(R.id.navigation_view_main);

        View header = navigationView.getHeaderView(0);
        profileImageView =  header.findViewById(R.id.profile_photo);
        textView = header.findViewById(R.id.profile_name);

        navigationView = findViewById(R.id.navigation_view_main);
    }

    private void setUpIntialListerer()
    {
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musicplay();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musicpause();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musicstop();
            }
        });

        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMusicName(R.id.gazab);
            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMusicName(R.id.roses);
            }
        });

        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMusicName(R.id.namo);
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
    }

    private void setUpListerner()
    {

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.item1:
                        Toast.makeText(MainActivity.this, "Subscribe please", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.item2:
                        musicplay();
                        Toast.makeText(MainActivity.this, "Playing recently played", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.item4:
                        Toast.makeText(MainActivity.this, "Playing Roses", Toast.LENGTH_SHORT).show();
                        getMusicName(R.id.roses);
                        musicplay();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.item3:
                        Toast.makeText(MainActivity.this, "Playing Gazab ka he din", Toast.LENGTH_SHORT).show();
                        getMusicName(R.id.gazab);
                        musicplay();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.item5:
                        Toast.makeText(MainActivity.this, "Playing Senorita", Toast.LENGTH_SHORT).show();
                        getMusicName(R.id.namo);
                        musicplay();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                }
                return false;
            }
        });
    }

    private void SetUpNavigationDrawerIcon()
    {
        drawerLayout = findViewById(R.id.navigation_drawer_main);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.on_drawer_opened, R.string.on_drawer_closed);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void setUpToolBar()
    {
        toolbar = findViewById(R.id.toolBar_main);
        setSupportActionBar(toolbar);
    }

    public void getMusicName(int id)

    {
        idl = id;

        if(id == R.id.gazab)
        {
            idl =  R.raw.gazab;
        }
        else if(id == R.id.roses)
        {
            idl =  R.raw.roses;
        }
        else if(id == R.id.namo)
        {
            idl = R.raw.senorita;
        }
        music = MediaPlayer.create(this, idl);
        music.start();
    }
    public void musicplay()
    {
        music.start();
    }
    public void musicpause()
    {
        music.pause();
    }
    public void musicstop()
    {
        music.stop();
        music = MediaPlayer.create(this,idl );
    }
}