package com.android.android_lab_6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity {
    EditText fileName, lname, group, faculty, fnameread;
    Button write, read;
    TextView filecon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fileName = (EditText) findViewById(R.id.fname);
        lname = (EditText) findViewById(R.id.lname);
        group = (EditText) findViewById(R.id.group);
        faculty = (EditText) findViewById(R.id.faculty);
        fnameread = (EditText) findViewById(R.id.fnameread);
        write = (Button) findViewById(R.id.btnwrite);
        read = (Button) findViewById(R.id.btnread);
        filecon = (TextView) findViewById(R.id.filecon);
        write.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                String filename = fileName.getText().toString();
                String lname = MainActivity.this.lname.getText().toString();
                String group = MainActivity.this.group.getText().toString();
                String faculty = MainActivity.this.faculty.getText().toString();
                FileOperations fop = new FileOperations();
                fop.write(filename, lname, group, faculty);
                if (fop.write(filename, lname, group, faculty)) {
                    Toast.makeText(getApplicationContext(),
                            filename + ".txt created", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "I/O error", Toast.LENGTH_SHORT).show();

                }
            }
        });
        read.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                String readfilename = fnameread.getText().toString();
                FileOperations fop = new FileOperations();
                String text = fop.read(readfilename);
                if (text != null) {
                    filecon.setText(text);
                } else {
                    Toast.makeText(getApplicationContext(), "File not Found", Toast.LENGTH_SHORT).show();
                    filecon.setText(null);
                }

            }
        });
    }
}
