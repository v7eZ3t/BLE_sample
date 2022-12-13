package com.wakeupgetapp.bluetoothlowenergysample.central.datasource

import androidx.compose.runtime.collectAsState
import com.juul.kable.Advertisement
import com.juul.kable.Filter
import com.juul.kable.Scanner
import com.juul.kable.logs.Logging
import com.juul.kable.logs.SystemLogEngine
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.toList
import javax.inject.Inject


class DeviceDataSourceImpl @Inject constructor(){
    private val scanner = Scanner {
        filters = null
        logging {
            engine = SystemLogEngine
            level = Logging.Level.Warnings
            format = Logging.Format.Multiline
        }
    }

    suspend fun scanDevices() = scanner.advertisements

}


interface DeviceDataSource {

}