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


public class editcopingstrategies extends AppCompatActivity {

    EditText copingstrategiesedittext1, copingstrategiesedittext2, copingstrategiesedittext3
            , copingstrategiesedittext4, copingstrategiesedittext5, copingstrategiesedittext6, copingstrategiesedittext7
            , copingstrategiesedittext8, copingstrategiesedittext9, copingstrategiesedittext10;
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
                        SavePreferences("COPINGSTRATEGY1", copingstrategiesedittext1.getText().toString());
                        SavePreferences("COPINGSTRATEGY2", copingstrategiesedittext2.getText().toString());
                        SavePreferences("COPINGSTRATEGY3", copingstrategiesedittext3.getText().toString());
                        SavePreferences("COPINGSTRATEGY4", copingstrategiesedittext4.getText().toString());
                        SavePreferences("COPINGSTRATEGY5", copingstrategiesedittext5.getText().toString());
                        SavePreferences("COPINGSTRATEGY6", copingstrategiesedittext6.getText().toString());
                        SavePreferences("COPINGSTRATEGY7", copingstrategiesedittext7.getText().toString());
                        SavePreferences("COPINGSTRATEGY8", copingstrategiesedittext8.getText().toString());
                        SavePreferences("COPINGSTRATEGY9", copingstrategiesedittext9.getText().toString());
                        SavePreferences("COPINGSTRATEGY10", copingstrategiesedittext10.getText().toString());

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


        setContentView(R.layout.activity_editcopingstrategies);

