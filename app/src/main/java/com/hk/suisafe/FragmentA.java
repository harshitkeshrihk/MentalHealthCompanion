package com.hk.suisafe;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;



public class FragmentA extends Fragment implements View.OnClickListener {

    boolean showphonenumbers;

    public FragmentA() {
        //required empty public constructor
    }

    //The following is from the sliding tabs guide
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static FragmentA newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        FragmentA fragment = new FragmentA();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    //above this is from the sliding tabs

    Button callbutton1, callbutton2, callbutton3, callbutton4, callbutton5, callbutton6, callbutton7, callbutton8, callbutton9, callbutton10;
    View callline1, callline2, callline3, callline4, callline5, callline6, callline7, callline8, callline9, callline10;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a, container, false);

        //Call the buttons
        Button abutton = (Button) v.findViewById(R.id.call911button);
        Button bbutton = (Button) v.findViewById(R.id.callhelplinebutton);
        Button cbutton = (Button) v.findViewById(R.id.textbutton1);
        //Button dbutton = (Button) v.findViewById(R.id.callpsychiatristbutton);
        //Button ebutton = (Button) v.findViewById(R.id.callfriendsfamilybutton);
        Button fbutton = (Button) v.findViewById(R.id.findlocalurgentcarebutton);
        Button gbutton = (Button) v.findViewById(R.id.findlocalemergencydepartmentbutton);

        callbutton1 = (Button) v.findViewById(R.id.callbutton1);
        callbutton2 = (Button) v.findViewById(R.id.callbutton2);
        callbutton3 = (Button) v.findViewById(R.id.callbutton3);
        callbutton4 = (Button) v.findViewById(R.id.callbutton4);
        callbutton5 = (Button) v.findViewById(R.id.callbutton5);
        callbutton6 = (Button) v.findViewById(R.id.callbutton6);
        callbutton7 = (Button) v.findViewById(R.id.callbutton7);
        callbutton8 = (Button) v.findViewById(R.id.callbutton8);
        callbutton9 = (Button) v.findViewById(R.id.callbutton9);
        callbutton10 = (Button) v.findViewById(R.id.callbutton10);

        callline1 = v.findViewById(R.id.callline1);
        callline2 = v.findViewById(R.id.callline2);
        callline3 = v.findViewById(R.id.callline3);
        callline4 = v.findViewById(R.id.callline4);
        callline5 = v.findViewById(R.id.callline5);
        callline6 = v.findViewById(R.id.callline6);
        callline7 = v.findViewById(R.id.callline7);
        callline8 = v.findViewById(R.id.callline8);
        callline9 = v.findViewById(R.id.callline9);
        callline10 = v.findViewById(R.id.callline10);



        SharedPreferences sharedprefs3=this.getActivity().getSharedPreferences("SafetyPlan",Context.MODE_PRIVATE);


        String name1=sharedprefs3.getString("NAME1","");
        String name2=sharedprefs3.getString("NAME2","");
        String name3=sharedprefs3.getString("NAME3","");
        String name4=sharedprefs3.getString("NAME4","");
        String name5=sharedprefs3.getString("NAME5","");
        String name6=sharedprefs3.getString("NAME6","");
        String name7=sharedprefs3.getString("NAME7","");
        String name8=sharedprefs3.getString("NAME8","");
        String name9=sharedprefs3.getString("NAME9","");
        String name10=sharedprefs3.getString("NAME10","");

        String number1=sharedprefs3.getString("NUMBER1","");
        String number2=sharedprefs3.getString("NUMBER2","");
        String number3=sharedprefs3.getString("NUMBER3","");
        String number4=sharedprefs3.getString("NUMBER4","");
        String number5=sharedprefs3.getString("NUMBER5","");
        String number6=sharedprefs3.getString("NUMBER6","");
        String number7=sharedprefs3.getString("NUMBER7","");
        String number8=sharedprefs3.getString("NUMBER8","");
        String number9=sharedprefs3.getString("NUMBER9","");
        String number10=sharedprefs3.getString("NUMBER10","");

        if(!name1.equals("") && !number1.equals("")) {
            callbutton1.setText(getResources().getString(R.string.call) + " " + name1);
            callbutton1.setOnClickListener(this);
        }
        else {
            callbutton1.setVisibility(View.GONE);
            callline1.setVisibility(View.GONE);
        }
        if(!name2.equals("") && !number2.equals("")) {
            callbutton2.setText(getResources().getString(R.string.call) + " " + name2);
            callbutton2.setOnClickListener(this);
        }
        else {
            callbutton2.setVisibility(View.GONE);
            callline2.setVisibility(View.GONE);
        }
        if(!name3.equals("") && !number3.equals("")) {
            callbutton3.setText(getResources().getString(R.string.call) + " " + name3);
            callbutton3.setOnClickListener(this);
        }
        else {
            callbutton3.setVisibility(View.GONE);
            callline3.setVisibility(View.GONE);
        }
        if(!name4.equals("") && !number4.equals("")) {
            callbutton4.setText(getResources().getString(R.string.call) + " " + name4);
            callbutton4.setOnClickListener(this);
        }
        else {
            callbutton4.setVisibility(View.GONE);
            callline4.setVisibility(View.GONE);
        }
        if(!name5.equals("") && !number5.equals("")) {
            callbutton5.setText(getResources().getString(R.string.call) + " " + name5);
            callbutton5.setOnClickListener(this);
        }
        else {
            callbutton5.setVisibility(View.GONE);
            callline5.setVisibility(View.GONE);
        }
        if(!name6.equals("") && !number6.equals("")) {
            callbutton6.setText(getResources().getString(R.string.call) + " " + name6);
            callbutton6.setOnClickListener(this);
        }
        else {
            callbutton6.setVisibility(View.GONE);
            callline6.setVisibility(View.GONE);
        }
        if(!name7.equals("") && !number7.equals("")) {
            callbutton7.setText(getResources().getString(R.string.call) + " " + name7);
            callbutton7.setOnClickListener(this);
        }
        else {
            callbutton7.setVisibility(View.GONE);
            callline7.setVisibility(View.GONE);
        }
        if(!name8.equals("") && !number8.equals("")) {
            callbutton8.setText(getResources().getString(R.string.call) + " " + name8);
            callbutton8.setOnClickListener(this);
        } else {
            callbutton8.setVisibility(View.GONE);
            callline8.setVisibility(View.GONE);
        }
        if(!name9.equals("") && !number9.equals("")) {
            callbutton9.setText(getResources().getString(R.string.call) + " " + name9);
            callbutton9.setOnClickListener(this);
        }
        else {
            callbutton9.setVisibility(View.GONE);
            callline9.setVisibility(View.GONE);
        }
        if(!name10.equals("") && !number10.equals("")) {
            callbutton10.setText(getResources().getString(R.string.call) + " " + name10);
            callbutton10.setOnClickListener(this);
        }
        else {
            callbutton10.setVisibility(View.GONE);
            callline10.setVisibility(View.GONE);
        }




        //set on click listeners
        abutton.setOnClickListener(this);
        bbutton.setOnClickListener(this);
        cbutton.setOnClickListener(this);
       // dbutton.setOnClickListener(this);
       // ebutton.setOnClickListener(this);
        fbutton.setOnClickListener(this);
        gbutton.setOnClickListener(this);

        //call the dialogs
