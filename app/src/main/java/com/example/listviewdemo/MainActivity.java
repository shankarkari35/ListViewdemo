package com.example.listviewdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ExpandableListSetAdapter expandableListSetAdapter;
    ExpandableListView expandableListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listChildData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = (ExpandableListView) findViewById(R.id.lvExp); //get list view
        prepareListData(); //prepared list data for header and child

        //invokindg adapter to transfer data on expandableListView
        expandableListSetAdapter = new ExpandableListSetAdapter(this,listDataHeader,listChildData);

        expandableListView.setAdapter((ExpandableListAdapter) expandableListSetAdapter);
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Group clicked"  +listDataHeader.get(i), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {
                Toast.makeText(MainActivity.this, "Expanded" +listDataHeader.get(i), Toast.LENGTH_SHORT).show();
            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int i) {
                Toast.makeText(MainActivity.this, "Collapse" +listDataHeader.get(i), Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Toast.makeText(MainActivity.this, "clicked"  +listChildData.get(i), Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new  AlertDialog.Builder(MainActivity.this);
                builder.setTitle(listDataHeader.get(i));
                builder.setMessage(listChildData.get(listDataHeader.get(i)).get(i1));
                builder.setCancelable(true);
                builder.setIcon(R.drawable.a);
                //builder.setIcon(R.drawable.color1);
                builder.show();
                return false;
            }
        });
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listChildData = new HashMap<>();

        //Adding Header Data
        listDataHeader.add("Topics");
        listDataHeader.add("topics covered");
        listDataHeader.add("topics not covered");

        List<String> top250 = new ArrayList<String>();
        top250.add("a");
        top250.add("b");
        top250.add("c");
        top250.add("d");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("e");
        nowShowing.add("f");
        nowShowing.add("g");
        nowShowing.add("h");

        List<String> commingSoon = new ArrayList<String>();
        commingSoon.add("i");
        commingSoon.add("j");
        commingSoon.add("k");
        commingSoon.add("l");

        //List<String> workon = new ArrayList<String>();
        //workon.add("Start Activity and Start Activity Result");
        listChildData.put(listDataHeader.get(0), top250);
        listChildData.put(listDataHeader.get(1), nowShowing);
        listChildData.put(listDataHeader.get(2), commingSoon);
        //listChildData.put(listDataHeader.get(3), workon);

        //expandableListView.setOnGroupExpandListener();
    }
}





