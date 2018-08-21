package com.example.hakeem.sebha.helper;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.Button;
import android.widget.TextView;

import com.example.hakeem.sebha.tasbehat.TasbehatNavigationActivity;

import java.util.Objects;

import static com.example.hakeem.sebha.helper.MySuperAppApplication.getContext;

public final class Variables {

    /**
     * -سبحان الله
     * -الحمدلله
     * -لا اله الا الله
     * -الله اكبر
     * -لا حول ولا قوه الا بالله
     * -سبحان الله وبحمده سبحان الله العظيم
     * -الاستغفار
     * -الصلاه علي النبي
     */

   

    public static final String SOBHAN_ALLAH_COUNT = "sobhan_allah";
    public static final String ELHAMD_L_ALLAH_COUNT = "hamd_le_allah";
    public static final String TAWHEED_COUNT = "tawheed";
    public static final String TAKBEER_COUNT = "takbeer";
    public static final String HAWKALA_COUNT = "hawkala";
    public static final String TASBEEH_COUNT = "tasbeeh";
    public static final String ESTEKFAR_COUNT = "estekfar";
    public static final String SALAH_COUNT = "salah";

    public static final String PREF_NAME = "app_preference";



    public static long sobhanallah_count = SessionManager.getSobhanAllahCount();
    public static long elhamedLallah_count = SessionManager.getElhamedLallahCount();
    public static long tawhed_count = SessionManager.getTawheedCount();
    public static long takbeer_count = SessionManager.getTakbeerCount();
    public static long hawkala_count = SessionManager.getHawkalaCount();
    public static long tasbeeh_count = SessionManager.getTasbeehCount();
    public static long estakfar_count = SessionManager.getEstakfarCount();
    public static long salah_count = SessionManager.getSalahCount();


    public static void applyFontToTextView(Button button){
        Typeface font = Typeface.createFromAsset(Objects.requireNonNull(getContext()).getAssets(), "fonts/OldAnticDecorative.ttf");
        button.setTypeface(font);
    }

    public static String convertToArabicNumber(String number){
        if (number != null) {
            return number
                    .replaceAll("1","١")
                    .replaceAll("2","٢")
                    .replaceAll("3","٣")
                    .replaceAll("4","٤")
                    .replaceAll("5","٥")
                    .replaceAll("6","٦")
                    .replaceAll("7","٧")
                    .replaceAll("8","٨")
                    .replaceAll("9","٩")
                    .replaceAll("0","٠");
        }

        return null;
    }

    
}
