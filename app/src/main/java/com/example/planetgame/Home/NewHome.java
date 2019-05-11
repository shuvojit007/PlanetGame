package com.example.planetgame.Home;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Point;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

import com.example.planetgame.R;

public class NewHome extends AppCompatActivity {

    private int ScreenWidth;
    private int ScreenHeight;
    private static final String TAG = "NewHome";

    ImageView rocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_new_home);


        rocket = findViewById(R.id.rocket);


        GetScreenInfo();
        final ValueAnimator val = ValueAnimator.ofFloat(0, -ScreenHeight);
        val.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                rocket.setTranslationY(value);


                if (Math.abs(value) < ScreenHeight / 6) {
                    rocket.setTranslationX((float) (4 * Math.cos(value * Math.PI)));
                    Log.d(TAG, "true");
                }


                Log.d(TAG, "value -> : " + Math.abs(value) + " h-> " + ScreenHeight / 6);


            }
        });
        val.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                startActivity(new Intent(NewHome.this,PlanetList.class));
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        val.setInterpolator(new AccelerateInterpolator(2.5f));
        val.setDuration(5000);
        val.start();

    }


    private void GetScreenInfo() {
        WindowManager wm = this.getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point point = new Point();
        disp.getSize(point);
        ScreenWidth = point.x;
        ScreenHeight = point.y;

    }


    public void AdvanceAnim() {

        final SpringAnimation anim = new SpringAnimation(rocket, DynamicAnimation.Y, 0)
                .setStartVelocity(5000);

        anim.start();
    }
}
