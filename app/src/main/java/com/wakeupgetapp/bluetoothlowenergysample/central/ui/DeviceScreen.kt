package com.wakeupgetapp.bluetoothlowenergysample.central

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.juul.kable.Peripheral

@Composable
fun DeviceScreen() {
    val processor = viewModel<ChosenDeviceViewModel>().processor

    
}