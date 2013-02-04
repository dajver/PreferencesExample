package com.preferencesexample;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	SharedPreferences prefs;
	EditText et;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		et = (EditText) findViewById(R.id.editText1);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		menu.add(Menu.NONE, 1, 0, "Настройки");
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
			case 1: {
				Intent intent = new Intent(this, PrefsActivity.class);
				startActivity(intent);
			}
		}
		return true;
	}
	
	@Override
	public void onResume() { 
		prefs = PreferenceManager.getDefaultSharedPreferences(this); 
		//режим для вида поля ввода (ночной дневной)
	    if (prefs.getBoolean("night", false)) {
	        et.setBackgroundColor(Color.BLACK);
	        et.setTextColor(Color.YELLOW);
	    } else {
	    	et.setBackgroundColor(Color.WHITE);
	        et.setTextColor(Color.BLACK);
	    }
	    // читаем размер шрифта из EditTextPreference 
	    float fSize = Float.parseFloat(prefs.getString("text_size", "20")); 
	    // применяем настройки в текстовом поле 
	    et.setTextSize(fSize);
	    
	    // читаем стили текста из ListPreference 
	    String regular = prefs.getString("text_style", "");
	    int typeface = Typeface.NORMAL; 

	    if (regular.contains("Полужирный")) 
	        typeface += Typeface.BOLD; 

	    if (regular.contains("Курсив")) 
	        typeface += Typeface.ITALIC; 

	    // меняем настройки в EditText 
	    et.setTypeface(null, typeface);
	    super.onResume();
	}
}
