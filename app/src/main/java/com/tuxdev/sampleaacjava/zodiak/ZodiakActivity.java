package com.tuxdev.sampleaacjava.zodiak;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.tuxdev.sampleaacjava.R;
import com.tuxdev.sampleaacjava.databinding.ActivityZodiakBinding;
import com.tuxdev.sampleaacjava.model.DataZodiak;

public class ZodiakActivity extends AppCompatActivity {

    private ActivityZodiakBinding dataBindingUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TODO Inisialisasi DataBinding
        dataBindingUtil = DataBindingUtil.setContentView(this, R.layout.activity_zodiak);
        dataBindingUtil.setLifecycleOwner(this);

        //TODO Inisialisasi FAN
        AndroidNetworking.initialize(this);

        //TODO Setup ViewModel
        ZodiakViewModel viewModel = ViewModelProviders.of(this).get(ZodiakViewModel.class);
        dataBindingUtil.setViewModel(viewModel); //TODO Set value untuk variable viewModel di activity_zodiak.xml

        //TODO Observe zodiakLiveData
        viewModel.zodiakLiveData.observe(this, new Observer<DataZodiak>() {
            @Override
            public void onChanged(@Nullable DataZodiak dataZodiak) {
                dataBindingUtil.setDataZodiak(dataZodiak); //TODO Set value untuk variable dataZodiak di activity_zodiak.xml
            }
        });


    }
}
