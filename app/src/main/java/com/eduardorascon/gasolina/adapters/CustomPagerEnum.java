package com.eduardorascon.gasolina.adapters;

import com.eduardorascon.gasolina.R;

public enum CustomPagerEnum {

    RED(1, R.layout.activity_main),
    BLUE(2, R.layout.activity_favorites);

    private int mTitleResId, mLayoutResId;

    CustomPagerEnum(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }
}