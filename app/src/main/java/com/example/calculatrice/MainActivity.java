package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int val1=0;
    private int val2=0;
    private String operation="";
    private boolean isOp1=true;
    private TextView saisie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button btnclear=findViewById(R.id.btnClear);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saisie= findViewById(R.id.screen);


    }
    private void afficher(){
        if(!isOp1){
            saisie.setText(String.valueOf(val1)+""+operation+""+String.valueOf(val2));
        }
        else{
            saisie.setText(String.valueOf(val1));
        }
    }
    public void setOperator(View v) {
        switch (v.getId()) {
            case R.id.btnPlus  : operation="+";  break;
            case R.id.btnMoins : operation="-"; break;
            case R.id.btnFois  : operation="*";  break;
            case R.id.btnDiv   : operation="/";   break;
            default :
               Toast.makeText(this, "L'opérateur est introuvable",Toast.LENGTH_LONG);
                return;
        }
        isOp1=false;
        afficher();//update display show a result
    }

    public void ajouterNbr(View v){

            int val = Integer.parseInt(((Button)v).getText().toString());
            if (isOp1) {
                val1 = val1 * 10 + val;
                afficher();
            } else {
                val2 = val2 * 10 + val;
                afficher();
            }

    }
    public void calculer(View v) {
        if(isOp1) {

        } else {
            switch(operation) {
                case "+"  : val1 = val1 + val2; break;
                case "-"  : val1 = val1 - val2; break;
                case "*"  : val1 = val1 * val2; break;
                case "/"  : val1 = val1 / val2; break;
                default : return;
            }

            val2 = 0;
            isOp1 = true;
            afficher();
        }
    }

    private void clean(View v) {
        val1 = 0;
        val2 = 0;
        isOp1=true;
        operation ="";
        afficher();
    }


    }


