package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listViewDanhsach;
    EditText editTextHoten, editTextNamsinh;
    Button buttonAdd;
    ArrayList<Sinhvien> dsSinhvien = new ArrayList<Sinhvien>();
    SinhvienAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitWidgets();
        dsSinhvien.add(new Sinhvien("Tran Van Hieu", 2001));
        dsSinhvien.add(new Sinhvien("Nguyen Trong hai",1992));
        dsSinhvien.add(new Sinhvien("khong Quang Hiep",1985));
        dsSinhvien.add(new Sinhvien("Phan Thi Tuyet Nhung",2000));
        dsSinhvien.add(new Sinhvien("Nguyen Van Hung",2001));

        adapter = new SinhvienAdapter(MainActivity.this,
                R.layout.item_list, dsSinhvien);
        listViewDanhsach.setAdapter(adapter);
        listViewDanhsach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = dsSinhvien.get(i).Hoten + "-" + dsSinhvien.get(i).Namsinh;
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                editTextHoten.setText(dsSinhvien.get(i).Hoten.toString());
                editTextNamsinh.setText(dsSinhvien.get(i).Namsinh.toString());
            }
        });

            buttonAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!editTextHoten.getText().toString().trim().equals("")&& !editTextNamsinh.getText().toString().trim().equals("")){
                        dsSinhvien.add(new Sinhvien(editTextHoten.getText().toString().trim(), Integer.parseInt(editTextNamsinh.getText().toString().trim())));
                        adapter.notifyDataSetChanged();
                        editTextNamsinh.setText("");
                        editTextHoten.setText("");
                    }
                }
            });
    }

    private void InitWidgets() {
        listViewDanhsach = (ListView) findViewById(R.id.listViewDanhsach);
        editTextHoten = (EditText) findViewById(R.id.editTextHoten);
        editTextNamsinh = (EditText) findViewById(R.id.editTextNamsinh);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
    }

}