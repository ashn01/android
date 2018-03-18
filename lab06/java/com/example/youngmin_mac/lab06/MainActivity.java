package com.example.youngmin_mac.lab06;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button add,view,find,delete;
    private EditText id,name,grade;
    private SQLManager sqlman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sql
        sqlman = new SQLManager(this);


        id = findViewById(R.id.idTextField);
        name = findViewById(R.id.nameTextField);
        grade = findViewById(R.id.gradeTextField);

        add = findViewById(R.id.addBtn);
        view = findViewById(R.id.viewBtn);
        find = findViewById(R.id.findBtn);
        delete = findViewById(R.id.deleteBtn);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student s = new Student(id.getText().toString(),name.getText().toString(),grade.getText().toString());
                sqlman.add(s);
                String msg = "ID: "+id.getText().toString() +" Name: "+name.getText().toString()+
                        " Grade: "+ grade.getText().toString();
                makeDialogAlert("The following student was added",msg,"CLOSE");
                clearTextField(id,name,grade);
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Student> list = sqlman.viewAll();
                String str = "";
                if(list.isEmpty())
                {
                    makeDialogAlert("No students were found",str,"CLOSE");
                }
                else {
                    for (Student s : list) {
                        str += "ID: " + s.getID() + " name: " + s.getName() + " grade: " + s.getGrade() + "\n";
                    }
                    makeDialogAlert("The following students have been added", str, "CLOSE");
                }
            }
        });

        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str="";

                List<Student> list = sqlman.view(id.getText().toString());
                if(list.isEmpty())
                    makeDialogAlert("This student does not exist", str, "CLOSE");
                else {
                    for (Student s : list) {
                        str += "ID: " + s.getID() + " name: " + s.getName() + " grade: " + s.getGrade() + "\n";
                    }
                    makeDialogAlert("Student details are as follows", str, "CLOSE");
                }
                clearTextField(id,name,grade);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Student> list = sqlman.view(id.getText().toString());
                String str = "";
                if(list.isEmpty())
                {
                    makeDialogAlert("This student does not exist", str, "CLOSE");
                }
                else {
                    sqlman.delete(id.getText().toString());
                    for (Student s : list) {
                        str += "ID: " + s.getID() + " name: " + s.getName() + " grade: " + s.getGrade() + "\n";
                    }
                    makeDialogAlert("The following student has been deleted", str, "CLOSE");
                }
                clearTextField(id, name, grade);
            }
        });

    }
    private void clearTextField(EditText t1,EditText t2,EditText t3 )
    {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t1.requestFocus();
    }

    private void makeDialogAlert(String title, String msg, String button)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle(title);
        alert.setMessage(msg);
        alert.setPositiveButton(button,null);
        alert.show();
    }
}
