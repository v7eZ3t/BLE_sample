package com.wakeupgetapp.bluetoothlowenergysample.central.scanUtils

import com.juul.kable.Advertisement
import com.tomcz.ellipse.PartialState

sealed class ScanEvents {
    data class ChoosePeripheral(val device: Advertisement): ScanEvents()
}