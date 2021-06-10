package com.example.examapp.Views;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.examapp.R;

public class QuestionAddOrModify extends AppCompatActivity {
    Button btnEditDialog,btnEditDialog1,btnEditDialog2,btnEditDialog3,btnsv;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_add_or_modify);

        btnEditDialog = findViewById(R.id.E1);
        btnEditDialog1 = findViewById(R.id.E2);
        btnEditDialog2 = findViewById(R.id.E3);
        btnEditDialog3 = findViewById(R.id.E4);
        btnsv = findViewById(R.id.buttonsv);





        btnEditDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ViewGroup viewGroup = findViewById(R.id.LinearLayoutEdit);

                EditText editText1;
                Button btn1;

                RadioButton RR1,RR2,RR3,RR4;

                AlertDialog.Builder builder = new AlertDialog.Builder(QuestionAddOrModify.this);
                View view1 = LayoutInflater.from(QuestionAddOrModify.this).inflate(R.layout.aleredittxml,viewGroup,false);
                builder.setCancelable(false);
                builder.setView(view1);

                editText1 = view1.findViewById(R.id.txt_edit);
                btn1 = view1.findViewById(R.id.btn_edit);

                RR1 = findViewById(R.id.radioButton1);
                RR2 = findViewById(R.id.radioButton2);
                RR3 = findViewById(R.id.radioButton3);
                RR4 = findViewById(R.id.radioButton4);

                AlertDialog alertDialog = builder.create();

                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(QuestionAddOrModify.this,"Done",Toast.LENGTH_LONG).show();
                        RR1.setText(editText1.getText());
                        alertDialog.hide();

                    }
                });

                alertDialog.show();
            }
        });

        btnEditDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ViewGroup viewGroup = findViewById(R.id.LinearLayoutEdit);

                EditText editText1;
                Button btn1;

                RadioButton RR2;

                AlertDialog.Builder builder = new AlertDialog.Builder(QuestionAddOrModify.this);
                View view1 = LayoutInflater.from(QuestionAddOrModify.this).inflate(R.layout.aleredittxml,viewGroup,false);
                builder.setCancelable(false);
                builder.setView(view1);

                editText1 = view1.findViewById(R.id.txt_edit);
                btn1 = view1.findViewById(R.id.btn_edit);

                RR2 = findViewById(R.id.radioButton2);

                AlertDialog alertDialog = builder.create();

                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(QuestionAddOrModify.this,"Done",Toast.LENGTH_LONG).show();
                        RR2.setText(editText1.getText());
                        alertDialog.hide();

                    }
                });

                alertDialog.show();
            }
        });

        btnEditDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ViewGroup viewGroup = findViewById(R.id.LinearLayoutEdit);

                EditText editText1;
                Button btn1;

                RadioButton RR3;

                AlertDialog.Builder builder = new AlertDialog.Builder(QuestionAddOrModify.this);
                View view1 = LayoutInflater.from(QuestionAddOrModify.this).inflate(R.layout.aleredittxml,viewGroup,false);
                builder.setCancelable(false);
                builder.setView(view1);

                editText1 = view1.findViewById(R.id.txt_edit);
                btn1 = view1.findViewById(R.id.btn_edit);

                RR3 = findViewById(R.id.radioButton3);

                AlertDialog alertDialog = builder.create();

                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(QuestionAddOrModify.this,"Done",Toast.LENGTH_LONG).show();
                        RR3.setText(editText1.getText());
                        alertDialog.hide();

                    }
                });

                alertDialog.show();
            }
        });

        btnEditDialog3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ViewGroup viewGroup = findViewById(R.id.LinearLayoutEdit);

                EditText editText1;
                Button btn1;

                RadioButton RR4;

                AlertDialog.Builder builder = new AlertDialog.Builder(QuestionAddOrModify.this);
                View view1 = LayoutInflater.from(QuestionAddOrModify.this).inflate(R.layout.aleredittxml,viewGroup,false);
                builder.setCancelable(false);
                builder.setView(view1);

                editText1 = view1.findViewById(R.id.txt_edit);
                btn1 = view1.findViewById(R.id.btn_edit);

                RR4 = findViewById(R.id.radioButton4);

                AlertDialog alertDialog = builder.create();

                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(QuestionAddOrModify.this,"Done",Toast.LENGTH_LONG).show();
                        RR4.setText(editText1.getText());
                        alertDialog.hide();

                    }
                });

                alertDialog.show();
            }
        });

        btnsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Qustion = editText.getText().toString();

            }
        });





    }
//    public void onCustomAlertDialog(View v) {
//        LayoutInflater inflater = getLayoutInflater();
//        View adView = inflater.inflate(R.layout.aleredittxml, null, false);
//        final EditText edt = adView.findViewById(R.id.txt_edit);
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Edit Option");
//        builder.setCancelable(false);
//
//        builder.setPositiveButton("Edit", DialogInterface.OnClickListener(onCustomAlertDialog())
//
//
//
//        builder.setNegativeButton("Cansle", onClick(dialog, which) {
//            String cerd = "Password: " + txt_edit.getText().toString();
//
//            Toast.makeText( QuestionAddOrModify.this, cerd, Toast.LENGTH_LONG).show();
//            dialog.dismiss();
//
//        });
//
//
//
//    }
}