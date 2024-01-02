package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView welcomeTxt, luckyTxt;
    Button share_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        welcomeTxt = findViewById(R.id.text_view2);
        luckyTxt = findViewById(R.id.lucky_text);
        share_btn = findViewById(R.id.btn2);

                   //we'll learn how to receive and store data into specific variables

        Intent i = getIntent(); /*this ,method allows to get the key & value pairs stored in the
                                     putExtra() method to get intent*/
                  //getIntent() method- retrieve this key and value pairs
        String userName = i.getStringExtra("name");
                  //here we stored the intent received in a string where "name"<- key
                  //receiving and storing done

                 //Now, sharing the generated no. among other apps
                 //Generating random no.s
                 //displaying the lucky no. got by calling the method that returns int
        int random_num = generateRandomNumber();
        luckyTxt.setText(""+random_num);

        //sharing the results
        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 //adding functionality
                shareData(userName, random_num);
            }
        });

    }


                   //generating random no.s and learning about Random class
    public int generateRandomNumber()
    {
        Random random = new Random();
               //created an instance of random class
        int upper_limit  = 1000; //upper lim- max no. that this class can generate
        int randomNumberGenerated = random.nextInt(upper_limit);
              //stored the no. generated from the random class
              //specifying limit now it can generate from 0-1000
        return randomNumberGenerated;


    }
    public void shareData(String username, int randomNum){
        //Implicit intent
    Intent i = new Intent(Intent.ACTION_SEND);
                /*Action_send is a predefined constant that represents an
                action to send data typically used to share content, typically
                used to share content with other apps or computers on the device.
                It's part of the Android systems intent mech. , which
                 enables communication between diff compo.s of same or bet diff apps
                 */
                   //here we sending the data using intent action send to other apps
    i.setType("text/plain"); //telling that we are sharing data of string type and it is s a plain text.
             //additional info
    i.putExtra(Intent.EXTRA_SUBJECT,username + "got lucky today");
             //concatinated the username with got lucky today
             //extra sub and text- cons used as keys to attach additional data to an-
             // -intent. when we want to perform an action like sending data to another app using action send intent
             //these extras are used when we want to prepopulate the subj and text fields when sharing contents like emails or messages
             //=here preferable sharing with emails becoz we are using the title and the subj
        i.putExtra(Intent.EXTRA_TEXT , "Hey! My Lucky Number is: "+ randomNum);
             //adding extra intent for the body of the email

        startActivity(Intent.createChooser(i, "Choose a Platform"));
             //createChooser method is a utility provided bh the Intent class thet allows you to create a dialog that-
             // -displays a list of applications that can handle a specific intent.This is useful when you-
               //-want to give user a choice of using which app to use to perform an action ex. sharing content
}
}