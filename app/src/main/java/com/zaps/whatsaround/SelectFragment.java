package com.zaps.whatsaround;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SelectFragment extends Fragment {

    private LinearLayout layout1;
    private LinearLayout layout2;
    private LinearLayout parentlayout;

    public SelectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_select, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        parentlayout=view.findViewById(R.id.parentlayout);
        layout1=parentlayout.findViewById(R.id.layout1);
        layout2=parentlayout.findViewById(R.id.layout2);

        LayoutInflater layoutInflater=LayoutInflater.from(layout1.getContext());
        View listItem= layoutInflater.inflate(R.layout.placeobj, layout1, false);
        ImageView image =listItem.findViewById(R.id.image);
        image.setImageResource(R.drawable.mechanic);
        TextView textView=listItem.findViewById(R.id.textView);
        textView.setText("Mechanic");
        //aggiungere child sul layout1
        Toast.makeText(view.getContext(), "ciao:"+layout1.getChildCount(), Toast.LENGTH_SHORT).show();
    }
}
