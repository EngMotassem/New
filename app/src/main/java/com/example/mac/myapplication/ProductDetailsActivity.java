package com.example.mac.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class ProductDetailsActivity extends AppCompatActivity {
    public Context context;
    private TextView tv1, tv2;
    private ImageView iv;
    private ImageButton phone, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // FloatingActionButton fab = (FloatingActionButton) findViewById( R.id.fab );
        /*fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make( view, "Replace with your own action", Snackbar.LENGTH_LONG )
                        .setAction( "Action", null ).show();
            }
        } );*/
        //getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        //getSupportActionBar().setDisplayOptions(0);

        Intent i = getIntent();
        String productName = i.getExtras().getString("name");
        String productDetails = i.getExtras().getString("details");
        String imageUrl = i.getExtras().getString("imageUrl");

        int img = i.getExtras().getInt("image");

        iv = (ImageView) findViewById(R.id.deailsImage);

        PicassoClient.downloadImage(getApplicationContext(), imageUrl, iv);
        tv1 = (TextView) findViewById(R.id.product_name);
        tv2 = (TextView) findViewById(R.id.product_details);

        tv1.setText(productName);
        tv2.setText(productDetails);

        email = (ImageButton) findViewById(R.id.emailButton);

        phone = (ImageButton) findViewById(R.id.callButton);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:60056111"));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                //og.i("Send email", "");
                String[] TO = {"mrchili29@yahoo.com"};
                String[] CC = {""};
                String subject = tv1.getText().toString();
                String message = tv2.getText().toString();

                emailIntent.setData(Uri.parse("mailto:"));
                // emailIntent.setType("text/plain");
                emailIntent.setType("message/rfc822");


                //android.content.Intent.ACTION_SENDTO (new Intent(Intent.ACTION_SENDTO));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                emailIntent.putExtra(Intent.EXTRA_CC, CC);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                emailIntent.putExtra(Intent.EXTRA_TEXT, message);

                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();
                    //Log.i("Finished sending email...", "");
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(ProductDetailsActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}
