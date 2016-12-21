package com.example.mac.myapplication;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by mac on 4‏/12‏/2016.
 */

public class PicassoClient {

    public static void downloadImage(Context c, String imageUrl, ImageView img) {
        if (imageUrl.length() > 0) {
               /* Transformation transformation = RoundedTransformationBuilder()
                        .borderColor(Color.BLACK)
                        .borderWidthDp(3)
                        .cornerRadiusDp(30)
                        .oval(false)
                        .build();*/

            // PicassoClient.with(c).load(imageUrl).resize(300,300).transform(new RoundedTransform()).placeholder(R.drawable.placeholder).into(img);
            Picasso.with(c).load(imageUrl).resize(200, 200).transform(new RoundedTransform()).placeholder(R.drawable.placehoder_name).into(img);

        } else {
            Picasso.with(c).load(R.drawable.placehoder_name).into(img);
        }
    }


}