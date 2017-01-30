package pt.ipbeja.estig.pdm.thewalkingdeadapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toast.makeText(this, twdData.Temporadas[0], Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, twdData.TemporadasContent[0], Toast.LENGTH_SHORT).show();

        //Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            ListFrag Frag = new ListFrag();
            Frag.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, Frag).commit();
        }
    }
}
