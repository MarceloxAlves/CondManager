package br.com.avantitecnologiati.condmanager.helper;

import android.widget.TextView;

public class ValidateTextView {

    public static boolean isEmpty(TextView textView){
        return textView.getText().toString().trim().isEmpty();
    }

    public static boolean compare(TextView textView, TextView textView2){
        return textView.getText().toString().equalsIgnoreCase(textView2.getText().toString());
    }

    public static String validate(TextView textView) throws IllegalArgumentException {
        if (ValidateTextView.isEmpty(textView)) {
            throw new IllegalArgumentException("Campo "+ textView.getHint() +" inválido");
        }
        return textView.getText().toString().trim();

    }

}
