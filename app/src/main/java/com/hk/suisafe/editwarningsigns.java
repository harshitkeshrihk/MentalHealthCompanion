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


public class editwarningsigns extends AppCompatActivity {
    EditText warningsignsedittext1, warningsignsedittext2, warningsignsedittext3
            , warningsignsedittext4, warningsignsedittext5, warningsignsedittext6, warningsignsedittext7
            , warningsignsedittext8, warningsignsedittext9, warningsignsedittext10;
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
                        SavePreferences("WARNINGSIGN1", warningsignsedittext1.getText().toString());
                        SavePreferences("WARNINGSIGN2", warningsignsedittext2.getText().toString());
                        SavePreferences("WARNINGSIGN3", warningsignsedittext3.getText().toString());
                        SavePreferences("WARNINGSIGN4", warningsignsedittext4.getText().toString());
                        SavePreferences("WARNINGSIGN5", warningsignsedittext5.getText().toString());
                        SavePreferences("WARNINGSIGN6", warningsignsedittext6.getText().toString());
                        SavePreferences("WARNINGSIGN7", warningsignsedittext7.getText().toString());
                        SavePreferences("WARNINGSIGN8", warningsignsedittext8.getText().toString());
                        SavePreferences("WARNINGSIGN9", warningsignsedittext9.getText().toString());
                        SavePreferences("WARNINGSIGN10", warningsignsedittext10.getText().toString());
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


        setContentView(R.layout.activity_editwarningsigns);

        warningsignsedittext1 = (EditText)  findViewById(R.id.warningedittext1);
        warningsignsedittext2 = (EditText)  findViewById(R.id.warningedittext2);
        warningsignsedittext3 = (EditText)  findViewById(R.id.warningedittext3);
        warningsignsedittext4 = (EditText)  findViewById(R.id.warningedittext4);
        warningsignsedittext5 = (EditText)  findViewById(R.id.warningedittext5);
        warningsignsedittext6 = (EditText)  findViewById(R.id.warningedittext6);
        warningsignsedittext7 = (EditText)  findViewById(R.id.warningedittext7);
        warningsignsedittext8 = (EditText)  findViewById(R.id.warningedittext8);
        warningsignsedittext9 = (EditText)  findViewById(R.id.warningedittext9);
        warningsignsedittext10 = (EditText)  findViewById(R.id.warningedittext10);
        addnewbutton = (Button) findViewById(R.id.warningsignsaddnew);

        addnewbutton.setOnClickListener(addbuttononclicklistener);

       // ActionBar actionBar = getActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);

