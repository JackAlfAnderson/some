package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val listOfSettings = remember {
                        mutableStateListOf(
                            Setting(
                                R.drawable.baseline_dehaze_24,
                                "Some",
                                "some"
                            )
                        )
                    }
                    Settings(listOfSettings)
                    Box (Modifier.fillMaxWidth().fillMaxHeight()){
                        val settingsFolder = mutableListOf(
                            Setting(R.drawable.baseline_create_24, "Profile", "Edit your profile"),
                            Setting(R.drawable.baseline_currency_bitcoin_24, "Bitcoin", "Pomyanem cryptu"),
                            Setting(R.drawable.baseline_color_lens_24, "Paint", "You can even paint there, don't ask me why"),
                            Setting(R.drawable.baseline_edit_document_24, "Documents", "Edit your docs"),
                            Setting(R.drawable.ic_launcher_foreground, "Another", "Another setting item")
                        )
                        var counter = 0
                        Button(
                            onClick = {
                                listOfSettings.add(settingsFolder[counter])
                                counter++
                                if (counter > 4){
                                    counter = 0
                                }
                            },
                            Modifier.align(
                                Alignment.BottomCenter
                            )
                        ) {
                            Text("Add new setting item")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Settings(listOfSettings: List<Setting>) {
    Column (
        Modifier
            .background(Color.DarkGray)
            .fillMaxWidth()
    ){
        Header()
        Divider(
            Modifier
                .height(0.5.dp)
        )
        Spacer(
            Modifier
                .height(15.dp)
        )
        Divider(
            Modifier
                .height(0.5.dp)
        )


        LazyColumn(){
            items(listOfSettings){
                    listOfSettings -> SettingsItem(setting = listOfSettings)
            }
        }
    }
}

@Composable
fun Header(){
    Box(
        Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Row {
            Icon(
                painter = painterResource(id = R.drawable.baseline_dehaze_24),
                contentDescription = null,
                tint = Color.White,)
            Text(
                text = "Settings",
                color = Color.White)
        }
        Icon(
            painter = painterResource(id = R.drawable.baseline_dehaze_24),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .align(Alignment.CenterEnd)
        )
    }
}
@Composable
fun SettingsItem(
    setting: Setting
){
    Box(
        Modifier
            .padding(top = 10.dp, bottom = 10.dp, start = 5.dp)
    ) {
        Row {
            Icon(
                painter = painterResource(setting.icon),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .padding(5.dp)
                    .align(Alignment.CenterVertically),
                Color.White
            )
            Column {
                Text(
                    text = setting.title,
                    fontSize = 14.sp,
                    color = Color.White
                )
                Text(
                    text = setting.description,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsPreview() {
    MyApplicationTheme {
        val listOfSettings = remember {
            mutableStateListOf(Setting(R.drawable.baseline_dehaze_24,"Some","some"))
        }
        Settings(listOfSettings)
        Box (Modifier.fillMaxWidth().fillMaxHeight()){
            val settingsFolder = mutableListOf(
                Setting(R.drawable.baseline_create_24, "Profile", "Edit your profile"),
                Setting(R.drawable.baseline_currency_bitcoin_24, "Bitcoin", "Pomyanem cryptu"),
                Setting(R.drawable.baseline_color_lens_24, "Paint", "You can even paint there, don't ask me why"),
                Setting(R.drawable.baseline_edit_document_24, "Documents", "Edit your docs"),
                Setting(R.drawable.ic_launcher_foreground, "Another", "Another setting item")
            )
            var counter = 0
            Button(
                onClick = {
                    listOfSettings.add(settingsFolder[counter])
                    counter++
                    if (counter > 4){
                        counter = 0
                    }
                },
                Modifier
                    .align(
                    Alignment.BottomCenter
                    )
            ) {
                Text("Add new setting item")
            }
        }
    }
}