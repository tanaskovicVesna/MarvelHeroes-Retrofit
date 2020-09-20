package com.menu.assignment.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.menu.assignment.retrofitdemo.model.Image;
import com.menu.assignment.retrofitdemo.network.API;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    CustomAdapter customAdapter;
    public static List<Image> imageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        imageList = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API api = retrofit.create(API.class);

        //make network call
        Call<List<Image>> call = api.getImages();
        call.enqueue(new Callback<List<Image>>() {
            @Override
            public void onResponse(Call<List<Image>> call, Response<List<Image>> response) {
                if(response.isSuccessful()){

                   imageList = response.body();

                   customAdapter = new CustomAdapter(imageList,getApplicationContext());
                   gridView.setAdapter(customAdapter);
                   gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                       @Override
                       public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                           Intent intent = new Intent(MainActivity.this,ItemDataActivity.class);
                           intent.putExtra("name",imageList.get(position).getName());
                           intent.putExtra("image",imageList.get(position).getLink());
                           startActivity(intent);
                       }
                   });

                }else{
                    Toast.makeText(getApplicationContext(),"An error occurred",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<List<Image>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"An error occurred"+t.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });


    }

    public class CustomAdapter extends BaseAdapter{
        public List<Image> imagesList;

        public Context context;

        public CustomAdapter(List<Image> imagesList, Context context) {
            this.imagesList = imagesList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return imagesList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = LayoutInflater.from(context).inflate(R.layout.row_data,null);

            //find view
            TextView name = view.findViewById(R.id.textView);
            ImageView image= view.findViewById(R.id.imageView);

            //set data
            name.setText(imagesList.get(position).getName());

            //set image
            Glide.with(context)
                    .load(imagesList.get(position).getLink())
                    .into(image);


            return view;
        }
    }
}