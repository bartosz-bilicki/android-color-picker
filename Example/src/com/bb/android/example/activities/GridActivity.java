package com.bb.android.example.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.bb.android.example.R;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends Activity {

    @InjectView(R.id.imageView1)
    ImageView imageView1;

    @InjectView(R.id.imageView2)
    ImageView imageView2;

    @InjectView(R.id.imageView3)
    ImageView imageView3;

    @InjectView(R.id.imageView4)
    ImageView imageView4;



    public GridActivity() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);
        ButterKnife.inject(this);
    }

    public void color1(View view) {
       imageView1.setPadding(1,1,1,1);
       imageView2.setPadding(0,0,0,0);
       imageView3.setPadding(0,0,0,0);
       imageView4.setPadding(0,0,0,0);
    }

    public void color2(View view) {
        imageView1.setPadding(0,0,0,0);
        imageView2.setPadding(1,1,1,1);
        imageView3.setPadding(0,0,0,0);
        imageView4.setPadding(0,0,0,0);
    }

    public void color3(View view) {
        imageView1.setPadding(0,0,0,0);
        imageView2.setPadding(0,0,0,0);
        imageView3.setPadding(1,1,1,1);
        imageView4.setPadding(0,0,0,0);
    }

    public void color4(View view) {
        imageView1.setPadding(0,0,0,0);
        imageView2.setPadding(0,0,0,0);
        imageView3.setPadding(0,0,0,0);
        imageView4.setPadding(1,1,1,1);
    }
}
