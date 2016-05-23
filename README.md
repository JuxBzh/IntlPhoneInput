# International Phone Input #
A fork of the [IntlPhoneInput](https://github.com/Rimoto/IntlPhoneInput) library by RIMOTO

## What is it?
**IntlNumberInput** is a custom view for Android that allows the user to enter his phone number in an
elegant and friendly way. It adds a flag dropdown to any input, automatically detects the user's
country, displays a relevant placeholder and auto formats the number as they type.

## Features
Features from the original version
1. Automatically format the number as the user types
2. Automatically set the input placeholder to an example number for the selected country
3. Selecting a country from the dropdown will update the dial code in the input
4. Easy embedding as a Custom View
5. Listener available to detect validity change
6. Automatically detect phone number when information available
7. Listen to "done" even on the keyboard

Features added in this version
1. Set view style using custom XML attributes
2. Custom error field
3. Support for mobile and landline phone numbers
4. Possibility to hide the country spinner (to benefit phone number validation and formatting for a single country)


## Download
Download via Gradle or Maven:
```groovy
compile 'com.juxbzh:intlphoneinput:1.0.4'
```
or Maven:
```xml
<dependency>
  <groupId>com.juxbzh</groupId>
  <artifactId>intlphoneinput</artifactId>
  <version>1.0.4</version>
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

4. Customize appearance via XML
```xml
<net.rimoto.intlphoneinput.IntlPhoneInput
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginBottom="@dimen/component_default_spacing"
    app:textColor="#FF0000"
    app:textColorHint="#FFBBBB"
    app:countryNameColor="@color/colorPrimary"
    app:dialCodeColor="@color/colorAccent"
    app:textSize="20sp"/>
```
For more details see attached sample project
