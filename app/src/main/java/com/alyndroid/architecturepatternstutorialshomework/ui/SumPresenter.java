package com.alyndroid.architecturepatternstutorialshomework.ui;

import android.util.Log;

import com.alyndroid.architecturepatternstutorialshomework.pojo.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

public class SumPresenter {

    SumView sumView;

    DataBase dataBase = new DataBase();

    public SumPresenter(SumView sumView) {
        this.sumView = sumView;
    }

    public NumberModel getNumberModel() {
        return dataBase.getNumbers();
    }

    public void doPlural(){
        sumView.pluralResult(getNumberModel().getFirstNum() + getNumberModel().getSecondNum());
    }
}
