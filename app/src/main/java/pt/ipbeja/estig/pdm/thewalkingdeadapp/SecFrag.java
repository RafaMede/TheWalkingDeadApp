package pt.ipbeja.estig.pdm.thewalkingdeadapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecFrag extends Fragment {

    int currentPosition;

    public SecFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sec, container, false);
    }

    @Override public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        if (args != null) {
            currentPosition = args.getInt("position");
            TextView article = (TextView) getActivity().findViewById(R.id.SecFrag);
            article.setText(twdData.TemporadasContent[currentPosition]);
            }
        }

}
