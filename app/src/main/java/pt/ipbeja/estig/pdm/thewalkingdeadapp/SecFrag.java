package pt.ipbeja.estig.pdm.thewalkingdeadapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecFrag extends Fragment {

    public SecFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_sec, container, false);
    }

    @Override public void onStart() {
        super.onStart();

        Bundle args = getArguments();
        if (args != null) {

            int currentPosition = args.getInt("position");
            updateArticleView(currentPosition);
        }
        else{
            updateArticleView(0);
        }
    }

    public void updateArticleView( int position){
        TextView content = (TextView) getActivity().findViewById(R.id.SecFrag);
        content.setText(twdData.ListDescription.get(position));
        ImageView photo = (ImageView) getActivity().findViewById(R.id.imageTemporada);
        photo.setImageResource(twdData.ListPhoto.get(position));
    }
}
