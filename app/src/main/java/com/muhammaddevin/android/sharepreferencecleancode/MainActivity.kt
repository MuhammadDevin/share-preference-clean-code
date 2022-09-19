package com.muhammaddevin.android.sharepreferencecleancode

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muhammaddevin.android.sharepreferencecleancode.databinding.ActivityMainBinding
import com.muhammaddevin.android.sharepreferencecleancode.helper.Constant
import com.muhammaddevin.android.sharepreferencecleancode.helper.PreferenceHelper

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var preferencesHelper: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferencesHelper = PreferenceHelper(this)

        binding.btnLogin.setOnClickListener { onClick() }
    }

    private fun onClick(){
        if (binding.inputEmail.text.isNotEmpty() && binding.inputPassword.text.isNotEmpty()){
            preferencesHelper.put(Constant.PREF_EMAIL, binding.inputEmail.text.toString())
            preferencesHelper.put(Constant.PREF_PASSWORD, binding.inputPassword.text.toString())
            preferencesHelper.put(Constant.PREF_IS_LOGIN, true)
            moveActivity()
        }
    }

    override fun onStart() {
        super.onStart()
        if (preferencesHelper.getBoolean(Constant.PREF_IS_LOGIN)){
            moveActivity()
        }
    }

    private fun moveActivity(){
        startActivity(Intent(this, HomeActivity::class.java))
    }
}