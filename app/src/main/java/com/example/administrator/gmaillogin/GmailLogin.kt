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

        val account = GoogleSignIn.getLastSignedInAccount(activity.applicationContext)
    }

    fun GetData(): MutableMap<String, String>? {
        val signInIntent = mGoogleSignInClient!!.signInIntent

        val task = GoogleSignIn.getLastSignedInAccount(activity.baseContext)

        var data: MutableMap<String, String> = mutableMapOf()
        data.put("displayName", task!!.displayName!!)
        data.put("familyName", task!!.familyName!!)
        data.put("givenName", task!!.givenName!!)
        data.put("accountName", task!!.account!!.name)
        data.put("accountType", task!!.account!!.type!!)
        data.put("email", task!!.email!!)
        data.put("id", task!!.id!!)
        data.put("photoUrl", task!!.photoUrl.toString()!!)

        return data
    }


}