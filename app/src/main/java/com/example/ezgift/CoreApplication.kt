package com.example.ezgift

import android.app.Application
import android.content.Context
import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings

open class CoreApplication: Application() {

    private var instance: CoreApplication? = null
    private val TAG = CoreApplication::class.java.simpleName

    open fun getInstances(): CoreApplication? {
        return instance
    }

    open fun getContext(): Context? {
        return applicationContext
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initializeRemoteConfig()

    }

    private fun initializeRemoteConfig() {
        val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)

        fetchRemote()
    }

    private fun fetchRemote() {
        FirebaseRemoteConfig.getInstance().fetchAndActivate()
            .addOnCompleteListener { task: Task<Boolean?> ->
                if (task.isSuccessful) {
                    val updated = task.result != null
                    Log.d(TAG, "Firebase Config params updated: $updated")
                }
            }

        val user: FirebaseUser = FirebaseAuth.getInstance().currentUser ?: return

        user.getIdToken(true).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val idToken: String? = task.result.token
                Log.d(TAG, "Firebase token: $idToken")
            } else {
                Log.d(TAG, "Firebase token: " + task.exception)
            }
        }
    }
}