package com.perfpr.fetishapp;

/**
 * Created by Gmurray68w on 6/14/2017.
 */

public class KinkList {
    private String mName;
    private String mDescription;
    private int mRating;

    public KinkList(String mName, String mDescription, int mRating) {
        this.mName = mName;
        this.mDescription = mDescription;
        this.mRating = mRating;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public int getmRating() {
        return mRating;
    }

    public void setmRating(int mRating) {
        this.mRating = mRating;
    }
}
