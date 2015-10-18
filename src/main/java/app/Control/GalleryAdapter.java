package app.Control;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import app.R;


import java.util.List;

/**
 * Created by Shalom on 10/18/2015.
 */
public class GalleryAdapter extends ArrayAdapter<String> {

    private Context context ;


    public GalleryAdapter(Context context,int resource,List<String>items){

        super(context,resource,items);
        this.context=context;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent){


        ViewHolder holder;

        if(convertView==null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.gallery_item, parent);
            holder.view = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
       String currentItem=getItem(position);



        Picasso.with(context).load(currentItem).resize(300,300).centerCrop().into(holder.view);


        return convertView;
    }


    private class ViewHolder {
        private ImageView view ;
    }

}
