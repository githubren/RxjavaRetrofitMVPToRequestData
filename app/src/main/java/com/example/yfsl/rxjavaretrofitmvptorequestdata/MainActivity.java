package com.example.yfsl.rxjavaretrofitmvptorequestdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Button post_btn;
    private TextView showdata_tv;
    private DataModelPresenterModel dataModelPresenter = new DataModelPresenterModel(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initData() {
        final Map<String,String> map = new HashMap<>();
        map.put("USER_PHONE1",Constant.USER_PHONE1);
        map.put("USER_PSW",Constant.USER_PSW);
        dataModelPresenter.bindPresenterView(mDataModelPv);
        post_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataModelPresenter.postData(Constant.URL,map);
            }
        });
    }

    private void initView() {
        post_btn = findViewById(R.id.post_btn);
        showdata_tv = findViewById(R.id.showdata_tv);
        dataModelPresenter.onCreate();
    }

    private DataModelPv mDataModelPv = new DataModelPv() {
        @Override
        public void onSuccess(DataModel dataModel) {
            showdata_tv.setText(dataModel.toString());
        }

        @Override
        public void onError(String message) {
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };
}
