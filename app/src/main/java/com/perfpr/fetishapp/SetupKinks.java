package com.perfpr.fetishapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SetupKinks extends AppCompatActivity {
    private static final String TAG = "SETUP KINKS" ;
    private RecyclerView rvKinks;
    private KinkAdapter mKinkAdapter;
    private LayoutInflater layoutInflater;
    private List<KinkList> mKinkList = new ArrayList<>();
    private TextView tvKinkName;
    private TextView tvKinkDesc;
    private RatingBar ratingBar;
    private Button btnSkip, btnNext;
    private CheckBox cbNeverTried;
    private Boolean neverTried;
    private int kinkInt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kink_rating_scale);


        tvKinkName = (TextView)findViewById(R.id.tvFetishName);
        tvKinkDesc = (TextView)findViewById(R.id.tvDescriptionLong);
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        btnSkip = (Button)findViewById(R.id.btnPrevious);
        btnNext = (Button)findViewById(R.id.btnNext);
        cbNeverTried = (CheckBox)findViewById(R.id.cbAttempted);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kinkInt ++;
                nextFetish();
            }
        });
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kinkInt--;
                nextFetish();
            }
        });
        kinkOne();

        addKinks();

    }

    private void nextFetish() {
        switch (kinkInt){
            case 0:
                Log.d(TAG, "KinkInt: " +kinkInt);
                tvKinkName.setText("Vanilla");
                tvKinkDesc.setText("Basic missionary fucking");
                float startRating = 0;
                ratingBar.setRating(startRating);
                ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        int rb = Math.round(rating);
                        ratingBar.setNumStars(rb);
                        saveInfo();

                    }
                });
                cbNeverTried.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked){
                            neverTried = true;
                            saveInfo();

                        }if(!isChecked){
                            neverTried = false;
                        }
                    }
                });
                break;
            case 1:
                Log.d(TAG, "KinkInt: " +kinkInt);
                tvKinkName.setText("Role Play");
                tvKinkDesc.setText("Basic dress up as Mario fucking");
                startRating = 0;
                ratingBar.setMax(5);
                ratingBar.setRating(startRating);
                ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        int rb = Math.round(rating);
                        ratingBar.setNumStars(rb);

                    }
                });
                break;
            case 2:
                Log.d(TAG, "KinkInt: " +kinkInt);
                tvKinkName.setText("Voyeurism");
                tvKinkDesc.setText("Basic spy fucking");
             startRating = 0;
             ratingBar.setMax(5);
                ratingBar.setRating(startRating);
                ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        int rb = Math.round(rating);
                        ratingBar.setNumStars(rb);

                    }
                });
                break;

            case 3:
                Log.d(TAG, "Case 4");
                tvKinkName.setText("NSA Hookup");
                tvKinkDesc.setText("Basic anon fucking");
                startRating = 0;
                ratingBar.setMax(5);
                ratingBar.setRating(startRating);
                ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        int rb = Math.round(rating);
                        ratingBar.setNumStars(rb);
                        kinkInt++;
                    }
                });
                break;
            case 4:
                Log.d(TAG, "Case 4");
                tvKinkName.setText("BDSM");
                tvKinkDesc.setText("Basic Bondage fucking");
                startRating = 0;
                ratingBar.setMax(5);
                ratingBar.setRating(startRating);
                ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        int rb = Math.round(rating);
                        ratingBar.setNumStars(rb);

                    }
                });
                break;

            case 5:
                Log.d(TAG, "Case 5");
                tvKinkName.setText("Foot");
                tvKinkDesc.setText("Basic Foot fucking");
                startRating = 0;
                ratingBar.setMax(5);
                ratingBar.setRating(startRating);
                ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        int rb = Math.round(rating);
                        ratingBar.setNumStars(rb);
                        saveInfo();
                    }
                });
                break;

        }
    }

    private void saveInfo() {

        Toast.makeText(this, "Save completed", Toast.LENGTH_LONG).show();
        Intent i = new Intent(SetupKinks.this, BaseActivity.class);
        startActivity(i);
    }

    private void kinkOne() {
        kinkInt = 1;
        tvKinkName.setText("Swinging / Group Fun");
        tvKinkDesc.setText("Basic group sexual activities.");
        float startRating = 0;
        ratingBar.setRating(startRating);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                int rb = Math.round(rating);
                ratingBar.setNumStars(rb);

            }
        });
    }

    private void addKinks() {
        KinkList kink1 = new KinkList("Vanilla", "Basic standard fucking", 0);
        mKinkList.add(kink1);
        KinkList kink2 = new KinkList("NSA Hookup", "Basic standard no strings attatched fucking", 0);
        mKinkList.add(kink2);
        KinkList kink3 = new KinkList("BDSM", "Basic standard BDSM fucking", 0);
        mKinkList.add(kink3);
        KinkList kink4 = new KinkList("Voyeurism", "Basic standard spy fucking", 0);
        mKinkList.add(kink4);
        KinkList kink5 = new KinkList("Swinging", "Basic standard group fucking", 0);
        mKinkList.add(kink5);



    }
}
