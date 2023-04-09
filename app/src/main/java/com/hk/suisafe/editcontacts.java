package com.hk.suisafe;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;


public class editcontacts extends AppCompatActivity {

    Button addnewbutton, importcontactbutton;

    RelativeLayout contactrl1, contactrl2, contactrl3, contactrl4, contactrl5, contactrl6, contactrl7, contactrl8, contactrl9, contactrl10;

    EditText contactnameedittext1, contactnameedittext2, contactnameedittext3, contactnameedittext4, contactnameedittext5, contactnameedittext6, contactnameedittext7
            , contactnameedittext8, contactnameedittext9, contactnameedittext10
            , contactnumberedittext1, contactnumberedittext2, contactnumberedittext3, contactnumberedittext4, contactnumberedittext5, contactnumberedittext6, contactnumberedittext7
            , contactnumberedittext8, contactnumberedittext9, contactnumberedittext10;


    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final LayoutInflater inflater = (LayoutInflater) getSupportActionBar().getThemedContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        final View customActionBarView = inflater.inflate(R.layout.actionbar_done_cancel, null);
        //this clickListener adds contacts of user's family and friends contact nos
        customActionBarView.findViewById(R.id.bulk_add_subjects_save).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {

                        //Check if somebody has entered a name without entering a number
                        if(!contactnumberedittext1.getText().toString().equals("") && contactnameedittext1.getText().toString().equals("") ||
                                !contactnumberedittext2.getText().toString().equals("") && contactnameedittext2.getText().toString().equals("") ||
                                !contactnumberedittext3.getText().toString().equals("") && contactnameedittext3.getText().toString().equals("") ||
                                !contactnumberedittext4.getText().toString().equals("") && contactnameedittext4.getText().toString().equals("") ||
                                !contactnumberedittext5.getText().toString().equals("") && contactnameedittext5.getText().toString().equals("") ||
                                !contactnumberedittext6.getText().toString().equals("") && contactnameedittext6.getText().toString().equals("") ||
                                !contactnumberedittext7.getText().toString().equals("") && contactnameedittext7.getText().toString().equals("") ||
                                !contactnumberedittext8.getText().toString().equals("") && contactnameedittext8.getText().toString().equals("") ||
                                !contactnumberedittext9.getText().toString().equals("") && contactnameedittext9.getText().toString().equals("") ||
                                !contactnumberedittext10.getText().toString().equals("") && contactnameedittext10.getText().toString().equals("")
                                ) {

                            //Launch error dialog
                            AlertDialog alertDialog = new AlertDialog.Builder(editcontacts.this).create();
                            alertDialog.setMessage(getResources().getString(R.string.enternameforphonenumber));
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, getString(R.string.ok),
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    });
                            alertDialog.show();


                            return;
                        }



