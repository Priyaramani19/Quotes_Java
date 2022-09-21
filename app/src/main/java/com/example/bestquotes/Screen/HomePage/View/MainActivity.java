package com.example.bestquotes.Screen.HomePage.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bestquotes.R;
import com.example.bestquotes.Screen.HomePage.Controller.Adapter_category;
import com.example.bestquotes.Screen.HomePage.Model.Model_category;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;
    AutoCompleteTextView auto_com_txt;

    String[] category = {"Emotional","Motivational","Love","Sad","Family","Attitude","Birthday","Food",
                        "Marriage","Mother","Father","Music","Shopping","Success","Women","Thank You","Sister",
                        "Rain","Party","Parents"};


    String[] images = {"https://soulsofsilver.com/wp-content/uploads/2020/10/iStock-688148142-1.jpg","https://avatars.mds.yandex.net/i?id=c3ee0cf40c9f4a789c753d90e49aa51a-5876743-images-thumbs&n=13","https://avatars.mds.yandex.net/i?id=5b68b7a1a5f3fedf0ab4da5443a52d9e-4697805-images-thumbs&n=13",
                        "https://adoptlondon.org.uk/app/uploads/2020/10/SomePeople_Teddy-scaled.jpg","https://avatars.mds.yandex.net/i?id=feb23af0022d282bf89d0c68bfd0ad70-5666076-images-thumbs&n=13", "https://avatars.mds.yandex.net/i?id=5bfb47d694cd058fea9ddb4d1332561e-5452061-images-thumbs&n=13",
                        "https://avatars.mds.yandex.net/i?id=8a690bf1d49ac6418e5d0bc0bf83afa6-5877309-images-thumbs&n=13","https://avatars.mds.yandex.net/i?id=dd300eab1cf9c0aecef7043b1a6a26d9-4055786-images-thumbs&n=13", "https://avatars.mds.yandex.net/i?id=529a072dba0bcbf86c18d537890cf577-5474261-images-thumbs&n=13",
                        "https://avatars.mds.yandex.net/i?id=29c257ac28965946a5ecf2fad05e2116-5465325-images-thumbs&n=13", "https://avatars.mds.yandex.net/i?id=2a9da0e57a428cc92383bb87cab61b77-5856310-images-thumbs&n=13", "https://avatars.mds.yandex.net/i?id=344a9ab48c2a8cb5aaeef09ad872909e-5733951-images-thumbs&n=13",
                        "https://avatars.mds.yandex.net/i?id=892c25e60ef7b6fc73d1c03ebdb359a1-5704334-images-thumbs&n=13", "https://avatars.mds.yandex.net/i?id=c2c968edb4515c2d09d60ac2a5fdf754-4575626-images-thumbs&n=13", "https://avatars.mds.yandex.net/i?id=7469e5e9e36f314e76f9cdb276bcfb33-4577649-images-thumbs&n=13",
                        "https://avatars.mds.yandex.net/i?id=c4e2de2d4365a75a2d638512a2abde64-5234381-images-thumbs&n=13", "https://avatars.mds.yandex.net/i?id=acb6e2b1dbdd869e6352711195c406b9-5877309-images-thumbs&n=13", "https://avatars.mds.yandex.net/i?id=15e8b446db1f3ba5a27c0739eee9245a-5844149-images-thumbs&n=13",
                        "https://avatars.mds.yandex.net/i?id=1c8ea2e180e467c663bf29c5bf57aea4-5708463-images-thumbs&n=13", "https://avatars.mds.yandex.net/i?id=bed5b6d6bea911e91966ca217a36a809-5485045-images-thumbs&n=13"};

    List<Model_category> l1 = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding();



        for(int i=0;i< category.length;i++)
        {
            Model_category modelCategory = new Model_category(category[i],images[i]);

            l1.add(modelCategory);
        }

        Adapter_category adapterCategory = new Adapter_category(MainActivity.this,l1);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapterCategory);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,category);
        auto_com_txt.setAdapter(arrayAdapter);

        Editable search = auto_com_txt.getText();


    }

    void binding()
    {
        recycler = findViewById(R.id.recycler);
        auto_com_txt = findViewById(R.id.auto_com_txt);
    }
}