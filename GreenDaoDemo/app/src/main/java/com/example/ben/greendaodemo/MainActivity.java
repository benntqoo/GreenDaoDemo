package com.example.ben.greendaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnSearch)
    Button btnSearch;
    @BindView(R.id.btnInsert)
    Button btnInsert;
    @BindView(R.id.btnDelete)
    Button btnDelete;
    @BindView(R.id.editName)
    EditText editName;
    @BindView(R.id.editPoint)
    EditText editPoint;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.btnCancel)
    Button btnCancel;
    @BindView(R.id.btnSubmit)
    Button btnSubmit;
    @BindView(R.id.listView)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViewData();
    }


    private void initViewData() {
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_item, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

    }

    @OnClick({R.id.btnSearch, R.id.btnInsert, R.id.btnDelete, R.id.btnCancel, R.id.btnSubmit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnSearch:
                btnInitStatus(R.id.btnSearch);
                break;
            case R.id.btnInsert:
                btnInitStatus(R.id.btnInsert);
                break;
            case R.id.btnDelete:
                btnInitStatus(R.id.btnDelete);
                break;
            case R.id.btnCancel:
                btnInitStatus(-1);
                break;
            case R.id.btnSubmit:
                btnInitStatus(-1);
                break;
        }
    }

    private void btnInitStatus(int id) {
        switch (id) {
            case R.id.btnSearch:
                btnSearch.setEnabled(true);
                btnInsert.setEnabled(false);
                btnDelete.setEnabled(false);

                btnCancel.setEnabled(true);
                btnSubmit.setEnabled(true);

                editName.setEnabled(true);
                editPoint.setEnabled(true);
                break;
            case R.id.btnInsert:
                btnSearch.setEnabled(false);
                btnInsert.setEnabled(true);
                btnDelete.setEnabled(false);

                btnCancel.setEnabled(true);
                btnSubmit.setEnabled(true);

                editName.setEnabled(true);
                editPoint.setEnabled(true);
                break;
            case R.id.btnDelete:
                btnSearch.setEnabled(false);
                btnInsert.setEnabled(false);
                btnDelete.setEnabled(true);

                btnCancel.setEnabled(true);
                btnSubmit.setEnabled(true);

                editName.setEnabled(true);
                editPoint.setEnabled(true);
                break;
            default:
                btnSearch.setEnabled(true);
                btnInsert.setEnabled(true);
                btnDelete.setEnabled(true);

                btnCancel.setEnabled(false);
                btnSubmit.setEnabled(false);

                editName.setEnabled(false);
                editPoint.setEnabled(false);
                break;

        }
    }

}
