package pt.ipbeja.estig.pdm.thewalkingdeadapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class GPSCordenadas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpscordenadas);

        Intent intentGPS = getIntent();
        String gps = intentGPS.getStringExtra("gps");
        WebView gpsWeb = (WebView) findViewById(R.id.GPSwebView);
        gpsWeb.loadUrl(gps);
    }
}
