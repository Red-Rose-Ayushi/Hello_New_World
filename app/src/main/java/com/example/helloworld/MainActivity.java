package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    //ATTRIBUTS
    private Button btnjouer;
    private Button btnparam;

    //CREATION DE L'ACTIVITE PRINCIPALE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //ASSOCIATION DES OBJETS btn AUX XML btn
        btnjouer= (Button) findViewById(R.id.btnjouer); // objet bntjouer a xml btnjouer
        btnparam= (Button) findViewById(R.id.btnparam); // objet bntparam a xml btnparam

        //CREATION DES CLICK LISTENER DES BOUTONS JOUER ET PARAM
        btnjouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityJouer();
            }
        });
        btnparam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityParam();
            }
        });
    }

    //FONCTIONS POUR OUVRIR LES ACTIVITY POUR LES PARAMETRES ET JOUER
    public void openActivityJouer(){
        Intent intent = new Intent(this, ActivityJouer.class);
        startActivity(intent);
    }
    public void openActivityParam(){
        Intent intent = new Intent(this, ActivityParam.class);
        startActivity(intent);
    }

}