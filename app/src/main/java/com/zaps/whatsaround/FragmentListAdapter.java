package com.zaps.whatsaround;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentListAdapter extends RecyclerView.Adapter<FragmentListAdapter.ViewHolder> {

    private ArrayList<ListItem> listdata;
    private int objCount;
    private int rowCount;
    private LinearLayout rowLayout;
    private View listrowView;
    private LayoutInflater rowInflater;
    private ViewGroup rowView;

    // RecyclerView recyclerView;
    public FragmentListAdapter(ArrayList<ListItem> listdata) {
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (objCount==0 || objCount % 5 == 0)
        {
            rowLayout=new LinearLayout(parent.getContext());
            rowLayout.setOrientation(LinearLayout.HORIZONTAL);
            listrowView = layoutInflater.inflate(R.layout.rowlayout, parent, false);
            rowView= (ViewGroup) parent.getChildAt(rowCount);
            rowInflater=LayoutInflater.from(parent.getChildAt(rowCount).getContext());
            rowCount++;
        }
        View listItem= layoutInflater.inflate(R.layout.placeobj, rowView, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        objCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ListItem myListData = listdata.get(position);
        holder.textView.setText(listdata.get(position).getText());
        holder.imageView.setImageResource(listdata.get(position).getImgid());

    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.image);
            this.textView = itemView.findViewById(R.id.textView);
        }
    }
}
