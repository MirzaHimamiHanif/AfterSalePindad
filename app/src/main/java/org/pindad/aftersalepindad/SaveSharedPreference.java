package org.pindad.aftersalepindad;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by ASUS on 25/01/2018.
 */

public class SaveSharedPreference
{
    static final String PREF_USER_NAME= "username";
    static final String ID_CUSTOMER = "id_customer";
    static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static void setUserName(Context ctx, String userName, String idCustomer)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_USER_NAME, userName);
        editor.putString(ID_CUSTOMER, idCustomer);
        editor.commit();
    }
    public static void deletePreference(Context ctx){
        getSharedPreferences(ctx).edit().clear().commit();
    }
    public static String getUserName(Context ctx)
    {
        return getSharedPreferences(ctx).getString(PREF_USER_NAME, null);
    }
    public static String getIdCustomer(Context context){
        return getSharedPreferences(context).getString(ID_CUSTOMER, null);
    }
}