        copingstrategiesedittext1 = (EditText) findViewById(R.id.copingedittext1);
        copingstrategiesedittext2 = (EditText) findViewById(R.id.copingedittext2);
        copingstrategiesedittext3 = (EditText) findViewById(R.id.copingedittext3);
        copingstrategiesedittext4 = (EditText) findViewById(R.id.copingedittext4);
        copingstrategiesedittext5 = (EditText) findViewById(R.id.copingedittext5);
        copingstrategiesedittext6 = (EditText) findViewById(R.id.copingedittext6);
        copingstrategiesedittext7 = (EditText) findViewById(R.id.copingedittext7);
        copingstrategiesedittext8 = (EditText) findViewById(R.id.copingedittext8);
        copingstrategiesedittext9 = (EditText) findViewById(R.id.copingedittext9);
        copingstrategiesedittext10 = (EditText) findViewById(R.id.copingedittext10);
        addnewbutton = (Button) findViewById(R.id.copingstrategiesaddnew);
        addnewbutton.setOnClickListener(addbuttononclicklistener);
        LoadPreferences();
    }

    Button.OnClickListener addbuttononclicklistener
            = new Button.OnClickListener() {

        @Override
        public void onClick(View arg0) {
            //Check how many views are visible
            int counter = 0;
            if(copingstrategiesedittext1.getVisibility() == View.VISIBLE) counter++;
            if(copingstrategiesedittext2.getVisibility() == View.VISIBLE) counter++;
            if(copingstrategiesedittext3.getVisibility() == View.VISIBLE) counter++;
            if(copingstrategiesedittext4.getVisibility() == View.VISIBLE) counter++;
            if(copingstrategiesedittext5.getVisibility() == View.VISIBLE) counter++;
            if(copingstrategiesedittext6.getVisibility() == View.VISIBLE) counter++;
            if(copingstrategiesedittext7.getVisibility() == View.VISIBLE) counter++;
            if(copingstrategiesedittext8.getVisibility() == View.VISIBLE) counter++;
            if(copingstrategiesedittext9.getVisibility() == View.VISIBLE) counter++;
            if(copingstrategiesedittext10.getVisibility() == View.VISIBLE) counter++;
            //make a new thing appear!
            if(counter<4) copingstrategiesedittext4.setVisibility(View.VISIBLE);
            else if(counter==4) copingstrategiesedittext5.setVisibility(View.VISIBLE);
            else if(counter==5) copingstrategiesedittext6.setVisibility(View.VISIBLE);
            else if(counter==6) copingstrategiesedittext7.setVisibility(View.VISIBLE);
            else if(counter==7) copingstrategiesedittext8.setVisibility(View.VISIBLE);
            else if(counter==8) copingstrategiesedittext9.setVisibility(View.VISIBLE);
            else if(counter==9) {
                copingstrategiesedittext10.setVisibility(View.VISIBLE);
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
        String copingstrategystring1 = sharedPreferences.getString("COPINGSTRATEGY1", "");
        String copingstrategystring2 = sharedPreferences.getString("COPINGSTRATEGY2", "");
        String copingstrategystring3 = sharedPreferences.getString("COPINGSTRATEGY3", "");
        String copingstrategystring4 = sharedPreferences.getString("COPINGSTRATEGY4", "");
        String copingstrategystring5 = sharedPreferences.getString("COPINGSTRATEGY5", "");
        String copingstrategystring6 = sharedPreferences.getString("COPINGSTRATEGY6", "");
        String copingstrategystring7 = sharedPreferences.getString("COPINGSTRATEGY7", "");
        String copingstrategystring8 = sharedPreferences.getString("COPINGSTRATEGY8", "");
        String copingstrategystring9 = sharedPreferences.getString("COPINGSTRATEGY9", "");
        String copingstrategystring10 = sharedPreferences.getString("COPINGSTRATEGY10", "");

        copingstrategiesedittext1.setText(copingstrategystring1);
        copingstrategiesedittext2.setText(copingstrategystring2);
        copingstrategiesedittext3.setText(copingstrategystring3);
        copingstrategiesedittext4.setText(copingstrategystring4);
        copingstrategiesedittext5.setText(copingstrategystring5);
        copingstrategiesedittext6.setText(copingstrategystring6);
        copingstrategiesedittext7.setText(copingstrategystring7);
        copingstrategiesedittext8.setText(copingstrategystring8);
        copingstrategiesedittext9.setText(copingstrategystring9);
        copingstrategiesedittext10.setText(copingstrategystring10);

        int counter = 0;
        if(!copingstrategystring1.equals("")) counter++;
        if(!copingstrategystring2.equals("")) counter++;
        if(!copingstrategystring3.equals("")) counter++;
        if(!copingstrategystring4.equals("")) counter++;
        if(!copingstrategystring5.equals("")) counter++;
        if(!copingstrategystring6.equals("")) counter++;
        if(!copingstrategystring7.equals("")) counter++;
        if(!copingstrategystring8.equals("")) counter++;
        if(!copingstrategystring9.equals("")) counter++;
        if(!copingstrategystring10.equals("")) counter++;

        //if counter = 10, then hide nothing. If counter = 1, 2, or 3; then hide nothing.

        if(counter<4) {
            copingstrategiesedittext4.setVisibility(View.GONE);
            copingstrategiesedittext5.setVisibility(View.GONE);
            copingstrategiesedittext6.setVisibility(View.GONE);
            copingstrategiesedittext7.setVisibility(View.GONE);
            copingstrategiesedittext8.setVisibility(View.GONE);
            copingstrategiesedittext9.setVisibility(View.GONE);
            copingstrategiesedittext10.setVisibility(View.GONE);
        }
        else if(counter==4) {
            copingstrategiesedittext5.setVisibility(View.GONE);
            copingstrategiesedittext6.setVisibility(View.GONE);
            copingstrategiesedittext7.setVisibility(View.GONE);
            copingstrategiesedittext8.setVisibility(View.GONE);
            copingstrategiesedittext9.setVisibility(View.GONE);
            copingstrategiesedittext10.setVisibility(View.GONE);
        }
        else if(counter==5) {
            copingstrategiesedittext6.setVisibility(View.GONE);
            copingstrategiesedittext7.setVisibility(View.GONE);
            copingstrategiesedittext8.setVisibility(View.GONE);
            copingstrategiesedittext9.setVisibility(View.GONE);
            copingstrategiesedittext10.setVisibility(View.GONE);
        }
        else if(counter==6) {
            copingstrategiesedittext7.setVisibility(View.GONE);
            copingstrategiesedittext8.setVisibility(View.GONE);
            copingstrategiesedittext9.setVisibility(View.GONE);
            copingstrategiesedittext10.setVisibility(View.GONE);
        }
        else if(counter==7) {
            copingstrategiesedittext8.setVisibility(View.GONE);
            copingstrategiesedittext9.setVisibility(View.GONE);
            copingstrategiesedittext10.setVisibility(View.GONE);
        }
        else if(counter==8) {
            copingstrategiesedittext9.setVisibility(View.GONE);
            copingstrategiesedittext10.setVisibility(View.GONE);
        }
        else if(counter==9) {
            copingstrategiesedittext10.setVisibility(View.GONE);
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
