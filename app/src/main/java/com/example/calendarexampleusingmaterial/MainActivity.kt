package com.example.calendarexampleusingmaterial

import android.os.Bundle
import android.widget.DatePicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calendarexampleusingmaterial.ui.theme.CalendarExampleUsingMaterialTheme
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalendarExampleUsingMaterialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ShowCalendar()
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowCalendar() {

    val calendar = Calendar.getInstance()
    calendar.set(1990, 0, 22)

    val dataPickerState = rememberDatePickerState(initialSelectedDateMillis = calendar.timeInMillis)

    DatePicker(state = dataPickerState)

    val formatter = SimpleDateFormat("dd MMMM yyyy", Locale.ROOT)
    Text(
        text = "Selected date: ${formatter.format(Date(dataPickerState.selectedDateMillis!!))}"
    )

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalendarExampleUsingMaterialTheme {
        Greeting("Android")
    }
}