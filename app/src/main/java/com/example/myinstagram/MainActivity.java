package com.example.myinstagram;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myinstagram.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myinstagram.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view); //it is the id of whole navigation view, now navView can be used as reference Object to some item present in BottomNavigation
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.search, R.id.navigation_notifications)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);


//        Toolbar toolbar = findViewById(R.id.toolbar);

        Toolbar toolbar = findViewById(R.id.toolbar); //There are 2 Toolbar classes, make sure you use "androidx.appcompat.widget.Toolbar"
        setSupportActionBar(toolbar);
        ImageView camera = toolbar.findViewById(R.id.camera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Opening Camera", Toast.LENGTH_SHORT).show();
            }
        });
        navView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId()== R.id.navigation_home){ //id of that home icon
                    HomeFragment homeFragment = new HomeFragment(); //HomeFragment is a custom class, we already get when we choose 'BottomNavigation' layout app in the starting
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.nav_host_fragment_activity_main, homeFragment);
                    transaction.commit();
                    Toast.makeText(MainActivity.this, "You clicked on Home i know", Toast.LENGTH_SHORT).show();
                }
                else if (item.getItemId()== R.id.search){
                    Toast.makeText(MainActivity.this, "You clicked on Search i know", Toast.LENGTH_SHORT).show();
                }
                else if (item.getItemId()== R.id.navigation_notifications){
                    Toast.makeText(MainActivity.this, "Notifications are bad for your health", Toast.LENGTH_SHORT).show();
                }
                else if (item.getItemId()== R.id.heart){
                    Toast.makeText(MainActivity.this, "You have my heart", Toast.LENGTH_SHORT).show();
                }
                else if (item.getItemId()== R.id.profile){
                    Toast.makeText(MainActivity.this, "Profile coming soon", Toast.LENGTH_SHORT).show();
                }
                return true; //iF kept 'false', then view will not highlight
            }
        });
    }

}