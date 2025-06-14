package com.pro.finsight.splitwise.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.pro.finsight.splitwise.R;
import com.pro.finsight.splitwise.utils.Constants;
import com.pro.finsight.splitwise.utils.Messages;

public class LoginActivity extends AppCompatActivity {
    private EditText emailId;
    private EditText password;
    private Button signInButton;
    private SignInButton googleSignInButton;
    private GoogleSignInClient mGoogleSignInClient;
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            init();
            GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(getString(R.string.googleSignInId))
                    .requestEmail()
                    .build();

            mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

            googleSignInButton.setOnClickListener(view -> signInWithGoogle());
        } catch (Exception e) {
            Log.e(TAG, "Exception :", e.getCause());
        }
    }

    /**
     * Method to Initialize the views.
     */
    private void init() {
        emailId = findViewById(R.id.emailId);
        password = findViewById(R.id.password);
        signInButton = findViewById(R.id.SignInButton);
        googleSignInButton = findViewById(R.id.btnGoogleSignIn);
    }

    private void signInWithGoogle() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, Constants.GOOGLE_SIGNIN_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constants.GOOGLE_SIGNIN_CODE) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                GoogleSignInAccount account = task.getResult();
                if (account != null) {
                    String token = account.getIdToken();
                } else {
                    Messages.logErrorMessage(TAG, " Google sign-in failed: Account is null");
                }
            } catch (Exception e) {
                Messages.logErrorMessage(TAG, " Google sign-in failed: " + e.getMessage());
                Messages.toastShortMessage(this, "Google sign-in failed");
            }
        }
    }
}