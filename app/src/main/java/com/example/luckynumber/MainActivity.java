package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //declaring and initialising the widgets first
    EditText editText;
    Button btn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt= findViewById(R.id.first_txt);
        btn= findViewById(R.id.btn);
        editText= findViewById(R.id.edit_text);

        //declaring and initialise these widgets
        //adding functionality to the button..use listeners

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*directing the user to the second activity...but we
                need to get his name and pass it to the second act.
                 */

                //passing data b/w activity
                String userName = editText.getText().toString(); //userNme is a var.

                //using Explicit Intent..as we are navigating b/w the compo.s of the app
                Intent i= new Intent(
                        getApplicationContext(),  /*here this was showing error becos had no context
                                            thus got a package context variable which returns context*/
                        SecondActivity.class         //destination
                );

                //passing name to the second activity

                /*putExtra method- used to include add. data with an intent obj
                This data passes with the intent and can be retrieved by by the receiving compo.
                This method is overloaded with var. versions to accom. diff types of data like
                strings, int, boolean, more complex objs that implement serializable and parsable
                interfaces
                 */
                i.putExtra("name",userName); //key is 'name' and value passing is userName

                startActivity(i);
                //whenever we use intent we use startActivity method
                

            }
        });





    }
}