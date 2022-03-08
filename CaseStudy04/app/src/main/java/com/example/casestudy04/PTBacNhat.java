package com.example.casestudy04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PTBacNhat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptbac_nhat);
        EditText etA= findViewById(R.id.etA);
        EditText etB= findViewById(R.id.etB);
        Button btnGiai= findViewById(R.id.btnGiai);

        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                double a=Double.parseDouble(etA.getText().toString().trim()),
                b=Double.parseDouble(etB.getText().toString().trim());
                intent.putExtra("kq",giaiPTBacNhat(a,b));
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
    public String giaiPTBacNhat(double a, double b){
        String s="";
        if (a == 0)
            if (b == 0)
                s+=("Có vô số nghiệm");
            else
               s+=("Vô nghiệm");
        else
           s+=(String.format("Có 1 nghiệm đơn: x=%f", -b / a));
        return s;
    }
}