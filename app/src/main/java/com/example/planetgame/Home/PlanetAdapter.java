package com.example.planetgame.Home;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.planetgame.R;

import java.util.ArrayList;
import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter {

    Context cn;

    List<String>name;
    public PlanetAdapter(Context cn ) {
        this.cn = cn;
        name =new ArrayList<>();
        name.add("Introduction");
        name.add("Output");
        name.add("Variable");
        name.add("User Input");
        name.add("Math");
        name.add("Ice Cream");
        name.add("Condition");
        name.add("List");
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(cn).inflate(R.layout.planet_left, parent, false);
                return new ViewHolder1(view);
            case 1:
                view = LayoutInflater.from(cn).inflate(R.layout.planet_right, parent, false);
                return new ViewHolder2(view);
        }
        return null;

    }


    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        holder.setIsRecyclable(false);

        if (position % 2 == 0) {
            ((ViewHolder1) holder).Update( position);
           
        } else {
            ((ViewHolder2) holder).Update(position);
           
        }
    }

    @Override
    public int getItemCount() {
        return name.size();
    }


    public class ViewHolder1 extends RecyclerView.ViewHolder {
        public View mView;

        RelativeLayout planet;
        ImageView planetimg;

        RelativeLayout circle;



        private ViewHolder1(View itemView) {
            super(itemView);

            planetimg = itemView.findViewById(R.id.planetimg);
            planet= itemView.findViewById(R.id.planet);
            circle =itemView.findViewById(R.id.circle);
            mView = itemView;
        }


        public void Update(int position) {
         //   TranslateAnimation anim = new TranslateAnimation(-200, 200, 0, 0);
         //   anim.setDuration(1000);
//
//            anim.setAnimationListener(new TranslateAnimation.AnimationListener() {
//
//
//
//                @Override
//                public void onAnimationStart(Animation animation) { }
//
//                @Override
//                public void onAnimationRepeat(Animation animation) { }
//
//                @Override
//                public void onAnimationEnd(Animation animation)
//                {
//                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)planetimg.getLayoutParams();
//                   //params.topMargin += amountToMoveDown;
//                    params.leftMargin += 200;
//                    planetimg.setLayoutParams(params);
//                }
//            });
//

            TranslateAnimation mAnimation = new TranslateAnimation(-200,0,0,0);
            mAnimation.setDuration(1000);
            mAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
//                    CircularView circularView = new CircularView(itemView.getContext());
//                //    circularView.setZOrderOnTop(true);    // necessary
//                    SurfaceHolder sfhTrackHolder = circularView.getHolder();
//                    sfhTrackHolder.setFormat(PixelFormat.TRANSPARENT);
//                    circle.addView(circularView);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            planet.setAnimation(mAnimation);
        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {
        public View mView;

        RelativeLayout planet;
        ImageView planetimg;
        RelativeLayout circle;

        private ViewHolder2(View itemView) {
            super(itemView);

            mView = itemView;
          //  circle = itemView.findViewById(R.id.circle);
            planetimg = itemView.findViewById(R.id.planetimg);
            planet= itemView.findViewById(R.id.planet);
        }


        public void Update(int position) {
            TranslateAnimation mAnimation = new TranslateAnimation(200,0,0,0);
            //time it will take to finish reach destination, this means how fast the view will translate
            mAnimation.setDuration(1000);

            planet.setAnimation(mAnimation);


        }
    }
}
