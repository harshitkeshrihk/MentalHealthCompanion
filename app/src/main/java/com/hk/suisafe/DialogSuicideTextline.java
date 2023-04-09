package com.hk.suisafe;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.DialogFragment;


public class DialogSuicideTextline extends DialogFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        final String textlinename = getArguments().getString("textlinename");
        final String textlinenumber = getArguments().getString("textlinenumber");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(getString(R.string.text) + " " + textlinename + "? (" + textlinenumber+ ")")
                .setPositiveButton(R.string.text, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        try {
                            Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                            sendIntent.setData(Uri.parse("sms:"));
                            sendIntent.putExtra("address", textlinenumber);
                            sendIntent.putExtra("sms_body", "HOME");
                            startActivity(sendIntent);
                        }
                        catch(Exception e) {
                            Log.d("crisis", "Can't send text message");

                        }





                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        return builder.create();
    }


}