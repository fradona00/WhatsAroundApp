package com.zaps.whatsaround;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SelectFragment extends Fragment {

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

        ArrayList<ListItem> items=new ArrayList<>();
        items.add(new ListItem(R.drawable.airport, "Airport"));
        items.add(new ListItem(R.drawable.bank, "Bank"));
        items.add(new ListItem(R.drawable.hospital, "Hospital"));
        items.add(new ListItem(R.drawable.hotel, "Hotel"));
        /*items.add(new ListItem(R.drawable.airport, "Airport"));
        items.add(new ListItem(R.drawable.bank, "Bank"));
        items.add(new ListItem(R.drawable.hospital, "Hospital"));
        items.add(new ListItem(R.drawable.hotel, "Hotel"));
        items.add(new ListItem(R.drawable.airport, "Airport"));
        items.add(new ListItem(R.drawable.bank, "Bank"));
        items.add(new ListItem(R.drawable.hospital, "Hospital"));
        items.add(new ListItem(R.drawable.hotel, "Hotel"));*/

        FragmentListAdapter adapter=new FragmentListAdapter(items);

        RecyclerView rcv=view.findViewById(R.id.fragmentrcv);
        rcv.setHasFixedSize(true);
        LinearLayoutManager manager=new LinearLayoutManager(view.getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv.setLayoutManager(manager);
        rcv.setAdapter(adapter);
    }
}
