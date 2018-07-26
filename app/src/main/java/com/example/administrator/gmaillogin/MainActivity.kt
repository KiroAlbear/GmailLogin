package com.example.administrator.gmaillogin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import android.support.annotation.NonNull
import android.view.View
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.auth.api.signin.GoogleSignIn
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.R.attr.data
import android.support.v4.app.FragmentActivity
import android.util.Log
import com.google.android.gms.common.api.ApiException


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
        var mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        val account = GoogleSignIn.getLastSignedInAccount(this)

        var gmailLogin: GmailLogin = GmailLogin(this)
        var data = gmailLogin.GetData()
        var datastr: String = ""
        google_sign.setOnClickListener(View.OnClickListener {

            for (i in gmailLogin.GetData()!!) {
                datastr += i.key + " : " + i.value + "\n"
            }
            textView.text = datastr
        })


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // super.onActivityResult(requestCode, resultCode, data)
        // handleSignInResult(task)
    }

}
