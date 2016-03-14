package com.juxbzh.intlphoneinputsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import net.rimoto.intlphoneinput.IntlPhoneInput;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntlPhoneInput phoneInput = (IntlPhoneInput) findViewById(R.id.intl_phone_input);

        IntlPhoneInput phoneInput2 = (IntlPhoneInput) findViewById(R.id.intl_phone_input2);
        phoneInput2.setNumber("+32470127865");
    }
}
