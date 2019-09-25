package com.zaps.whatsaround;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentListAdapter extends RecyclerView.Adapter<FragmentListAdapter.ViewHolder> {

    private ArrayList<ListItem[]> listdata;

    // RecyclerView recyclerView;
    public FragmentListAdapter(ArrayList<ListItem[]> listdata) {
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.rowlayout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    private void OnSelectionClick(View v,int imgid)
    {
        Toast.makeText(v.getContext(), "click on btn id:"+imgid, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final ListItem[] myListData = listdata.get(position);
        try {
            holder.textView1.setText(myListData[0].getText().replace(' ','\n'));
            holder.imageView1.setImageResource(myListData[0].getImgid());
            holder.layout1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OnSelectionClick(v, myListData[0].getImgid());
                }
            });
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
            holder.textView1.setText("");
            holder.imageView1.setImageDrawable(null);
        }
        try{
        holder.textView2.setText(myListData[1].getText().replace(' ','\n'));
        holder.imageView2.setImageResource(myListData[1].getImgid());
        holder.layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnSelectionClick(v,myListData[1].getImgid());
            }
        });
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
            holder.textView2.setText("");
            holder.imageView2.setImageDrawable(null);
        }
        try {
            holder.textView3.setText(myListData[2].getText().replace(' ','\n'));
            holder.imageView3.setImageResource(myListData[2].getImgid());
            holder.layout3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OnSelectionClick(v, myListData[2].getImgid());
                }
            });
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
            holder.textView3.setText("");
            holder.imageView3.setImageDrawable(null);
        }
        try {
            holder.textView4.setText(myListData[3].getText().replace(' ','\n'));
            holder.imageView4.setImageResource(myListData[3].getImgid());
            holder.layout4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OnSelectionClick(v, myListData[3].getImgid());
                }
            });
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
            holder.textView4.setText("");
            holder.imageView4.setImageDrawable(null);
        }
        try {
            holder.textView5.setText(myListData[4].getText().replace(' ','\n'));
            Log.d("prova",myListData[4].getText());
            holder.imageView5.setImageResource(myListData[4].getImgid());
            holder.layout5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OnSelectionClick(v, myListData[4].getImgid());
                }
            });
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
            holder.textView5.setText("");
            holder.imageView5.setImageDrawable(null);
        }
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView1;
        public TextView textView1;
        public LinearLayout layout1;
        public ImageView imageView2;
        public TextView textView2;
        public LinearLayout layout2;
        public ImageView imageView3;
        public TextView textView3;
        public LinearLayout layout3;
        public ImageView imageView4;
        public TextView textView4;
        public LinearLayout layout4;
        public ImageView imageView5;
        public TextView textView5;
        public LinearLayout layout5;


        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView1 = itemView.findViewById(R.id.image1);
            this.textView1 = itemView.findViewById(R.id.textView1);
            this.layout1=itemView.findViewById(R.id.layout1);
            this.imageView2 = itemView.findViewById(R.id.image2);
            this.textView2= itemView.findViewById(R.id.textView2);
            this.layout2=itemView.findViewById(R.id.layout2);
            this.imageView3 = itemView.findViewById(R.id.image3);
            this.textView3= itemView.findViewById(R.id.textView3);
            this.layout3=itemView.findViewById(R.id.layout3);
            this.imageView4 = itemView.findViewById(R.id.image4);
            this.textView4= itemView.findViewById(R.id.textView4);
            this.layout4=itemView.findViewById(R.id.layout4);
            this.imageView5 = itemView.findViewById(R.id.image5);
            this.textView5= itemView.findViewById(R.id.textView5);
            this.layout5=itemView.findViewById(R.id.layout5);

        }
    }
}
