package edu.njnu.friendinfo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

/**
 * Created by Sawatari on 2017/1/26.
 */

public class SystemSet extends PreferenceActivity {

    SharedPreferences set_info;

    //界面样式
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.system_set);
        //获取preferences
        set_info = PreferenceManager.getDefaultSharedPreferences(this);

        Preference noti = findPreference("getinfo");
        noti.setOnPreferenceClickListener(new OnPreferenceClickListener(){
            public boolean onPreferenceClick(Preference preference) {
                return true;
            }
        });
    }
}