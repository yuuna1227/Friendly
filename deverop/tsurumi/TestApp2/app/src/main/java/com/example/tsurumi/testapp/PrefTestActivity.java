package com.keicode.android.test;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PrefTest1Activity extends Activity {
    SharedPreferences sharedPref;

    TextView readTextView;
    EditText writeEditText;
    Button readButton;
    Button writeButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findViews();
        setListeners();
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionsmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.settings: startActivity(new Intent(this, MyPreferences.class)); return true; } return false; } protected void findViews(){ readTextView = (TextView)findViewById(R.id.textView1); writeEditText = (EditText)findViewById(R.id.editText1); readButton = (Button)findViewById(R.id.readButton); writeButton = (Button)findViewById(R.id.writeButton); } protected void setListeners(){ readButton.setOnClickListener(new OnClickListener(){ @Override public void onClick(View v) { readTextView.setText( sharedPref.getString("data1", "")); } }); writeButton.setOnClickListener(new OnClickListener(){ @Override public void onClick(View v){ Editor editor = sharedPref.edit(); editor.putString( "data1", writeEditText.getText().toString()); editor.commit(); } }); } } - See more at: http://android.keicode.com/basics/preferences-basic.php#sthash.4zbVAzBC.dpuf