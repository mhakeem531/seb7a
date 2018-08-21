package com.example.hakeem.sebha.tasbehat;

import com.example.hakeem.sebha.R;
import com.example.hakeem.sebha.fragments.AllahGreatNamesFragment;
import com.example.hakeem.sebha.fragments.ElhamdFragment;
import com.example.hakeem.sebha.fragments.EsteghfarFragment;
import com.example.hakeem.sebha.fragments.HawkalaFragment;
import com.example.hakeem.sebha.fragments.HomeFragment;
import com.example.hakeem.sebha.fragments.SalahFragment;
import com.example.hakeem.sebha.fragments.SobhanAllahFragment;
import com.example.hakeem.sebha.fragments.TakbeerFragment;
import com.example.hakeem.sebha.fragments.TasbeehFragment;
import com.example.hakeem.sebha.fragments.TawheedFragment;
import com.example.hakeem.sebha.helper.CustomTypefaceSpan;
import com.example.hakeem.sebha.helper.SessionManager;
import com.example.hakeem.sebha.helper.Variables;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.Gravity;
import android.view.SubMenu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;


public class TasbehatNavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, HomeFragment.OnFragmentInteractionListener{

    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private TextView ChoosePraiseTextView;
    private Menu navigationMenu;

////////////counters
    /*
    public long sobhanallah_count = SessionManager.getSobhanAllahCount();
    public long elhamedLallah_count = SessionManager.getElhamedLallahCount();
    public long tawhed_count = SessionManager.getTawheedCount();
    public long takbeer_count = SessionManager.getTakbeerCount();
    public long hawkala_count = SessionManager.getHawkalaCount();
    public long tasbeeh_count = SessionManager.getTasbeehCount();
    public long estakfar_count = SessionManager.getEstakfarCount();
    public long salah_count = SessionManager.getSalahCount();
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasbehat_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.drawer_layout);

        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);


        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationMenu = navigationView.getMenu();




        View hView = navigationView.getHeaderView(0);
        navigationView.setNavigationItemSelectedListener(this);
        ChoosePraiseTextView = hView.findViewById(R.id.string_choose_praise);
        applyFontToTextView(ChoosePraiseTextView);
        Menu m = navigationView.getMenu();
        for (int i = 0; i < m.size(); i++) {
            MenuItem mi = m.getItem(i);

            //for aapplying a font to subMenu ...
            SubMenu subMenu = mi.getSubMenu();
            if (subMenu != null && subMenu.size() > 0) {
                for (int j = 0; j < subMenu.size(); j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    applyFontToMenuItem(subMenuItem);
                }
            }

            //the method we have create in activity
            applyFontToMenuItem(mi);
        }

//        navigationView.setLayoutParams(params);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        startHomeMenuItem();
    }

    @Override
    protected void onStop() {
        super.onStop();

        updateCounters();
        Log.e("ONSTOP", "onstop");
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }


    @Override
    public void onBackPressed() {
        Log.e("onBackPressed", "onBackPressed");
        updateCounters();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }


    }

    private void updateCounters(){
        SessionManager.setSobhanAllahCount(Variables.sobhanallah_count);
        SessionManager.setElhamedLallahCount(Variables.elhamedLallah_count);
        SessionManager.setEstakfarCount(Variables.estakfar_count);
        SessionManager.setHawkalaCount(Variables.hawkala_count);
        SessionManager.setSalahCount(Variables.salah_count);
        SessionManager.setTakbeerCount(Variables.takbeer_count);
        SessionManager.setTasbeehCount(Variables.tasbeeh_count);
        SessionManager.setTawheedCount(Variables.tawhed_count);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        if(toggle.onOptionsItemSelected(item)){
            return true;
        }

        switch (item.getItemId()) {
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);
                return true;

            case R.id.action_settings:
                return true;



        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.


        displaySelectedScreen(item);

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void displaySelectedScreen(MenuItem item) {
        int id = item.getItemId();

        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;
        switch (id) {
            case R.id.nav_home_menu_item:
                fragmentClass = HomeFragment.class;
                fragment = new HomeFragment();
                break;

            case R.id.nav_sobhan_allah_menu_item:
                fragmentClass = SobhanAllahFragment.class;
                fragment = new SobhanAllahFragment();
                break;

            case R.id.nav_elhamed_lallah_menu_item:
                fragmentClass = ElhamdFragment.class;
                fragment = new ElhamdFragment();
                break;
            case R.id.nav_allah_great_names_menu_item:
                fragmentClass = AllahGreatNamesFragment.class;
                fragment = new AllahGreatNamesFragment();
                break;

            case R.id.nav_tawheed_menu_item:
                fragmentClass = TawheedFragment.class;
                fragment = new TawheedFragment();
                break;

            case R.id.nav_takbeer_menu_item:
                fragmentClass = TakbeerFragment.class;
                fragment = new TakbeerFragment();
                break;

            case R.id.nav_hawkala_menu_item:
                fragmentClass = HawkalaFragment.class;
                fragment = new HawkalaFragment();
                break;

            case R.id.nav_tasbeeh_menu_item:
                fragmentClass = TasbeehFragment.class;
                fragment = new TasbeehFragment();
                break;

            case R.id.nav_estakfar_menu_item:
                fragmentClass = EsteghfarFragment.class;
                fragment = new EsteghfarFragment();
                break;

            case R.id.nav_salah_menu_item:
                fragmentClass = SalahFragment.class;
                fragment = new SalahFragment();
                break;


            default:
                fragmentClass = HomeFragment.class;
        }


        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        if (fragment != null) {
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.frame, fragment);
//            ft.commit();
//
//           // item.setChecked(true);
//
//        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        item.setChecked(true);
        // Set action bar title
        setTitle(item.getTitle());
        // Close the navigation drawer
      //  drawer.closeDrawers();

    }

    private void startHomeMenuItem(){
        MenuItem homeMenuItem = navigationMenu.findItem(R.id.nav_home_menu_item);
        displaySelectedScreen(homeMenuItem);
    }
    private void applyFontToMenuItem(MenuItem mi) {
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/OldAnticDecorative.ttf");
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypefaceSpan("", font), 0, mNewTitle.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }

    private void applyFontToTextView(TextView textView){
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/OldAnticDecorative.ttf");
        textView.setTypeface(font);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

        Log.e("URIII", uri.toString());

    }
}
