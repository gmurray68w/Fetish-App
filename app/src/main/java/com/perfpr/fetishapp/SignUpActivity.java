package com.perfpr.fetishapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity {
    private TextView tvImMale;
    private TextView tvImTrans;
    private TextView tvImFemale;
    private TextView tvSeekingMale;
    private TextView tvSeekingTrans;
    private TextView tvSeekingFemale;
    private EditText etFirstName;
    private EditText etLastName;
    private ImageView ivImMale;
    private ImageView ivImTrans;
    private ImageView ivImFemale;
    private ImageView ivSeekingMale;
    private ImageView ivSeekingTrans;
    private ImageView ivSeekingFemale;
    private Button btnDob;
    private TextView tvDob;
    private TextView tvNext;
    private String formatedDate;
    int year, month, day;
    private String SexualOrientation;
    private ArrayList<StandardUser> standardUsers = new ArrayList<>();
    private String seeking;
    private String gender;
    private String zipCode;
    private String savedZip;
    private String savedBio;
    private String bio;
    private String email, savedEmail;
    private static final String TAG = "SIGNUPACTIVITY.class";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        dobDialog();
        //Import objects
        etFirstName = (EditText) findViewById(R.id.etFirst);
        etLastName = (EditText)findViewById(R.id.etLastName);
        //Gender
        ivImMale = (ImageView)findViewById(R.id.ivImMale);
        tvImMale = (TextView)findViewById(R.id.tvMale);
        ivImTrans = (ImageView)findViewById(R.id.ivImTrans);
        tvImTrans = (TextView)findViewById(R.id.tvTrans);
        ivImFemale = (ImageView)findViewById(R.id.ivImFem);
        tvImFemale = (TextView)findViewById(R.id.tvFemale);
        //Seeking
        ivSeekingMale = (ImageView)findViewById(R.id.ivSeekingMale);
        ivSeekingFemale = (ImageView)findViewById(R.id.ivSeekingFemale);
        ivSeekingTrans = (ImageView)findViewById(R.id.ivSeekingTrans);
        tvSeekingMale = (TextView)findViewById(R.id.tvSeekingMale);
        tvSeekingTrans = (TextView)findViewById(R.id.tvSeekingTrans);
        tvSeekingFemale = (TextView)findViewById(R.id.tvSeekingFem);
        //Dob

        tvDob = (TextView)findViewById(R.id.tvDob);
        //Next
        tvNext = (TextView)findViewById(R.id.btnNext);

        //Add Listeners
        ivImMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genderMale();
            }
        });
        ivImTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genderTrans();
            }
        });
        ivImFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genderFemale();
            }
        });
        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

        //Turn off textviews
        tvSeekingFemale.setVisibility(View.INVISIBLE);
        tvSeekingMale.setVisibility(View.INVISIBLE);
        tvSeekingTrans.setVisibility(View.INVISIBLE);
          //Calendar
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        formatedDate = sdf.format(c.getTime());
        tvDob.setText(formatedDate);


    }

    private void save() {
        dobDialog();
     String first =  etFirstName.getText().toString();
     String last = etLastName.getText().toString();
     if(first.length() >1){
         if(last.length()> 1){
             //TODO save strings
             String lastName = etLastName.getText().toString();
             String firstName = etFirstName.getText().toString();
             String dob = tvDob.getText().toString();
             String selectedGender = gender;
             String selectedSeeking = seeking;
             String orientation = SexualOrientation;
             StandardUser user = new StandardUser("pathtoPhoto" ,firstName,lastName,dob,selectedGender,
                     savedBio, orientation,"kinks","rejected List",
                     "unmatched List", "matched List", savedEmail,
                     savedZip, formatedDate, true);
             standardUsers.add(user);
             Intent i = new Intent(SignUpActivity.this, SetupKinks.class);
             startActivity(i);

         }else {
             //TODO Setup errors
         }
     }else {
         //TODO Setup Errors
     }
    }

    private void dobDialog() {
    showDialog(999);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id ==999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }

        return null;
    }


    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            String mMonth = String.valueOf(month);
            String mDayOfMonth = String.valueOf(dayOfMonth+1);
            String mYear = String.valueOf(year);
            Log.d(TAG, "DOB: " + mMonth + "\n" + mDayOfMonth + "\n" + mYear);
            tvDob.setText("DOB: " + mMonth + "/"+ mDayOfMonth + "/" + mYear);
            zipEmail();
        }
    };

    private void zipEmail() {
        Log.d(TAG, "ZipEmail initiated");
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(SignUpActivity.this);
        alertDialog.setTitle("Zip Code");
        alertDialog.setMessage("Please enter Zip Code");
        final EditText inputZip = new EditText(SignUpActivity.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        inputZip.setLayoutParams(lp);
        inputZip.setHint("17257");
        int type =Integer.getInteger("number", 0);

        inputZip.setInputType(type);

        alertDialog.setView(inputZip);
        alertDialog.setIcon(R.drawable.ic_location_city_cyan_500_24dp);

        alertDialog.setPositiveButton("Next", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                zipCode = inputZip.getText().toString();
                if(zipCode.length() == 0){

                }else if(zipCode.length() == 5){
                    savedZip = zipCode;
                    getEmail();
                }
            }
        });

        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.setCancelable(true);
        alertDialog.show();
        Log.d(TAG , "ZipEmail finished");
    }

    private void getEmail() {
        AlertDialog.Builder alertEmailDialog = new AlertDialog.Builder(SignUpActivity.this);
        alertEmailDialog.setTitle("Email");
        alertEmailDialog.setMessage("Please enter a valid email address");
        final EditText inputEmail = new EditText(SignUpActivity.this);
        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        inputEmail.setLayoutParams(lp2);
        alertEmailDialog.setView(inputEmail);
        alertEmailDialog.setIcon(R.drawable.ic_email_cyan_500_24dp);

        alertEmailDialog.setPositiveButton("Next", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                savedEmail = inputEmail.getText().toString();
                dialog.dismiss();
                getBio();


            }
        });
        alertEmailDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertEmailDialog.setCancelable(true);
        alertEmailDialog.show();

    }

    private void getBio() {
        final AlertDialog.Builder alertBioDialog = new AlertDialog.Builder(SignUpActivity.this);
        alertBioDialog.setTitle("Bio");
        alertBioDialog.setMessage("Please enter a short biography");
        final EditText inputBio = new EditText(SignUpActivity.this);
        LinearLayout.LayoutParams lp3 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        inputBio.setLayoutParams(lp3);
        alertBioDialog.setView(inputBio);
        alertBioDialog.setIcon(R.drawable.ic_account_box_cyan_500_24dp);

        alertBioDialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                savedBio = inputBio.getText().toString();
                dialog.cancel();

            }
        });
        alertBioDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertBioDialog.setCancelable(true);
        alertBioDialog.show();
        Log.d(TAG, "Bio completed");

    }

    private void genderFemale() {
        gender = "Female";
        ivImMale.setVisibility(View.INVISIBLE);
        tvImMale.setVisibility(View.INVISIBLE);
        ivImTrans.setVisibility(View.INVISIBLE);
        tvImTrans.setVisibility(View.INVISIBLE);
        listenForSeeking(gender);
    }

    private void genderTrans() {
        String gender = "Transgender";
        ivImMale.setVisibility(View.INVISIBLE);
        tvImMale.setVisibility(View.INVISIBLE);
        ivImFemale.setVisibility(View.INVISIBLE);
        tvImFemale.setVisibility(View.INVISIBLE);
        listenForSeeking(gender);
    }

    private void genderMale() {
        String gender = "Male";
        ivImFemale.setVisibility(View.INVISIBLE);
        tvImFemale.setVisibility(View.INVISIBLE);
        ivImTrans.setVisibility(View.INVISIBLE);
        tvImTrans.setVisibility(View.INVISIBLE);
        listenForSeeking(gender);
    }

    private void listenForSeeking(final String gender) {
        ivSeekingMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seeking = gender+ " Seeking Male";
                if (gender.equals("Male")) {
                    tvSeekingMale.setVisibility(View.VISIBLE);
                    SexualOrientation = "Gay";

                }
                if (gender.equals("Female")) {
                    SexualOrientation = "Straight";
                    tvSeekingFemale.setVisibility(View.VISIBLE);

                }
                if (gender.equals("Transgender")) {
                    SexualOrientation = "Bi";
                    tvSeekingTrans.setVisibility(View.VISIBLE);
                }
            }
        });
        ivSeekingFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 seeking = gender+ " Seeking Female";
                if (gender.equals("Male")) {
                    SexualOrientation = "Straight";
                    tvSeekingMale.setVisibility(View.VISIBLE);
                }
                if (gender.equals("Female")) {
                    SexualOrientation = "Gay";
                    tvSeekingFemale.setVisibility(View.VISIBLE);

                }
                if (gender.equals("Transgender")) {
                    SexualOrientation = "Bi";
                    tvSeekingTrans.setVisibility(View.VISIBLE);
                }

            }
        });
        ivSeekingTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seeking = gender+ " Seeking Transgender";
                if (gender.equals("Male")) {
                    SexualOrientation = "Bi";
                    tvSeekingMale.setVisibility(View.VISIBLE);
                }
                if (gender.equals("Female")) {
                    SexualOrientation = "Bi";
                    tvSeekingFemale.setVisibility(View.VISIBLE);
                }
                if (gender.equals("Transgender")) {
                    SexualOrientation = "Bi";
                    tvSeekingTrans.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
