package com.wakeupgetapp.bluetoothlowenergysample.central.scanUtils

import com.juul.kable.Advertisement
import com.juul.kable.Peripheral
import com.tomcz.ellipse.PartialState

sealed interface ScanPartialState: PartialState<ScanState> {

    class CreatePeripheral(private val device: Peripheral) : ScanPartialState {
        override fun reduce(oldState: ScanState): ScanState {
            return oldState.copy(peripheral = device)
        }
    }

    class UpdateDeviceList(private val newDevice: Advertisement): ScanPartialState {
        override fun reduce(oldState: ScanState): ScanState {
            val newMap = oldState.deviceMap.toMutableMap()
            newMap[newDevice.address] = newDevice
            return oldState.copy(deviceMap = newMap)
        }
    }



}