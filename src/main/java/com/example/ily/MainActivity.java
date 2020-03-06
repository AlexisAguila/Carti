package com.example.ily;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MainActivity extends AppCompatActivity {

    private View FindingPers;
    private ImageView MyImg, ImgA, ImgA2;
    private Handler AnimationHandle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        Glide.with(getBaseContext()).load(R.drawable.imgmyphoto).apply(new RequestOptions().circleCrop()).into(MyImg);

        findViewById(R.id.buttonStart).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                StartProgram();
            }
        });

        findViewById(R.id.buttonStop).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                EndProgram();
            }
        });

    }

    private void init(){
        this.AnimationHandle=new Handler();
        this.FindingPers=findViewById(R.id.layoutPers);
        this.MyImg=findViewById(R.id.imgMyphoto);
        this.ImgA=findViewById(R.id.imgAnim);
        this.ImgA2=findViewById(R.id.imgAnim2);
    }

    private void StartProgram(){
        this.runnableAnimation.run();
        this.FindingPers.setVisibility(View.VISIBLE);
    }

    private void EndProgram(){
        this.AnimationHandle.removeCallbacks(runnableAnimation);
        this.FindingPers.setVisibility(View.GONE);
    }

    private Runnable runnableAnimation = new Runnable() {
        @Override
        public void run() {

            ImgA.animate().scaleX(4f).scaleY(4f).alpha(0f).setDuration(1000).withEndAction(new Runnable() {
                @Override
                public void run() {
                    ImgA.setScaleX(1f);
                    ImgA.setScaleY(1f);
                    ImgA.setAlpha(1f);
                }
            });

            ImgA2.animate().scaleX(4f).scaleY(4f).alpha(0f).setDuration(700).withEndAction(new Runnable() {
                @Override
                public void run() {
                    ImgA2.setScaleX(1f);
                    ImgA2.setScaleY(1f);
                    ImgA2.setAlpha(1f);
                }
            });

            AnimationHandle.postDelayed(runnableAnimation,1700);

        }
    };












}
