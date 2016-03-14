# International Phone Input #
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-IntlPhoneInput-green.svg?style=true)](https://android-arsenal.com/details/1/2976)

## What is it?
**IntlNumberInput** is a custom view for Android that allows the user to enter his phone number in an
elegant and friendly way. It adds a flag dropdown to any input, automatically detects the user's
country, displays a relevant placeholder and auto formats the number as they type.

![IntlPhoneInput](gif-animation.gif) <br />
***Full Demo Video - https://youtu.be/vDL6gBtltng ***


## Features
1. Automatically format the number as the user types
2. Automatically set the input placeholder to an example number for the selected country
3. Selecting a country from the dropdown will update the dial code in the input
4. Easy embedding as a Custom View
5. Listener available to detect validity change
6. Automatically detect phone number when information available
7. Listen to "done" even on the keyboard
8. Set view style via custom attributes
9. More..

## Download
Download via Gradle or Maven:
```groovy
compile 'com.juxbzh:intlphoneinput:1.0.1'
```
or Maven:
```xml
<dependency>
  <groupId>com.juxbzh</groupId>
  <artifactId>intlphoneinput</artifactId>
  <version>1.0.1</version>
</dependency>
```

## Usage
It's easy like 1-2-3! 

1. Add the view to your layout XML:
```xml
<net.rimoto.intlphoneinput.IntlPhoneInput
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:id="@+id/my_phone_input" />
```

2. Find it in your java
```java
IntlPhoneInput phoneInputView = (IntlPhoneInput) findById(R.id.my_phone_input);
```

3. Check for validity and get the number!
```java
String myInternationalNumber;
if(phoneInputView.isValid()) {
    myInternationalNumber = phoneInputView.getNumber();
}
```

## Public methods

1. `boolean isValid()`
1. `void setEnabled(boolean enabled)`
2. `void setOnValidityChange(IntlPhoneInputListener listener)`

    ```java
    public interface IntlPhoneInputListener {
      void done(View view, boolean isValid);
    }
    ```
    
    This simple structure allows you to use lambda expression! (with [retrolambda](https://github.com/orfjackal/retrolambda)):
    ```
    mIntlPhoneInput.setOnValidityChange((view, isValid) -> {
      if(isValid) {...}
    }
    ```
  
3. `void setOnKeyboardDone(IntlPhoneInputListener listener)`
4. `void hideKeyboard()`
5. `void setDefault()` - Set default number: if can detect line by permission(requires `android.permission.READ_PHONE_STATE`), else- example number for country as hint(detect by SIM info if has permission, else by locale). This method automatically invoked on init
6. `void setEmptyDeafult(String iso)` - Set example hint for iso
7. `void setEmptyDefault()` - Set example hint by locale
8. `void setNumber(String number)` - Set number, number in [E.164](https://en.wikipedia.org/wiki/E.164) format(i.e. `+972501234567`)
9. `String getNumber()` or `String getText()` - Get number in [E.164](https://en.wikipedia.org/wiki/E.164) format


## Attributions

1. Forked from [IntlPhoneInput](https://github.com/Rimoto/IntlPhoneInput)

# LICENSE
    Copyright 2015 Rimoto LTD, AlmogBaku
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
      http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
