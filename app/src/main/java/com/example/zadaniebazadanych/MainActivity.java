package com.example.zadaniebazadanych;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView lst;
    EditText studentid;
    EditText studentname;
    EditText v3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lst = (TextView) findViewById(R.id.list);

        studentid = (EditText) findViewById(R.id.studentID);
        studentname = (EditText) findViewById(R.id.studentName);
        v3 = (EditText) findViewById(R.id.vV3);

        lst.setMovementMethod(new ScrollingMovementMethod());

    }

    public void addStudent (View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 2);

        int id = Integer.parseInt(studentid.getText().toString());
        String name = studentname.getText().toString();
        String v =    v3.getText().toString();

        Student student = new Student(id,name,v);

        dbHandler.addHandler(student);

        studentid.setText("");
        studentname.setText("");
        v3.setText("");
        Toast.makeText(MainActivity.this, "Record added", Toast.LENGTH_LONG).show();
        lst.setText(dbHandler.loadHandler());

    }




    public void loadStudents(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 2);
        lst.setText(dbHandler.loadHandler());
        studentid.setText("");
        studentname.setText("");
        v3.setText("");
        Toast.makeText(MainActivity.this, "Refreshed", Toast.LENGTH_LONG).show();
    }

    public void deleteStudent(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null,
                null, 2);
        boolean result = dbHandler.deleteHandler(Integer.parseInt(
                studentid.getText().toString()));
        if (result) {
            studentid.setText("");
            studentname.setText("");
            v3.setText("");
            Toast.makeText(MainActivity.this, "Record deleted", Toast.LENGTH_LONG).show();
            lst.setText(dbHandler.loadHandler());
        } else
            Toast.makeText(MainActivity.this, "No Match Found", Toast.LENGTH_LONG).show();

    }

    public void updateStudent(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null,
                null, 2);
        boolean result = dbHandler.updateHandler(Integer.parseInt(
                studentid.getText().toString()), studentname.getText().toString(),v3.getText().toString());
        if (result) {
            studentid.setText("");
            studentname.setText("");
            v3.setText("");
            Toast.makeText(MainActivity.this, "Record Updated", Toast.LENGTH_LONG).show();
            lst.setText(dbHandler.loadHandler());
        } else
            Toast.makeText(MainActivity.this, "No Match Found", Toast.LENGTH_LONG).show();



    }


}