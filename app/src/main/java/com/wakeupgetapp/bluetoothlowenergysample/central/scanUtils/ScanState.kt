package com.wakeupgetapp.bluetoothlowenergysample.central.scanUtils

import com.juul.kable.Advertisement
import com.juul.kable.Peripheral

data class ScanState(
    val chosenDevice: Advertisement? = null,
    val deviceMap: Map<String,Advertisement> = mapOf(),
    val peripheral: Peripheral? = null

)
