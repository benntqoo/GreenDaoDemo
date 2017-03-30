package com.example.ben.myapplication;

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
    @BindView(R.id.btnOk)
    Button btnOk;
    @BindView(R.id.btnCancel)
    Button btnCancel;
    @BindView(R.id.editName)
    EditText editName;
    @BindView(R.id.txtPoint)
    EditText txtPoint;
    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.spinner)
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initBtn(-1);
    }

    private void initView() {
        ArrayAdapter<CharSequence> lunchList = ArrayAdapter.createFromResource(MainActivity.this,
                R.array.spinner,
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(lunchList);
    }

    private void initBtn(int id) {
        switch (id) {
            case R.id.btnSearch:
                btnInsert.setEnabled(false);
                btnDelete.setEnabled(false);
                editName.setEnabled(true);
                txtPoint.setEnabled(true);

                btnOk.setEnabled(true);
                btnCancel.setEnabled(true);

                spinner.setEnabled(true);
                break;
            case R.id.btnInsert:
                btnSearch.setEnabled(false);
                btnDelete.setEnabled(false);

                editName.setEnabled(true);
                txtPoint.setEnabled(true);

                btnOk.setEnabled(true);
                btnCancel.setEnabled(true);

                spinner.setEnabled(true);
                break;
            case R.id.btnDelete:
                btnSearch.setEnabled(false);
                btnInsert.setEnabled(false);

                editName.setEnabled(true);
                txtPoint.setEnabled(true);

                btnOk.setEnabled(true);
                btnCancel.setEnabled(true);

                spinner.setEnabled(true);
                break;
            default:
                btnOk.setEnabled(false);
                btnCancel.setEnabled(false);

                btnSearch.setEnabled(true);
                btnInsert.setEnabled(true);
                btnDelete.setEnabled(true);

                editName.setEnabled(false);
                txtPoint.setEnabled(false);

                spinner.setEnabled(false);
                editName.setText("");
                txtPoint.setText("");

        }

    }

    @OnClick({R.id.btnSearch, R.id.btnInsert, R.id.btnDelete, R.id.btnOk, R.id.btnCancel})
    public void onViewClicked(View view) {
        initBtn(view.getId());

        switch (view.getId()) {
            case R.id.btnSearch:
                break;
            case R.id.btnInsert:
                break;
            case R.id.btnDelete:
                break;
            case R.id.btnOk:
                break;
            case R.id.btnCancel:
                break;
        }
    }
}
