package com.nabi.nf70.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {
    private EditText nameField;
    private EditText phoneField;
    private EditText genderField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = (EditText) findViewById(R.id.nameField);
        phoneField = (EditText) findViewById(R.id.phoneField);
        genderField = (EditText) findViewById(R.id.genderField);
    }

    //按下儲存按鈕
    public void btnSave_Click(View view) {
        //取得SharedPreference設定("Preference"為設定檔的名稱)
        SharedPreferences settings = getSharedPreferences("Preference", 0);
        //置入字串
        settings.edit()
                .putString("name", nameField.getText().toString())
                .putString("phone",phoneField.getText().toString())
                .putString("gender",genderField.getText().toString())
                .commit();
        Toast.makeText(MainActivity.this, "儲存成功", Toast.LENGTH_LONG).show();
    }

    //按下清除按鈕
    public void btnClear_Click(View view) {
        //取得SharedPreference設定("Preference"為設定檔的名稱)
        SharedPreferences settings = getSharedPreferences("Preference", 0);
        //資料進行清空動作
        settings.edit()
                .clear()
                .commit();
        Toast.makeText(MainActivity.this, "清除完成", Toast.LENGTH_LONG).show();
    }

    //按下讀取按鈕
    public void btnRead_Click(View view) {
        //取得SharedPreference設定("Preference"為設定檔的名稱)
        SharedPreferences settings = getSharedPreferences("Preference", 0);
        //取出字串
        String name = settings.getString("name", "");
        String phone = settings.getString("phone","");
        String gender=settings.getString("gender","");
        nameField.setText(name);
        phoneField.setText(phone);
        genderField.setText(gender);
        Toast.makeText(MainActivity.this,"讀取完成",Toast.LENGTH_LONG).show();
    }
}
