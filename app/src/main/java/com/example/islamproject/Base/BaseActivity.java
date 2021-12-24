package com.example.islamproject.Base;

import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    public AlertDialog showMessage(int message, int posActionName, DialogInterface.OnClickListener onPosClick,
                                   int NegActionName, DialogInterface.OnClickListener onNegClick,
                                   boolean isCancelable){

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
         builder.setMessage(message);
         builder.setPositiveButton(posActionName,onPosClick );
        builder.setNegativeButton(NegActionName,onNegClick );
        builder.setCancelable(isCancelable);


        return builder.show();

    }



}
