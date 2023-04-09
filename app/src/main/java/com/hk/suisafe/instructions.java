package com.hk.suisafe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class instructions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        TextView option3textview = (TextView) findViewById(R.id.option3textview);
        Button callhelplinebuttoninstructions = (Button) findViewById(R.id.callhelplinebuttoninstructions);
        TextView option3descriptiontextview = (TextView) findViewById(R.id.option3descriptiontextview);
        //Hide option 3 if not in a supported country

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean showphonenumbers = prefs.getBoolean("countryshowphonenumbers", false);

        if(!showphonenumbers) {
            option3textview.setVisibility(View.GONE);
            callhelplinebuttoninstructions.setVisibility(View.GONE);
            option3descriptiontextview.setVisibility(View.GONE);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void callhelpline(View view) {
        String suicidehotlinenumber = getResources().getString(R.string.helplinenumber);
        String suicidehotlinename = getResources().getString(R.string.hotlinename);
        DialogSuicideHotline newFragment = new DialogSuicideHotline();
        Bundle suicidehotlinebundle = new Bundle();
        suicidehotlinebundle.putString("hotlinenumber", suicidehotlinenumber);
        suicidehotlinebundle.putString("hotlinename", suicidehotlinename);
        newFragment.setArguments(suicidehotlinebundle);
        newFragment.show(getSupportFragmentManager(), "dialog");
    }

    public void watchsafetyplanvideo(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=tfDruc0QDCc")));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
