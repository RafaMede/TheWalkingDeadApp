package pt.ipbeja.estig.pdm.thewalkingdeadapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements
        ListFrag.OnListSelectedListener {

    public int pos;

    public void onSecFragSelected(int position) {
        if (findViewById(R.id.fragment_container) != null){

            SecFrag newContent = new SecFrag();
            Bundle args = new Bundle();
            args.putInt("position", position);
            newContent.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.fragment_container, newContent);
            transaction.addToBackStack(null);

            transaction.commit();

        }
        else{

            SecFrag ContentFrag = (SecFrag)
            getSupportFragmentManager().findFragmentById(R.id.fragment_sec);
            ContentFrag.updateArticleView(position);
        }
        pos = position;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if( savedInstanceState == null) {
            Initialize();

        }

        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }

            ListFrag listFragment = new ListFrag();

            listFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, listFragment).commit();
        }
    }

    public void Initialize(){

        DBHelper db = new DBHelper(this);
        //db.insertTemporadas("Temporada1", "A primeira temporada tem 6 episódios.", R.drawable.temporada1, "https://goo.gl/maps/MeUV5yRDjQ22", "tel: 968526910");
        //db.insertTemporadas("Temporada2", "A primeira temporada tem 13 episódios.", R.drawable.temporada2, "https://goo.gl/maps/yKPHE2PxZj72", "tel: 969762806");
        //db.insertTemporadas("Temporada3", "A primeira temporada tem 16 episódios.", R.drawable.temporada3, "https://goo.gl/maps/L9SPn94xke52", "tel: 926758430");
        //db.insertTemporadas("Temporada4", "A primeira temporada tem 16 episódios.", R.drawable.temporada4, "https://goo.gl/maps/L9SPn94xke52", "tel: 926758430");
        //db.insertTemporadas("Temporada5", "A primeira temporada tem 16 episódios.", R.drawable.temporada5, "https://goo.gl/maps/L9SPn94xke52", "tel: 926758430");
        //db.insertTemporadas("Temporada6", "A primeira temporada tem 16 episódios.", R.drawable.temporada6, "https://goo.gl/maps/L9SPn94xke52", "tel: 926758430");
        //db.insertTemporadas("Temporada7", "A primeira temporada tem 16 episódios.", R.drawable.temporada7, "https://goo.gl/maps/L9SPn94xke52", "tel: 926758430");


        twdData.ListFrag = db.getAllNames();
        twdData.ListDescription = db.getAllDescription();
        twdData.ListPhoto = db.getAllPhoto();
        twdData.ListGPS = db.getAllGPS();
        twdData.ListCellphone = db.getAllCellphone();

    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    public void btnCall_onClick(View view) {

        Uri number = Uri.parse(twdData.ListCellphone.get(pos));
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(callIntent);
    }

    public void btnGPS_onClick(View view) {
        Uri gps = Uri.parse(twdData.ListGPS.get(pos));
        Intent callGPS = new Intent(Intent.ACTION_VIEW, gps);
        startActivity(callGPS);
    }
}
