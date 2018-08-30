package com.tuxdev.sampleaacjava.utils;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.view.View;

/**
 * *********************************************
 * Created by ukie on 8/30/18 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 * *********************************************
 * © 2018 | All Right Reserved
 */

public class DataBindingAdapter {

    //TODO membuat attribut visibility
    @BindingAdapter("app:visibility")
    public static void setVisibility(View view, Boolean isVisible) {
        Log.e("zodiak", String.valueOf(isVisible));
        if (isVisible != null)
            if (isVisible)
                view.setVisibility(View.VISIBLE);
            else view.setVisibility(View.GONE);
    }

    //TODO membuat attribut enable
    @BindingAdapter("app:buttonEnable")
    public static void setEnable(View view, Boolean isEnable) {
        if (isEnable != null)
            if (isEnable) // jika progress bar muncul button di set disable
                view.setEnabled(false);
            else view.setEnabled(true);

    }
}
