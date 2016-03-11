package com.juxbzh.intlphoneinputsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.rimoto.intlphoneinput.IntlPhoneInput;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntlPhoneInput phoneInput = (IntlPhoneInput) findViewById(R.id.intl_phone_input);
        phoneInput.setEmptyDefault(null);
    }
}
