package pt.ipbeja.estig.pdm.thewalkingdeadapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFrag extends ListFragment {


    public ListFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        /**
         * Creating an array adapter to host the list of items to be displayed in the ListFragment
         */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, twdData.Temporadas);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        if (getActivity().findViewById(R.id.activity_main) != null){
            Toast.makeText(getActivity().getBaseContext(), "Clicked Portrait." + twdData.Temporadas[position],
                    Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getActivity().getBaseContext(), "Clicked Landscape." + twdData.Temporadas[position],
                    Toast.LENGTH_SHORT).show();
        }
    }

}