        LoadPreferences();
    }


    //When add new button is pressed
    Button.OnClickListener addbuttononclicklistener
            = new Button.OnClickListener() {

        @Override
        public void onClick(View arg0) {
            //Check how many views are visible
            int counter = 0;
            if(warningsignsedittext1.getVisibility() == View.VISIBLE) counter++;
            if(warningsignsedittext2.getVisibility() == View.VISIBLE) counter++;
            if(warningsignsedittext3.getVisibility() == View.VISIBLE) counter++;
            if(warningsignsedittext4.getVisibility() == View.VISIBLE) counter++;
            if(warningsignsedittext5.getVisibility() == View.VISIBLE) counter++;
            if(warningsignsedittext6.getVisibility() == View.VISIBLE) counter++;
            if(warningsignsedittext7.getVisibility() == View.VISIBLE) counter++;
            if(warningsignsedittext8.getVisibility() == View.VISIBLE) counter++;
            if(warningsignsedittext9.getVisibility() == View.VISIBLE) counter++;
            if(warningsignsedittext10.getVisibility() == View.VISIBLE) counter++;
            //make a new thing appear!
            if(counter<4) warningsignsedittext4.setVisibility(View.VISIBLE);
            else if(counter==4) warningsignsedittext5.setVisibility(View.VISIBLE);
            else if(counter==5) warningsignsedittext6.setVisibility(View.VISIBLE);
            else if(counter==6) warningsignsedittext7.setVisibility(View.VISIBLE);
            else if(counter==7) warningsignsedittext8.setVisibility(View.VISIBLE);
            else if(counter==8) warningsignsedittext9.setVisibility(View.VISIBLE);
            else if(counter==9) {
                warningsignsedittext10.setVisibility(View.VISIBLE);
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
        String warningsignstring1 = sharedPreferences.getString("WARNINGSIGN1", "");
        String warningsignstring2 = sharedPreferences.getString("WARNINGSIGN2", "");
        String warningsignstring3 = sharedPreferences.getString("WARNINGSIGN3", "");
        String warningsignstring4 = sharedPreferences.getString("WARNINGSIGN4", "");
        String warningsignstring5 = sharedPreferences.getString("WARNINGSIGN5", "");
        String warningsignstring6 = sharedPreferences.getString("WARNINGSIGN6", "");
        String warningsignstring7 = sharedPreferences.getString("WARNINGSIGN7", "");
        String warningsignstring8 = sharedPreferences.getString("WARNINGSIGN8", "");
        String warningsignstring9 = sharedPreferences.getString("WARNINGSIGN9", "");
        String warningsignstring10 = sharedPreferences.getString("WARNINGSIGN10", "");

        warningsignsedittext1.setText(warningsignstring1);
        warningsignsedittext2.setText(warningsignstring2);
        warningsignsedittext3.setText(warningsignstring3);
        warningsignsedittext4.setText(warningsignstring4);
        warningsignsedittext5.setText(warningsignstring5);
        warningsignsedittext6.setText(warningsignstring6);
        warningsignsedittext7.setText(warningsignstring7);
        warningsignsedittext8.setText(warningsignstring8);
        warningsignsedittext9.setText(warningsignstring9);
        warningsignsedittext10.setText(warningsignstring10);

        int counter = 0;
        if(!warningsignstring1.equals("")) counter++;
        if(!warningsignstring2.equals("")) counter++;
        if(!warningsignstring3.equals("")) counter++;
        if(!warningsignstring4.equals("")) counter++;
        if(!warningsignstring5.equals("")) counter++;
        if(!warningsignstring6.equals("")) counter++;
        if(!warningsignstring7.equals("")) counter++;
        if(!warningsignstring8.equals("")) counter++;
        if(!warningsignstring9.equals("")) counter++;
        if(!warningsignstring10.equals("")) counter++;


        //if counter = 10, then hide . If counter = 1, 2, or 3; then hide nothing.

        if(counter<4) {
            warningsignsedittext4.setVisibility(View.GONE);
            warningsignsedittext5.setVisibility(View.GONE);
            warningsignsedittext6.setVisibility(View.GONE);
            warningsignsedittext7.setVisibility(View.GONE);
            warningsignsedittext8.setVisibility(View.GONE);
            warningsignsedittext9.setVisibility(View.GONE);
            warningsignsedittext10.setVisibility(View.GONE);
        }
        if(counter==4) {
            warningsignsedittext5.setVisibility(View.GONE);
            warningsignsedittext6.setVisibility(View.GONE);
            warningsignsedittext7.setVisibility(View.GONE);
            warningsignsedittext8.setVisibility(View.GONE);
            warningsignsedittext9.setVisibility(View.GONE);
            warningsignsedittext10.setVisibility(View.GONE);
        }
        if(counter==5) {
            warningsignsedittext6.setVisibility(View.GONE);
            warningsignsedittext7.setVisibility(View.GONE);
            warningsignsedittext8.setVisibility(View.GONE);
            warningsignsedittext9.setVisibility(View.GONE);
            warningsignsedittext10.setVisibility(View.GONE);
        }
        if(counter==6) {
            warningsignsedittext7.setVisibility(View.GONE);
            warningsignsedittext8.setVisibility(View.GONE);
            warningsignsedittext9.setVisibility(View.GONE);
            warningsignsedittext10.setVisibility(View.GONE);
        }
        if(counter==7) {
            warningsignsedittext8.setVisibility(View.GONE);
            warningsignsedittext9.setVisibility(View.GONE);
            warningsignsedittext10.setVisibility(View.GONE);
        }
        if(counter==8) {
            warningsignsedittext9.setVisibility(View.GONE);
            warningsignsedittext10.setVisibility(View.GONE);
        }
        if(counter==9) {
            warningsignsedittext10.setVisibility(View.GONE);
        }
        if(counter==10) {
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
