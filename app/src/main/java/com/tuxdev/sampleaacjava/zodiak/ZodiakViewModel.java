package com.tuxdev.sampleaacjava.zodiak;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.tuxdev.sampleaacjava.model.DataZodiak;

/**
 * *********************************************
 * Created by ukie on 8/30/18 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 * *********************************************
 * © 2018 | All Right Reserved
 */
public class ZodiakViewModel extends ViewModel {

    public MutableLiveData<Boolean> visibilityProgressBar = new MutableLiveData<>(); //TODO untuk handle visibility progressbar
    public MutableLiveData<DataZodiak> zodiakLiveData = new MutableLiveData<>(); //TODO untuk observe DataZodiak

    //TODO getZodiak , Variable nama dan tanggal di ambil dari nilai inputan di activity_zodiak.xml
    public void getZodiak(String nama, String tanggal) {

        visibilityProgressBar.setValue(true); //TODO menampilkan progressbar
        AndroidNetworking.get("https://script.google.com/macros/exec?service=AKfycbw7gKzP-WYV2F5mc9RaR7yE3Ve1yN91Tjs91hp_jHSE02dSv9w")
                .addQueryParameter("nama", nama)
                .addQueryParameter("tanggal", tanggal)
                .setTag(this)
                .setPriority(Priority.HIGH)
                .build()
                .getAsObject(DataZodiak.class, new ParsedRequestListener<DataZodiak>() {
                    @Override
                    public void onResponse(DataZodiak response) {
                        Log.e("zodiak", response.getData().getUsia());
                        zodiakLiveData.setValue(response); // TODO set value untuk zodiakLiveData yang di observe di Zodiak Activity
                        visibilityProgressBar.setValue(false); //TODO menyembunyikan progressbar
                    }

                    @Override
                    public void onError(ANError anError) {
                        anError.printStackTrace();
                    }
                });
    }
}
