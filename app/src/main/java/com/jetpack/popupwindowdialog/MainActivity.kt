package com.jetpack.popupwindowdialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.jetpack.popupwindowdialog.ui.theme.PopupWindowDialogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PopupWindowDialogTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "Popup Window Dialog",
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            )
                        }
                    ) {
                        PopupWindowDialog()
                    }
                }
            }
        }
    }
}

@Composable
fun PopupWindowDialog() {
    val openDialog = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                openDialog.value = !openDialog.value
            }
        ) {
            Text(text = "Show Popup")
        }
        Box {
            val popupWidth = 120.dp
            val popupHeight = 100.dp
            val cornerSize = 10.dp

            if (openDialog.value) {
                Popup(
                    alignment = Alignment.TopStart,
                    properties = PopupProperties()
                ) {
                    Box(
                        Modifier
                            .size(popupWidth, popupHeight)
                            .padding(top = 5.dp)
                            .background(Color.Green, RoundedCornerShape(cornerSize))
                            .border(1.dp, color = Color.Black, RoundedCornerShape(cornerSize))
                    ) {
                        Column(
                            modifier = Modifier.padding(horizontal = 10.dp)
                        ) {
                            Text(
                                text = "Edit",
                                modifier = Modifier.padding(vertical = 5.dp),
                                fontSize = 16.sp
                            )
                            Divider(modifier = Modifier.border(1.dp, Color.Black))
                            Text(
                                text = "Settings",
                                modifier = Modifier.padding(vertical = 5.dp),
                                fontSize = 16.sp
                            )
                            Divider(modifier = Modifier.border(1.dp, Color.Black))
                            Text(
                                text = "Logout",
                                modifier = Modifier.padding(vertical = 5.dp),
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }
        }
    }
}






















