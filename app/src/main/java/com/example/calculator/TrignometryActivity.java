package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TrignometryActivity extends AppCompatActivity {


    EditText editText;
    TextView textView;
    Button button;
    private RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trignometry);

        editText  =findViewById(R.id.edittex_trignometry);
        textView = findViewById(R.id.textView_trignometry);
        button = findViewById(R.id.buttonsubmit_trignometry);


        radioGroup = (RadioGroup)findViewById(R.id.groupradio);

        // Uncheck or reset the radio buttons initially
        radioGroup.clearCheck();

        // Add the Listener to the RadioGroup
        radioGroup.setOnCheckedChangeListener(
                new RadioGroup
                        .OnCheckedChangeListener() {
                    @Override

                    // The flow will come here when
                    // any of the radio buttons in the radioGroup
                    // has been clicked

                    // Check which radio button has been clicked
                    public void onCheckedChanged(RadioGroup group,
                                                 int checkedId)
                    {

                        // Get the selected Radio Button
                        RadioButton
                                radioButton
                                = (RadioButton)group
                                .findViewById(checkedId);
                    }
                });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double ans = Double.parseDouble(editText.getText().toString());

                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(TrignometryActivity.this,
                                    "No answer has been selected",
                                    Toast.LENGTH_SHORT)
                            .show();
                }
                else {

                    RadioButton radioButton
                            = (RadioButton)radioGroup
                            .findViewById(selectedId);

                    if(radioButton.getText().equals("Sin")){
                         String strDouble = String. format("%.2f",Math.sin(Math.toRadians(ans)));
                         textView.setText(strDouble);

                    }else if(radioButton.getText().equals("Cos")){
                        String strDouble = String. format("%.2f",Math.cos(Math.toRadians(ans)));
                        textView.setText(strDouble);
                    }
                    else if(radioButton.getText().equals("tan")){
                        String strDouble = String. format("%.2f",Math.tan(Math.toRadians(ans)));
                        textView.setText(strDouble);
                    }else if(radioButton.getText().equals("cosec")){
                        String strDouble = String. format("%.2f",1/Math.sin(Math.toRadians(ans)));
                        textView.setText(strDouble);
                    }else if(radioButton.getText().equals("sec")){
                        String strDouble = String. format("%.2f",1/Math.cos(Math.toRadians(ans)));
                        textView.setText(strDouble);
                    }else if(radioButton.getText().equals("cot")){
                        String strDouble = String. format("%.2f",1/Math.tan(Math.toRadians(ans)));
                        textView.setText(strDouble);
                    }
                }
            }
        });


    }

    public void retry2(View v){
        Intent intent = new Intent(this,TrignometryActivity.class);
        startActivity(intent);
        finish();
    }
}