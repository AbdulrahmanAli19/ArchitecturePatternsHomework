package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;

import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.databinding.ActivityMainBinding;
import com.alyndroid.architecturepatternstutorialshomework.pojo.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

import java.util.Observer;

public class MainActivity extends AppCompatActivity implements SumView {

    ActivityMainBinding binding;
    SumPresenter sumPresenter;
    SumViewModel sumViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        sumPresenter = new SumPresenter(this);

        sumPresenter.getNumberModel();

        binding.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sumPresenter.doPlural();
            }
        });

        binding.divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doDivision();
            }
        });

        sumViewModel = ViewModelProviders.of(this).get(SumViewModel.class);

        binding.setResult(sumViewModel);

        binding.setLifecycleOwner(this);
    }

    @Override
    public void pluralResult(int sum) {
        binding.plusResultTextView.setText(String.valueOf(sum));
    }

    public void doDivision() {
        DataBase dataBase = new DataBase();
        float result = dataBase.getNumbers().getFirstNum() / dataBase.getNumbers().getSecondNum();
        binding.divResultTextView.setText(String.valueOf(result));
    }


}
