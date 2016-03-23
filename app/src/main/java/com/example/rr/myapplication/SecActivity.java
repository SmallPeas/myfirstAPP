package com.example.rr.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by 若冰RR on 2016/3/21.
 */
public class SecActivity extends AppCompatActivity {
    private EditText mEditText;
    private Button mButton;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_sec);
        Intent intent =getIntent();
        mEditText= (EditText) findViewById(R.id.edittext);
        mButton= (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String text=mEditText.getText().toString();
                Intent intent=new Intent();
                intent.putExtra("text",text);
                setResult(RESULT_OK,intent);
                SecActivity.this.finish();;
            }
        });



    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
