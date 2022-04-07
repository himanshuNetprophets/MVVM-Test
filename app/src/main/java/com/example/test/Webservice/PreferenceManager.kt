package com.example.test.Webservice

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import java.lang.Exception

object PreferenceManager {
    const val PREFERENCE_NAME = "Soccer"
    private fun getPreferences(context: Context?): SharedPreferences? {
        return context?.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    fun getString(context: Context?, key: String?): String? {
        return getString(context, key, "")
    }

    fun getString(context: Context?, key: String?, defaultValue: String?): String? {
        val preferences = getPreferences(context)
        return if (preferences != null && preferences.contains(key)) {
            preferences.getString(key, defaultValue)
        } else defaultValue
    }

    fun saveString(context: Context?, key: String?, value: String?) {
        val preferences = getPreferences(context)
        preferences?.edit()?.putString(key, value)?.apply()
    }

    fun getBoolean(context: Context?, key: String?): Boolean {
        val preferences = getPreferences(context)
        return if (preferences != null && preferences.contains(key)) {
            preferences.getBoolean(key, false)
        } else false
    }

    fun saveBoolean(context: Context?, key: String?, value: Boolean) {
        val preferences = getPreferences(context)
        preferences?.edit()?.putBoolean(key, value)?.apply()
    }

    fun getLong(context: Context?, key: String?): Long {
        val preferences = getPreferences(context)
        try {
            return preferences!!.getLong(key, 0)
        } catch (e: Exception) {
        }
        return 0
    }


    fun savedouble(context: Context?, key: String?, value: Double) {
        val preferences = getPreferences(context)
        if (preferences != null) {
            try {
                preferences.edit().putString(key, value.toString()).apply()
            } catch (e: Exception) {
            }
        }
    }

    fun saveLong(context: Context?, key: String?, value: Long) {
        val preferences = getPreferences(context)
        if (preferences != null) {
            try {
                preferences.edit().putLong(key, value).apply()
            } catch (e: Exception) {
            }
        }
    }


    fun saveFloat(context: Context?, key: String?, value: Float) {
        val preferences = getPreferences(context)
        preferences?.edit()?.putFloat(key, value)?.apply()
    }

    fun deleteAllData(context: Context?) {
        val preferences = getPreferences(context)
        preferences?.edit()?.clear()?.apply()
    }

    fun delete(context: Context?, key: String?) {
        val preferences = getPreferences(context)
        preferences?.edit()?.remove(key)?.apply()
    }

    /*public static void deleteFirebaseInstance(){
        FirebaseInstallations.getInstance().delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d("Installations", "Installation deleted");
                        } else {
                            Log.e("Installations", "Unable to delete Installation");
                        }
                    }
                });
    }*/

    fun getInt(context: Context?, key: String?): Int {
        val preferences = getPreferences(context)
        try {
            return preferences!!.getInt(key, 0)
        } catch (e: Exception) {
        }
        return 0
    }

    fun saveInt(context: Context?, key: String?, value: Int) {
        val preferences = getPreferences(context)
        if (preferences != null) {
            try {
                preferences.edit().putInt(key, value).apply()
            } catch (e: Exception) {
            }
        }
    }

//    fun saveUserAsCoach(context: Context?, data: AuthBeanModel.Data) {
//        saveBoolean(context, Constants.Key.IS_ALREADY_LOGGED_IN, true)
//        //saveString(context, ParamsKeyManager.Key.NAME, user.getData().getName());
//        saveString(context, Constants.Key.USERID, data.getUserId())
//        saveString(context, Constants.Key.MOBILE, data.getMobile())
//        saveString(context, Constants.Key.EMAIL, data.getEmail())
//    }

//    fun saveUser(context: Context?, user: User) {
//        saveBoolean(context, Constants.Key.IS_ALREADY_LOGGED_IN, true)
//        saveString(context, Constants.Key.USERID, user.getUserId())
//        saveString(context, Constants.Key.NAME, user.getName())
//        saveString(context, Constants.Key.MOBILE, user.getMoNumber())
//        saveString(context, Constants.Key.EMAIL, user.getEmail())
//        saveString(context, Constants.Key.Type, user.getType())
//    }

    fun deleteUser(context: Context?) {
        saveBoolean(context, Constants.Key.IS_ALREADY_LOGGED_IN, false)
        delete(context, Constants.Key.NAME)
        delete(context, Constants.Key.EMAIL)
        delete(context, Constants.Key.USERID)
        delete(context, Constants.Key.Type)
        delete(context, Constants.Key.MOBILE)
    }

//    fun getUser(context: Context?): User {
//        val user = User()
//        user.setName(getString(context, Constants.Key.NAME))
//        user.setEmail(getString(context, Constants.Key.EMAIL))
//        user.setUserId(getString(context, Constants.Key.USERID))
//        user.setMoNumber(getString(context, Constants.Key.MOBILE))
//        user.setType(getString(context, Constants.Key.Type))
//        return user
//    }

    fun saveFcmToken(context: Context?, fcmToken: String?) {
        saveString(context, Constants.Key.FCM_TOKEN, fcmToken)
    }

    fun getFcmToken(context: Context?): String? {
        return getString(context, Constants.Key.FCM_TOKEN)
    }
}