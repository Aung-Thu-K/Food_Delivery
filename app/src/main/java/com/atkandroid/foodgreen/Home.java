package com.atkandroid.foodgreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

 /*   private ImageView img;
    private TextView email;
    String url;
    FirebaseAuth auth;
 */
 private TextView homelabel;
 private RecyclerView popular_rv,recommended_rv,trad_rv;
 private myAdapter adapter;
// private DatabaseReference databaseReference;
 private EditText etSearch;
 private CircleImageView myProfile;
 private ImageView btnSearch;
 private recomAdapter recomAdapter;
 private shopAdapter shopAdapter;
 private String url,myGmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homelabel = findViewById(R.id.homelabel);
        popular_rv = findViewById(R.id.popular_rv);
        etSearch = findViewById(R.id.etSearch);
        btnSearch = findViewById(R.id.btnSearch);
        myProfile = findViewById(R.id.myProfile);
//        Typeface typeface = Typeface.createFromAsset(getAssets(),"zawgyi.ttf");
//        homelabel.setTypeface(typeface);


         url = getIntent().getStringExtra("Photo");
        Glide.with(this).load(url).into(myProfile);
        myGmail = getIntent().getStringExtra("Name");
        myProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this,myAccount.class);
                i.putExtra("Name",myGmail);
                i.putExtra("MyPhoto",getIntent().getStringExtra("Photo"));
                startActivity(i);
            }
        });

        final ArrayList<model> item = new ArrayList<>();
        item.add(new model("Beef Corned","CN Nine","3.5","4500",R.drawable.b1));
        item.add(new model("Chicken Marvel","MC Teen","4.5","3500",R.drawable.c1));
        item.add(new model("Pizza Cheef","Star Mobile","3.8","6500",R.drawable.pizza1));
        item.add(new model("Rice Beef","Mobile World","4.2","1500",R.drawable.rice1));
        item.add(new model("Yum Yum","CN Nine","3.2","1500",R.drawable.yum4));
        item.add(new model("Drink Golden","Min Thar Gyi","3.9","1500",R.drawable.d8));
        adapter =  new myAdapter(item,Home.this);
        popular_rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        popular_rv.setAdapter(adapter);


        recommended_rv = findViewById(R.id.recommended_rv);
        ArrayList<model> recoms = new ArrayList<>();
        recoms.add(new model("Beef Marvel","CN Nine","4.5","5500",R.drawable.b4));
        recoms.add(new model("Chicken Corned","MC Teen","3.3","3500",R.drawable.c5));
        recoms.add(new model("Chicken World","Star Mobile","4.8","4500",R.drawable.c2));
        recoms.add(new model("Rice Chicken","Mobile World","2.2","1500",R.drawable.rice4));
        recoms.add(new model("Yum Yum","CN Nine","4.2","2500",R.drawable.yum2));
        recoms.add(new model("Drink Burble Tea","Min Thar Gyi","3.9","1500",R.drawable.d9));
        recomAdapter =  new recomAdapter(recoms,Home.this);
        recommended_rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recommended_rv.setAdapter(recomAdapter);


        trad_rv = findViewById(R.id.trad_rv);
        final ArrayList<shopModel> shopModels = new ArrayList<>();
        shopModels.add(new shopModel(R.drawable.shop1,"CN Nine","4.3","650 Meter","Everyday, from 10am to 8pm"));
        shopModels.add(new shopModel(R.drawable.shop2,"MC Teen","3.3","510 Meter","Sat & Sun, from 9am to 3pm"));
        shopModels.add(new shopModel(R.drawable.shop3,"Marvel World","4.5","780 Meter","Tue, from 7am to 5pm"));
        shopModels.add(new shopModel(R.drawable.shop4,"Super Star","3.9","450 Meter","Wed, from 10am to 9pm"));
        shopModels.add(new shopModel(R.drawable.shop5,"Shwe Shan Lay","3.5","890 Meter","Sat & Sun, from 5am to 8pm"));
        shopModels.add(new shopModel(R.drawable.shop5,"Mya Kabar","3.3","1200 Meter","Sat & Sun, from 5am to 8pm"));
        shopAdapter = new shopAdapter(this,shopModels);
        trad_rv.setLayoutManager(new LinearLayoutManager(Home.this,LinearLayoutManager.VERTICAL,false));
        trad_rv.setAdapter(shopAdapter);


    }

}