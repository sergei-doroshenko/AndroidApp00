package com.example.sergei.androidapp00;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private TextView tvOut;
    private Button btnOk;
    private Button btnCancel;
    // for contex menu
    private TextView tvColor, tvSize;

    private final int MENU_COLOR_RED = 1;
    private final int MENU_COLOR_GREEN = 2;
    private final int MENU_COLOR_BLUE = 3;
    private final int MENU_SIZE_22 = 4;
    private final int MENU_SIZE_26 = 5;
    private final int MENU_SIZE_30 = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find components
        Log.d(TAG, "найдем View-элементы");
        tvOut = (TextView) findViewById(R.id.tvOut);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        tvColor = (TextView) findViewById(R.id.tvColor);
        tvSize = (TextView) findViewById(R.id.tvSize);

        // set onClick listeners
        Log.d(TAG, "присваиваем обработчик кнопкам");
        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        // для tvColor и tvSize необходимо создавать контекстное меню
        registerForContextMenu(tvColor);
        // analog tvColor.setOnCreateContextMenuListener(this);
        registerForContextMenu(tvSize);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        /*menu.add("menu1");
        menu.add("menu2");
        menu.add("menu3");
        menu.add("menu4");*/
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.dynamic_layout:{
                startActivity(new Intent(this, ProgramLayoutActivity.class));
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()) {
            case R.id.tvColor:
                menu.add(0, MENU_COLOR_RED, 0, "Red");
                menu.add(0, MENU_COLOR_GREEN, 0, "Green");
                menu.add(0, MENU_COLOR_BLUE, 0, "Blue");
                break;
            case R.id.tvSize:
                menu.add(0, MENU_SIZE_22, 0, "22");
                menu.add(0, MENU_SIZE_26, 0, "26");
                menu.add(0, MENU_SIZE_30, 0, "30");
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
        // пункты меню для tvColor
            case MENU_COLOR_RED:
                tvColor.setTextColor(Color.RED);
                tvColor.setText("Text color = red");
                break;
            case MENU_COLOR_GREEN:
                tvColor.setTextColor(Color.GREEN);
                tvColor.setText("Text color = green");
                break;
            case MENU_COLOR_BLUE:
                tvColor.setTextColor(Color.BLUE);
                tvColor.setText("Text color = blue");
                break;
        // пункты меню для tvSize
            case MENU_SIZE_22:
                tvSize.setTextSize(22);
                tvSize.setText("Text size = 22");
                break;
            case MENU_SIZE_26:
                tvSize.setTextSize(26);
                tvSize.setText("Text size = 26");
                break;
            case MENU_SIZE_30:
                tvSize.setTextSize(30);
                tvSize.setText("Text size = 30");
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        // по id определеяем кнопку, вызвавшую этот обработчик
        Log.d(TAG, "по id определеяем кнопку, вызвавшую этот обработчик");
        switch (v.getId()) {
            case R.id.btnOk: // кнопка ОК
                Log.d(TAG, "кнопка ОК");
                tvOut.setText("Нажата кнопка ОК");
                Toast.makeText(this, "Нажата кнопка ОК", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnCancel: // кнопка Cancel
                Log.d(TAG, "кнопка Cancel");
                tvOut.setText("Нажата кнопка Cancel");
                Toast.makeText(this, "Нажата кнопка Cancel", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
