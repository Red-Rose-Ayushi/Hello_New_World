package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;

//coucou Anaelle

public class MainActivity extends AppCompatActivity {

    private Button btnjouer;
    private Button btnparam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnjouer= (Button) findViewById(R.id.btnjouer); // On associe l'objet bntjouer au xml btnjouer
        btnjouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onpenActivityJouer();
            }
        });
    }
    public void onpenActivityJouer(){
        Intent intent = new Intent(this, ActivityJouer.class);
        startActivity(intent);
    }
}