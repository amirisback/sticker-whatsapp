package com.frogobox.stickerwa.util.helper

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Environment
import com.frogobox.stickerwa.BuildConfig
import com.frogobox.stickerwa.util.helper.ConstHelper.Dir.DIR_NAME
import com.frogobox.stickerwa.util.helper.ConstHelper.Dir.VIDEO_FILE_NAME
import com.frogobox.stickerwa.util.helper.ConstHelper.Pref.PREF_NAME


/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * PublicSpeakingBooster
 * Copyright (C) 16/08/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.publicspeakingbooster.helper
 *
 */
class FunHelper{

    object Func {

        fun createFolderPictureVideo(){
            val videoFolder = Environment.getExternalStoragePublicDirectory(DIR_NAME)
            if (!videoFolder.exists()) {
                videoFolder.mkdirs()
            }
        }

        fun getVideoFilePath(): String {
            val dir = Environment.getExternalStoragePublicDirectory(DIR_NAME)
            return if (dir == null) {
                VIDEO_FILE_NAME
            } else {
                "${dir.absoluteFile}/$VIDEO_FILE_NAME"
            }
        }

        fun noAction() : Boolean {
            return true
        }

        fun isNetworkAvailable(context: Context): Boolean? {
            var isConnected: Boolean? = false // Initial Value
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
            if (activeNetwork != null && activeNetwork.isConnected) isConnected = true
            return isConnected
        }

        fun showVersion() : String {
            return "Version " + BuildConfig.VERSION_NAME
        }

    }

    object Preference {

        fun getSp(context: Context): SharedPreferences {
            return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        }

        object Save {
            fun savePrefFloat(sharedPreferences: SharedPreferences, constPref: String, data: Float) {
                sharedPreferences.edit().putFloat(constPref, data).apply()
            }

            fun savePrefInt(sharedPreferences: SharedPreferences, constPref: String, data: Int) {
                sharedPreferences.edit().putInt(constPref, data).apply()
            }

            fun savePrefString(sharedPreferences: SharedPreferences, constPref: String, data: String) {
                sharedPreferences.edit().putString(constPref, data).apply()
            }

            fun savePrefBoolean(sharedPreferences: SharedPreferences, constPref: String, data: Boolean) {
                sharedPreferences.edit().putBoolean(constPref, data).apply()
            }

            fun savePrefLong(sharedPreferences: SharedPreferences, constPref: String, data: Long) {
                sharedPreferences.edit().putLong(constPref, data).apply()
            }

        }

        object Delete {

            fun deletePref(sharedPreferences: SharedPreferences, constPref: String) {
                sharedPreferences.edit().remove(constPref).apply()
            }

        }

        object Load {

            fun loadPrefFloat(sharedPreferences: SharedPreferences, constPref: String): Float {
                return sharedPreferences.getFloat(constPref, 0f)
            }

            fun loadPrefString(sharedPreferences: SharedPreferences, constPref: String): String {
                return sharedPreferences.getString(constPref, "")!!
            }

            fun loadPrefInt(sharedPreferences: SharedPreferences, constPref: String): Int {
                return sharedPreferences.getInt(constPref, 0)
            }

            fun loadPrefLong(sharedPreferences: SharedPreferences, constPref: String): Long {
                return sharedPreferences.getLong(constPref, 0)
            }

            fun loadPrefBoolean(sharedPreferences: SharedPreferences, constPref: String): Boolean {
                return sharedPreferences.getBoolean(constPref, false)
            }

        }

    }
}