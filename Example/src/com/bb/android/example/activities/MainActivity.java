package com.bb.android.example.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.bb.android.example.R;
import com.bb.android.example.model.Question;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

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

    @InjectView(R.id.text_question)
    TextView mTextQuestion;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ButterKnife.inject(this);

        q=questions.get(0);
        mTextQuestion.setText(q.getText());
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
}
