package com.tai.androidtai.modules;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tai.androidtai.R;

public class TabestoSnackbar {

    @NonNull
    public static Snackbar make(@NonNull View view, @NonNull CharSequence text, int duration) {
        Snackbar snackbar = Snackbar.make(view, text, duration);
        Context context = view.getContext();

        TypedValue outValue = new TypedValue();
        float spacing = outValue.getFloat();

        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
        layout.setBackgroundColor(context.getResources().getColor(R.color.white));

        TextView textView = layout.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(context.getResources().getColor(R.color.colorPrimary));
        textView.setLetterSpacing(spacing);

        Button button = layout.findViewById(R.id.snackbar_action);
        button.setTextColor(context.getResources().getColor(R.color.white));
        button.setLetterSpacing(spacing);

        return snackbar;
    }

}
