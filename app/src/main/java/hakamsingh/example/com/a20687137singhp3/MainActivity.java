package hakamsingh.example.com.a20687137singhp3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.Menu;
import android.view.MenuItem;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    Button login,practice;
    String id;
    EditText userName;
    public static final String MyPREFERENCES = "MyPrefs" ;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button)findViewById(R.id.login);
        userName = (EditText)findViewById(R.id.username) ;
        sharedpreferences=getSharedPreferences("login",MODE_PRIVATE);

        //if SharedPreferences contains username and password then directly redirect to Home activity
        if(sharedpreferences.contains("id")) {
            Intent ii = new Intent(getApplicationContext(),Application.class);
            //         ii.putExtra("name",id);
            startActivity(ii); finish();   //finish current activity
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // SharedPreferences     sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

                id = userName.getText().toString();

                if(id.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Username is Empty", Toast.LENGTH_SHORT).show();
                }
                else{
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("id", userName.getText().toString());
                editor.commit();
                //startActivity(new Intent(getApplicationContext(),Application.class));
                Intent ii = new Intent(getApplicationContext(),Application.class);
                ii.putExtra("name",userName.getText().toString());
                startActivity(ii);
                finish();}

            }
        });



    }



}
