package com.smartgreen.firebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.CountDownTimer;

import com.github.anastr.speedviewlib.SpeedView;
import com.ntt.customgaugeview.library.GaugeView;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private FragmentStatePagerAdapter myStatePagerAdapter;

    private GaugeView gv_meter;
    private GaugeView gv_meter2;
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
                    return "SoilMonitor";
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
        /*BarChart chart = (BarChart) findViewById(R.id.chart);

      //  BarData data = new BarData(getXAxisValues(), getDataSet());
        //chart.setData(data);
        //chart.setDescription("My Chart");
        //chart.animateXY(2000, 2000);
        //chart.invalidate();
        gv_meter =  findViewById(R.id.gv_meter);
        SpeedView mySpeedView = findViewById(R.id.pointerSpeedometer);
        mySpeedView.speedTo(50);
        gv_meter.setShowRangeValues(true);
        gv_meter.setTargetValue(0);

        CountDownTimer timer = new CountDownTimer(10000, 2) {
            @Override
            public void onTick(long millisUntilFinished) {
                gv_meter.setTargetValue(Float.valueOf(90));
            }

            @Override
            public void onFinish() {
                gv_meter.setTargetValue(Float.valueOf(90));
            }
        };
        timer.start();*/
    }
}
