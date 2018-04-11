package com.ajeng.aplikasi1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button BtnLogin;
    Button BtnClear;
    EditText User;
    EditText Pass;
    SharedPreferences sharedpref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sharedpref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
        if(sharedpref.contains("username")){
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            intent.putExtra("username", sharedpref.getString("username", "none"));
            startActivity(intent);
            finish();
        }else {

        }
        User = (EditText) findViewById(R.id.edituser);
        Pass = (EditText) findViewById(R.id.editpass);
        BtnLogin = (Button) findViewById(R.id.btnlogin);
        BtnClear = (Button) findViewById(R.id.btnclear);
        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameKey = User.getText().toString();
                String passwordKey = Pass.getText().toString();
                if (usernameKey.equals("ajeng") && passwordKey.equals("123")) {
                    Toast.makeText(getApplicationContext(), "LOGIN BERHASIL",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    MainActivity.this.startActivity(intent);
                    finish();

                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Username atau Password Anda salah!")
                            .setNegativeButton("Retry", null).create().show();
                }
            }
        });
        BtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User.setText("");
                Pass.setText("");

            }
        });
    }

}
