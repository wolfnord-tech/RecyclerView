package ru.wolfnord.recyclerview;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<DataModel> dataModels;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dataModels = new ArrayList<>();
        adapter = new RecyclerViewAdapter(dataModels);

        addData("https://avatars.mds.yandex.net/i?id=040c60744841e247c31272845682fa9e_l-8174002-images-thumbs&n=13","Использование интерактивных методов обучения на уроках истории");
        addData("https://i.pinimg.com/originals/7a/9e/be/7a9ebe714be01a05afdbc1626335ffee.jpg","Формирование читательской грамотности на уроках литературы");
        addData("https://images.wallpapersden.com/image/download/dramatic-mountain-reflection-over-lake_bGlqbG2UmZqaraWkpJRsa21lrWloZ2U.jpg","Применение цифровых технологий в обучении математике");
        addData("https://s8.hostingkartinok.com/uploads/images/2016/08/a131e3cfd554b650c83ab2f5327b8b27.jpg","Развитие критического мышления на уроках литературы");
        addData("https://searchthisweb.com/wallpaper/moraine-lake_3840x2400_zzss6.jpg","Роль проектной деятельности в изучении химии");

        recyclerView.setAdapter(adapter);
    }

    public void addData(String imageUrl, String text) {
        DataModel newDataModel = new DataModel();
        newDataModel.setImageUrl(imageUrl);
        newDataModel.setText(text);
        dataModels.add(newDataModel);
        adapter.notifyDataSetChanged();
    }
}