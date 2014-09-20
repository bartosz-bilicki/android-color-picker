package com.bb.android.example.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
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

    PopupWindow popupWindow;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ButterKnife.inject(this);

        q=questions.get(0);
        mTextQuestion.setText(q.getText());

        LayoutInflater layoutInflater= (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.grid, null);

        popupWindow = new PopupWindow(
                popupView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
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
        View  popupView=popupWindow.getContentView();
        popupView.findViewById(R.id.imageView1).setOnClickListener(new PopupOnClickListener(popupWindow,this));
        popupView.findViewById(R.id.imageView2).setOnClickListener(new PopupOnClickListener(popupWindow,this));
        popupView.findViewById(R.id.imageView3).setOnClickListener(new PopupOnClickListener(popupWindow,this));
        popupView.findViewById(R.id.imageView4).setOnClickListener(new PopupOnClickListener(popupWindow,this));
        popupWindow.showAsDropDown(view, 50, -30);
    }

    @Override
    public void onColorChanged(int color) {
        //Toast.makeText(getBaseContext(),""+color,Toast.LENGTH_SHORT).show();
        mButton.setBackgroundColor(color);
    }
}
