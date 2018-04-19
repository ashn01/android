package com.example.youngmin_mac.assignment4;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.io.File;

public class Main3Activity extends AppCompatActivity {

    private ImageView img;
    private Button update,exit,upload,delete;
    private EditText city,name,mvp;
    private Spinner sports;
    private SQLManager sqlMan;
    private String imgDecodableString="";

    private int id;

    private static int RESULT_LOAD_IMG = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent i = getIntent();
        id = Integer.parseInt(i.getStringExtra("id"));

        askPermission();


        sports = findViewById(R.id.sports);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.sports_array,R.layout.spinner_item);
        sports.setAdapter(adapter);

        img = findViewById(R.id.imageView);
        //img.setImageResource(R.drawable.not_found);

        update = findViewById(R.id.submit);
        exit = findViewById(R.id.exit);
        upload = findViewById(R.id.upload);
        delete = findViewById(R.id.delete);

        city = findViewById(R.id.cEdit);
        name = findViewById(R.id.nEdit);
        mvp = findViewById(R.id.mEdit);


        sqlMan = new SQLManager(this);



        //set items

        DataModel d = sqlMan.getData(id);
        d.showDetails();
        if(d != null)
        {
            city.setText(d.getCity());
            name.setText(d.getName());
            mvp.setText(d.getMvp());

            if(!d.getSport().equals("") )
            {
                int spinnerPos = adapter.getPosition(d.getSport().toString());
                sports.setSelection(spinnerPos);
            }

            if(!d.getImage().equals(""))
            {
                try{
                    File imgFile = new  File(d.getImage().toString());
                    if(imgFile.exists()){
                        Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                        ImageView myImage = (ImageView) findViewById(R.id.imageView);
                        myImage.setImageBitmap(myBitmap);
                    }
                }catch (Exception e)
                {

                }

            }
        }



        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!city.getText().toString().equals("")) {


                    DataModel d = new DataModel(0,city.getText().toString(),
                            name.getText().toString(),
                            sports.getSelectedItem().toString(),
                            mvp.getText().toString(),
                            imgDecodableString);

                    d.showDetails();

                    sqlMan.update(d,id);

                    Intent i = getIntent();
                    setResult(RESULT_OK,i);
                    finish();
                }
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                // Start the Intent
                startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlMan.delete(id);
                Intent i = getIntent();
                setResult(RESULT_OK,i);
                finish();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getIntent();
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data

                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();

                ImageView imgView = (ImageView) findViewById(R.id.imageView);
                // Set the Image in ImageView after decoding the String

                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                bitmap = Bitmap.createScaledBitmap(bitmap,  600 ,600, true);
                imgView.setImageBitmap(bitmap); //trying bitmap

//                imgView.setImageBitmap(BitmapFactory.decodeFile(imgDecodableString));
                System.out.println(imgDecodableString);
            } else {

            }
        } catch (Exception e) {

        }

    }

    public void askPermission()
    {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.
                int result=0;
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        result);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }

    @Override
    public void onBackPressed() {

    }
}
