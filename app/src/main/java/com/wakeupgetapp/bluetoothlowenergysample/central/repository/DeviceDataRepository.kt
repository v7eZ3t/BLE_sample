package com.wakeupgetapp.bluetoothlowenergysample.central.repository

import com.juul.kable.Advertisement
import com.wakeupgetapp.bluetoothlowenergysample.central.datasource.DeviceDataSourceImpl
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeviceDataRepository @Inject constructor(
    private val deviceDataSource: DeviceDataSourceImpl
) {
    suspend fun observeDevices(): Flow<Advertisement> = deviceDataSource.scanDevices()

}