/*
        SharedPreferences preferences = this.getActivity().getSharedPreferences("PhoneNumbers", Context.MODE_PRIVATE);
        String counselorphonenumber = preferences.getString("COUNSELORNUMBER", "");
        String psychiatristphonenumber = preferences.getString("PSYCHIATRISTNUMBER", "");
        int counselorphonenumberint = Integer.parseInt(counselorphonenumber);
        int psychiatristphonenumberint = Integer.parseInt(psychiatristphonenumber);
*/

        //Hide call 911 and call helpline if in country without values entered
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getBaseContext());
        showphonenumbers = prefs.getBoolean("countryshowphonenumbers", false);
        boolean showtextnumber = prefs.getBoolean("countryshowtextnumber", false);
        View call911line = v.findViewById(R.id.call911line);
        View callhelplineline = v.findViewById(R.id.callhelplineline);
        View textlineline = v.findViewById(R.id.texthelplineline);
        if(!showphonenumbers) {
            //Put in code that replaces the first button with a button that says 'Find Suicide Hotline'
            abutton.setVisibility(View.GONE);
          //  bbutton.setVisibility(View.GONE);
            bbutton.setText(getString(R.string.findsuicidehotline));
            call911line.setVisibility(View.GONE);
           // callhelplineline.setVisibility(View.GONE);
        }
        if(!showtextnumber) {
            //Hide the button if 'show text number' is not true
            cbutton.setVisibility(View.GONE);
            textlineline.setVisibility(View.GONE);
        }

        return v;
    }


    public void onClick(View v) {
        SharedPreferences preferences = this.getActivity().getSharedPreferences("PhoneNumbers", Context.MODE_PRIVATE);
        SharedPreferences preferences2 = this.getActivity().getSharedPreferences("FriendsFamily", Context.MODE_PRIVATE);
        SharedPreferences sharedprefs3=this.getActivity().getSharedPreferences("SafetyPlan",Context.MODE_PRIVATE);

        String number1=sharedprefs3.getString("NUMBER1","");
        String number2=sharedprefs3.getString("NUMBER2","");
        String number3=sharedprefs3.getString("NUMBER3","");
        String number4=sharedprefs3.getString("NUMBER4","");
        String number5=sharedprefs3.getString("NUMBER5","");
        String number6=sharedprefs3.getString("NUMBER6","");
        String number7=sharedprefs3.getString("NUMBER7","");
        String number8=sharedprefs3.getString("NUMBER8","");
        String number9=sharedprefs3.getString("NUMBER9","");
        String number10=sharedprefs3.getString("NUMBER10","");


        switch (v.getId()) {
            case R.id.call911button:
                String emergencynumber = getResources().getString(R.string.emergencynumber);
                Bundle emergencybundle = new Bundle();
                emergencybundle.putString("emergencynumber", emergencynumber);
                DialogCall911 newFragment3 = new DialogCall911();
                newFragment3.setArguments(emergencybundle);
                newFragment3.show(getFragmentManager(), "dialog2");

                break;

            case R.id.callhelplinebutton:
                // Create and show the dialog.
                if(showphonenumbers) {
                    String suicidehotlinenumber = getResources().getString(R.string.helplinenumber);
                    String suicidehotlinename = getResources().getString(R.string.hotlinename);
                    DialogSuicideHotline newFragment = new DialogSuicideHotline();
                    Bundle suicidehotlinebundle = new Bundle();
                    suicidehotlinebundle.putString("hotlinenumber", suicidehotlinenumber);
                    suicidehotlinebundle.putString("hotlinename", suicidehotlinename);
                    newFragment.setArguments(suicidehotlinebundle);
                    newFragment.show(getFragmentManager(), "dialog");
                }
                else {
                    Intent i = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.befrienders.org/"));
                    startActivity(i);

                }

                break;

            case R.id.textbutton1:
                //Create and show the dialog
                String crisistextlinenumber = getResources().getString(R.string.textlinenumber);
                String crisistextlinename = getResources().getString(R.string.textlinename);
                DialogSuicideTextline newFragment2 = new DialogSuicideTextline();
                Bundle textlinebuttonbundle = new Bundle();
                textlinebuttonbundle.putString("textlinenumber", crisistextlinenumber);
                textlinebuttonbundle.putString("textlinename", crisistextlinename);
                newFragment2.setArguments(textlinebuttonbundle);
                newFragment2.show(getFragmentManager(), "dialog");

                break;


            case R.id.findlocalemergencydepartmentbutton:
                //Because I can't get the maps working with places... here is an easy work around!
                String url = "geo:0,0?q=Emergency Room";
                Intent intent3 = new Intent(Intent.ACTION_VIEW,  Uri.parse(url));
                startActivity(intent3);
                break;

            case R.id.findlocalurgentcarebutton:
                //Because google maps API is too much work for now... here's an easy workaround!
                String url2 = "geo:0,0?q=Urgent Care";
                Intent intent2 = new Intent(Intent.ACTION_VIEW,  Uri.parse(url2));
                startActivity(intent2);
                /*Intent intent = new Intent(getActivity(), findlocalurgentcare.class);
                startActivity(intent);

                */
                break;
            case R.id.callbutton1:
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number1));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            case R.id.callbutton2:
                Intent intent4 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number2));
                intent4.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent4);
                break;
            case R.id.callbutton3:
                Intent intent5 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number3));
                intent5.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent5);
                break;
            case R.id.callbutton4:
                Intent intent6 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number4));
                intent6.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent6);
                break;
            case R.id.callbutton5:
                Intent intent7 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number5));
                intent7.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent7);
                break;
            case R.id.callbutton6:
                Intent intent8 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number6));
                intent8.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent8);
                break;
            case R.id.callbutton7:
                Intent intent9 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number7));
                intent9.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent9);
                break;
            case R.id.callbutton8:
                Intent intent11 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number8));
                intent11.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent11);
                break;
            case R.id.callbutton9:
                Intent intent12 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number9));
                intent12.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent12);
                break;
            case R.id.callbutton10:
                Intent intent13 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number10));
                intent13.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent13);
                break;


        }
    }


}