package com.example.quizmundoverde;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA,ansB,ansC,ansD;
    Button submitBtn;

    int score=0;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.Perguntatxt);
        ansA = findViewById(R.id.Ans_A);
        ansB = findViewById(R.id.Ans_B);
        ansC = findViewById(R.id.Ans_C);
        ansD = findViewById(R.id.Ans_D);
        submitBtn = findViewById(R.id.btn_sb);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Total de Perguntas : "+totalQuestion);



        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if(clickedButton.getId() == R.id.btn_sb){
            if(selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();


        } else{
            //choices Button
            //escolhas(possíveis) cliques de botão

            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.CYAN);


        }
    }

    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion){
            finishQuiz();
            return;
        }

        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);
    }

    void finishQuiz(){
        String passStatus;
        if(score > totalQuestion*0.60){
            passStatus = "Parabéns: você acertou!!";
        } else{
            passStatus = "você falhou...";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Sua Pontuação foi " + score+" de " + totalQuestion)
                .setPositiveButton("Tentar Novamente", (dialogInterface, i) -> restartQuiz() )
                .setNegativeButton("Voltar", (dialogInterface, i) -> voltar() )
                .setCancelable(false)
                .show();
    }

    private void restartQuiz() {
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }

    private void voltar() {
        Intent in = new Intent(MainActivity.this, Home.class);
        startActivity(in);
    }
}