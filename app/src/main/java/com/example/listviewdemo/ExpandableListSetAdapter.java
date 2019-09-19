package com.example.listviewdemo;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

class ExpandableListSetAdapter extends BaseExpandableListAdapter {
    Context context;
    List<String> _listDataHeader;
    HashMap<String, List<String>> _listChildData;
    private int i;
    private boolean b;
    private View view;
    private ViewGroup viewGroup;

    public ExpandableListSetAdapter(MainActivity mainActivity, List<String> listDataHeader, HashMap<String, List<String>> listChildData) {
        this.context=mainActivity;
        this._listDataHeader=listDataHeader;
        this._listChildData=listChildData;
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return this._listChildData.get(this._listDataHeader.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return this._listDataHeader.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return this._listChildData.get(this._listDataHeader.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

   /* public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        this.i = i;
        this.b = b;
        this.view = view;
        this.viewGroup = viewGroup;
        return null;
    }*/
    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        final String headerTitle = (String) getGroup(i);
        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.list_view,null);
        }
        TextView listHeader = (TextView) view.findViewById(R.id.listViewHeader);
        listHeader.setTypeface(null, Typeface.BOLD);
        listHeader.setText(headerTitle);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {

        final String childText = (String) getChild(i,i1);
        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.list_groups,null);
        }
        TextView textViewChild = (TextView) view.findViewById(R.id.listViewItem);
        textViewChild.setText(childText);
        return view;
    }


    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}




