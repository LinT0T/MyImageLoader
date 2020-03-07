package com.lint0t.myimageloader;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final static String[] imageUrls = new String[]{
            "http://img.mukewang.com/54780ea90001f3b406000338.jpg",
            "http://img.mukewang.com/547ed1c9000150cc06000338.jpg",
            "http://img.mukewang.com/54214727000160e306000338.jpg",
            "http://img.mukewang.com/54125edc0001ce6306000338.jpg",
            "http://img.mukewang.com/548165820001b4b006000338.jpg",
            "http://img.mukewang.com/53d74f960001ae9d06000338.jpg",
            "http://img.mukewang.com/547d5a45000156f406000338.jpg",
            "http://img.mukewang.com/549bda090001c53e06000338.jpg",
            "http://img.mukewang.com/530f0ef700019b5906000338.jpg",
            "http://img.mukewang.com/550a87da000168db06000338.jpg",
            "http://img.mukewang.com/550a836c0001236606000338.jpg",
            "http://img.mukewang.com/550a78720001f37a06000338.jpg",
            "http://img.mukewang.com/5513e20600017c1806000338.jpg",
            "http://img.mukewang.com/5513a1b50001752806000338.jpg",
            "http://img.mukewang.com/550a33b00001738a06000338.jpg",
            "http://img.mukewang.com/551380400001da9b06000338.jpg",
            "http://img.mukewang.com/54c87c73000150cf06000338.jpg",
            "http://img.mukewang.com/5518bbe30001c32006000338.jpg",
            "http://img.mukewang.com/5518ecf20001cb4e06000338.jpg",
            "http://img.mukewang.com/551916790001125706000338.jpg",
            "http://img.mukewang.com/550b86560001009406000338.jpg",
            "http://img.mukewang.com/551b98ae0001e57906000338.jpg",
            "http://img.mukewang.com/5518c3d7000175af06000338.jpg",
            "http://img.mukewang.com/551b92340001c9f206000338.jpg",
            "http://img.mukewang.com/552640c300018a9606000338.jpg",
            "http://img.mukewang.com/551de0570001134f06000338.jpg",
            "http://img.mukewang.com/551e470500018dd806000338.jpg",
            "http://img.mukewang.com/5523711700016d1606000338.jpg",
            "http://img.mukewang.com/55249cf30001ae8a06000338.jpg",
            "http://img.mukewang.com/55237dcc0001128c06000338.jpg"
    };
    private List<Bean> imgs = new ArrayList<>();
    private List<Bitmap> a = new ArrayList<>();
    private ImageView imageView;
    private MyAdapter adapter;
    private RecyclerView mrv_test;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 200:
                    Bitmap bitmap = (Bitmap) msg.obj;
                    Bean bean = new Bean(bitmap);
                    a.add(bitmap);
                    imgs.add(bean);
                    imageView.setImageBitmap(bean.getBitmap());
                    adapter.notifyItemChanged(imgs.size() - 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.img_test);
        mrv_test = findViewById(R.id.rv_test);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mrv_test.setLayoutManager(layoutManager);
        adapter = new MyAdapter(a);
        mrv_test.setAdapter(adapter);
        MyImageLoader myImageLoader = new MyImageLoader(this);
        myImageLoader.setHandler(handler).setTaskNumber(1).load();
        myImageLoader.setMaxThread(30);
        for (int i = 0; i < imageUrls.length; i++) {
            myImageLoader.loads(imageUrls[i]);
        }

    }
}
