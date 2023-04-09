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
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class editextranote extends AppCompatActivity {

    EditText extranoteedittext;

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
//saves it to 'sharedPreferences' under the tag 'COUNSELORNUMBER'
                        SavePreferences("EXTRANOTE", extranoteedittext.getText().toString());
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


        setContentView(R.layout.activity_editextranote);

        extranoteedittext = (EditText) findViewById(R.id.extranoteedittext);


        //If there are already phone numbers in the sharedpreferences file, then load them!
        LoadPreferences();


    }





    private void SavePreferences(String key, String value){
        //get sharedpreferences from the file "PhoneNumbers"
       SharedPreferences sharedPreferences = getSharedPreferences("SafetyPlan", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    private void LoadPreferences(){
        SharedPreferences sharedPreferences = getSharedPreferences("SafetyPlan", MODE_PRIVATE);;
        String extranote = sharedPreferences.getString("EXTRANOTE", "");
        extranoteedittext.setText(extranote);
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
