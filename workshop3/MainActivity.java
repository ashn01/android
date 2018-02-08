package com.example.youngmin_mac.workshop3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button username = findViewById(R.id.btUser);
        final Button password = findViewById(R.id.btPass);
        final Button login = findViewById(R.id.btLogin);
        final Intent itUser = new Intent(this,UserActivity.class);
        final Intent itPass = new Intent(this,PassActivity.class);
        final Intent itLogin = new Intent(this,LoginActivity.class);

        username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = getTextFromEditText((EditText)findViewById(R.id.etUsername));
                itUser.putExtra("username",str);
                startActivity(itUser);
            }
        });

        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = getTextFromEditText((EditText)findViewById(R.id.etPassword));
                itPass.putExtra("password",str);
                startActivity(itPass);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = getTextFromEditText((EditText)findViewById(R.id.etUsername));
                String str2 = getTextFromEditText((EditText)findViewById(R.id.etPassword));

                itLogin.putExtra("username",str);
                itLogin.putExtra("password",str2);
                startActivity(itLogin);
            }
        });
    }

    protected String getTextFromEditText(EditText et)
    {
        return et.getText().toString();
    }
}
