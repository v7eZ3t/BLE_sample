package com.wakeupgetapp.bluetoothlowenergysample.central.chosenDeviceUtils

import com.juul.kable.Advertisement
import com.juul.kable.Peripheral
import com.tomcz.ellipse.PartialState
import com.wakeupgetapp.bluetoothlowenergysample.central.scanUtils.ScanState

sealed interface ChosenDevicePartialState: PartialState<ChosenDeviceState> {

    class CreatePeripheral(private val device: Peripheral) : ChosenDevicePartialState {
        override fun reduce(oldState: ChosenDeviceState): ChosenDeviceState {
            return oldState.copy(peripheral = device)
        }
    }

}