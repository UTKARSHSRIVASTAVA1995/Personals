package com.example.personal;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    private TextInputLayout textInputFirstName, textInputLastName, textInputDOB, textInputDesiredDesignation, textInputPayRate, textInputLocation, textInputWorkPermit, textInputLinkedin, textInputGithub, textInputStackOverflow, textInputOthers, textInputUrl, textInputName, textInputEmailID, textInputCapacity, textInputPhoneNumber;
    private TextInputEditText textInputEditTextFirstName, textInputEditTextLastName, textInputEditTextDOB, textInputEditTextDesiredDesignation, textInputEditTextPayRate, textInputEditTextLocation, textInputEditTextWorkPermit, textInputEditTextLinkedin, textInputEditTextGithub, textInputEditTextStackOverflow, textInputEditTextOthers, textInputEditTextUrl, textInputEditTextName, textInputEditTextEmailId, textInputEditTextCapacity, textInputEditTextPhoneNumber;

    private TextView textViewSubmit;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {

        textInputFirstName = findViewById(R.id.tilFirstName);
        textInputLastName = findViewById(R.id.tilLastName);
        textInputDOB = findViewById(R.id.tilDOB);
        textInputDesiredDesignation = findViewById(R.id.tilDesignation);
        textInputPayRate = findViewById(R.id.tilPayRate);
        textInputLocation = findViewById(R.id.tilPayRate);
        textInputWorkPermit = findViewById(R.id.tilWorkPermit);
        textInputLinkedin = findViewById(R.id.tilLinkedin);
        textInputGithub = findViewById(R.id.tilGithub);
        textInputStackOverflow = findViewById(R.id.tilStackOverflow);
        textInputOthers = findViewById(R.id.tilOthers);
        textInputUrl = findViewById(R.id.tilUrl);
        textInputName = findViewById(R.id.tilLastName);
        textInputEmailID = findViewById(R.id.tilEmailid);
        textInputCapacity = findViewById(R.id.tilCapacity);
        textInputPhoneNumber = findViewById(R.id.tilPhoneNumber);

        textInputEditTextFirstName = findViewById(R.id.tieFirstName);
        textInputEditTextLastName = findViewById(R.id.tieLastName);
        textInputEditTextDOB = findViewById(R.id.tieDOB);
        textInputEditTextDesiredDesignation = findViewById(R.id.tieDesignation);
        textInputEditTextPayRate = findViewById(R.id.tiePayRate);
        textInputEditTextLocation = findViewById(R.id.tiePreferredLocations);
        textInputEditTextWorkPermit = findViewById(R.id.tieWorkPermit);
        textInputEditTextLinkedin = findViewById(R.id.tieLinkedin);
        textInputEditTextGithub = findViewById(R.id.tieGithub);
        textInputEditTextStackOverflow = findViewById(R.id.tieStackOverflow);
        textInputEditTextOthers = findViewById(R.id.tieOthers);
        textInputEditTextUrl = findViewById(R.id.tieUrl);
        textInputEditTextName = findViewById(R.id.tieFirstReferenceName);
        textInputEditTextEmailId = findViewById(R.id.tieFirstEmailid);
        textInputEditTextCapacity = findViewById(R.id.tieCapacity);
        textInputEditTextPhoneNumber = findViewById(R.id.tiePhoneNumber);

        textViewSubmit = findViewById(R.id.tvSubmit);

    }


    private boolean isValidEmail(String email) {

        boolean isValidEmail = false;

        String regExpn = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (email.matches(regExpn)) {
            isValidEmail = true;
        }
        return isValidEmail;
    }

    private boolean personalprofileValidation() {

        String firstName = textInputFirstName.getEditText().toString();
        String lastName = textInputLastName.getEditText().toString();
        String dob = textInputDOB.getEditText().toString();

        if (!TextUtils.isEmpty(firstName) | !TextUtils.isEmpty(lastName) | !TextUtils.isEmpty(dob)) {
            textInputFirstName.setError("Enter First Name");
            textInputLastName.setError("Enter Last Name");
            textInputDOB.setError("Enter DOB");
            return false;

        } else {

            textInputFirstName.setError(null);
            textInputLastName.setError(null);
            textInputDOB.setError(null);
            return true;
        }

    }

    private boolean professionalprofileValidation() {

        String designation = textInputDesiredDesignation.getEditText().toString();
        String payRate = textInputPayRate.getEditText().toString();
        String preferredLocation = textInputLocation.getEditText().toString();
        String workPermit = textInputWorkPermit.getEditText().toString();

        if (!TextUtils.isEmpty(designation) | !TextUtils.isEmpty(payRate) | !TextUtils.isEmpty(preferredLocation) | !TextUtils.isEmpty(workPermit)) {
            textInputEditTextDesiredDesignation.setError("Enter Desired Designation");
            textInputEditTextPayRate.setError("Enter Pay Rate");
            textInputEditTextLocation.setError("Enter Preferred Location");
            textInputEditTextWorkPermit.setError("Enter work permit for USA");
            return false;

        } else {
            textInputEditTextDesiredDesignation.setError(null);
            textInputEditTextPayRate.setError(null);
            textInputEditTextLocation.setError(null);
            textInputEditTextWorkPermit.setError(null);
            return true;
        }
    }

   /* private boolean socialLinks() {

        String linkedin = textInputLinkedin.getEditText().toString();
        String github = textInputGithub.getEditText().toString();
        String stackOverflow = textInputStackOverflow.getEditText().toString();
        String others = textInputOthers.getEditText().toString();

        if (!linkedin.isEmpty() | !github.isEmpty() | !stackOverflow.isEmpty() | !others.isEmpty()){
    }

       private boolean validateEmail() {

            String emailInput = textInputEmailID.getEditText().toString().trim();
            if (emailInput.isEmpty()) {
                textInputEmailID.setError("Enter Email-id");
                return false;
            } else {
                textInputEmailID.setError(null);
                return true;

            }
        }*/

    public void confirmSubmit(View v) {

        Toast.makeText(this, "Submitted", Toast.LENGTH_SHORT).show();
        professionalprofileValidation();
        personalprofileValidation();
    }
}
