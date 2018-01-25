package com.example.hdahagam.app9;

import android.content.Context;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by hdahagam on 11/10/2017.
 */

public class SignupFragment extends android.support.v4.app.Fragment {

    private EditText inputEmail , inputPassword;
    private Button btnSignIn , btnSignUp , btnResetPassword;
    private FirebaseAuth auth;
    private OnFragmentInteractionListener mListener;
    public SignupFragment() {

    }

    public static SignupFragment newInstance()
    {
        SignupFragment fragment = new SignupFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.signupscreen , container , false);
        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();
        btnSignIn = (Button) view.findViewById(R.id.signlogin);
        btnSignUp = (Button) view.findViewById(R.id.signup);
        inputEmail = (EditText) view.findViewById(R.id.signemail);
        inputPassword = (EditText) view.findViewById(R.id.signpassword);

        btnSignIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(mListener != null)
                    mListener.onSigninRoutine();
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length() < 6) {
                    Toast.makeText(getContext(), "Password too short , enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                //create user
                auth.createUserWithEmailAndPassword(email , password).addOnCompleteListener(getActivity(),
                        new OnCompleteListener<AuthResult>()
                        {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult > task) {
                                Log.d("createUserWithEmail: ", "onComplete:" + task.isSuccessful());
                                Toast.makeText(getContext(), "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_LONG).show();

                                if (!task.isSuccessful())
                                {
                                    Toast.makeText(getContext(), "Authentication failed." + task.getException(), Toast.LENGTH_LONG).show();
                                }
                                else
                                {
                                    // sign up success
                                    mListener.onSigninRoutine();
                                }
                            }
                        });
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

    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener
    {
        void onSigninRoutine();
    }
}
