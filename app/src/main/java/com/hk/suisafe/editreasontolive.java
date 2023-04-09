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


public class editreasontolive extends AppCompatActivity {
    EditText reasontoliveedittext1, reasontoliveedittext2, reasontoliveedittext3
            , reasontoliveedittext4, reasontoliveedittext5, reasontoliveedittext6
            , reasontoliveedittext7, reasontoliveedittext8, reasontoliveedittext9, reasontoliveedittext10;
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
//saves it to 'sharedPreferences' under the tag 'COUNSELORNUMBER'
                        SavePreferences("REASONTOLIVE", reasontoliveedittext1.getText().toString());
                        SavePreferences("REASONTOLIVE2", reasontoliveedittext2.getText().toString());
                        SavePreferences("REASONTOLIVE3", reasontoliveedittext3.getText().toString());
                        SavePreferences("REASONTOLIVE4", reasontoliveedittext4.getText().toString());
                        SavePreferences("REASONTOLIVE5", reasontoliveedittext5.getText().toString());
                        SavePreferences("REASONTOLIVE6", reasontoliveedittext6.getText().toString());
                        SavePreferences("REASONTOLIVE7", reasontoliveedittext7.getText().toString());
                        SavePreferences("REASONTOLIVE8", reasontoliveedittext8.getText().toString());
                        SavePreferences("REASONTOLIVE9", reasontoliveedittext9.getText().toString());
                        SavePreferences("REASONTOLIVE10", reasontoliveedittext10.getText().toString());
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


        setContentView(R.layout.activity_editreasontolive);

        reasontoliveedittext1 = (EditText) findViewById(R.id.reasontoliveedittext1);
        reasontoliveedittext2 = (EditText) findViewById(R.id.reasontoliveedittext2);
        reasontoliveedittext3 = (EditText) findViewById(R.id.reasontoliveedittext3);
        reasontoliveedittext4 = (EditText) findViewById(R.id.reasontoliveedittext4);
        reasontoliveedittext5 = (EditText) findViewById(R.id.reasontoliveedittext5);
        reasontoliveedittext6 = (EditText) findViewById(R.id.reasontoliveedittext6);
        reasontoliveedittext7 = (EditText) findViewById(R.id.reasontoliveedittext7);
        reasontoliveedittext8 = (EditText) findViewById(R.id.reasontoliveedittext8);
        reasontoliveedittext9 = (EditText) findViewById(R.id.reasontoliveedittext9);
        reasontoliveedittext10 = (EditText) findViewById(R.id.reasontoliveedittext10);
        addnewbutton = (Button) findViewById(R.id.reasontoliveaddnew);
        addnewbutton.setOnClickListener(addbuttononclicklistener);

