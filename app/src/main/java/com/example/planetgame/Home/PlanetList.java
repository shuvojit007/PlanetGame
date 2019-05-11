package com.example.planetgame.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Point;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.example.planetgame.R;
import com.example.planetgame.StartAnimationView;

public class PlanetList extends AppCompatActivity {

    private int ScreenWidth;
    private int ScreenHeight;
    Context cn;

    RecyclerView rec;

    ImageView rocket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_list);
        cn =this;
        init();
    }

    public void init(){
        rec = findViewById(R.id.rec);
        rec.setLayoutManager(new LinearLayoutManager(cn));
        rec.setHasFixedSize(true);


        rocket =findViewById(R.id.rocket);

        GetScreenInfo();
        TranslateAnimation mAnimation = new TranslateAnimation(0,0,0,-(ScreenHeight/3));
        mAnimation.setDuration(800);
        mAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                rocket.setTranslationY(-(ScreenHeight/3));
                final Animation anim_out= AnimationUtils.loadAnimation(cn,android.R.anim.fade_out);
                anim_out.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        rocket.setVisibility(View.GONE);
                        rec.setAdapter(new PlanetAdapter(cn));
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                anim_out.setDuration(500);
                rocket.startAnimation(anim_out);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        rocket.setAnimation(mAnimation);
    }


    private void GetScreenInfo() {
        WindowManager wm = this.getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point point = new Point();
        disp.getSize(point);
        ScreenWidth = point.x;
        ScreenHeight = point.y;

    }






}
