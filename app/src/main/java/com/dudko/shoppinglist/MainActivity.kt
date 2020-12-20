package com.dudko.shoppinglist

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onSettingsClick(view: View) {
        val optionsActivityIntent = Intent(this, OptionsActivity::class.java)
        startActivity(optionsActivityIntent)
    }

    fun onYourListClick(view: View) {
        val productListActivityIntent = Intent(this, ProductListActivity::class.java)
        startActivity(productListActivityIntent)
    }

    fun onSignInClick(view: View) {
        val signInActivityIntent = Intent(this, LoginActivity::class.java)
        startActivity(signInActivityIntent)
    }

    fun onSignUpClick(view: View) {
        val signUpActivityIntent = Intent(this, RegisterActivity::class.java)
        startActivity(signUpActivityIntent)
    }

    override fun onStart() {
        super.onStart()
        val onYourListBtn = findViewById<Button>(R.id.yourList)
        val signInBtn = findViewById<Button>(R.id.sign_in_btn)
        val signUpBtn = findViewById<Button>(R.id.sign_up_btn)
        val signOutBtn = findViewById<Button>(R.id.sign_out_btn)

        if (mAuth.currentUser?.uid != null) {
            onYourListBtn.isEnabled = true
            signInBtn.isEnabled = false
            signUpBtn.isEnabled = false
            signOutBtn.isEnabled = true
        } else {
            onYourListBtn.isEnabled = false
            signInBtn.isEnabled = true
            signUpBtn.isEnabled = true
            signOutBtn.isEnabled = false
        }
    }

    fun onSignOutClick(view: View) {
        mAuth.signOut()
        finish()
        startActivity(intent)
    }
}