package com.example.ben.greendaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ben.greendaodemo.Adapter.MainListViewAdapter;
import com.example.ben.greendaodemo.Helper.DBHelper;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;
import greendao.student;
import greendao.studentDao;


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


    private static final String TAG = "MainActivity";

    private studentDao _studentDao;
    private static final int QUERY_TABLE = 1;
    private static final int INSERT_TABLE = 2;
    private static final int DELETE_TABLE = 3;
    private int _sqlMode = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViewData();
        btnInitStatus(-1);
        _studentDao = DBHelper.getInstance(getApplicationContext()).getStudentDao();
    }


    private void initViewData() {
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_item, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
       List<student> _studentList = _studentDao.loadAll();

        MainListViewAdapter adapter = new MainListViewAdapter(MainActivity.this, _studentList);
        listView.setAdapter(adapter);

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
                doSql(_sqlMode);
                btnInitStatus(-1);
                break;
        }
    }

    private void doSql(int modeType) {
        String name = editName.getText().toString();
        int point = -1;
        String kinds = spinner.getSelectedItem().toString();

        Boolean checkNull = false;

        if (name.trim().equals("") && _sqlMode != QUERY_TABLE) {
            Toast.makeText(MainActivity.this, "name not " +
                    "null", Toast.LENGTH_SHORT).show();
            editName.setFocusable(true);
            return;
        } else {
            checkNull = true;
        }

        if (editPoint.getText().toString().equals("") && !checkNull) {
            Toast.makeText(MainActivity.this, "point not " +
                    "null", Toast.LENGTH_SHORT).show();

            editPoint.setFocusable(true);
            return;
        } else {
            Pattern pattern = Pattern.compile("[0-9]*");
            Matcher isNum = pattern.matcher(editPoint.getText().toString());

            if (isNum.matches()) {
                point = Integer.parseInt(editPoint.getText().toString());
                checkNull = true;
            } else {
                Toast.makeText(MainActivity.this, "請輸入數字",
                        Toast.LENGTH_SHORT).show();
                return;
            }
        }

        if (kinds.equals("") && !checkNull) {
            Toast.makeText(MainActivity.this, "kinds not " +
                    "null", Toast.LENGTH_SHORT).show();
            spinner.setFocusable(true);
            return;
        } else {
            checkNull = true;
        }

        if (!checkNull) {
            Toast.makeText(MainActivity.this, "請輸入數值", Toast.LENGTH_SHORT).show();
            return;
        }

        student student = new student();
        switch (modeType) {
            case INSERT_TABLE:
                student.setName(name);
                student.setPoint(point);
                student.setKinds(kinds);
                Long id = _studentDao.insert(student);
                Log.i(TAG, "doSql:INSERT  id:" + id);
                break;

            case DELETE_TABLE:
                student.setName(name);
                student.setPoint(point);
                student.setKinds(kinds);
                _studentDao.delete(student);
                break;
            case QUERY_TABLE:
                break;
        }
    }

    private void btnInitStatus(int id) {
        switch (id) {
            case R.id.btnSearch:
                _sqlMode = QUERY_TABLE;

                btnSearch.setEnabled(true);
                btnInsert.setEnabled(false);
                btnDelete.setEnabled(false);

                btnCancel.setEnabled(true);
                btnSubmit.setEnabled(true);

                editName.setEnabled(true);
                editPoint.setEnabled(true);

                spinner.setEnabled(true);
                break;
            case R.id.btnInsert:
                _sqlMode = INSERT_TABLE;

                btnSearch.setEnabled(false);
                btnInsert.setEnabled(true);
                btnDelete.setEnabled(false);

                btnCancel.setEnabled(true);
                btnSubmit.setEnabled(true);

                editName.setEnabled(true);
                editPoint.setEnabled(true);

                spinner.setEnabled(true);
                break;
            case R.id.btnDelete:
                _sqlMode = DELETE_TABLE;

                btnSearch.setEnabled(false);
                btnInsert.setEnabled(false);
                btnDelete.setEnabled(true);

                btnCancel.setEnabled(true);
                btnSubmit.setEnabled(true);

                editName.setEnabled(true);
                editPoint.setEnabled(true);

                spinner.setEnabled(true);
                break;
            default:
                _sqlMode = -1;

                btnSearch.setEnabled(true);
                btnInsert.setEnabled(true);
                btnDelete.setEnabled(true);

                btnCancel.setEnabled(false);
                btnSubmit.setEnabled(false);

                editName.setEnabled(false);
                editPoint.setEnabled(false);

                spinner.setEnabled(false);

                editPoint.setText("");
                editName.setText("");
                spinner.setSelection(0);
                break;

        }
    }
}
