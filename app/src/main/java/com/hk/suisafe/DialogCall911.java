package com.hk.suisafe;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;


public class DialogCall911 extends DialogFragment {

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction

        //this code deals with the actual calling of the function
        //here it opens a dialog box and if user click poitive button or call then it takes the no from argument value and calls on it
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final String emergencynumber = getArguments().getString("emergencynumber");
        builder.setMessage(getString(R.string.call) + " " + emergencynumber + "?")
                .setPositiveButton(R.string.call, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //calling intent
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + emergencynumber));
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        return builder.create();
    }
}