//saves it to 'sharedPreferences' under the tag 'FRIENDSFAMILYNUMBER1
                        SavePreferences("NAME1", contactnameedittext1.getText().toString());
                        SavePreferences("NAME2", contactnameedittext2.getText().toString());
                        SavePreferences("NAME3", contactnameedittext3.getText().toString());
                        SavePreferences("NAME4", contactnameedittext4.getText().toString());
                        SavePreferences("NAME5", contactnameedittext5.getText().toString());
                        SavePreferences("NAME6", contactnameedittext6.getText().toString());
                        SavePreferences("NAME7", contactnameedittext7.getText().toString());
                        SavePreferences("NAME8", contactnameedittext8.getText().toString());
                        SavePreferences("NAME9", contactnameedittext9.getText().toString());
                        SavePreferences("NAME10", contactnameedittext10.getText().toString());
                        SavePreferences("NUMBER1", contactnumberedittext1.getText().toString());
                        SavePreferences("NUMBER2", contactnumberedittext2.getText().toString());
                        SavePreferences("NUMBER3", contactnumberedittext3.getText().toString());
                        SavePreferences("NUMBER4", contactnumberedittext4.getText().toString());
                        SavePreferences("NUMBER5", contactnumberedittext5.getText().toString());
                        SavePreferences("NUMBER6", contactnumberedittext6.getText().toString());
                        SavePreferences("NUMBER7", contactnumberedittext7.getText().toString());
                        SavePreferences("NUMBER8", contactnumberedittext8.getText().toString());
                        SavePreferences("NUMBER9", contactnumberedittext9.getText().toString());
                        SavePreferences("NUMBER10", contactnumberedittext10.getText().toString());


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

        setContentView(R.layout.activity_editcontacts);

        contactrl1 = (RelativeLayout) findViewById(R.id.editcontactrl01);
        contactrl2 = (RelativeLayout) findViewById(R.id.editcontactrl02);
        contactrl3 = (RelativeLayout) findViewById(R.id.editcontactrl03);
        contactrl4 = (RelativeLayout) findViewById(R.id.editcontactrl04);
        contactrl5 = (RelativeLayout) findViewById(R.id.editcontactrl05);
        contactrl6 = (RelativeLayout) findViewById(R.id.editcontactrl06);
        contactrl7 = (RelativeLayout) findViewById(R.id.editcontactrl07);
        contactrl8 = (RelativeLayout) findViewById(R.id.editcontactrl08);
        contactrl9 = (RelativeLayout) findViewById(R.id.editcontactrl09);
        contactrl10 = (RelativeLayout) findViewById(R.id.editcontactrl10);
        contactnameedittext1 = (EditText) findViewById(R.id.contactnameedittext01);
        contactnameedittext2 = (EditText) findViewById(R.id.contactnameedittext02);
        contactnameedittext3 = (EditText) findViewById(R.id.contactnameedittext03);
        contactnameedittext4 = (EditText) findViewById(R.id.contactnameedittext04);
        contactnameedittext5 = (EditText) findViewById(R.id.contactnameedittext05);
        contactnameedittext6 = (EditText) findViewById(R.id.contactnameedittext06);
        contactnameedittext7 = (EditText) findViewById(R.id.contactnameedittext07);
        contactnameedittext8 = (EditText) findViewById(R.id.contactnameedittext08);
        contactnameedittext9 = (EditText) findViewById(R.id.contactnameedittext09);
        contactnameedittext10 = (EditText) findViewById(R.id.contactnameedittext10);
        contactnumberedittext1 = (EditText) findViewById(R.id.contactnumberedittext01);
        contactnumberedittext2 = (EditText) findViewById(R.id.contactnumberedittext02);
        contactnumberedittext3 = (EditText) findViewById(R.id.contactnumberedittext03);
        contactnumberedittext4 = (EditText) findViewById(R.id.contactnumberedittext04);
        contactnumberedittext5 = (EditText) findViewById(R.id.contactnumberedittext05);
        contactnumberedittext6 = (EditText) findViewById(R.id.contactnumberedittext06);
        contactnumberedittext7 = (EditText) findViewById(R.id.contactnumberedittext07);
        contactnumberedittext8 = (EditText) findViewById(R.id.contactnumberedittext08);
        contactnumberedittext9 = (EditText) findViewById(R.id.contactnumberedittext09);
        contactnumberedittext10 = (EditText) findViewById(R.id.contactnumberedittext10);
        addnewbutton = (Button) findViewById(R.id.contactsaddnew);
        importcontactbutton = (Button) findViewById(R.id.importcontactbutton);
        addnewbutton.setOnClickListener(addbuttononclicklistener);
