package com.example.zadaniebazadanych;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class WordExtractTest extends Activity {

    TextView list;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (TextView)findViewById(R.id.list);

        loadDoc();
    }

    private void loadDoc() {

        String s = "";

        for(int x=0; x<=100; x++) {
            s += "Line: " + String.valueOf(x) + "\n";
        }

        list.setMovementMethod(new ScrollingMovementMethod());

        list.setText(s);
    }
}