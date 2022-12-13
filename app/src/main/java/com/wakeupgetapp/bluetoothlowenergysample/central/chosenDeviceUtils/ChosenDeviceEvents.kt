package com.wakeupgetapp.bluetoothlowenergysample.central.chosenDeviceUtils

import com.juul.kable.Advertisement

sealed class ChosenDeviceEvents {
    data class ChoosePeripheral(val device: Advertisement): ChosenDeviceEvents()
}