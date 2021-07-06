package com.atkandroid.foodgreen;

import androidx.appcompat.app.AppCompatActivity;
import maes.tech.intentanim.CustomIntent;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class userData extends AppCompatActivity {

    EditText etCustomerName,etCustomerPhone,etCustomerAddress;
    Button btnCancel,btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        etCustomerName = findViewById(R.id.etCustomer_name);
        etCustomerPhone = findViewById(R.id.etCustomer_phone);
        etCustomerAddress = findViewById(R.id.etCustomer_address);
        btnCancel = findViewById(R.id.btnCustomer_cancel);
        btnSave = findViewById(R.id.btn_Customer_Save);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etCustomerName.setText("");
                etCustomerPhone.setText("");
                etCustomerAddress.setText("");
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String customerName = etCustomerName.getText().toString();
                String customerPhone = etCustomerPhone.getText().toString();
                String customerAddress = etCustomerAddress.getText().toString();

                if(TextUtils.isEmpty(customerName)){
                    etCustomerName.setError("Fill in the customer name");
                    return;
                }if (TextUtils.isEmpty(customerPhone)){
                    etCustomerPhone.setError("Fill in the customer phone number");
                    return;
                }if (TextUtils.isEmpty(customerAddress)){
                    etCustomerAddress.setError("Fill in the your address completely!");
                    return;
                }
                Intent i = new Intent(userData.this,success.class);
                startActivity(i);
                CustomIntent.customType(userData.this,"bottom-to-up");
            }
        });
    }
}