        LoadPreferences();
    }

    Button.OnClickListener addbuttononclicklistener
            = new Button.OnClickListener() {

        @Override
        public void onClick(View arg0) {
            //Check how many views are visible
            int counter = 0;
            if(reasontoliveedittext1.getVisibility() == View.VISIBLE) counter++;
            if(reasontoliveedittext2.getVisibility() == View.VISIBLE) counter++;
            if(reasontoliveedittext3.getVisibility() == View.VISIBLE) counter++;
            if(reasontoliveedittext4.getVisibility() == View.VISIBLE) counter++;
            if(reasontoliveedittext5.getVisibility() == View.VISIBLE) counter++;
            if(reasontoliveedittext6.getVisibility() == View.VISIBLE) counter++;
            if(reasontoliveedittext7.getVisibility() == View.VISIBLE) counter++;
            if(reasontoliveedittext8.getVisibility() == View.VISIBLE) counter++;
            if(reasontoliveedittext9.getVisibility() == View.VISIBLE) counter++;
            if(reasontoliveedittext10.getVisibility() == View.VISIBLE) counter++;
            //make a new thing appear!
            if(counter<4) reasontoliveedittext4.setVisibility(View.VISIBLE);
            else if(counter==4) reasontoliveedittext5.setVisibility(View.VISIBLE);
            else if(counter==5) reasontoliveedittext6.setVisibility(View.VISIBLE);
            else if(counter==6) reasontoliveedittext7.setVisibility(View.VISIBLE);
            else if(counter==7) reasontoliveedittext8.setVisibility(View.VISIBLE);
            else if(counter==8) reasontoliveedittext9.setVisibility(View.VISIBLE);
            else if(counter==9) {
                reasontoliveedittext10.setVisibility(View.VISIBLE);
                addnewbutton.setVisibility(View.GONE);
            }
        }
    };


    private void SavePreferences(String key, String value){
        //get sharedpreferences from the file "PhoneNumbers"
        SharedPreferences sharedPreferences = getSharedPreferences("SafetyPlan", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    private void LoadPreferences(){
        SharedPreferences sharedPreferences = getSharedPreferences("SafetyPlan", MODE_PRIVATE);
        String reasontolivestring1 = sharedPreferences.getString("REASONTOLIVE", "");
        String reasontolivestring2 = sharedPreferences.getString("REASONTOLIVE2", "");
        String reasontolivestring3 = sharedPreferences.getString("REASONTOLIVE3", "");
        String reasontolivestring4 = sharedPreferences.getString("REASONTOLIVE4", "");
        String reasontolivestring5 = sharedPreferences.getString("REASONTOLIVE5", "");
        String reasontolivestring6 = sharedPreferences.getString("REASONTOLIVE6", "");
        String reasontolivestring7 = sharedPreferences.getString("REASONTOLIVE7", "");
        String reasontolivestring8 = sharedPreferences.getString("REASONTOLIVE8", "");
        String reasontolivestring9 = sharedPreferences.getString("REASONTOLIVE9", "");
        String reasontolivestring10 = sharedPreferences.getString("REASONTOLIVE10", "");
        reasontoliveedittext1.setText(reasontolivestring1);
        reasontoliveedittext2.setText(reasontolivestring2);
        reasontoliveedittext3.setText(reasontolivestring3);
        reasontoliveedittext4.setText(reasontolivestring4);
        reasontoliveedittext5.setText(reasontolivestring5);
        reasontoliveedittext6.setText(reasontolivestring6);
        reasontoliveedittext7.setText(reasontolivestring7);
        reasontoliveedittext8.setText(reasontolivestring8);
        reasontoliveedittext9.setText(reasontolivestring9);
        reasontoliveedittext10.setText(reasontolivestring10);

        int counter = 0;
        if(!reasontolivestring1.equals("")) counter++;
        if(!reasontolivestring2.equals("")) counter++;
        if(!reasontolivestring3.equals("")) counter++;
        if(!reasontolivestring4.equals("")) counter++;
        if(!reasontolivestring5.equals("")) counter++;
        if(!reasontolivestring6.equals("")) counter++;
        if(!reasontolivestring7.equals("")) counter++;
        if(!reasontolivestring8.equals("")) counter++;
        if(!reasontolivestring9.equals("")) counter++;
        if(!reasontolivestring10.equals("")) counter++;

        //if counter = 10, then hide nothing. If counter = 1, 2, or 3; then hide nothing.

        if(counter<4) {
            reasontoliveedittext4.setVisibility(View.GONE);
            reasontoliveedittext5.setVisibility(View.GONE);
            reasontoliveedittext6.setVisibility(View.GONE);
            reasontoliveedittext7.setVisibility(View.GONE);
            reasontoliveedittext8.setVisibility(View.GONE);
            reasontoliveedittext9.setVisibility(View.GONE);
            reasontoliveedittext10.setVisibility(View.GONE);
        }
        else if(counter==4) {
            reasontoliveedittext5.setVisibility(View.GONE);
            reasontoliveedittext6.setVisibility(View.GONE);
            reasontoliveedittext7.setVisibility(View.GONE);
            reasontoliveedittext8.setVisibility(View.GONE);
            reasontoliveedittext9.setVisibility(View.GONE);
            reasontoliveedittext10.setVisibility(View.GONE);
        }
        else if(counter==5) {
            reasontoliveedittext6.setVisibility(View.GONE);
            reasontoliveedittext7.setVisibility(View.GONE);
            reasontoliveedittext8.setVisibility(View.GONE);
            reasontoliveedittext9.setVisibility(View.GONE);
            reasontoliveedittext10.setVisibility(View.GONE);
        }
        else if(counter==6) {
            reasontoliveedittext7.setVisibility(View.GONE);
            reasontoliveedittext8.setVisibility(View.GONE);
            reasontoliveedittext9.setVisibility(View.GONE);
            reasontoliveedittext10.setVisibility(View.GONE);
        }
        else if(counter==7) {
            reasontoliveedittext8.setVisibility(View.GONE);
            reasontoliveedittext9.setVisibility(View.GONE);
            reasontoliveedittext10.setVisibility(View.GONE);
        }
        else if(counter==8) {
            reasontoliveedittext9.setVisibility(View.GONE);
            reasontoliveedittext10.setVisibility(View.GONE);
        }
        else if(counter==9) {
            reasontoliveedittext10.setVisibility(View.GONE);
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
