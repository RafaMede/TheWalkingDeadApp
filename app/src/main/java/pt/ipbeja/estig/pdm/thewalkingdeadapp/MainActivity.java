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
        //db.insertTemporadas("Temporada1", R.drawable.temporada1, "A 1ª Temporada de The Walking Dead começou a ser transmitida a 31 de Outubro de 2010 e foi concluida a 5 de Dezembro de 2010, consistiu em 6 episódios.", "https://goo.gl/maps/L9SPn94xke52", "tel: 926758430");
        //db.insertTemporadas("Temporada2", R.drawable.temporada2, "A 2ª Temporada de The Walking Dead começou a ser transmitida a 16 de Outubro de 2011 e foi concluida a 18 de Março de 2012, consistiu em 13 episódios.", "https://goo.gl/maps/L9SPn94xke52", "tel: 926758430");
        //db.insertTemporadas("Temporada3", R.drawable.temporada3, "A 3ª Temporada de The Walking Dead começou a ser transmitida a 14 de Outubro de 2012 e foi concluida a 31 de Março de 2013, consistiu em 16 episódios.", "https://goo.gl/maps/L9SPn94xke52", "tel: 926758430");
        //db.insertTemporadas("Temporada4", R.drawable.temporada4, "A 4ª Temporada de The Walking Dead começou a ser transmitida a 13 de Outubro de 2013 e foi concluida a 30 de Março de 2014, consistiu em 16 episódios.", "https://goo.gl/maps/L9SPn94xke52", "tel: 926758430");
        //db.insertTemporadas("Temporada5", R.drawable.temporada5, "A 5ª Temporada de The Walking Dead começou a ser transmitida a 12 de Outubro de 2014 e foi concluida a 29 de Março de 2015, consistiu em 16 episódios.", "https://goo.gl/maps/L9SPn94xke52", "tel: 926758430");
        //db.insertTemporadas("Temporada6", R.drawable.temporada6, "A 6ª Temporada de The Walking Dead começou a ser transmitida a 11 de Outubro de 2015 e foi concluida a 3 de Abril de 2016, consistiu em 16 episódios.", "https://goo.gl/maps/L9SPn94xke52", "tel: 926758430");
        //db.insertTemporadas("Temporada7", R.drawable.temporada7, "A 7ª Temporada de The Walking Dead começou a ser transmitida a 23 de Outubro de 2016 e vai regressar a 12 de Abril de 2017, vai consistir em 16 episódios.", "https://goo.gl/maps/L9SPn94xke52", "tel: 926758430");

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
