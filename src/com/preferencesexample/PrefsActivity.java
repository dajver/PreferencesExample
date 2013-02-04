package com.preferencesexample;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;

public class PrefsActivity extends PreferenceActivity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	    addPreferencesFromResource(R.xml.preferences);
	    
	    //обрабатываем нажатие кнопки в настройках
	    Preference button = (Preference)findPreference("button");
		button.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
		    @Override
		    public boolean onPreferenceClick(Preference arg0) { 
		    	Intent intent = new Intent(PrefsActivity.this, MainActivity.class);
				startActivity(intent);
		        return true;
		    }
		});
	}
}