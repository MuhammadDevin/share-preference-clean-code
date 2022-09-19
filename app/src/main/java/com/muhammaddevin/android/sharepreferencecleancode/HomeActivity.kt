package com.muhammaddevin.android.sharepreferencecleancode

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muhammaddevin.android.sharepreferencecleancode.databinding.ActivityHomeBinding
import com.muhammaddevin.android.sharepreferencecleancode.helper.Constant
import com.muhammaddevin.android.sharepreferencecleancode.helper.PreferenceHelper

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    // pref helper
    private lateinit var preferencesHelper: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // init pref
        preferencesHelper = PreferenceHelper(this)
        // binding tv main -> getString from preference helper
        val email = preferencesHelper.getString(Constant.PREF_EMAIL)
        binding.textViewEmail.text = email
        // btnLogout onClock
        binding.btnLogout.setOnClickListener {
            preferencesHelper.clear()
            finish()
        }
    }
}