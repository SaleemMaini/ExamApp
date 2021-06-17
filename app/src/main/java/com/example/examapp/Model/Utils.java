package com.example.examapp.Model;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.examapp.R;

public class Utils {
    private static int sTheme;
    public final static int THEME_DEFAULT = 0;
    public final static int THEME_DARKBLUE = 1;
    public final static int THEME_TEAL = 2;

   public void setColorTheme(View v) {
        switch (v.getId()) {
            case R.id.redBtn:
                Constant.theme = R.style.RedTheme;
                break;
            case R.id.darkBlueBtn:
                Constant.theme = R.style.DarkBlueTheme;
                break;
            case R.id.tealBtn:
                Constant.theme = R.style.tealTheme;
                break;
            default:
                Constant.theme = R.style.Theme_ExamApp;
                break;
        }
    }
}
