package com.example.hakeem.sebha.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import static com.example.hakeem.sebha.helper.Variables.PREF_NAME;

public final class SessionManager {

    private static String TAG = SessionManager.class.getSimpleName();

    @SuppressLint("StaticFieldLeak")
    private static Context context = MySuperAppApplication.getContext();
    
    // Shared Preferences
    public static SharedPreferences pref = context.getSharedPreferences(PREF_NAME, 0);

    public static SharedPreferences.Editor editor = pref.edit();
    

    


//    @SuppressLint("CommitPrefEdits")
//    public SessionManager(Context context) {
//       // this.context = context;
//        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
//        editor = pref.edit();
//    }

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

    public static void setSobhanAllahCount(long sobhanAllahCount) {

        editor.putLong(Variables.SOBHAN_ALLAH_COUNT, sobhanAllahCount);
        editor.commit();
    }

    public static void setElhamedLallahCount(long elhamedLallahCount) {
        editor.putLong(Variables.ELHAMD_L_ALLAH_COUNT, elhamedLallahCount);
        editor.commit();
    }

    public static void setTawheedCount(long elTawheedCount) {
        editor.putLong(Variables.TAWHEED_COUNT, elTawheedCount);
        editor.commit();
    }

    public static void setTakbeerCount(long takbeerCount) {
        editor.putLong(Variables.TAKBEER_COUNT, takbeerCount);
        editor.commit();
    }


    public static void setHawkalaCount(long hawkalaCount) {
        editor.putLong(Variables.HAWKALA_COUNT, hawkalaCount);
        editor.commit();
    }

    public static void setTasbeehCount(long tasbeehCount) {
        editor.putLong(Variables.TASBEEH_COUNT, tasbeehCount);
        editor.commit();
    }

    public static void setEstakfarCount(long estakfarCount) {
        editor.putLong(Variables.ESTEKFAR_COUNT, estakfarCount);
        editor.commit();
    }

    public static void setSalahCount(long salahCount) {
        editor.putLong(Variables.SALAH_COUNT, salahCount);
        editor.commit();
    }


    public static long getSobhanAllahCount() {

        return pref.getLong(Variables.SOBHAN_ALLAH_COUNT, 0);
    }

    public static long getElhamedLallahCount() {

        return pref.getLong(Variables.ELHAMD_L_ALLAH_COUNT, 0);
    }

    public static long getTawheedCount() {
        return pref.getLong(Variables.TAWHEED_COUNT, 0);
    }

    public static long getTakbeerCount() {
        return pref.getLong(Variables.TAKBEER_COUNT, 0);
    }


    public static long getHawkalaCount() {
        return pref.getLong(Variables.HAWKALA_COUNT, 0);
    }

    public static long getTasbeehCount() {
        return pref.getLong(Variables.TASBEEH_COUNT, 0);
    }

    public static long getEstakfarCount() {
        return pref.getLong(Variables.ESTEKFAR_COUNT, 0);
    }

    public static long getSalahCount() {
        return pref.getLong(Variables.SALAH_COUNT, 0);
    }


}
