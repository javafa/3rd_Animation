package com.veryworks.android.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnScale;
    private Button btnAlpha;
    private Button btnTrans;
    private Button btnRotate;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btnScale = (Button) findViewById(R.id.btnScale);
        btnAlpha = (Button) findViewById(R.id.btnAlpha);
        btnTrans = (Button) findViewById(R.id.btnTrans);
        btnRotate = (Button) findViewById(R.id.btnRotate);
        imageView = (ImageView) findViewById(R.id.imageView);

        btnScale.setOnClickListener(this);
        btnAlpha.setOnClickListener(this);
        btnTrans.setOnClickListener(this);
        btnRotate.setOnClickListener(this);

        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // 작성해둔 애니메이션 설정파일 로드
        Animation animation = null;
        switch (v.getId()){
            case R.id.btnTrans:
                animation = AnimationUtils.loadAnimation(this, R.anim.trans);
                break;
            case R.id.btnRotate:
                animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
                break;
            case R.id.btnScale:
                animation = AnimationUtils.loadAnimation(this, R.anim.scale);
                break;
            case R.id.btnAlpha:
                animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
                break;
            case R.id.imageView:
                Intent intent = new Intent(this, WindmillActivity.class);
                startActivity(intent);
                break;
        }
        if(animation != null)
            imageView.startAnimation(animation);
    }
}
