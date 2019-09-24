package com.zaps.whatsaround;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//@todo modificare l'oggetto rowlayout.xml aggiungendo 5 items cosi non fa casini con l'oggetto Inflater

public class FragmentListAdapter extends RecyclerView.Adapter<FragmentListAdapter.ViewHolder> {

    private ArrayList<ListItem> listdata;
    private int objCount;
    private int rowCount;
    private LinearLayout rowLayout;
    private View listrowView;
    private LayoutInflater rowInflater;
    private ViewGroup rowViewGroup;

    // RecyclerView recyclerView;
    public FragmentListAdapter(ArrayList<ListItem> listdata) {
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (objCount==0 || objCount % 5 == 0)
        {
            listrowView = layoutInflater.inflate(R.layout.rowlayout, parent, false);
            rowViewGroup= (ViewGroup) listrowView;
            rowInflater=LayoutInflater.from(listrowView.getContext());
            rowCount++;
            Log.d("ROWCOUNT",String.valueOf(rowCount));
        }
        View listItem= layoutInflater.inflate(R.layout.placeobj, rowViewGroup, false);
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
