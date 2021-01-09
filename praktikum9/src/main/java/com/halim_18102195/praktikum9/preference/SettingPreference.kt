package com.halim_18102195.praktikum9.preference

import android.content.Context
import com.halim_18102195.praktikum9.data.SettingModel

    internal class SettingPreference(context: Context) {
        companion object {
            private const val PREFS_NAME = "setting_pref"
            private const val NAME = "name"
            private const val EMAIL = "email"
            private const val AGE = "age"
            private const val PHONE_NUMBER = "phone"
            private const val JENIS_KELAMIN = "jenisKelamin"
            private const val AGAMA = "agama"
            private const val THEME = "theme"
        }

        private val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        fun setSetting(value: SettingModel) {
            val editor = preferences.edit()
            editor.putString(NAME, value.name)
            editor.putString(EMAIL, value.email)
            editor.putInt(AGE, value.age)
            editor.putString(PHONE_NUMBER, value.phoneNumber)
            editor.putString(JENIS_KELAMIN, value.jenisKelamin)
            editor.putString(AGAMA, value.agama)
            editor.putBoolean(THEME, value.isDarkTheme)
            editor.apply()
        }

        fun getSetting(): SettingModel {
            val model = SettingModel()
            model.name = preferences.getString(NAME, "")
            model.email = preferences.getString(EMAIL, "")
            model.age = preferences.getInt(AGE, 0)
            model.agama = preferences.getString(AGAMA, "")
            model.isDarkTheme = preferences.getBoolean(THEME, false)
            model.phoneNumber = preferences.getString(PHONE_NUMBER, "")
            model.jenisKelamin = preferences.getString(JENIS_KELAMIN, "")
            return model
        }
    }