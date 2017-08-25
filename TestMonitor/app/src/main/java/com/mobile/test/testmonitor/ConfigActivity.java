package com.mobile.test.testmonitor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mobile.test.testmonitor.configuration.ConfigAdapter;
import com.mobile.test.testmonitor.configuration.ConfigItem;


import java.util.ArrayList;
import java.util.List;

public class ConfigActivity extends AppCompatActivity {

    private List<ConfigItem> configItems = new ArrayList<>();

    private RecyclerView configRecyclerView;

    private ConfigAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        listConfig();

        setBackButton();

        timeSelect();
    }

    private void setBackButton() {
        TextView back = (TextView) findViewById(R.id.back_config);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void timeSelect() {
        Spinner spinner = (Spinner) findViewById(R.id.time_selector);
        String[] times = getResources().getStringArray(R.array.time_intervals);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, times);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] select = getResources().getStringArray(R.array.time_intervals);
                Toast.makeText(ConfigActivity.this, "你选择了"+select[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void listConfig() {
        initConfig();
        configRecyclerView = (RecyclerView) findViewById(R.id.config_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        configRecyclerView.setLayoutManager(layoutManager);
        adapter = new ConfigAdapter(configItems);
        configRecyclerView.setAdapter(adapter);
    }

    private void initConfig() {
        ConfigItem configItem1 = new ConfigItem("截屏自动记录时间","ON");
        configItems.add(configItem1);
        ConfigItem configItem2 = new ConfigItem("SIM卡状态获取", "ON");
        configItems.add(configItem2);
        ConfigItem configItem3 = new ConfigItem("WIFI状态获取", "ON");
        configItems.add(configItem3);
        ConfigItem configItem4 = new ConfigItem("蓝牙状态获取", "ON");
        configItems.add(configItem4);
        ConfigItem configItem5 = new ConfigItem("设置状态获取", "ON");
        configItems.add(configItem5);
        ConfigItem configItem6 = new ConfigItem("APP状态获取", "ON");
        configItems.add(configItem6);
        ConfigItem configItem7 = new ConfigItem("电量状态获取", "ON");
        configItems.add(configItem7);
    }
}
