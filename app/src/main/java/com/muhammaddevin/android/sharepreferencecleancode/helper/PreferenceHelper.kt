package com.muhammaddevin.android.sharepreferencecleancode.helper

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper(ctx: Context) {

    private val PREF_NAME = "mypref"
    private val sharedPreferences: SharedPreferences
    val editor : SharedPreferences.Editor

    init {
        sharedPreferences = ctx.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }

    fun put(key: String, value: String){
        editor.putString(key, value)
        editor.apply()
    }

    fun put(key: String, value: Boolean){
        editor.putBoolean(key, true)
        editor.apply()
    }

    fun getBoolean(key: String): Boolean{
        return sharedPreferences.getBoolean(key, false)
    }

    fun getString(key: String): String?{
        return sharedPreferences.getString(key,null)
    }

    fun clear(){
        editor.clear().apply()
    }
}