package com.wakeupgetapp.bluetoothlowenergysample.central

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juul.kable.peripheral
import com.tomcz.ellipse.Processor
import com.tomcz.ellipse.common.processor
import com.tomcz.ellipse.common.toNoAction
import com.wakeupgetapp.bluetoothlowenergysample.central.chosenDeviceUtils.ChosenDeviceEvents
import com.wakeupgetapp.bluetoothlowenergysample.central.chosenDeviceUtils.ChosenDeviceState
import com.wakeupgetapp.bluetoothlowenergysample.central.repository.DeviceDataRepository
import com.wakeupgetapp.bluetoothlowenergysample.central.scanUtils.ScanEvents
import com.wakeupgetapp.bluetoothlowenergysample.central.scanUtils.ScanPartialState
import com.wakeupgetapp.bluetoothlowenergysample.central.scanUtils.ScanState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

typealias ChosenDeviceProcessor = Processor<ChosenDeviceEvents, ChosenDeviceState, Any>

@HiltViewModel
class ChosenDeviceViewModel @Inject constructor(
) : ViewModel() {

    val processor: ChosenDeviceProcessor = processor(
        initialState = ChosenDeviceState(),
       // prepare = { },
        onEvent = { event ->
            when (event) {
                is ChosenDeviceEvents.ChoosePeripheral -> {
                    ScanPartialState.CreatePeripheral(viewModelScope.peripheral(identifier = event.device.address))
                    toNoAction()
                }
            }
        })
}
