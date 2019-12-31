package com.e.taskmanager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgProfile;
    Button btnSignup;
EditText fName, lName, userName, etPassword, etConformPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imgProfile=findViewById(R.id.imgProfile);
        btnSignup=findViewById(R.id.btnSignup);
        fName=findViewById(R.id.fName);
        lName=findViewById(R.id.lName);
        userName=findViewById(R.id.userName);
        etPassword=findViewById(R.id.etPassword);
        etConformPassword=findViewById(R.id.etConformPassword);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermission();
                loadCamera();

            }
        });

    }
    private void checkPermission(){

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                +ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA},0);
        }
    }

    private void loadCamera(){
        Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(intent, 0);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 0 && resultCode==RESULT_OK){
            Bundle extras= data.getExtras();
            Bitmap imageBitmap=(Bitmap) extras.get("data");
            imgProfile.setImageBitmap(imageBitmap);


        }super.onActivityResult(requestCode, resultCode, data);


    }
}
