package org.pytorch.demo.objectdetection;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class Surrounding_Activity extends AppCompatActivity {

    VrPanoramaView panoramaView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surrounding);
       // panoramaView=findViewById(R.id.viewPanaroma);
       // loadPanoramaImage();
    }

//    private void loadPanoramaImage() {
//        VrPanoramaView.Options options = new VrPanoramaView.Options();
//        try {
//            options.inputType = VrPanoramaView.Options.TYPE_MONO;
////            Picasso
////                    .get()
////                    .load("https://firebasestorage.googleapis.com/v0/b/mobile-app-da42b.appspot.com/o/christ_football_ground.jpg?alt=media&token=9f9e3498-62c1-4bd4-9943-222f3492d102")
////                    .into(panoramaView);
//            panoramaView.loadImageFromBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.block2_surroundings), options);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        VrPanoramaView.Options options = new VrPanoramaView.Options();
//        String url = "https://firebasestorage.googleapis.com/v0/b/mobile-app-da42b.appspot.com/o/block2_surroundings.jpg?alt=media&token=7fc26901-cc31-404b-b901-b703682e6264";
//
//        Picasso.get().load(url).into(new Target() {
//            @Override
//            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
//                options.inputType = VrPanoramaView.Options.TYPE_MONO;
//                panoramaView.loadImageFromBitmap(bitmap, options);
//            }
//
//            @Override
//            public void onBitmapFailed(Exception e, Drawable errorDrawable) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onPrepareLoad(Drawable placeHolderDrawable) {
//                // Optional: Handle placeholder drawable preparation
//            }
//        });
//    }

}