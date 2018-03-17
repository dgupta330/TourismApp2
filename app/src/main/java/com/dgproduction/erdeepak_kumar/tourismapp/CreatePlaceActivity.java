package com.dgproduction.erdeepak_kumar.tourismapp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;

public class CreatePlaceActivity extends AppCompatActivity {
EditText name,place,type,description,location,url1,url2,url3;
Button save;
ImageButton add_guide;
Places_DatabaseHelper db;
DatabaseHelper gdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_place);
        name=findViewById(R.id.et_name_createplace);
        place=findViewById(R.id.et_place_createplace);
        type=findViewById(R.id.et_type_createplace);
        description=findViewById(R.id.et_description_createplace);
        url1=findViewById(R.id.et_url1_createplace);
        url2=findViewById(R.id.et_url2_createplace);
        url3=findViewById(R.id.et_url3_createplace);
        //location=findViewById();
        add_guide=findViewById(R.id.ib_add_guide_createplace);
        save=findViewById(R.id.btn_save_createplace);

        db=new Places_DatabaseHelper(this);
        gdb=new DatabaseHelper(this);
        //Dialog box appears when Add guide button clicks
        add_guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(CreatePlaceActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.custom_dialog_guide_add, null);
                final EditText mguidename = (EditText) mView.findViewById(R.id.et_name_dialog_ga);
                final EditText mguidearea = (EditText) mView.findViewById(R.id.et_area_dialog_ga);
                final RatingBar mrating = (RatingBar) mView.findViewById(R.id.rat_dialog_ga);
                final EditText mmobileno = (EditText) mView.findViewById(R.id.et_mobile_dialog_ga);
                final EditText mprice = (EditText) mView.findViewById(R.id.et_price_dialog_ga);
                final EditText mregno=(EditText) mView.findViewById(R.id.et_reg_dialog_ga);
                Button madd = (Button) mView.findViewById(R.id.btn_add_dialog_ga);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                madd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(!mguidename.getText().toString().isEmpty() && !mguidearea.getText().toString().isEmpty()){
                            Guide guide=new Guide(mregno.getText().toString(),mguidename.getText().toString(),
                                    mmobileno.getText().toString(),
                                    mguidearea.getText().toString(),
                                    mprice.getText().toString(),
                                    mrating.getRating());
                            // Inserting Contacts
                            boolean res=gdb.addGuide(guide);

                         /*  String key = dbr.child("teamData").push().getKey();
                           Map<String, Object> postValues = db.toMap(team);
                           Map<String, Object> childUpdates = new HashMap<>();
                           childUpdates.put("/teamData/" + key, postValues);
*/

                            if(res) {
                                Toast.makeText(CreatePlaceActivity.this,
                                        "Guide Added Successfully",
                                        Toast.LENGTH_SHORT).show();
                            }
                            else{ Toast.makeText(CreatePlaceActivity.this,
                                    "Guide Added failed",
                                    Toast.LENGTH_SHORT).show();

                            }

                            dialog.dismiss();
                        }else{
                            Toast.makeText(CreatePlaceActivity.this,
                                    "CANCEL",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString()!=null&&place.getText().toString()!=null)
                {
                 Places places = new Places();
                 places.setName(name.getText().toString());
                 places.setPlace(place.getText().toString());
                 places.setType(type.getText().toString());
                 places.setDescription(description.getText().toString());
                 places.setUrl1((url1.getText().toString()));
                    places.setUrl2((url2.getText().toString()));
                    places.setUrl3((url3.getText().toString()));
                 //place.setLocation();

                   Boolean res=db.addPlaces(places);
                    if(res) {
                        Toast.makeText(CreatePlaceActivity.this,
                                "Place Added Successfully",
                                Toast.LENGTH_SHORT).show();
                    }
                    else{ Toast.makeText(CreatePlaceActivity.this,
                            "Place Added failed",
                            Toast.LENGTH_SHORT).show();
                    }





                }
            }
        });
    }
}
