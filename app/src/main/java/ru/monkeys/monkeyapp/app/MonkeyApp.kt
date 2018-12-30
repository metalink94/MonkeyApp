package ru.monkeys.monkeyapp.app

import android.app.Application
import com.facebook.FacebookSdk
import com.facebook.LoggingBehavior
import com.facebook.appevents.AppEventsLogger
import com.google.firebase.FirebaseApp

class MonkeyApp: Application() {

  lateinit var logger: AppEventsLogger

  override fun onCreate() {
    FirebaseApp.initializeApp(this)
    super.onCreate()
//    if (BuildConfig.DEBUG) {
      FacebookSdk.setIsDebugEnabled(true)
      FacebookSdk.addLoggingBehavior(LoggingBehavior.APP_EVENTS)
//    }
    logger = AppEventsLogger.newLogger(this)
  }
}