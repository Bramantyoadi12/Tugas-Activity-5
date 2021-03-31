package com.example.activity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

public class Home_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    //Deklarasi variabel dengan jenis data listview
    private ListView list;

    //Memanggil class ListviewAdapter dan diinialisasi menjadi variabel adapter
    private ListViewAdapter adapter;

    //Deklarasi array untuk menyimpan nama
    String[] listNama;

    //Memanggil class CmassNama
    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();

    //Membuat objek bundle
    Bundle bundle = new Bundle();

    //Membuat objek intent
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Menyimpan nama didalam array ListNama
        listNama = new String[]{"Inayah", "Ilham", "Eris",
                "Fikri", "Maul", "Intan", "Vina", "Gita",
                "Vian", "Lutfi"};
        list = findViewById(R.id.listKontak);

        //membuat objek dari classNama menjadi arrayList
        classNamaArrayList = new ArrayList<>();

        //Membaca seluruh data pada array ListNama
        for (int i = 0; i < listNama.length; i++)
        {
            //Membuat objek class nama da
            ClassNama classNama = new ClassNama(listNama[i]);
            //Binds strings ke array
            classNamaArrayList.add(classNama);
        }

        // Mmebuat objek dari listviewAdapter
        adapter = new ListViewAdapter(this);

        // Binds Adapter ke ListView
        list.setAdapter(adapter);

        //Membuat event dari List onclick
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nama = classNamaArrayList.get(position).getNama();

                bundle.putString("a", nama.trim());

                PopupMenu pm = new PopupMenu(getApplicationContext(),view);

                pm.setOnMenuItemClickListener(Home_Activity.this);

                pm.inflate(R.menu.popup_menu);

                pm.show();
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(), ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                Toast.makeText(getApplicationContext(), "Ini Untuk Edit Kontak Ya!!!",
                        Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
}