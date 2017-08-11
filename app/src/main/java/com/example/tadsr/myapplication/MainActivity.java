package com.example.tadsr.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import android.util.Log;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        getRecentPhotos();
    }

    private void requestPhoto() {}

    void getRecentPhotos() {
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.flickr.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

        FlickrService service = retrofit.create(FlickrService.class);
        final Call<RecentPhotosResponse> responsas =
            service.recentPhotos("flickr.photos.getRecent", "a1daf817971864203840711e280cb197", "json",
                "url_n", true);
        responsas.enqueue(new Callback<RecentPhotosResponse>() {
            @Override
            public void onResponse(Call<RecentPhotosResponse> call, Response<RecentPhotosResponse> response) {

                mRecyclerView.setAdapter(
                    new RecyclerAdapter(response.body().getPhotosObject().getPhotoArrayList()));
            }

            @Override
            public void onFailure(Call<RecentPhotosResponse> call, Throwable throwable) {
                Log.i("TAG", "error: " + throwable.getMessage());
                throwable.printStackTrace();
            }
        });

    }

}
