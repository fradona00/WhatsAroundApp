package com.zaps.whatsaround;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout btnt,btnl,btnr;
    private SelectFragment fragment;
    private Boolean isFragmentOn=false;
    private Button selectbtn;
    private Animation rotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnt=findViewById(R.id.topbutton);
        btnl=findViewById(R.id.leftbutton);
        btnr=findViewById(R.id.rightbutton);
        selectbtn=findViewById(R.id.selectbtn);

        rotation= AnimationUtils.loadAnimation(selectbtn.getContext(),R.anim.selectanim);

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
        selectbtn.startAnimation(rotation);
        if (!isFragmentOn)
        {
            fragment=new SelectFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.mainlayout,fragment).commit();
            isFragmentOn=true;
        }
        else {
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
            isFragmentOn = false;
        }
    }
}