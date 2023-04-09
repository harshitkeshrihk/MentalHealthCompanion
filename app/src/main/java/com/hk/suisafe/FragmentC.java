package com.hk.suisafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

//Guide Tab


public class FragmentC extends Fragment {


    //The following is from the sliding tabs guide
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static FragmentC newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        FragmentC fragment = new FragmentC();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    //above this is from the sliding tabs

    public FragmentC() {
        //required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_c, container, false);

        //Call the buttons

        Button overviewbutton = (Button) v.findViewById(R.id.suicideoverviewbutton);
        Button copingbutton = (Button) v.findViewById(R.id.suicidecopingbutton);
        Button recoveringbutton = (Button) v.findViewById(R.id.suiciderecoveringbutton);
        Button usingsafetyplanbutton = (Button) v.findViewById(R.id.suicideusingsafetyplanbutton);
        Button suicidepreventionbutton = (Button) v.findViewById(R.id.suicidepreventionbutton);
        Button makingenvironmentsafebutton = (Button) v.findViewById(R.id.editmakingenvironmentsafebutton);
        Button resourcesbutton = (Button) v.findViewById(R.id.suicideresourcesbutton);

        overviewbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getActivity(), GuideOverview.class);
                startActivity(intent3);
            }
        });

        copingbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getActivity(), GuideCoping.class);
                startActivity(intent3);
            }
        });

        recoveringbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getActivity(), GuideRecovering.class);
                startActivity(intent3);
            }
        });

        usingsafetyplanbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getActivity(), GuideSafetyPlan.class);
                startActivity(intent3);
            }
        });

        suicidepreventionbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getActivity(), GuideSuicidePrevention.class);
                startActivity(intent3);
            }
        });

        makingenvironmentsafebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getActivity(), editmakingenvironmentsafe.class);
                startActivity(intent3);
            }
        });

        resourcesbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getActivity(), suicideresources.class);
                startActivity(intent3);
            }
        });












        return v;
    }
}
