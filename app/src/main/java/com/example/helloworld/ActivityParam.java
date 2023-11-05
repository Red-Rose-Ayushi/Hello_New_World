package com.example.helloworld;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityParam extends AppCompatActivity {

    String[] langues = {"Francais","Anglais"};
    String[] themes = {"Claire","Sombre"};
    String[] utilisateurs = {"Anaelle","Leo","Eve"};
    String[] univers = {"Mathématiques","Culture générale","Divers"};
    String[] difficultés = {"Débutant","Amateur","Professionel"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_param);
        createDropDown(langues, R.id.autoComplete1);
        createDropDown(themes, R.id.autoComplete2);
        createDropDown(utilisateurs, R.id.autoComplete3);
        createDropDown(univers, R.id.autoComplete4);
        createDropDown(difficultés, R.id.autoComplete5);
    }

    public void createDropDown(String[] options, @IdRes int id){
        AutoCompleteTextView autocompleteTextView=findViewById(id);
        autocompleteTextView.setInputType(InputType.TYPE_NULL); //pour ne pas pouvoir ecrir dans l'autocomplete car le android:inputType="none" dans le xml ne marche pas
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, R.layout.dropdown,options);
        autocompleteTextView.setAdapter(adapter);
        autocompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ActivityParam.this,autocompleteTextView.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}

