package com.example.kostas.reslife.gallery;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.kostas.reslife.R;

/**
 * Created by Kostas on 27/12/2015.
 */
public class SwipeAdapter extends PagerAdapter {
    private int[] image_resources = {/*R.drawable.imagetravelgreec, R.drawable.reslifephoto_eighteen, R.drawable.reslifephoto_sixteen,
                                     R.drawable.deree1,R.drawable.deree2,R.drawable.deree3,R.drawable.deree4,R.drawable.deree5,
                                     R.drawable.deree6,R.drawable.deree7,R.drawable.deree8*/};
    private Context ctx;
    private LayoutInflater layoutInflater;


    public SwipeAdapter (Context ctx){//constructor of the class
        this.ctx = ctx;
    }


    @Override
    public int getCount(){
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject (View view, Object o){
        return (view==(LinearLayout)o);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){

        layoutInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_layout, container, false);
        ImageView imageView = (ImageView)item_view.findViewById(R.id.swipe_imageView);
        imageView.setImageResource(image_resources [position]);
        container.addView(item_view);

        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){// in order to move to the next slide, delete the previous to make the app faster
        container.removeView((LinearLayout)object);

    }
}
