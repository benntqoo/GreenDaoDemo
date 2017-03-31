package com.example.ben.greendaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.btnSearch)
    Button btnSearch;
    @InjectView(R.id.btnInsert)
    Button btnInsert;
    @InjectView(R.id.btnDelete)
    Button btnDelete;
    @InjectView(R.id.editName)
    EditText editName;
    @InjectView(R.id.editPoint)
    EditText editPoint;
    @InjectView(R.id.spinner)
    Spinner spinner;
    @InjectView(R.id.btnCancel)
    Button btnCancel;
    @InjectView(R.id.btnSubmit)
    Button btnSubmit;
    @InjectView(R.id.listView)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.btnSearch, R.id.btnInsert, R.id.btnDelete, R.id.spinner, R.id.btnCancel, R.id.btnSubmit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnSearch:
                break;
            case R.id.btnInsert:
                break;
            case R.id.btnDelete:
                break;
            case R.id.spinner:
                break;
            case R.id.btnCancel:
                break;
            case R.id.btnSubmit:
                break;
        }
    }
}
