package com.example.recycleviewdancardview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    RecyclerView.Adapter recyclerViewAdapter;

    RecyclerView.LayoutManager recyclerViewLayoutManager;
    private ArrayList<SkincareModel> skincareModel;

    private SkincareAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        getData();

        recyclerView = findViewById(R.id.skincare);
        recyclerView.setHasFixedSize(true);

        recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        setOnClickListener();
        recyclerViewAdapter = new SkincareAdapter(this, skincareModel,listener);
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    private void setOnClickListener(){
        listener = new SkincareAdapter.RecyclerViewClickListener(){
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("namabarang", skincareModel.get(position).getNamaSkincare());
                intent.putExtra("deskripsibarang", getDeskripsi(skincareModel.get(position).getNamaSkincare()));
                intent.putExtra("hargabarang", getHarga(skincareModel.get(position).getNamaSkincare()));
                intent.putExtra("gambarbarang",skincareModel.get(position).getGambarSkincare());
                startActivity(intent);
            }
        };
    }

    private void getData() {
        skincareModel = new ArrayList<>();
        skincareModel.add(new SkincareModel("PITERA™ Facial Treatment", R.drawable.tonerskii, "Toner yang menghidrasi dengan kandungan AHA untuk mengelupas dan mengkondisikan kulit.", 1249155.));
        skincareModel.add(new SkincareModel("SKINPOWER Advanced Cream", R.drawable.moisskii, "Untuk mengurangi munculnya garis-garis halus dan membuat kulit terasa kenyal dan kenyal.", 3981777.));
        skincareModel.add(new SkincareModel("PITERA™ Facial Treatment Cleanse", R.drawable.sabunskii, "Tampilkan kulit yang bersih dan halus dengan pembersih berbusa kami.", 1172095.));
        skincareModel.add(new SkincareModel("LXP Ultimate Revival Eye Cream", R.drawable.eyecareskii, "PITERA™ Konsentrat Tertinggi kami dalam krim mata yang sangat kaya.", 3125513.));
        skincareModel.add(new SkincareModel("GenOptics Ultraura Essence Serum", R.drawable.serumskii, "Kurangi kulit kusam, cerahkan warna kulit Anda, dan targetkan bintik matahari yang terlihat secara holistik.", 4134074.));
        skincareModel.add(new SkincareModel("Facial Toner Hydrating", R.drawable.tonerskin, "Membantu melembabkan hingga lapisan kulit terdalam, sehingga kulit lebih terhidrasi, lembap, segar, dan memperkuat skin barier.", 296317.));
        skincareModel.add(new SkincareModel("Repair Moisture Gel", R.drawable.moisskin, "Bersihkan dengan lembut dengan perlindungan penghalang lembab.", 139000.));
        skincareModel.add(new SkincareModel("Ceramide Low pH Cleanser", R.drawable.sabunskin, "Bersihkan dengan lembut dengan perlindungan penghalang lembab.", 169000.));
        skincareModel.add(new SkincareModel("Crystal Massager Lifting", R.drawable.eyecareskin, "Untuk memudarkan lingkaran hitam nakal di area bawah mata dan mengurangi munculnya mata bengkak.", 229000.));
        skincareModel.add(new SkincareModel("Ceramide Barrier Repair Serum", R.drawable.serumskin, "Serum diformulasikan untuk mengoptimalkan perbaikan pelindung kulit yang rusak.",  199000.));
        skincareModel.add(new SkincareModel("Whitelab Essence Toner", R.drawable.tonerwl, "Dapat membantu mengembalikan pH alami kulit wajah, membersihkan sisa debu dan kotoran.", 58000.));
        skincareModel.add(new SkincareModel("Whitelab Barrier Moisturizing Gel", R.drawable.moiswl, "Dapat mempertahankan fungsi skin barrier, meningkatkan level hidrasi, dan menenangkan kulit yang iritasi.",  95400.));
        skincareModel.add(new SkincareModel("Whitelab pH-Balanced Facial Cleanser", R.drawable.sabunwl, "Dapat membersihkan wajah dari debu, kotoran, dan sebum berlebih hingga ke pori-pori.", 62100.));
        skincareModel.add(new SkincareModel("Whitelab Eye Cream", R.drawable.eyecarewl, "Merawat elastisitas kulit, menyamarkan kerutan, dan mencerahkan area sekitar mata sehingga tampak lebih segar.", 84600.));
        skincareModel.add(new SkincareModel("Whitelab A-Dose+ Glowing Serum", R.drawable.serumwl, "Membantu menyamarkan noda hitam dan bekas jerawat, sehingga warna kulit tampak lebih merata, cerah, dan lembap.", 84300.));

    }
    private String getDeskripsi(String namaSkincare) {
        for (SkincareModel parfume : skincareModel) {
            if (parfume.getNamaSkincare().equals(namaSkincare)) {
                return parfume.getDeskripsiSkincare();
            }
        }
        return "";
    }

    private double getHarga(String namaSkincare) {
        for (SkincareModel parfum : skincareModel) {
            if (parfum.getNamaSkincare().equals(namaSkincare)) {
                return parfum.getHargaSkincare();
            }
        }
        return 0.0;
    }
}

