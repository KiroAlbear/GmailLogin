package com.example.administrator.gmaillogin

import android.app.Activity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class GmailLogin {

    var activity: Activity
    var mGoogleSignInClient: GoogleSignInClient? = null

    constructor(activity: Activity) {
        this.activity = activity
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
        mGoogleSignInClient = GoogleSignIn.getClient(activity, gso)

      //  val account = GoogleSignIn.getLastSignedInAccount(activity.applicationContext)


    }

    fun GetData(): MutableMap<String, String>? {

        val signInIntent = mGoogleSignInClient!!.signInIntent

        //val task = GoogleSignIn.getLastSignedInAccount(activity.baseContext)

        activity.startActivityForResult(signInIntent,0)

        return null
    }


}