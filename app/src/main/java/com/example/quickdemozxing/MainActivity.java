package com.example.quickdemozxing;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnScan = findViewById(R.id.btnScan);
        btnScan.setOnClickListener(this);
        Log.d("CQ - TESTING", "onCreate");
    }

    @Override
    public void onClick(View v) {
        scanItemCode();
        Log.d("CQ - TESTING", "onClick");
    }

    private void scanItemCode(){
        // This will call onActivityResult eventually.

        // IntentIntegrator is a utility class that allows integration using Intents

        // Initiating an instance of IntentIntegrator
        IntentIntegrator intentIntegrator = new IntentIntegrator(this);
        // can be any activity, but it should handle intent extras
        intentIntegrator.setCaptureActivity(CapturedActivityInformation.class);
        intentIntegrator.setOrientationLocked(false);

        // This will allow almost all barcode formats to be scanned.
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);

        // This is the text that appears when you are trying to scan an item
        intentIntegrator.setPrompt("Scanning item");

        // This is what is initializing the scan
        intentIntegrator.initiateScan();
        Log.d("CQ - TESTING", "scanItemCode");
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            if(result.getContents() != null) {
                // This is a subclass of dialog, displays up to 3 buttons. (this just has exit and scan again)
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                // This is setting the message to be the number of the code that was scanned
                builder.setMessage(result.getContents());
                builder.setTitle("Scanned Item Results: ");

                // Event if the person wants to scan an item again
                // This will also calls the scanItem code again
                builder.setPositiveButton("Scan again?", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        scanItemCode();
                        Log.d("CQ - TESTING", "onActivityResult - SCAN AGAIN");
                    }

                    // This is just going to end the call
                }).setNegativeButton("Exit?", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        Log.d("CQ - TESTING", "onActivityResult - EXIT");

                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                Log.d("CQ - TESTING", "Item was scanned.");

            } else {
                Toast.makeText(this, "Please try again.",  Toast.LENGTH_LONG).show();
                Log.d("CQ - TESTING", "Didnt work");
            }

        } else {
            super.onActivityResult(requestCode, resultCode, data);
            Log.d("CQ - TESTING", "onActivityResult");
        }
    }
}
