package com.perfpr.fetishapp;

import android.content.Context;
import android.icu.util.Calendar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Gmurray68w on 6/17/2017.
 */

public class UserPickerAdapter extends RecyclerView.Adapter<UserPickerAdapter.MyViewHolder> {


    private List<StandardUser> userList;
    private Context mContext;
    private Calendar today;

    public UserPickerAdapter(List<StandardUser> currentUsers, Context context){
        this.userList = currentUsers;
        this.mContext = context;
    }

    @Override
    public UserPickerAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
      View view = LayoutInflater.from(viewGroup.getContext()).inflate(
              R.layout.user_card_layout, viewGroup, false);
      UserPickerAdapter.MyViewHolder viewHolder = new UserPickerAdapter.MyViewHolder(view);
      return viewHolder;

    }

    @Override
    public void onBindViewHolder(UserPickerAdapter.MyViewHolder vh, int i) {
 final StandardUser currentUser = userList.get(i);
    vh.mName.setText(currentUser.getmFirstName().toString());
        vh.mGender.setText(currentUser.getmSexualOrientation());

        String dobUnformatted = currentUser.getmDob();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            today = Calendar.getInstance();
        }


        vh.mTopFetish1.setText(currentUser.getmKinks());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView profilePic;
        TextView mName;
        TextView mGender;
        TextView mDistance;
        TextView mAge;
        TextView mTopFetish1;
        TextView mTopFetish2;
        TextView mTopFetish3;
        public MyViewHolder(View itemView) {
            super(itemView);
            profilePic = (ImageView)itemView.findViewById(R.id.ivProfilePic);
            mName = (TextView)itemView.findViewById(R.id.tvName);
            mGender = (TextView)itemView.findViewById(R.id.tvGender);
            mDistance = (TextView)itemView.findViewById(R.id.tvDistance);
            mAge = (TextView)itemView.findViewById(R.id.tvAge);
            mTopFetish1 = (TextView)itemView.findViewById(R.id.tvFetish1);
            mTopFetish2 = (TextView)itemView.findViewById(R.id.tvFetish2);
            mTopFetish3 = (TextView)itemView.findViewById(R.id.tvFetish3);
        }
    }
}
