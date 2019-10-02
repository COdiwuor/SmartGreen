package com.smartgreen.firebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import com.google.firebase.auth.FirebaseAuth;
import com.ntt.customgaugeview.library.GaugeView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private FragmentStatePagerAdapter myStatePagerAdapter;
    public static class MyPagerAdapter extends FragmentStatePagerAdapter{
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager){
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new HumidityMonitorFragment();
                case 1:
                    return new SoilMonitorFragment();
                case 2:
                    return new TemperatureMonitorFragment();
                    default:
                        return null;
            }
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch(position){
                case 0:
                    return "Humidity";
                case 1:
                    return "SoilMoisture";
                case 2:
                    return "Temperature";
                    default:
                        return "No Title";
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager myViewPager = findViewById(R.id.my_view_pager);
        myStatePagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        myViewPager.setAdapter(myStatePagerAdapter);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /* Use AppCompatActivity's method getMenuInflater to get a handle on the menu inflater */
        MenuInflater inflater = getMenuInflater();
        /* Use the inflater's inflate method to inflate our menu layout to this menu */
        inflater.inflate(R.menu.menu_item, menu);
        /* Return true so that the menu is displayed in the Toolbar */
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_refresh) {
            Toast toast = Toast.makeText(MainActivity.this, "successfully logged out", Toast.LENGTH_SHORT);
            toast.show();
          FirebaseAuth.getInstance().signOut();
          Intent intent = new Intent(MainActivity.this, LoginActivity.class);
          startActivity(intent);
          return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
