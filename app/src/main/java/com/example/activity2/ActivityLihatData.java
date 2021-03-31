package com.example.activity2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityLihatData extends AppCompatActivity {
    TextView tvnama, tvnomor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        Bundle bundle = getIntent().getExtras();

        String nama = bundle.getString("a");

        tvnama = findViewById(R.id.tvNamaKontak);
        tvnomor = findViewById(R.id.tvNomorTelepon);

        switch (nama)
        {
            case "Inayah":
                tvnama.setText("Inayah M");
                tvnomor.setText("082111714008");
                break;
            case "Ilham" :
                tvnama.setText("Ilham R");
                tvnomor.setText("08228912236");
                break;
            case "Eris" :
                tvnama.setText("Eris J");
                tvnomor.setText("085700912236");
                break;
            case "Fikri" :
                tvnama.setText("M Fikri");
                tvnomor.setText("08579812236");
                break;
            case "Maul" :
                tvnama.setText("Maul M");
                tvnomor.setText("0822891229009");
                break;
            case "Intan" :
                tvnama.setText("Intan S");
                tvnomor.setText("08218912227");
                break;
            case "Vina" :
                tvnama.setText("Vina R");
                tvnomor.setText("0822891222099");
                break;
            case "Gita" :
                tvnama.setText("Gita S");
                tvnomor.setText("082289220997");
                break;
            case "Lutfi" :
                tvnama.setText("Lutfi M");
                tvnomor.setText("082289220999");
                break;
            case "Vian" :
                tvnama.setText("Vian M");
                tvnomor.setText("08228970922");
                break;
        }
    }
}