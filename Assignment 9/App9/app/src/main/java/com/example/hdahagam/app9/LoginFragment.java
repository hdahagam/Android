package com.example.hdahagam.app9;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by hdahagam on 11/10/2017.
 */

public class LoginFragment extends android.support.v4.app.Fragment {
    private static final String TAG="GoogleActivity";
    private static final int RC_SIGN_IN = 9001;


    private OnFragmentInteractionListener mListener;

    private EditText inputEmail , inputPassword;
    private FirebaseAuth auth;
    private Button btnSignup , btnLogin , btnReset;
    private GoogleSignInClient mGoogleSignInClient;

    public LoginFragment() {
    }

    public static LoginFragment newInstance()
    {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.loginscreen , container , false);

        //Get Firebase instance
        auth = FirebaseAuth.getInstance();

        inputEmail = (EditText) view.findViewById(R.id.email);
        inputPassword = (EditText) view.findViewById(R.id.password);
        btnSignup = (Button) view.findViewById(R.id.register);
        btnLogin = (Button) view.findViewById(R.id.login);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (mListener != null) {
                    mListener.onSignupRoutine();
                }
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String email = inputEmail.getText().toString();
                final String password = inputPassword.getText().toString();
                if (TextUtils.isEmpty(email))
                {
                    Toast.makeText(getContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                //authenticate user
                auth.signInWithEmailAndPassword(email , password).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult >()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {

                        if (!task.isSuccessful())
                        {
                            // there was an error
                            if (password.length() < 6)
                            {
                                inputPassword.setError("Minumum password");
                            }
                            else
                            {
                                Toast.makeText(getActivity(), "Authentication Failed", Toast.LENGTH_LONG).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(getActivity(), "Authentication SUCCESS", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getActivity(), Task1.class);
                            startActivity(intent); getActivity().finish();
                        }
                    }
                });
            }
        });

        // Enabling Google Sign IN
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);
        view.findViewById(R.id.sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
        return view;
    }
    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener)
        {
            mListener = (OnFragmentInteractionListener) context;
        }
        else
        {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            Intent intent = new Intent(getActivity(), Task1.class);
            startActivity(intent); getActivity().finish();
        } catch (ApiException e) {
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
        }
    }

    public interface OnFragmentInteractionListener
    {
        void onSignupRoutine();
    }
}
