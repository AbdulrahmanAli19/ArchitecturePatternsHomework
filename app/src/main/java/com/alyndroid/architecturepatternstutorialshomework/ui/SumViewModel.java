package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alyndroid.architecturepatternstutorialshomework.pojo.DataBase;

public class SumViewModel extends ViewModel {
    DataBase dataBase = new DataBase();

    public MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();

    public void doMultiplication(){
        mutableLiveData.setValue(dataBase.getNumbers().getFirstNum() * dataBase.getNumbers().getSecondNum());
    }

}
