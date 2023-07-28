package com.example.myfat


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfat.ui.theme.MyFatTheme
import kotlin.math.pow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFatTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BMIApp()
                }
            }
        }
    }
}

@Composable
fun BMIApp() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
        ) {
            Text(
                text = "Body Fat Calculator",
                modifier = Modifier.padding(
                    start = 8.dp,
                    end = 8.dp,
                    top = 50.dp,
                    bottom = 16.dp
                )
            )
        }
        Spacer(modifier = Modifier.height(60.dp))
        BMICalculator()
    }

}

fun getBMIDescription(fat: Float): String {
    return when {
        fat <= 18.5 -> "underweight"
        fat > 18.5 && fat <= 24.9 -> "healthy weight"
        fat > 25.0 && fat <= 29.9 -> "overweight"
        fat > 30.0 && fat <= 34.9 -> "Class I obesity"
        fat > 35.0 && fat <= 39.9 -> "Class II obesity"
        else -> "class III obesity"
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BMICalculator() {
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var imc by remember { mutableStateOf(0f) }
    var age by remember { mutableStateOf("") }
    var sexe by remember { mutableStateOf("") }
    var fat by remember { mutableStateOf(.0f) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = weight,
            onValueChange = {
                weight = it
                imc = (weight.toFloatOrNull() ?: 0f) / ((height.toFloatOrNull()?.pow(2) ?: 1f))

                if (sexe.toUpperCase() == "m" ){
                    fat = ((1.20 * imc) + (0.23 * (age.toFloatOrNull() ?: 0f)) - (10.8 * (1)) - 5.4).toFloat()
                } else if (sexe.toUpperCase() == "f"){
                    fat = ((1.20 * (imc)) + (0.23 * (age.toFloatOrNull() ?: 0f)) - (10.8 * (0)) - 5.4).toFloat()
                }
            },
            label = {
                Text(text = "Your Weight")
            },
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.LightGray),
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            value = height,
            onValueChange = {
                height = it
                imc = (weight.toFloatOrNull() ?: 0f) / ((height.toFloatOrNull()?.pow(2) ?: 1f))

                if (sexe.toUpperCase() == "m" ){
                    fat = ((1.20 * imc) + (0.23 * (age.toFloatOrNull() ?: 0f)) - (10.8 * (1)) - 5.4).toFloat()
                } else if (sexe.toUpperCase() == "f"){
                    fat = ((1.20 * (imc)) + (0.23 * (age.toFloatOrNull() ?: 0f)) - (10.8 * (0)) - 5.4).toFloat()
                }
            },
            label = {
                Text(text = "Your height")
            },
            colors = TextFieldDefaults.textFieldColors(Color.LightGray),
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            value = sexe,
            onValueChange = {
                sexe = it
                imc = (weight.toFloatOrNull() ?: 0f) / ((height.toFloatOrNull()?.pow(2) ?: 1f))

                if (sexe.toUpperCase() == "m" ){
                    fat = ((1.20 * imc) + (0.23 * (age.toFloatOrNull() ?: 0f)) - (10.8 * (1)) - 5.4).toFloat()
                } else if (sexe.toUpperCase() == "f"){
                    fat = ((1.20 * (imc)) + (0.23 * (age.toFloatOrNull() ?: 0f)) - (10.8 * (0)) - 5.4).toFloat()
                }
            },
            label = {
                Text(text = "Your Gender")
            },
            colors = TextFieldDefaults.textFieldColors(Color.LightGray),
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            value = age,
            onValueChange = {
                age  = it
                imc = (weight.toFloatOrNull() ?: 0f) / ((height.toFloatOrNull()?.pow(2) ?: 1f))

                if (sexe.toUpperCase() == "m" ){
                    fat = ((1.20 * imc) + (0.23 * (age.toFloatOrNull() ?: 0f)) - (10.8 * (1)) - 5.4).toFloat()
                } else if (sexe.toUpperCase() == "f"){
                    fat = ((1.20 * (imc)) + (0.23 * (age.toFloatOrNull() ?: 0f)) - (10.8 * (0)) - 5.4).toFloat()
                }
            },
            label = {
                Text(text = "Your Age")
            },
            colors = TextFieldDefaults.textFieldColors(Color.LightGray),
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "You are ${getBMIDescription(fat)} \nYour Body fact is: $fat")
    }
}

@Preview
@Composable
fun BMICalculatorPreview() {
    BMICalculator()
}