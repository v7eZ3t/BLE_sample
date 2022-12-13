package com.wakeupgetapp.bluetoothlowenergysample.central

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.juul.kable.Advertisement
import com.tomcz.ellipse.common.collectAsState
import com.wakeupgetapp.bluetoothlowenergysample.central.scanUtils.ScanEvents
import com.wakeupgetapp.bluetoothlowenergysample.ui.theme.BluetoothLowEnergySampleTheme


@Composable
fun ListOfDevices() {
    val processor = viewModel<ScanViewModel>().processor
    val deviceSet = processor.collectAsState { it.deviceMap }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        val deviceList = deviceSet.value.values
        items(deviceList.toList()) {
            Log.d("TAG", deviceSet.value.size.toString())
            AdvertisementCard(advertisement = it
            ) { processor.sendEvent(ScanEvents.ChoosePeripheral(it)) }
        }
    }
}


@Composable
fun AdvertisementCard(advertisement: Advertisement, onClick: ()-> Unit) {
    val name = if (advertisement.name.isNullOrEmpty()) "No Name" else advertisement.name!!
//    val manufacturerData = if(advertisement.manufacturerData == null) "No Manufacturer"
//    else advertisement.manufacturerData!!.data.decodeToString()
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable{onClick.invoke()},
        shape = MaterialTheme.shapes.large,
        color = MaterialTheme.colors.secondaryVariant
    ) {
        Column() {
            Text(text = name)
            Text(text = advertisement.address)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BluetoothLowEnergySampleTheme {
        ListOfDevices()
    }
}