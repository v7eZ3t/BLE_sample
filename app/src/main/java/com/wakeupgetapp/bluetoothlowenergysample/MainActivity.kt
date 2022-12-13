package com.wakeupgetapp.bluetoothlowenergysample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wakeupgetapp.bluetoothlowenergysample.central.ListOfDevices
import com.wakeupgetapp.bluetoothlowenergysample.ui.navigation.NavigationScreens
import com.wakeupgetapp.bluetoothlowenergysample.ui.theme.BluetoothLowEnergySampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BluetoothLowEnergySampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController,
                        startDestination = NavigationScreens.ChooseFunctionScreen.name,
                    ) {


                        composable(NavigationScreens.ChooseFunctionScreen.name) {
                            ListOfDevices()
                        }

//                        composable(NavigationScreens.ScanDevicesScreen.name) {
//                            BuildWordsView(navController, sharedViewModel)
//                        }
//
//                        composable(NavigationScreens.ManageDeviceScreen.name) {
//                            CheckIfExistView(navController, sharedViewModel)
//                        }
//
//                        composable(NavigationScreens.DeviceMainScreen.name) {
//                            WordListView(navController, sharedViewModel)
//                        }


                    }
                }
            }
        }
    }
}
