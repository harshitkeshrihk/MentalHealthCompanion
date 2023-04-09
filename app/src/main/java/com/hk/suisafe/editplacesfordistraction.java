package com.hk.suisafe;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class editplacesfordistraction extends AppCompatActivity {

    EditText placesfordistractionedittext1, placesfordistractionedittext2, placesfordistractionedittext3
            , placesfordistractionedittext4, placesfordistractionedittext5, placesfordistractionedittext6
            , placesfordistractionedittext7, placesfordistractionedittext8, placesfordistractionedittext9, placesfordistractionedittext10;
    Button addnewbutton;
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final LayoutInflater inflater = (LayoutInflater) getSupportActionBar().getThemedContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        final View customActionBarView = inflater.inflate(R.layout.actionbar_done_cancel, null);
        customActionBarView.findViewById(R.id.bulk_add_subjects_save).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
//saves it to 'sharedPreferences' under the tag 'FRIENDSFAMILYNUMBER1
                        SavePreferences("DISTRACTIONPLACE1", placesfordistractionedittext1.getText().toString());
                        SavePreferences("DISTRACTIONPLACE2", placesfordistractionedittext2.getText().toString());
                        SavePreferences("DISTRACTIONPLACE3", placesfordistractionedittext3.getText().toString());
                        SavePreferences("DISTRACTIONPLACE4", placesfordistractionedittext4.getText().toString());
                        SavePreferences("DISTRACTIONPLACE5", placesfordistractionedittext5.getText().toString());
                        SavePreferences("DISTRACTIONPLACE6", placesfordistractionedittext6.getText().toString());
                        SavePreferences("DISTRACTIONPLACE7", placesfordistractionedittext7.getText().toString());
                        SavePreferences("DISTRACTIONPLACE8", placesfordistractionedittext8.getText().toString());
                        SavePreferences("DISTRACTIONPLACE9", placesfordistractionedittext9.getText().toString());
                        SavePreferences("DISTRACTIONPLACE10", placesfordistractionedittext10.getText().toString());

                        //Relaunch the main activity
                        Intent intent = new Intent(arg0.getContext(), MainActivity.class);
                        startActivity(intent);
                    }
                });
        customActionBarView.findViewById(R.id.bulk_add_subjects_discard).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        // "Cancel"
                        onBackPressed();
                    }
                });

        // Show the custom action bar view and hide the normal Home icon and title.
        final androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(
                ActionBar.DISPLAY_SHOW_CUSTOM,
                ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME
                        | ActionBar.DISPLAY_SHOW_TITLE);
        actionBar.setCustomView(customActionBarView,
                new androidx.appcompat.app.ActionBar.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        setContentView(R.layout.activity_editplacesfordistraction);

        placesfordistractionedittext1 = (EditText) findViewById(R.id.distractionedittext1);
        placesfordistractionedittext2 = (EditText) findViewById(R.id.distractionedittext2);
        placesfordistractionedittext3 = (EditText) findViewById(R.id.distractionedittext3);
        placesfordistractionedittext4 = (EditText) findViewById(R.id.distractionedittext4);
        placesfordistractionedittext5 = (EditText) findViewById(R.id.distractionedittext5);
        placesfordistractionedittext6 = (EditText) findViewById(R.id.distractionedittext6);
        placesfordistractionedittext7 = (EditText) findViewById(R.id.distractionedittext7);
        placesfordistractionedittext8 = (EditText) findViewById(R.id.distractionedittext8);
        placesfordistractionedittext9 = (EditText) findViewById(R.id.distractionedittext9);
        placesfordistractionedittext10 = (EditText) findViewById(R.id.distractionedittext10);
        addnewbutton = (Button) findViewById(R.id.distractionaddnew);

        addnewbutton.setOnClickListener(addbuttononclicklistener);

        LoadPreferences();
    }


    Button.OnClickListener addbuttononclicklistener
            = new Button.OnClickListener() {

        @Override
        public void onClick(View arg0) {
            //Check how many views are visible
            int counter = 0;
            if(placesfordistractionedittext1.getVisibility() == View.VISIBLE) counter++;
            if(placesfordistractionedittext2.getVisibility() == View.VISIBLE) counter++;
            if(placesfordistractionedittext3.getVisibility() == View.VISIBLE) counter++;
            if(placesfordistractionedittext4.getVisibility() == View.VISIBLE) counter++;
            if(placesfordistractionedittext5.getVisibility() == View.VISIBLE) counter++;
            if(placesfordistractionedittext6.getVisibility() == View.VISIBLE) counter++;
            if(placesfordistractionedittext7.getVisibility() == View.VISIBLE) counter++;
            if(placesfordistractionedittext8.getVisibility() == View.VISIBLE) counter++;
            if(placesfordistractionedittext9.getVisibility() == View.VISIBLE) counter++;
            if(placesfordistractionedittext10.getVisibility() == View.VISIBLE) counter++;
            //make a new thing appear!
            if(counter<4) placesfordistractionedittext4.setVisibility(View.VISIBLE);
            else if(counter==4) placesfordistractionedittext5.setVisibility(View.VISIBLE);
            else if(counter==5) placesfordistractionedittext6.setVisibility(View.VISIBLE);
            else if(counter==6) placesfordistractionedittext7.setVisibility(View.VISIBLE);
            else if(counter==7) placesfordistractionedittext8.setVisibility(View.VISIBLE);
            else if(counter==8) placesfordistractionedittext9.setVisibility(View.VISIBLE);
            else if(counter==9) {
                placesfordistractionedittext10.setVisibility(View.VISIBLE);
                addnewbutton.setVisibility(View.GONE);
            }
        }
    };


    private void SavePreferences(String key, String value){
        //get sharedpreferences from the file "SafetyPlan"
        SharedPreferences sharedPreferences = getSharedPreferences("SafetyPlan", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    private void LoadPreferences(){
        SharedPreferences sharedPreferences = getSharedPreferences("SafetyPlan", MODE_PRIVATE);
        String distractionplacestring1 = sharedPreferences.getString("DISTRACTIONPLACE1", "");
        String distractionplacestring2 = sharedPreferences.getString("DISTRACTIONPLACE2", "");
        String distractionplacestring3 = sharedPreferences.getString("DISTRACTIONPLACE3", "");
        String distractionplacestring4 = sharedPreferences.getString("DISTRACTIONPLACE4", "");
        String distractionplacestring5 = sharedPreferences.getString("DISTRACTIONPLACE5", "");
        String distractionplacestring6 = sharedPreferences.getString("DISTRACTIONPLACE6", "");
        String distractionplacestring7 = sharedPreferences.getString("DISTRACTIONPLACE7", "");
        String distractionplacestring8 = sharedPreferences.getString("DISTRACTIONPLACE8", "");
        String distractionplacestring9 = sharedPreferences.getString("DISTRACTIONPLACE9", "");
        String distractionplacestring10 = sharedPreferences.getString("DISTRACTIONPLACE10", "");


        placesfordistractionedittext1.setText(distractionplacestring1);
        placesfordistractionedittext2.setText(distractionplacestring2);
        placesfordistractionedittext3.setText(distractionplacestring3);
        placesfordistractionedittext4.setText(distractionplacestring4);
        placesfordistractionedittext5.setText(distractionplacestring5);
        placesfordistractionedittext6.setText(distractionplacestring6);
        placesfordistractionedittext7.setText(distractionplacestring7);
        placesfordistractionedittext8.setText(distractionplacestring8);
        placesfordistractionedittext9.setText(distractionplacestring9);
        placesfordistractionedittext10.setText(distractionplacestring10);

        int counter = 0;
        if(!distractionplacestring1.equals("")) counter++;
        if(!distractionplacestring2.equals("")) counter++;
        if(!distractionplacestring3.equals("")) counter++;
        if(!distractionplacestring4.equals("")) counter++;
        if(!distractionplacestring5.equals("")) counter++;
        if(!distractionplacestring6.equals("")) counter++;
        if(!distractionplacestring7.equals("")) counter++;
        if(!distractionplacestring8.equals("")) counter++;
        if(!distractionplacestring9.equals("")) counter++;
        if(!distractionplacestring10.equals("")) counter++;

        //if counter = 10, then hide nothing. If counter = 1, 2, or 3; then hide nothing.

        if(counter<4) {
            placesfordistractionedittext4.setVisibility(View.GONE);
            placesfordistractionedittext5.setVisibility(View.GONE);
            placesfordistractionedittext6.setVisibility(View.GONE);
            placesfordistractionedittext7.setVisibility(View.GONE);
            placesfordistractionedittext8.setVisibility(View.GONE);
            placesfordistractionedittext9.setVisibility(View.GONE);
            placesfordistractionedittext10.setVisibility(View.GONE);
        }
        else if(counter==4) {
            placesfordistractionedittext5.setVisibility(View.GONE);
            placesfordistractionedittext6.setVisibility(View.GONE);
            placesfordistractionedittext7.setVisibility(View.GONE);
            placesfordistractionedittext8.setVisibility(View.GONE);
            placesfordistractionedittext9.setVisibility(View.GONE);
            placesfordistractionedittext10.setVisibility(View.GONE);
        }
        else if(counter==5) {
            placesfordistractionedittext6.setVisibility(View.GONE);
            placesfordistractionedittext7.setVisibility(View.GONE);
            placesfordistractionedittext8.setVisibility(View.GONE);
            placesfordistractionedittext9.setVisibility(View.GONE);
            placesfordistractionedittext10.setVisibility(View.GONE);
        }
        else if(counter==6) {
            placesfordistractionedittext7.setVisibility(View.GONE);
            placesfordistractionedittext8.setVisibility(View.GONE);
            placesfordistractionedittext9.setVisibility(View.GONE);
            placesfordistractionedittext10.setVisibility(View.GONE);
        }
        else if(counter==7) {
            placesfordistractionedittext8.setVisibility(View.GONE);
            placesfordistractionedittext9.setVisibility(View.GONE);
            placesfordistractionedittext10.setVisibility(View.GONE);
        }
        else if(counter==8) {
            placesfordistractionedittext9.setVisibility(View.GONE);
            placesfordistractionedittext10.setVisibility(View.GONE);
        }
        else if(counter==9) {
            placesfordistractionedittext10.setVisibility(View.GONE);
        }
        else if(counter==10) {
            addnewbutton.setVisibility(View.GONE);
        }

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
