package com.example.newshub;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.example.newshub.fragments.ARYFragment;
import com.example.newshub.fragments.AlJazeeraFragment;
import com.example.newshub.fragments.BBCFragment;
import com.example.newshub.fragments.CNNFragment;
import com.example.newshub.fragments.NewYorkTimes_Fragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.navigationview);
        toolbar=findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer,R.string.closeDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(item->{
            if(item.getItemId()==R.id.aljazeeranews){
                AlJazeeraFragment fragment=new AlJazeeraFragment();
                FragmentTransaction transition=getSupportFragmentManager().beginTransaction();
                transition.replace(R.id.fragmentContainer,fragment);
                transition.commit();
            } else if (item.getItemId()==R.id.arynews) {
                ARYFragment fragment=new ARYFragment();
                FragmentTransaction transition=getSupportFragmentManager().beginTransaction();
                transition.replace(R.id.fragmentContainer,fragment);
                transition.commit();
            } else if (item.getItemId()==R.id.bbcnews) {
                BBCFragment fragment=new BBCFragment();
                FragmentTransaction transition=getSupportFragmentManager().beginTransaction();
                transition.replace(R.id.fragmentContainer,fragment);
                transition.commit();
            } else if (item.getItemId()==R.id.cnnnews) {
                CNNFragment fragment=new CNNFragment();
                FragmentTransaction transition=getSupportFragmentManager().beginTransaction();
                transition.replace(R.id.fragmentContainer,fragment);
                transition.commit();
            } else if (item.getItemId()==R.id.newyorktimesnews) {
                NewYorkTimes_Fragment fragment=new NewYorkTimes_Fragment();
                FragmentTransaction transition=getSupportFragmentManager().beginTransaction();
                transition.replace(R.id.fragmentContainer,fragment);
                transition.commit();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

        drawerLayout.closeDrawer(GravityCompat.START);
    }

    @SuppressLint("GestureBackNavigation")
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}