package app.Fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import app.R;

/**
 * Created by Shalom on 10/18/2015.
 */
public class GalleryDailogFragment extends DialogFragment {


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle saveInstanceState) {

        View view =inflater.inflate(R.layout.large_gallery_image, container);
        ImageView imageView = (ImageView) view.findViewById(R.id.LargimageView);

        Bundle bundle = getArguments();

        if (bundle != null) {
            Picasso.with(getActivity()).load(bundle.getString("uri")).into(imageView);
        }

        return view;
    }
    }




