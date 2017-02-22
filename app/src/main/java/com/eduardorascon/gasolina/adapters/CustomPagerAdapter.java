package com.eduardorascon.gasolina.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CustomPagerAdapter extends PagerAdapter {
    private Context context;

    //TODO: Ceck if we can override getItem()
    public CustomPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        CustomPagerEnum pagerEnum = CustomPagerEnum.values()[position];
        LayoutInflater inflater = LayoutInflater.from(this.context);
        ViewGroup layout = (ViewGroup) inflater.inflate(pagerEnum.getLayoutResId(), collection, false);
        collection.addView(layout);

        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return CustomPagerEnum.values().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        CustomPagerEnum pagerEnum = CustomPagerEnum.values()[position];
        return this.context.getString(pagerEnum.getTitleResId());
    }
}