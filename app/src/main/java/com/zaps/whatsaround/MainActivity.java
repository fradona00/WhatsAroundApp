package com.zaps.whatsaround;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout btnt,btnl,btnr;
    private SelectFragment fragment;
    private Boolean isFragmentOn=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnt=findViewById(R.id.topbutton);
        btnl=findViewById(R.id.leftbutton);
        btnr=findViewById(R.id.rightbutton);

        btnt.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "LongClick on button:"+v.getId(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (isFragmentOn)
        {
            isFragmentOn=false;
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        }
        else
        {
            super.onBackPressed();
        }
    }

    public void onPreferenceBtnClick(View v){
        Toast.makeText(this, "Button:"+v.getId()+" clicked!", Toast.LENGTH_SHORT).show();
    }

    public void onSelectBtnClick(View v){
        if (!isFragmentOn)
        {
            fragment=new SelectFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.mainlayout,fragment).commit();
            isFragmentOn=true;
        }
    }
}