package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ActivityJouer extends AppCompatActivity implements View.OnClickListener{


    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA,ansB,ansC,ansD;
    Button submitBtn;

    int score=0;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    int questions_restantes = QuestionAnswer.question.length;
    String selectedAnswer = "";
    String dificulty = "normal";
    String langue = "fr";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jouer);

        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);                                                            //liaison de la variable ansA au bouton ansA
        ansB = findViewById(R.id.ans_B);                                                            //liaison de la variable ansB au bouton ansB
        ansC = findViewById(R.id.ans_C);                                                            //liaison de la variable ansC au bouton ansC
        ansD = findViewById(R.id.ans_D);                                                            //liaison de la variable ansD au bouton ansD
        submitBtn = findViewById(R.id.submit_btn);                                                  //liaison de la variable submitBtn au bouton submit_btn

        ansA.setOnClickListener(this);                                                              //tous les boutons mis en ecoute si click dessus
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Total questions : "+totalQuestion);                         //mise en forme de la page
        loadNewQuestion();                                                                          //appel de la fonction pour charger la premiere question

    }

    @Override
    public void onClick(View view) {
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;


        if(clickedButton.getId()==R.id.submit_btn) {                                                //si le bouton appuyé est le bouton "submitt"
            if (dificulty == "test") {                                                              //si difficulté set easy
                if(selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])){     //si la réponse est juste
                    score++; }                                                                      //incrémenter le score de
                }
                                                                                                    //ci dessous idem pour autres difficultés
            if (dificulty == "easy"){if(selectedAnswer.equals(QuestionAnswer.correctAnswers_easy[currentQuestionIndex])){score++;}}
            if (dificulty == "normal"){if(selectedAnswer.equals(QuestionAnswer.correctAnswers_normal[currentQuestionIndex])){score++;}}
            if (dificulty == "hard") {if(selectedAnswer.equals(QuestionAnswer.correctAnswers_hard[currentQuestionIndex])){score++;}}

            questions_restantes--;                                                                  //décrémenter le nombre de question restante pour mettre à jour la variable de suivi
            currentQuestionIndex++;                                                                 //on passe à la questio suvante dans le tableau
            loadNewQuestion();                                                                      //appel de la fonction pour charger la question suivante


        }else{
            //choices button clicked
            selectedAnswer = clickedButton.getText().toString();                                    //mise a our de la variable de suivi de la reponse choisie
            clickedButton.setBackgroundColor(Color.MAGENTA);                                        //mise en forme de l'interface
        }

    }

    void loadNewQuestion(){                                                                         //fonction de chargement de la question et des réponses suivantes

        if(currentQuestionIndex == totalQuestion){                                                  //si on arrive à la fin des question
            finishQuiz();                                                                           //appel de la fonction pour finir le quizz
            restartQuiz();
        }




            if (dificulty == "test")
            {
                totalQuestionsTextView.setText("Total Questions = "+ questions_restantes );
                questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
                ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
                ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
                ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
                ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);
            }

            if (dificulty == "easy")
            {
                totalQuestionsTextView.setText("Total Questions = "+ questions_restantes );
                if (langue == "fr") {questionTextView.setText(QuestionAnswer.question_facile_fr[currentQuestionIndex]);}
                else if (langue == "en") {questionTextView.setText(QuestionAnswer.question_easy_en[currentQuestionIndex]);}
                ansA.setText(QuestionAnswer.choices_easy[currentQuestionIndex][0]);
                ansB.setText(QuestionAnswer.choices_easy[currentQuestionIndex][1]);
                ansC.setText(QuestionAnswer.choices_easy[currentQuestionIndex][2]);
                ansD.setText(QuestionAnswer.choices_easy[currentQuestionIndex][3]);
            }

            if (dificulty == "normal")
            {
                totalQuestionsTextView.setText("Total Questions = "+ questions_restantes );
                if (langue == "fr") {questionTextView.setText(QuestionAnswer.question_normal_fr[currentQuestionIndex]);}
                else if (langue == "en") {questionTextView.setText(QuestionAnswer.question_normal_en[currentQuestionIndex]);}
                ansA.setText(QuestionAnswer.choices_normal[currentQuestionIndex][0]);
                ansB.setText(QuestionAnswer.choices_normal[currentQuestionIndex][1]);
                ansC.setText(QuestionAnswer.choices_normal[currentQuestionIndex][2]);
                ansD.setText(QuestionAnswer.choices_normal[currentQuestionIndex][3]);
            }

            if (dificulty == "hard")
            {
                totalQuestionsTextView.setText("Total Questions = "+ questions_restantes );
                if (langue == "fr") {questionTextView.setText(QuestionAnswer.question_difficile_fr[currentQuestionIndex]);}
                else if (langue == "en") {questionTextView.setText(QuestionAnswer.question_hard_en[currentQuestionIndex]);}
                ansA.setText(QuestionAnswer.choices_hard[currentQuestionIndex][0]);
                ansB.setText(QuestionAnswer.choices_hard[currentQuestionIndex][1]);
                ansC.setText(QuestionAnswer.choices_hard[currentQuestionIndex][2]);
                ansD.setText(QuestionAnswer.choices_hard[currentQuestionIndex][3]);
            }















    }

    void finishQuiz(){
        String passStatus = "";
        if(score>totalQuestion*0.60){
            passStatus="Passed";
        }else{
            passStatus="Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is"+score+" out of"+totalQuestion)
                //.setPositiveButton("Restart", (dialogInterface, i) -> restartQuiz() )
                .show();

    }
    void restartQuiz(){                                                                             //réinitialisation des variables de suivi
        score = 0;
        currentQuestionIndex=0;
        questions_restantes=QuestionAnswer.question.length;
        loadNewQuestion();
    }







}
