package com.atkandroid.foodgreen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;


public class MainActivity extends AppCompatActivity {

    private SignInButton btnSignIn;
    private GoogleSignInClient gsc;
    private String TAG = "MainActivity";
    private FirebaseAuth mAuth;
    private int RC_SIGN_IN = 1;

    //Email
    EditText etEmail,etPass;
    Button btnRegister;
    ProgressBar progressBar;
    FirebaseAuth fAuth;
    //Email

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Email
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnLogin);
        progressBar = findViewById(R.id.progressBar);

        fAuth = FirebaseAuth.getInstance();
        if(fAuth.getCurrentUser() != null){
            Intent i = new Intent(getApplicationContext(),Home.class);
//            i.putExtra("Name",fAuth.getCurrentUser().getEmail());
//            i.putExtra("Photo",fAuth.getCurrentUser().getPhotoUrl());
            startActivity(i);

            finish();
        }

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString().trim();
                String pass = etPass.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    etEmail.setError("Email Required");
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    etPass.setError("Password Required");
                    return;
                }
                if(pass.length() < 6){
                    etPass.setError("Password must be greater than 6");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"User Created",Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(),Home.class);
//                            i.putExtra("Name",fAuth.getCurrentUser().getEmail());
//                            i.putExtra("Photo",fAuth.getCurrentUser().getPhotoUrl());
                            startActivity(i);
                            finish();
                        }else{
                            Toast.makeText(MainActivity.this,"Error!"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });


            }
        });
        //Email


        //Google
        btnSignIn = findViewById(R.id.google);
        mAuth = FirebaseAuth.getInstance();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        gsc = GoogleSignIn.getClient(this,gso);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInGg();
            }
        });
    }

    //Google
    private void signInGg(){
        Intent i = gsc.getSignInIntent();
        startActivityForResult(i,RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResultGg(task);
        }
    }

    private void handleSignInResultGg(Task<GoogleSignInAccount> comtask){
        try{
            GoogleSignInAccount acc = comtask.getResult(ApiException.class);
            Toast.makeText(MainActivity.this,"Signed In Successfully",Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(acc);
        } catch (ApiException e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this,"Signed In Failed",Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(null);
        }
    }

    private void FirebaseGoogleAuth(GoogleSignInAccount account){
        AuthCredential authCredential = GoogleAuthProvider.getCredential(account.getIdToken(),null);
        mAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //Toast.makeText(MainActivity.this,"Successfully",Toast.LENGTH_SHORT).show();
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUIGg(user);
                }else{
                    Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_SHORT).show();
                    updateUIGg(null);
                }
            }
        });
    }

    private void updateUIGg(FirebaseUser fuser){
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if(account != null){
            String personName = account.getDisplayName();
            String profile = account.getPhotoUrl().toString();
            Toast.makeText(MainActivity.this,"Welcome Home Page",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,Home.class);
            intent.putExtra("Name",personName);
            intent.putExtra("Photo",profile);
            startActivity(intent);
            finish();
        }
    }
}