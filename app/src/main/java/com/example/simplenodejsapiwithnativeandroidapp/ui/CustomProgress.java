package com.example.simplenodejsapiwithnativeandroidapp.ui;

import android.app.ProgressDialog;
import android.content.Context;

public class CustomProgress extends ProgressDialog {
    public CustomProgress(Context context, String title) {
        super(context);
        this.title = title;
    }

    final String title;

}
