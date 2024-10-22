package com.st.storage

import android.app.Application
import android.content.Context

object StorageApplicationHolder {

    lateinit var application: Application

    val context: Context get() = application
}