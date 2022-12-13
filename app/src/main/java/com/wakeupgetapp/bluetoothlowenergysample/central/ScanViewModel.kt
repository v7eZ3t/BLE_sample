package com.wakeupgetapp.bluetoothlowenergysample.central

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juul.kable.peripheral
import com.tomcz.ellipse.Processor
import com.tomcz.ellipse.common.processor
import com.tomcz.ellipse.common.toNoAction
import com.wakeupgetapp.bluetoothlowenergysample.central.repository.DeviceDataRepository
import com.wakeupgetapp.bluetoothlowenergysample.central.scanUtils.ScanEvents
import com.wakeupgetapp.bluetoothlowenergysample.central.scanUtils.ScanPartialState
import com.wakeupgetapp.bluetoothlowenergysample.central.scanUtils.ScanState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.map
import javax.inject.Inject

typealias ScanProcessor = Processor<ScanEvents, ScanState, Any>

@HiltViewModel
class ScanViewModel @Inject constructor(
    repository: DeviceDataRepository
) : ViewModel() {

    val processor: ScanProcessor = processor(
        initialState = ScanState(),
        prepare = { repository.observeDevices().map { ScanPartialState.UpdateDeviceList(it) } },
        onEvent = { event ->
            when (event) {
                is ScanEvents.ChoosePeripheral -> {
                    ScanPartialState.CreatePeripheral(viewModelScope.peripheral(identifier = event.device.address))
                    toNoAction()
                }
            }
        })
}


