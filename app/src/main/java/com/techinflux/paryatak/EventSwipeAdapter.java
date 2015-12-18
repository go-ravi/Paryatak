package com.techinflux.paryatak;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class EventSwipeAdapter extends PagerAdapter{
    private int[] img_res = {R.drawable.slider1, R.drawable.slider2, R.drawable.slider3};
    private Context context;
    private LayoutInflater layoutInflater;

    public EventSwipeAdapter (Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return img_res.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_layout, container, false);
        ImageView imageView = (ImageView) item_view.findViewById(R.id.img_view);
        imageView.setImageResource(img_res[position]);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

}
