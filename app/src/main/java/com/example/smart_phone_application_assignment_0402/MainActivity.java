package com.example.smart_phone_application_assignment_0402;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    ExpandablelistAdapter adapter;
    List<String> groupData;
    HashMap<String, List<String>> childData;
    int lastExpandedGroup = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        expandableListView = findViewById(R.id.expandableListView);


        prepareData();


        adapter = new ExpandablelistAdapter(this, groupData, childData);
        expandableListView.setAdapter(adapter);


        expandableListView.setOnGroupClickListener((parent, v, groupPosition, id) -> {
            String groupText = groupData.get(groupPosition);
            Toast.makeText(getApplicationContext(), "Group: " + groupText, Toast.LENGTH_SHORT).show();
            return false;
        });


        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            String childText = childData.get(groupData.get(groupPosition)).get(childPosition);
            Toast.makeText(getApplicationContext(), "Child: " + childText, Toast.LENGTH_SHORT).show();
            return false;
        });


        expandableListView.setOnGroupExpandListener(groupPosition -> {
            if (lastExpandedGroup != -1 && lastExpandedGroup != groupPosition) {
                expandableListView.collapseGroup(lastExpandedGroup);
            }
            lastExpandedGroup = groupPosition;
        });
    }


    private void prepareData() {
        groupData = new ArrayList<>();
        childData = new HashMap<>();


        groupData.add("Dhaka Division");
        groupData.add("Chittagong Division");
        groupData.add("Khulna Division");
        groupData.add("Rajshahi Division");
        groupData.add("Sylhet Division");
        groupData.add("Barisal Division");
        groupData.add("Rangpur Division");
        groupData.add("Mymensingh Division");


        List<String> dhakaChild = new ArrayList<>();
        dhakaChild.add("Dhaka");
        dhakaChild.add("Gazipur");
        dhakaChild.add("Narayanganj");
        dhakaChild.add("Tangail");
        dhakaChild.add("Faridpur");


        List<String> chittagongChild = new ArrayList<>();
        chittagongChild.add("Chittagong");
        chittagongChild.add("Cox's Bazar");
        chittagongChild.add("Bandarban");
        chittagongChild.add("Rangamati");
        chittagongChild.add("Khagrachari");


        List<String> khulnaChild = new ArrayList<>();
        khulnaChild.add("Khulna");
        khulnaChild.add("Jessore");
        khulnaChild.add("Satkhira");
        khulnaChild.add("Bagerhat");
        khulnaChild.add("Kushtia");


        List<String> rajshahiChild = new ArrayList<>();
        rajshahiChild.add("Rajshahi");
        rajshahiChild.add("Pabna");
        rajshahiChild.add("Natore");
        rajshahiChild.add("Bogra");
        rajshahiChild.add("Joypurhat");


        List<String> sylhetChild = new ArrayList<>();
        sylhetChild.add("Sylhet");
        sylhetChild.add("Sunamganj");
        sylhetChild.add("Habiganj");
        sylhetChild.add("Moulvibazar");


        List<String> barisalChild = new ArrayList<>();
        barisalChild.add("Barisal");
        barisalChild.add("Bhola");
        barisalChild.add("Pirojpur");
        barisalChild.add("Jhalokati");
        barisalChild.add("Barguna");


        List<String> rangpurChild = new ArrayList<>();
        rangpurChild.add("Rangpur");
        rangpurChild.add("Dinajpur");
        rangpurChild.add("Kurigram");
        rangpurChild.add("Gaibandha");
        rangpurChild.add("Thakurgaon");


        List<String> mymensinghChild = new ArrayList<>();
        mymensinghChild.add("Mymensingh");
        mymensinghChild.add("Netrokona");
        mymensinghChild.add("Sherpur");
        mymensinghChild.add("Jamalpur");


        childData.put(groupData.get(0), dhakaChild);
        childData.put(groupData.get(1), chittagongChild);
        childData.put(groupData.get(2), khulnaChild);
        childData.put(groupData.get(3), rajshahiChild);
        childData.put(groupData.get(4), sylhetChild);
        childData.put(groupData.get(5), barisalChild);
        childData.put(groupData.get(6), rangpurChild);
        childData.put(groupData.get(7), mymensinghChild);
    }
}