//        importcontactbutton.setOnClickListener(importcontactbuttonclicklistener);

        //If there are already phone numbers in the sharedpreferences file, then load them!
        LoadPreferences();
    }

    Button.OnClickListener addbuttononclicklistener
            = new Button.OnClickListener() {

        @Override
        public void onClick(View arg0) {
            //Check how many views are visible
            int counter = 0;
            if(contactrl1.getVisibility() == View.VISIBLE) counter++;
            if(contactrl2.getVisibility() == View.VISIBLE) counter++;
            if(contactrl3.getVisibility() == View.VISIBLE) counter++;
            if(contactrl4.getVisibility() == View.VISIBLE) counter++;
            if(contactrl5.getVisibility() == View.VISIBLE) counter++;
            if(contactrl6.getVisibility() == View.VISIBLE) counter++;
            if(contactrl7.getVisibility() == View.VISIBLE) counter++;
            if(contactrl8.getVisibility() == View.VISIBLE) counter++;
            if(contactrl9.getVisibility() == View.VISIBLE) counter++;
            if(contactrl10.getVisibility() == View.VISIBLE) counter++;
            //make a new thing appear!
            if(counter<4) contactrl4.setVisibility(View.VISIBLE);
            else if(counter==4) contactrl5.setVisibility(View.VISIBLE);
            else if(counter==5) contactrl6.setVisibility(View.VISIBLE);
            else if(counter==6) contactrl7.setVisibility(View.VISIBLE);
            else if(counter==7) contactrl8.setVisibility(View.VISIBLE);
            else if(counter==8) contactrl9.setVisibility(View.VISIBLE);
            else if(counter==9) {
                contactrl10.setVisibility(View.VISIBLE);
                addnewbutton.setVisibility(View.GONE);
            }
        }
    };

    private void SavePreferences(String key, String value){

        SharedPreferences sharedPreferences = getSharedPreferences("SafetyPlan", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    private void LoadPreferences(){
        SharedPreferences sharedprefs3 = getSharedPreferences("SafetyPlan", MODE_PRIVATE);

        String name1=sharedprefs3.getString("NAME1", "");
        String name2=sharedprefs3.getString("NAME2", "");
        String name3=sharedprefs3.getString("NAME3", "");
        String name4=sharedprefs3.getString("NAME4", "");
        String name5=sharedprefs3.getString("NAME5", "");
        String name6=sharedprefs3.getString("NAME6", "");
        String name7=sharedprefs3.getString("NAME7", "");
        String name8=sharedprefs3.getString("NAME8", "");
        String name9=sharedprefs3.getString("NAME9", "");
        String name10=sharedprefs3.getString("NAME10", "");

        String number1=sharedprefs3.getString("NUMBER1", "");
        String number2=sharedprefs3.getString("NUMBER2", "");
        String number3=sharedprefs3.getString("NUMBER3", "");
        String number4=sharedprefs3.getString("NUMBER4", "");
        String number5=sharedprefs3.getString("NUMBER5", "");
        String number6=sharedprefs3.getString("NUMBER6", "");
        String number7=sharedprefs3.getString("NUMBER7", "");
        String number8=sharedprefs3.getString("NUMBER8", "");
        String number9=sharedprefs3.getString("NUMBER9", "");
        String number10=sharedprefs3.getString("NUMBER10", "");


        contactnameedittext1.setText(name1);
        contactnameedittext2.setText(name2);
        contactnameedittext3.setText(name3);
        contactnameedittext4.setText(name4);
        contactnameedittext5.setText(name5);
        contactnameedittext6.setText(name6);
        contactnameedittext7.setText(name7);
        contactnameedittext8.setText(name8);
        contactnameedittext9.setText(name9);
        contactnameedittext10.setText(name10);
        contactnumberedittext1.setText(number1);
        contactnumberedittext2.setText(number2);
        contactnumberedittext3.setText(number3);
        contactnumberedittext4.setText(number4);
        contactnumberedittext5.setText(number5);
        contactnumberedittext6.setText(number6);
        contactnumberedittext7.setText(number7);
        contactnumberedittext8.setText(number8);
        contactnumberedittext9.setText(number9);
        contactnumberedittext10.setText(number10);

        int counter = 0;
        if(!name1.equals("")) counter++;
        if(!name2.equals("")) counter++;
        if(!name3.equals("")) counter++;
        if(!name4.equals("")) counter++;
        if(!name5.equals("")) counter++;
        if(!name6.equals("")) counter++;
        if(!name7.equals("")) counter++;
        if(!name8.equals("")) counter++;
        if(!name9.equals("")) counter++;
        if(!name10.equals("")) counter++;

        //if counter = 10, then hide nothing. If counter = 1, 2, or 3; then hide nothing.

        if(counter<4) {
            contactrl4.setVisibility(View.GONE);
            contactrl5.setVisibility(View.GONE);
            contactrl6.setVisibility(View.GONE);
            contactrl7.setVisibility(View.GONE);
            contactrl8.setVisibility(View.GONE);
            contactrl9.setVisibility(View.GONE);
            contactrl10.setVisibility(View.GONE);
        }
        else if(counter==4) {
            contactrl5.setVisibility(View.GONE);
            contactrl6.setVisibility(View.GONE);
            contactrl7.setVisibility(View.GONE);
            contactrl8.setVisibility(View.GONE);
            contactrl9.setVisibility(View.GONE);
            contactrl10.setVisibility(View.GONE);
        }
        else if(counter==5) {
            contactrl6.setVisibility(View.GONE);
            contactrl7.setVisibility(View.GONE);
            contactrl8.setVisibility(View.GONE);
            contactrl9.setVisibility(View.GONE);
            contactrl10.setVisibility(View.GONE);
        }
        else if(counter==6) {
            contactrl7.setVisibility(View.GONE);
            contactrl8.setVisibility(View.GONE);
            contactrl9.setVisibility(View.GONE);
            contactrl10.setVisibility(View.GONE);
        }
        else if(counter==7) {
            contactrl8.setVisibility(View.GONE);
            contactrl9.setVisibility(View.GONE);
            contactrl10.setVisibility(View.GONE);
        }
        else if(counter==8) {
            contactrl9.setVisibility(View.GONE);
            contactrl10.setVisibility(View.GONE);
        }
        else if(counter==9) {
            contactrl10.setVisibility(View.GONE);
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
