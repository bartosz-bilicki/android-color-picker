package com.bb.android.example.activities;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.bb.android.example.R;
import com.bb.android.example.model.Question;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements ColorChangedCallback {

    private List<Question> questions;
    private Question q;

    public MainActivity() {
        questions=new ArrayList<Question>();
        questions.add(new Question("true",true));
        questions.add(new Question("false",false));
    }

    @InjectView(R.id.button_true)
    Button mButtonTrue;

    @InjectView(R.id.button_false)
    Button mButtonFalse;

    @InjectView(R.id.button)
    Button mButton;

    @InjectView(R.id.text_question)
    TextView mTextQuestion;

    private PopupWindow popupWindow;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ButterKnife.inject(this);

        q=questions.get(0);
        mTextQuestion.setText(q.getText());

        initPopupWindow();
    }

    private void initPopupWindow(){
        LayoutInflater layoutInflater= (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.grid, null);

        popupWindow = new PopupWindow(
                popupView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        popupView=popupWindow.getContentView();
        ImageView imageView1 = (ImageView) popupView.findViewById(R.id.imageView1);
        ImageView imageView2 = (ImageView) popupView.findViewById(R.id.imageView2);
        ImageView imageView3 = (ImageView) popupView.findViewById(R.id.imageView3);
        ImageView imageView4 = (ImageView) popupView.findViewById(R.id.imageView4);

        imageView1.setOnClickListener(new PopupOnClickListener(popupWindow, this));
        imageView2.setOnClickListener(new PopupOnClickListener(popupWindow, this));
        imageView3.setOnClickListener(new PopupOnClickListener(popupWindow, this));
        imageView4.setOnClickListener(new PopupOnClickListener(popupWindow, this));

        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());

        imageView1.performClick();
    }

    @OnClick(R.id.button_true)
    public void onButtonTrueClick(Button b) {
        String answer=q.isTrue()?"right":"wrong";
        Toast.makeText(MainActivity.this,answer,Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.button_false)
    public void onButtonFalseClick(Button b) {
        String answer=q.isTrue()?"wrong":"right";
        Toast.makeText(MainActivity.this,answer,Toast.LENGTH_LONG).show();
    }

    public void showPopup(View view) {
        popupWindow.showAsDropDown(view, 50, -30);
    }

    @Override
    public void onColorChanged(int color) {
        Log.d(MainActivity.class.toString(), "onColorChanged");
        mButton.setBackgroundColor(color);
    }
}
