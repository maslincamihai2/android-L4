package com.androidcodr.threads;

import androidx.appcompat.app.AppCompatActivity;
import  android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;
    private int currentImageIndex = 0;
    private int[] images = {R.drawable.fotbal, R.drawable.volei, R.drawable.tenis};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image_view);
        textView = findViewById(R.id.text_view);

        LoadImageTask loadImageTask = new LoadImageTask();
        loadImageTask.execute(images[0], images[1], images[2]);
    }
    private class LoadImageTask extends AsyncTask<Integer, Void, Integer> {

        @Override
        protected Integer doInBackground(Integer... params) {
            return params[currentImageIndex];
        }

        @Override
        protected void onPostExecute(Integer result) {
            imageView.setImageResource(result);
            currentImageIndex = (currentImageIndex + 1) % images.length;
            textView.setText("Text asociat imaginii " + (currentImageIndex + 1));
        }
    }
}