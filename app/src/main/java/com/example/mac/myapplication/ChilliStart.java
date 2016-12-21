package com.example.mac.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.mac.myapplication.Contacts.ChilliContactFragment;
import com.example.mac.myapplication.Products.AllChillProductsFragment;

public class ChilliStart extends AppCompatActivity implements AHBottomNavigation.OnTabSelectedListener {
    AHBottomNavigation bottomNavigation;
    Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chilli_start);

        bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnTabSelectedListener(this);


        bottomNavigation.setBehaviorTranslationEnabled(false);


        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);

        this.createView();


    }

    private void createView() {
        AHBottomNavigationItem item1 = new AHBottomNavigationItem("categories", R.drawable.cat_icon, R.color.color_tab_1);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("all products", R.drawable.ic_action_products, R.color.color_tab_2);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("contact us", R.drawable.cat_icon, R.color.color_tab_3);

        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);

// Set background color
        //bottomNavigation.setDefaultBackgroundColor( Color.parseColor("#FEFEFE"));
        bottomNavigation.setCurrentItem(0);

    }

    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {
        if (position == 0) {

            MainActivityFragment mainActivityFragment = new MainActivityFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.activity_chilli_start, mainActivityFragment).commit();

        } else if (position == 1) {
            AllChillProductsFragment chilliProductsFragment = new AllChillProductsFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.activity_chilli_start, chilliProductsFragment).commit();
            // bottomNavigation.setCurrentItem( 1);


        } else if (position == 2) {
            ChilliContactFragment chilliProductsFragment = new ChilliContactFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.activity_chilli_start, chilliProductsFragment).commit();


        }
        return false;
    }
}
