package com.perfpr.fetishapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import static android.content.ContentValues.TAG;


public class KinkAdapter extends RecyclerView.Adapter<KinkAdapter.MyViewHolder>{
    private List<KinkList> mFetishList;
    private KinkList kinkList;
    private Context mContext;
    public KinkAdapter(List<KinkList> currentFetishes, Context context){
        this.mFetishList = currentFetishes;
        this.mContext = context;

    }
    @Override
    public KinkAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.kink_rating_scale, viewGroup, false);
        KinkAdapter.MyViewHolder viewHolder = new KinkAdapter.MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final KinkAdapter.MyViewHolder viewHolder, final int i) {
        final KinkList[] currentItem = {mFetishList.get(i)};
        viewHolder.fetishName.setText(currentItem[0].getmName());
        viewHolder.fetishDescription.setText(currentItem[0].getmDescription());
        viewHolder.fetishRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                int ratingInt = ratingBar.getNumStars();
                ratingBar.setNumStars(ratingInt);

            }
        });
        viewHolder.fetishRating.setNumStars(currentItem[0].getmRating());
        viewHolder.skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO setup click action
                Log.d(TAG, "Skip clicked");
            }
        });
        viewHolder.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Next clicked");
                switch (i){
                    case 0 :
                        Log.d(TAG, "First pos");
                         viewHolder.fetishDescription.setText(currentItem[0].getmDescription());
                        viewHolder.fetishRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                            @Override
                            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                                int ratingInt = ratingBar.getNumStars();
                                ratingBar.setNumStars(ratingInt);

                            }
                        });
                        viewHolder.fetishRating.setNumStars(currentItem[0].getmRating());
                        break;
                    case 1:
                        Log.d(TAG, "Second pos");
                        viewHolder.fetishName.setText(currentItem[1].getmName());
                        viewHolder.fetishDescription.setText(currentItem[1].getmDescription());
                        viewHolder.fetishRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                            @Override
                            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                                int ratingInt = ratingBar.getNumStars();
                                ratingBar.setNumStars(ratingInt);

                            }
                        });
                        viewHolder.fetishRating.setNumStars(currentItem[1].getmRating());
                        break;
                    case 2:
                        Log.d(TAG, "Third pos");

                }


            }
        });
    }

    @Override
    public int getItemCount() {
      return   mFetishList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView skip;
        TextView fetishName;
        TextView next;
        TextView fetishDescription;
        RatingBar fetishRating;
        public MyViewHolder(View itemView) {
            super(itemView);
            fetishName = (TextView)itemView.findViewById(R.id.tvFetishName);
            fetishDescription = (TextView)itemView.findViewById(R.id.tvDescriptionLong);
            fetishRating = (RatingBar)itemView.findViewById(R.id.ratingBar);
            skip = (TextView)itemView.findViewById(R.id.btnPrevious);
            next = (TextView)itemView.findViewById(R.id.btnNext);
        }
    }
}
