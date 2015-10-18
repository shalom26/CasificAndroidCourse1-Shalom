package app.Fragments;

import android.app.Activity;
import android.app.DialogFragment;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.Control.GalleryAdapter;
import app.R;


public class GalleryFragment extends Fragment {

    Activity mActivity;
    GridView gridView;


    public static GalleryFragment newInstance() {
        GalleryFragment fragment = new GalleryFragment();
        return fragment;
    }

    public GalleryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_gallery, container, false);
        gridView =(GridView)v.findViewById(R.id.gridView);
        gridView.setAdapter(new GalleryAdapter(getActivity(),R.layout.gallery_item,getPhotos()));


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DialogFragment dialogFrag =new GalleryDailogFragment();

                Bundle bundle = new Bundle();
                bundle.putInt("position",position+1);
                bundle.putInt("total",parent.getCount());
            }
        });


        // text view
        TextView aboutText = (TextView) v.findViewById(R.id.about_textview);
        aboutText.setBackgroundColor(Color.TRANSPARENT);



        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private List<String>getPhotos(){

        Uri tablePath= MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[]columsToReturn={MediaStore.Images.Media.DATA};

        Cursor results=getActivity().getContentResolver().query(tablePath,columsToReturn,null,null,null);
        List<String>photos=new ArrayList<String>();

            if(results!=null){
                results.moveToFirst();
                while(!results.isAfterLast()){

                    int colIndex =results.getColumnIndex(MediaStore.Images.Media.DATA);
                    String filePath =results.getString(colIndex);

                    photos.add("file://"+filePath);

                    results.moveToNext();
                }
            }
        results.close();
        return photos;

    }
}
