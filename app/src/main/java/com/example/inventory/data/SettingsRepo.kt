package com.example.inventory.data

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.example.inventory.applicationContext

class SettingsRepo() {
    private val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
    private val sharedPreferences = EncryptedSharedPreferences.create(
        "PreferencesFilename",
        masterKeyAlias,
        applicationContext!!,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )


    fun isNoData(): Boolean {
        return (sharedPreferences.getString("isNoData", "") ?: return false) == "true"
    }
    fun switchNoData() {
        sharedPreferences.edit().putString("isNoData", (if(isNoData()) "false" else "true")).apply()
    }

    fun isNoShare(): Boolean {
        return (sharedPreferences.getString("isNoShare", "") ?: return false) == "true"
    }

    fun switchNoShare() {
        sharedPreferences.edit().putString("isNoShare", (if(isNoShare()) "false" else "true")).apply()
    }

    fun isDefolt(): Boolean {
        return (sharedPreferences.getString("isDefolt", "") ?: return false) == "true"
    }

    fun defolt(): Int {
        val t = sharedPreferences.getString("defolt", "") ?: return 10
        if (t == "") return 10
        return t.toInt()
    }

    fun switchDefolt() {
        sharedPreferences.edit().putString("isDefolt", (if(isDefolt()) "false" else "true")).apply()
    }

    fun newDefolt(toInt: String) {
        sharedPreferences.edit().putString("defolt", toInt).apply()
    }
}