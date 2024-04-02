package com.example.recycleviewdancardview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.ByteArrayOutputStream;
import java.text.NumberFormat;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        String namaSkincare = getIntent().getStringExtra("namabarang");
        String deskripsiSkincare = getIntent().getStringExtra("deskripsibarang");
        double hargaSkincare = getIntent().getDoubleExtra("hargabarang", 0.0);
        int gambarSkincare = getIntent().getIntExtra("gambarbarang", R.drawable.ic_launcher_background);

        TextView namaTextView = findViewById(R.id.namabarang);
        TextView deskripsiTextView = findViewById(R.id.deskripsibarang);
        TextView hargaTextView = findViewById(R.id.hargabarang);
        ImageView gambarImageView = findViewById(R.id.gambarbarang);
        Button bagikanButton = findViewById(R.id.bagikan);

        // Di dalam metode atau blok kode yang sesuai
        namaTextView.setText(namaSkincare);
        deskripsiTextView.setText(deskripsiSkincare);

// Menggunakan Locale Indonesia (ID)
        Locale indonesiaLocale = new Locale("id", "ID");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(indonesiaLocale);
        String formattedHarga = formatter.format(hargaSkincare);

        hargaTextView.setText("Harga: " + formattedHarga);
        gambarImageView.setImageResource(gambarSkincare);

        bagikanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), gambarSkincare);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, bytes);
                String path = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "Title", null);
                Uri imageUri = Uri.parse(path);

                String shareText = "Check out this skincare: " + namaSkincare + "\n\nDescription: " + deskripsiSkincare + "\n\nPrice: " + hargaSkincare;
                Intent shareIntent = new Intent(Intent.ACTION_SEND);

                shareIntent.setType("image/*");
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
                shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
                shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                startActivity(Intent.createChooser(shareIntent, "Share via"));
            }
        });
    }
}