package com.nrsoftbd.phploginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    private EditText name_et, email_et, password_et;
    private Button signup;

    String name, email, password;
    String url = "https://ultrateenpatti.com/android/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        name_et = findViewById(R.id.name_et);
        email_et = findViewById(R.id.email_et);
        password_et = findViewById(R.id.password_et);

        signup = findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (name_et.getText().toString().equals("")) {

                    Toast.makeText(getApplicationContext(), "Enter your name", Toast.LENGTH_LONG).show();

                } else if (email_et.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter your email", Toast.LENGTH_LONG).show();

                } else if (password_et.getText().toString().equals("")) {

                    Toast.makeText(getApplicationContext(), "Enter your Password", Toast.LENGTH_LONG).show();

                } else {

                    SignUP();

                }


            }
        });


    }

    private void SignUP() {

        name = name_et.getText().toString().trim();
        email = email_et.getText().toString().trim();
        password = password_et.getText().toString().trim();

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();

                params.put("name", name);
                params.put("email", email);
                params.put("password", password);


                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
    }
}
