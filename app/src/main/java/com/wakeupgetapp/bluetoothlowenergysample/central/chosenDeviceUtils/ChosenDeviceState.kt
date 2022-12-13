package com.wakeupgetapp.bluetoothlowenergysample.central.chosenDeviceUtils

import com.juul.kable.Advertisement
import com.juul.kable.Peripheral

data class ChosenDeviceState (
    val chosenDevice: Advertisement? = null,
    val deviceMap: Map<String, Advertisement> = mapOf(),
    val peripheral: Peripheral? = null
)
