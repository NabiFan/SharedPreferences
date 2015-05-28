package com.nabi.nf70.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {
    private EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //按下Save按鈕
    public void btnSave_Click(View view) {
        //取得SharedPreference設定("Preference"為設定檔的名稱)
        SharedPreferences settings = getSharedPreferences("Preference", 0);
        //置入name屬性的字串
        settings.edit().putString("name", nameEditText.getText().toString()).commit();
    }

    //按下Restore按鈕
    public void btnRestor_Click(View view) {
        //取得SharedPreference設定("Preference"為設定檔的名稱)
        SharedPreferences settings = getSharedPreferences("Preference", 0);
        //取出name屬性的字串
        String name = settings.getString("name", "");
        nameEditText.setText(name);
    }

    public void btnClear_Click(View view) {
        //取得SharedPreference設定("Preference"為設定檔的名稱)
        SharedPreferences settings = getSharedPreferences("Preference",0);
        //將name資料進行清空動作
        settings.edit()
                .clear()
                .commit();
        Toast.makeText(MainActivity.this,"清除完成", Toast.LENGTH_LONG).show();
    }
}
