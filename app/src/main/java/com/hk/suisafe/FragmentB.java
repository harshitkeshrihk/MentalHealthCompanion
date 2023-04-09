package com.hk.suisafe;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

//Safety Plan Tab

public class FragmentB extends Fragment implements View.OnClickListener{

        public FragmentB() {
            //required empty public constructor
        }


    //The following is from the sliding tabs guide
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static FragmentB newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        FragmentB fragment = new FragmentB();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    //above this is from the sliding tabs

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_b, container, false);


            //Call the buttons
            Button gbutton = (Button) v.findViewById(R.id.editwarningsignsbutton);
            Button hbutton = (Button) v.findViewById(R.id.editcopingstrategiesbutton);
            Button ibutton = (Button) v.findViewById(R.id.editplacesfordistractionbutton);
            Button kbutton = (Button) v.findViewById(R.id.editcontactsbutton);
            Button mbutton = (Button) v.findViewById(R.id.editworthlivingbutton);
            Button extranotesbutton = (Button) v.findViewById(R.id.extranotesbutton);

            //set on click listeners on the buttons
            gbutton.setOnClickListener(this);
            hbutton.setOnClickListener(this);
            ibutton.setOnClickListener(this);
            kbutton.setOnClickListener(this);
            extranotesbutton.setOnClickListener(this);
            mbutton.setOnClickListener(this);

            //call the textviews from layout



            TextView instructionstextview = (TextView) v.findViewById(R.id.instructionstextview);
            TextView warningsignstextview1 = (TextView) v.findViewById(R.id.warningsigntextview1);
            TextView warningsignstextview2 = (TextView) v.findViewById(R.id.warningsigntextview2);
            TextView warningsignstextview3 = (TextView) v.findViewById(R.id.warningsigntextview3);
            TextView warningsignstextview4 = (TextView) v.findViewById(R.id.warningsigntextview4);
            TextView warningsignstextview5 = (TextView) v.findViewById(R.id.warningsigntextview5);
            TextView warningsignstextview6 = (TextView) v.findViewById(R.id.warningsigntextview6);
            TextView warningsignstextview7 = (TextView) v.findViewById(R.id.warningsigntextview7);
            TextView warningsignstextview8 = (TextView) v.findViewById(R.id.warningsigntextview8);
            TextView warningsignstextview9 = (TextView) v.findViewById(R.id.warningsigntextview9);
            TextView warningsignstextview10 = (TextView) v.findViewById(R.id.warningsigntextview10);
            TextView copingstrategiestextview1 = (TextView) v.findViewById(R.id.copingstrategiestextview1);
            TextView copingstrategiestextview2 = (TextView) v.findViewById(R.id.copingstrategiestextview2);
            TextView copingstrategiestextview3 = (TextView) v.findViewById(R.id.copingstrategiestextview3);
            TextView copingstrategiestextview4 = (TextView) v.findViewById(R.id.copingstrategiestextview4);
            TextView copingstrategiestextview5 = (TextView) v.findViewById(R.id.copingstrategiestextview5);
            TextView copingstrategiestextview6 = (TextView) v.findViewById(R.id.copingstrategiestextview6);
            TextView copingstrategiestextview7 = (TextView) v.findViewById(R.id.copingstrategiestextview7);
            TextView copingstrategiestextview8 = (TextView) v.findViewById(R.id.copingstrategiestextview8);
            TextView copingstrategiestextview9 = (TextView) v.findViewById(R.id.copingstrategiestextview9);
            TextView copingstrategiestextview10 = (TextView) v.findViewById(R.id.copingstrategiestextview10);
            TextView placesfordistractiontextview1 = (TextView) v.findViewById(R.id.placesfordistractiontextview1);
            TextView placesfordistractiontextview2 = (TextView) v.findViewById(R.id.placesfordistractiontextview2);
            TextView placesfordistractiontextview3 = (TextView) v.findViewById(R.id.placesfordistractiontextview3);
            TextView placesfordistractiontextview4 = (TextView) v.findViewById(R.id.placesfordistractiontextview4);
            TextView placesfordistractiontextview5 = (TextView) v.findViewById(R.id.placesfordistractiontextview5);
            TextView placesfordistractiontextview6 = (TextView) v.findViewById(R.id.placesfordistractiontextview6);
            TextView placesfordistractiontextview7 = (TextView) v.findViewById(R.id.placesfordistractiontextview7);
            TextView placesfordistractiontextview8 = (TextView) v.findViewById(R.id.placesfordistractiontextview8);
            TextView placesfordistractiontextview9 = (TextView) v.findViewById(R.id.placesfordistractiontextview9);
            TextView placesfordistractiontextview10 = (TextView) v.findViewById(R.id.placesfordistractiontextview10);
            TextView contacttextview1 = (TextView) v.findViewById(R.id.contacttextview1);
            TextView contacttextview2 = (TextView) v.findViewById(R.id.contacttextview2);
            TextView contacttextview3 = (TextView) v.findViewById(R.id.contacttextview3);
            TextView contacttextview4 = (TextView) v.findViewById(R.id.contacttextview4);
            TextView contacttextview5 = (TextView) v.findViewById(R.id.contacttextview5);
            TextView contacttextview6 = (TextView) v.findViewById(R.id.contacttextview6);
            TextView contacttextview7 = (TextView) v.findViewById(R.id.contacttextview7);
            TextView contacttextview8 = (TextView) v.findViewById(R.id.contacttextview8);
            TextView contacttextview9 = (TextView) v.findViewById(R.id.contacttextview9);
            TextView contacttextview10 = (TextView) v.findViewById(R.id.contacttextview10);
            //   TextView professionalstextview1 = (TextView) v.findViewById(R.id.professionalstextview1);
         //   TextView professionalstextview2 = (TextView) v.findViewById(R.id.professionalstextview2);
            TextView reasontolivetextview1 = (TextView) v.findViewById(R.id.worthlivingtextview1);
            TextView reasontolivetextview2 = (TextView) v.findViewById(R.id.worthlivingtextview2);
            TextView reasontolivetextview3 = (TextView) v.findViewById(R.id.worthlivingtextview3);
            TextView reasontolivetextview4 = (TextView) v.findViewById(R.id.worthlivingtextview4);
            TextView reasontolivetextview5 = (TextView) v.findViewById(R.id.worthlivingtextview5);
            TextView reasontolivetextview6 = (TextView) v.findViewById(R.id.worthlivingtextview6);
            TextView reasontolivetextview7 = (TextView) v.findViewById(R.id.worthlivingtextview7);
            TextView reasontolivetextview8 = (TextView) v.findViewById(R.id.worthlivingtextview8);
            TextView reasontolivetextview9 = (TextView) v.findViewById(R.id.worthlivingtextview9);
            TextView reasontolivetextview10 = (TextView) v.findViewById(R.id.worthlivingtextview10);
            TextView notetextview = (TextView) v.findViewById(R.id.notetextview);

    /**
     *
     * THIS IS ALL OF THE INFORMATION WE HAVE TO TRANSFER FROM ONE 'SAVE' TO THE OTHER
     *
     *
     *
            SharedPreferences sharedprefs = this.getActivity().getSharedPreferences("PhoneNumbers", Context.MODE_PRIVATE);
            //getString("yourStringName", "defaultvaluehereifstringismissing")
            String counselorphonenumber = sharedprefs.getString("COUNSELORNUMBER", "");

            String psychiatristphonenumber = sharedprefs.getString("PSYCHIATRISTNUMBER", "");

            SharedPreferences sharedprefs2 = this.getActivity().getSharedPreferences("FriendsFamily", Context.MODE_PRIVATE);

            String friendsfamily1 = sharedprefs2.getString("FRIENDSFAMILYNUMBER1", "");
            String friendsfamily2 = sharedprefs2.getString("FRIENDSFAMILYNUMBER2", "");
            String friendsfamily3 = sharedprefs2.getString("FRIENDSFAMILYNUMBER3", "");
            String friendsfamily4 = sharedprefs2.getString("FRIENDSFAMILYNUMBER4", "");
            String friendsfamily5 = sharedprefs2.getString("FRIENDSFAMILYNUMBER5", "");
            String friendsfamily6 = sharedprefs2.getString("FRIENDSFAMILYNUMBER6", "");
            String friendsfamily7 = sharedprefs2.getString("FRIENDSFAMILYNUMBER7", "");
            String friendsfamily8 = sharedprefs2.getString("FRIENDSFAMILYNUMBER8", "");
            String friendsfamily9 = sharedprefs2.getString("FRIENDSFAMILYNUMBER9", "");
            String friendsfamily10 = sharedprefs2.getString("FRIENDSFAMILYNUMBER10", "");

            //If the first friends family is empty, then have it display 'edit friends family to add some!'
            //If the other ones are empty, then destroy the textview itself so that it doesn't take up space in the layout
            if(friendsfamily1.equalsIgnoreCase("")) friendsfamilytextview1.setText(R.string.emptyfriendsfamily);
            else friendsfamilytextview1.setText("• "+friendsfamily1);
            if(friendsfamily2.equalsIgnoreCase("")) friendsfamilytextview2.setVisibility(View.GONE);
            else  friendsfamilytextview2.setText("• "+friendsfamily2);
            if(friendsfamily3.equalsIgnoreCase("")) friendsfamilytextview3.setVisibility(View.GONE);
            else   friendsfamilytextview3.setText("• "+friendsfamily3);
            if(friendsfamily4.equalsIgnoreCase("")) friendsfamilytextview4.setVisibility(View.GONE);
            else   friendsfamilytextview4.setText("• "+friendsfamily4);
            if(friendsfamily5.equalsIgnoreCase("")) friendsfamilytextview5.setVisibility(View.GONE);
            else  friendsfamilytextview5.setText("• "+friendsfamily5);
            if(friendsfamily6.equalsIgnoreCase("")) friendsfamilytextview6.setVisibility(View.GONE);
            else  friendsfamilytextview6.setText("• "+friendsfamily6);
            if(friendsfamily7.equalsIgnoreCase("")) friendsfamilytextview7.setVisibility(View.GONE);
            else  friendsfamilytextview7.setText("• "+friendsfamily7);
            if(friendsfamily8.equalsIgnoreCase("")) friendsfamilytextview8.setVisibility(View.GONE);
            else  friendsfamilytextview8.setText("• "+friendsfamily8);
            if(friendsfamily9.equalsIgnoreCase("")) friendsfamilytextview9.setVisibility(View.GONE);
            else  friendsfamilytextview9.setText("• "+friendsfamily9);
            if(friendsfamily10.equalsIgnoreCase("")) friendsfamilytextview10.setVisibility(View.GONE);
            else  friendsfamilytextview10.setText("• "+friendsfamily10);

     **/


            SharedPreferences sharedprefs3 = this.getActivity().getSharedPreferences("SafetyPlan", Context.MODE_PRIVATE);

            String extranote = sharedprefs3.getString("EXTRANOTE", "");

            String name1 = sharedprefs3.getString("NAME1", "");
            String name2 = sharedprefs3.getString("NAME2", "");
            String name3 = sharedprefs3.getString("NAME3", "");
            String name4 = sharedprefs3.getString("NAME4", "");
            String name5 = sharedprefs3.getString("NAME5", "");
            String name6 = sharedprefs3.getString("NAME6", "");
            String name7 = sharedprefs3.getString("NAME7", "");
            String name8 = sharedprefs3.getString("NAME8", "");
            String name9 = sharedprefs3.getString("NAME9", "");
            String name10 = sharedprefs3.getString("NAME10", "");

            String number1 = sharedprefs3.getString("NUMBER1", "");
            String number2 = sharedprefs3.getString("NUMBER2", "");
            String number3 = sharedprefs3.getString("NUMBER3", "");
            String number4 = sharedprefs3.getString("NUMBER4", "");
            String number5 = sharedprefs3.getString("NUMBER5", "");
            String number6 = sharedprefs3.getString("NUMBER6", "");
            String number7 = sharedprefs3.getString("NUMBER7", "");
            String number8 = sharedprefs3.getString("NUMBER8", "");
            String number9 = sharedprefs3.getString("NUMBER9", "");
            String number10 = sharedprefs3.getString("NUMBER10", "");

            String copingstrategy1 = sharedprefs3.getString("COPINGSTRATEGY1", "");
            String copingstrategy2 = sharedprefs3.getString("COPINGSTRATEGY2", "");
            String copingstrategy3 = sharedprefs3.getString("COPINGSTRATEGY3", "");
            String copingstrategy4 = sharedprefs3.getString("COPINGSTRATEGY4", "");
            String copingstrategy5 = sharedprefs3.getString("COPINGSTRATEGY5", "");
            String copingstrategy6 = sharedprefs3.getString("COPINGSTRATEGY6", "");
            String copingstrategy7 = sharedprefs3.getString("COPINGSTRATEGY7", "");
            String copingstrategy8 = sharedprefs3.getString("COPINGSTRATEGY8", "");
            String copingstrategy9 = sharedprefs3.getString("COPINGSTRATEGY9", "");
            String copingstrategy10 = sharedprefs3.getString("COPINGSTRATEGY10", "");

            String distractionplace1 = sharedprefs3.getString("DISTRACTIONPLACE1", "");
            String distractionplace2 = sharedprefs3.getString("DISTRACTIONPLACE2", "");
            String distractionplace3 = sharedprefs3.getString("DISTRACTIONPLACE3", "");
            String distractionplace4 = sharedprefs3.getString("DISTRACTIONPLACE4", "");
            String distractionplace5 = sharedprefs3.getString("DISTRACTIONPLACE5", "");
            String distractionplace6 = sharedprefs3.getString("DISTRACTIONPLACE6", "");
            String distractionplace7 = sharedprefs3.getString("DISTRACTIONPLACE7", "");
            String distractionplace8 = sharedprefs3.getString("DISTRACTIONPLACE8", "");
            String distractionplace9 = sharedprefs3.getString("DISTRACTIONPLACE9", "");
            String distractionplace10 = sharedprefs3.getString("DISTRACTIONPLACE10", "");
            String warningsign1 = sharedprefs3.getString("WARNINGSIGN1", "");
            String warningsign2 = sharedprefs3.getString("WARNINGSIGN2", "");
            String warningsign3 = sharedprefs3.getString("WARNINGSIGN3", "");
            String warningsign4 = sharedprefs3.getString("WARNINGSIGN4", "");
            String warningsign5 = sharedprefs3.getString("WARNINGSIGN5", "");
            String warningsign6 = sharedprefs3.getString("WARNINGSIGN6", "");
            String warningsign7 = sharedprefs3.getString("WARNINGSIGN7", "");
            String warningsign8 = sharedprefs3.getString("WARNINGSIGN8", "");
            String warningsign9 = sharedprefs3.getString("WARNINGSIGN9", "");
            String warningsign10 = sharedprefs3.getString("WARNINGSIGN10", "");
            String reasontolive1 = sharedprefs3.getString("REASONTOLIVE", "");
            String reasontolive2 = sharedprefs3.getString("REASONTOLIVE2", "");
            String reasontolive3 = sharedprefs3.getString("REASONTOLIVE3", "");
            String reasontolive4 = sharedprefs3.getString("REASONTOLIVE4", "");
            String reasontolive5 = sharedprefs3.getString("REASONTOLIVE5", "");
            String reasontolive6 = sharedprefs3.getString("REASONTOLIVE6", "");
            String reasontolive7 = sharedprefs3.getString("REASONTOLIVE7", "");
            String reasontolive8 = sharedprefs3.getString("REASONTOLIVE8", "");
            String reasontolive9 = sharedprefs3.getString("REASONTOLIVE9", "");
            String reasontolive10 = sharedprefs3.getString("REASONTOLIVE10", "");

            if(copingstrategy1.equalsIgnoreCase("")) copingstrategiestextview1.setText(R.string.emptycopingstrategies);
            else copingstrategiestextview1.setText("• "+copingstrategy1);
            if(copingstrategy2.equalsIgnoreCase("")) copingstrategiestextview2.setVisibility(View.GONE);
            else copingstrategiestextview2.setText("• "+copingstrategy2);
            if(copingstrategy3.equalsIgnoreCase("")) copingstrategiestextview3.setVisibility(View.GONE);
            else copingstrategiestextview3.setText("• "+copingstrategy3);
            if(copingstrategy4.equalsIgnoreCase("")) copingstrategiestextview4.setVisibility(View.GONE);
            else copingstrategiestextview4.setText("• "+copingstrategy4);
            if(copingstrategy5.equalsIgnoreCase("")) copingstrategiestextview5.setVisibility(View.GONE);
            else copingstrategiestextview5.setText("• "+copingstrategy5);
            if(copingstrategy6.equalsIgnoreCase("")) copingstrategiestextview6.setVisibility(View.GONE);
            else copingstrategiestextview6.setText("• "+copingstrategy6);
            if(copingstrategy7.equalsIgnoreCase("")) copingstrategiestextview7.setVisibility(View.GONE);
            else copingstrategiestextview7.setText("• "+copingstrategy7);
            if(copingstrategy8.equalsIgnoreCase("")) copingstrategiestextview8.setVisibility(View.GONE);
            else copingstrategiestextview8.setText("• "+copingstrategy8);
            if(copingstrategy9.equalsIgnoreCase("")) copingstrategiestextview9.setVisibility(View.GONE);
            else copingstrategiestextview9.setText("• "+copingstrategy9);
            if(copingstrategy10.equalsIgnoreCase("")) copingstrategiestextview10.setVisibility(View.GONE);
            else copingstrategiestextview10.setText("• "+copingstrategy10);

            if(extranote.equalsIgnoreCase("")) notetextview.setText(R.string.emptynotes);
            else notetextview.setText(extranote);

            if(distractionplace1.equalsIgnoreCase("")) placesfordistractiontextview1.setText(R.string.emptyplacesfordistraction);
            else placesfordistractiontextview1.setText("• "+distractionplace1);
            if(distractionplace2.equalsIgnoreCase("")) placesfordistractiontextview2.setVisibility(View.GONE);
            else placesfordistractiontextview2.setText("• "+distractionplace2);
            if(distractionplace3.equalsIgnoreCase("")) placesfordistractiontextview3.setVisibility(View.GONE);
            else placesfordistractiontextview3.setText("• "+distractionplace3);
            if(distractionplace4.equalsIgnoreCase("")) placesfordistractiontextview4.setVisibility(View.GONE);
            else placesfordistractiontextview4.setText("• "+distractionplace4);
            if(distractionplace5.equalsIgnoreCase("")) placesfordistractiontextview5.setVisibility(View.GONE);
            else placesfordistractiontextview5.setText("• "+distractionplace5);
            if(distractionplace6.equalsIgnoreCase("")) placesfordistractiontextview6.setVisibility(View.GONE);
            else placesfordistractiontextview6.setText("• "+distractionplace6);
            if(distractionplace7.equalsIgnoreCase("")) placesfordistractiontextview7.setVisibility(View.GONE);
            else placesfordistractiontextview7.setText("• "+distractionplace7);
            if(distractionplace8.equalsIgnoreCase("")) placesfordistractiontextview8.setVisibility(View.GONE);
            else placesfordistractiontextview8.setText("• "+distractionplace8);
            if(distractionplace9.equalsIgnoreCase("")) placesfordistractiontextview9.setVisibility(View.GONE);
            else placesfordistractiontextview9.setText("• "+distractionplace9);
            if(distractionplace10.equalsIgnoreCase("")) placesfordistractiontextview10.setVisibility(View.GONE);
            else placesfordistractiontextview10.setText("• "+distractionplace10);

            //Name1 is required. Number is NOT required.
            if(name1.equalsIgnoreCase("")) contacttextview1.setText(R.string.emptycontacts);
            else if(number1.equalsIgnoreCase("")) contacttextview1.setText("• "+ name1);
            else contacttextview1.setText("• "+ name1 + ": " + number1);
            if(name2.equalsIgnoreCase("")) contacttextview2.setVisibility(View.GONE);
            else if(number2.equalsIgnoreCase("")) contacttextview2.setText("• "+ name2);
            else contacttextview2.setText("• "+ name2 + ": " + number2);
            if(name3.equalsIgnoreCase("")) contacttextview3.setVisibility(View.GONE);
            else if(number3.equalsIgnoreCase("")) contacttextview3.setText("• "+ name3);
            else contacttextview3.setText("• "+ name3 + ": " + number3);
            if(name4.equalsIgnoreCase("")) contacttextview4.setVisibility(View.GONE);
            else if(number4.equalsIgnoreCase("")) contacttextview4.setText("• "+ name4);
            else contacttextview4.setText("• "+ name4 + ": " + number4);
            if(name5.equalsIgnoreCase("")) contacttextview5.setVisibility(View.GONE);
            else if(number5.equalsIgnoreCase("")) contacttextview5.setText("• "+ name5);
            else contacttextview5.setText("• "+ name5 + ": " + number5);
            if(name6.equalsIgnoreCase("")) contacttextview6.setVisibility(View.GONE);
            else if(number6.equalsIgnoreCase("")) contacttextview6.setText("• "+ name6);
            else contacttextview6.setText("• "+ name6 + ": " + number6);
            if(name7.equalsIgnoreCase("")) contacttextview7.setVisibility(View.GONE);
            else if(number7.equalsIgnoreCase("")) contacttextview7.setText("• "+ name7);
            else contacttextview7.setText("• "+ name7 + ": " + number7);
            if(name8.equalsIgnoreCase("")) contacttextview8.setVisibility(View.GONE);
            else if(number8.equalsIgnoreCase("")) contacttextview8.setText("• "+ name8);
            else contacttextview8.setText("• "+ name8 + ": " + number8);
            if(name9.equalsIgnoreCase("")) contacttextview9.setVisibility(View.GONE);
            else if(number9.equalsIgnoreCase("")) contacttextview9.setText("• "+ name9);
            else contacttextview9.setText("• "+ name9 + ": " + number9);
            if(name10.equalsIgnoreCase("")) contacttextview10.setVisibility(View.GONE);
            else if(number10.equalsIgnoreCase("")) contacttextview10.setText("• "+ name10);
            else contacttextview10.setText("• "+ name10 + ": " + number10);


            if(warningsign1.equalsIgnoreCase("")) warningsignstextview1.setText(R.string.emptywarningsigns);
            else warningsignstextview1.setText("• "+warningsign1);
            if(warningsign2.equalsIgnoreCase("")) warningsignstextview2.setVisibility(View.GONE);
            else warningsignstextview2.setText("• "+warningsign2);
            if(warningsign3.equalsIgnoreCase("")) warningsignstextview3.setVisibility(View.GONE);
            else warningsignstextview3.setText("• "+warningsign3);
            if(warningsign4.equalsIgnoreCase("")) warningsignstextview4.setVisibility(View.GONE);
            else warningsignstextview4.setText("• "+warningsign4);
            if(warningsign5.equalsIgnoreCase("")) warningsignstextview5.setVisibility(View.GONE);
            else warningsignstextview5.setText("• "+warningsign5);
            if(warningsign6.equalsIgnoreCase("")) warningsignstextview6.setVisibility(View.GONE);
            else warningsignstextview6.setText("• "+warningsign6);
            if(warningsign7.equalsIgnoreCase("")) warningsignstextview7.setVisibility(View.GONE);
            else warningsignstextview7.setText("• "+warningsign7);
            if(warningsign8.equalsIgnoreCase("")) warningsignstextview8.setVisibility(View.GONE);
            else warningsignstextview8.setText("• "+warningsign8);
            if(warningsign9.equalsIgnoreCase("")) warningsignstextview9.setVisibility(View.GONE);
            else warningsignstextview9.setText("• "+warningsign9);
            if(warningsign10.equalsIgnoreCase("")) warningsignstextview10.setVisibility(View.GONE);
            else warningsignstextview10.setText("• "+warningsign10);

            if(reasontolive1.equalsIgnoreCase("")) reasontolivetextview1.setText(R.string.worthlivingfor);
            else reasontolivetextview1.setText("• "+reasontolive1);
            if(reasontolive2.equalsIgnoreCase("")) reasontolivetextview2.setVisibility(View.GONE);
            else reasontolivetextview2.setText("• "+reasontolive2);
            if(reasontolive3.equalsIgnoreCase("")) reasontolivetextview3.setVisibility(View.GONE);
            else reasontolivetextview3.setText("• "+reasontolive3);
            if(reasontolive4.equalsIgnoreCase("")) reasontolivetextview4.setVisibility(View.GONE);
            else reasontolivetextview4.setText("• "+reasontolive4);
            if(reasontolive5.equalsIgnoreCase("")) reasontolivetextview5.setVisibility(View.GONE);
            else reasontolivetextview5.setText("• "+reasontolive5);
            if(reasontolive6.equalsIgnoreCase("")) reasontolivetextview6.setVisibility(View.GONE);
            else reasontolivetextview6.setText("• "+reasontolive6);
            if(reasontolive7.equalsIgnoreCase("")) reasontolivetextview7.setVisibility(View.GONE);
            else reasontolivetextview7.setText("• "+reasontolive7);
            if(reasontolive8.equalsIgnoreCase("")) reasontolivetextview8.setVisibility(View.GONE);
            else reasontolivetextview8.setText("• "+reasontolive8);
            if(reasontolive9.equalsIgnoreCase("")) reasontolivetextview9.setVisibility(View.GONE);
            else reasontolivetextview9.setText("• "+reasontolive9);
            if(reasontolive10.equalsIgnoreCase("")) reasontolivetextview10.setVisibility(View.GONE);
            else reasontolivetextview10.setText("• "+reasontolive10);



            //Set the instructions dialog to appear if nothing is filled out
            if(warningsign1.equalsIgnoreCase("") && warningsign2.equalsIgnoreCase("") && warningsign3.equalsIgnoreCase("") && reasontolive1.equalsIgnoreCase("")
                    && distractionplace3.equalsIgnoreCase("") && distractionplace2.equalsIgnoreCase("") && distractionplace1.equalsIgnoreCase("")
                  &&
                    copingstrategy1.equalsIgnoreCase("") && copingstrategy2.equalsIgnoreCase("") && copingstrategy3.equalsIgnoreCase(""))
                instructionstextview.setText(getString(R.string.instructionstextview));
            else instructionstextview.setVisibility(View.GONE);

            return v;
        }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.editwarningsignsbutton:
                Intent intent = new Intent(getActivity(), editwarningsigns.class);
                startActivity(intent);

                break;

            case R.id.editcopingstrategiesbutton:
                Intent intent2 = new Intent(getActivity(), editcopingstrategies.class);
                startActivity(intent2);

                break;

            case R.id.editplacesfordistractionbutton:
                Intent intent3 = new Intent(getActivity(), editplacesfordistraction.class);
                startActivity(intent3);
                break;


            case R.id.editcontactsbutton:
                Intent intent5 = new Intent(getActivity(), editcontacts.class);
                startActivity(intent5);
                break;

            case R.id.extranotesbutton:
                Intent intent6 = new Intent(getActivity(), editextranote.class);
                startActivity(intent6);
                break;

            case R.id.editworthlivingbutton:
                Intent intent7 = new Intent(getActivity(), editreasontolive.class);
                startActivity(intent7);
                break;

        }
    }

}