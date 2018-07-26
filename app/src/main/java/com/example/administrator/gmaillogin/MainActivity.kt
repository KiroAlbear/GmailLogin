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



        var gmailLogin = GmailLogin(this)
        google_sign.setOnClickListener(View.OnClickListener {

            gmailLogin.GetData()

        })


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // super.onActivityResult(requestCode, resultCode, data)
        val task = GoogleSignIn.getSignedInAccountFromIntent(data)


        var data: MutableMap<String, String> = mutableMapOf()
        data.put("displayName", task!!.result.displayName!!)
        data.put("familyName", task!!.result.familyName!!)
        data.put("givenName", task!!.result.givenName!!)
        data.put("accountName", task.result!!.account!!.name)
        data.put("accountType", task!!.result.account!!.type!!)
        data.put("email", task!!.result.email!!)
        data.put("id", task!!.result.id!!)
        data.put("photoUrl", task!!.result.photoUrl.toString()!!)

        var datastr=""
        for (i in data){
            datastr+= i.key+" :"+i.value+"\n"
        }
        textView.text=datastr

        // handleSignInResult(task)
    }

}
