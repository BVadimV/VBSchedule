package com.borodinvadim.vbschedule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.borodinvadim.vbschedule.ui.theme.VBScheduleTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var name by rememberSaveable { mutableStateOf<String>("") }
            var choose by rememberSaveable { mutableStateOf<String>("") }

            VBScheduleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Greeting(
                            modifier = Modifier.padding(vertical = 12.dp, horizontal = 24.dp),
                            name = name
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        TextField(
                            modifier = Modifier
                                .padding(horizontal = 24.dp, vertical = 12.dp)
                                .fillMaxWidth(),
                            value = name,
                            onValueChange = { name = it },
                            label = { Text(text = "Name") },
                            placeholder = { Text(text = "Enter your name") },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Done
                            ),
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        DropDownMenu(
                            dropDownModifier = Modifier.padding(horizontal = 24.dp),
                            label = "Choose",
                            value = choose,
                            items = listOf<String>("NO", "NC"),
                            onItemSelected = { choose = it }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VBScheduleTheme {
        Greeting("Android")
    }
}