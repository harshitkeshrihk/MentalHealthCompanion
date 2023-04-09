package com.hk.suisafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle arg0) {

        setCountryValues(getUserCountry(getApplicationContext()));

//        setUpTabLayoutWithViewPager();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        super.onCreate(arg0);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setElevation(0);

        boolean previouslyStarted = prefs.getBoolean(getString(R.string.prefpreviouslystarted), false);

        if(!previouslyStarted){
            SharedPreferences.Editor edit = prefs.edit();
            edit.putBoolean(getString(R.string.prefpreviouslystarted), Boolean.TRUE);
            edit.apply();
            Intent intent = new Intent(this, FirstLaunch.class);
            startActivity(intent);
        }

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new SampleFragmentPagerAdapter(getSupportFragmentManager(),this));

        //Put the following in a boolean at the beginning and then save it to sharedpreferences!

        // Get the ViewPager and set it's PagerAdapter so that it can display items
//        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
//        viewPager.setAdapter(new SampleFragmentPagerAdapter(getSupportFragmentManager(), this));
//
//        // Give the PagerSlidingTabStrip the ViewPager
//        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.crisistabs);
//
//        //ADD STYLING TO THE PAGERSLIDINGTABSSTRIP
//        tabsStrip.setShouldExpand(true);
//        tabsStrip.setAllCaps(true);
//        tabsStrip.setDividerColor(R.color.gray);
//        tabsStrip.setIndicatorColorResource(R.color.white);
//        tabsStrip.setIndicatorHeight(15);
//
//
//        // Attach the view pager to the tab strip
//        tabsStrip.setViewPager(viewPager);
//        tabsStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//
//            // This method will be invoked when a new page becomes selected.
//            @Override
//            public void onPageSelected(int position) {
//            }
//
//            // This method will be invoked when the current page is scrolled
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                // Code goes here
//            }
//
//            // Called when the scroll state changes:
//            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
//            @Override
//            public void onPageScrollStateChanged(int state) {
//                // Code goes here
//            }
//        });
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.mainquestionbutton:
                questionclick();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }



    private void questionclick() {
        Intent intent = new Intent(this, instructions.class);
        startActivity(intent);
    }

    /**
     * Get ISO 3166-1 alpha-2 country code for this device (or null if not available)
     * @param context Context reference to get the TelephonyManager instance from
     * @return country code or null
     */
    public static String getUserCountry(Context context) {
        try {
            final TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            final String simCountry = tm.getSimCountryIso();
            if (simCountry != null && simCountry.length() == 2) { // SIM country code is available
                return simCountry.toLowerCase(Locale.US); //The locale.US is superfluous, just means lowercase it in english
            }
            else if (tm.getPhoneType() != TelephonyManager.PHONE_TYPE_CDMA) { // device is not 3G (would be unreliable)
                String networkCountry = tm.getNetworkCountryIso();
                if (networkCountry != null && networkCountry.length() == 2) { // network country code is available
                    return networkCountry.toLowerCase(Locale.US);
                }
            }
        }
        catch (Exception e) { }
        return "nocountryfound";
    }

    /**
     * If country code = US, AU, CA, GB, DE, IE, IN, NZ, PH, SG, ZA, NL, SE then show phone numbers
     * Only If country code = US , then can also show crisis text line
     * If country code is anything else, including null, then replace phone number with a befrienders.org number
     * @param string the country code!
     */
    public void setCountryValues(String string) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();

        if(string.equalsIgnoreCase("us")) {
            editor.putBoolean("countryshowtextnumber", true); //set text number as true
            editor.putBoolean("countryshowphonenumbers", true); //set phone as true
        }
        else if(string.equalsIgnoreCase("au")) {
            editor.putBoolean("countryshowtextnumber", false); //set text number as false
            editor.putBoolean("countryshowphonenumbers", true); //set phone as true
        }
        else if(string.equalsIgnoreCase("ca")) {
            editor.putBoolean("countryshowtextnumber", false); //set text number as false
            editor.putBoolean("countryshowphonenumbers", true); //set phone as true
        }
        else if(string.equalsIgnoreCase("gb")) {
            editor.putBoolean("countryshowtextnumber", false); //set text number as false
            editor.putBoolean("countryshowphonenumbers", true); //set phone as true
        }
        else if(string.equalsIgnoreCase("de")) {
            //only show phone numbers!
            editor.putBoolean("countryshowtextnumber", false); //set text number as false
            editor.putBoolean("countryshowphonenumbers", true); //set phone as true
        }
        else if(string.equalsIgnoreCase("ie")) {
            editor.putBoolean("countryshowtextnumber", false); //set text number as false
            editor.putBoolean("countryshowphonenumbers", true); //set phone as true
        }
        else if(string.equalsIgnoreCase("in")) {
            editor.putBoolean("countryshowtextnumber", false); //set text number as false
            editor.putBoolean("countryshowphonenumbers", true); //set phone as true
        }
        else if(string.equalsIgnoreCase("nz")) {
            editor.putBoolean("countryshowtextnumber", false); //set text number as false
            editor.putBoolean("countryshowphonenumbers", true); //set phone as true
        }
        else if(string.equalsIgnoreCase("ph")) {
            editor.putBoolean("countryshowtextnumber", false); //set text number as false
            editor.putBoolean("countryshowphonenumbers", true); //set phone as true
        }
        else if(string.equalsIgnoreCase("sg")) {
            editor.putBoolean("countryshowtextnumber", false); //set text number as false
            editor.putBoolean("countryshowphonenumbers", true); //set phone as true
        }
        else if(string.equalsIgnoreCase("za")) {
            editor.putBoolean("countryshowtextnumber", false); //set text number as false
            editor.putBoolean("countryshowphonenumbers", true); //set phone as true
        }
        else if(string.equalsIgnoreCase("nl")) {
            editor.putBoolean("countryshowtextnumber", false); //set text number as false
            editor.putBoolean("countryshowphonenumbers", true); //set phone as true
        }
        else if(string.equalsIgnoreCase("se")) {
            editor.putBoolean("countryshowtextnumber", false); //set text number as false
            editor.putBoolean("countryshowphonenumbers", true); //set phone as true
        }
        else {
            //show nothing! including the value null
            editor.putBoolean("countryshowtextnumber", false);
            editor.putBoolean("countryshowphonenumbers", false);
        }


        //commit changes
        editor.commit();
    }


}