package com.assignment.currencyconverter.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.assignment.currencyconverter.R
import com.assignment.currencyconverter.component.TextComponent
import com.assignment.currencyconverter.component.TextFieldComponent
import com.assignment.currencyconverter.ui.AppTheme
import com.assignment.currencyconverter.utils.getCurrencySymbols
import com.assignment.currencyconverter.widgets.DropDownWidget
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var text by remember { mutableStateOf("") }
            AppTheme {
                Column(modifier = Modifier.fillMaxSize().background(color = Color.Black)){

                    Box(modifier = Modifier.fillMaxWidth().weight(1f).background(color = Color.Black), contentAlignment = Alignment.Center){
                        TextComponent(
                            text = "Currency Converter",
                            fontSize = 25,
                            textStyle = MaterialTheme.typography.titleLarge,
                            textColor = Color.White,
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.Normal
                        )

                    }

                    Column(modifier = Modifier.fillMaxWidth().weight(2f).background(color = Color.Magenta)){
                        Row(modifier = Modifier.fillMaxWidth().weight(1f).background(color = Color.Blue), verticalAlignment = Alignment.CenterVertically){

                            Box(modifier = Modifier.height(100.dp).fillMaxWidth(0.80f).background(color = Color.Black)){

                                TextFieldComponent(
                                    text = text,
                                    modifier = Modifier.fillMaxHeight().fillMaxWidth().padding(end = 10.dp, start = 20.dp),
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                                    onValueChange = {
                                        text = it
                                    }, placeholderText = "", onFocusChange = { it -> },
                                    placeholderTextSize = 40f,
                                    textColor = Color.White,
                                    textSize = 40f
                                )


                            }

                            Box(modifier = Modifier.height(100.dp).fillMaxWidth().background(color = Color.Green)){

                                DropDownWidget(menuItems = getCurrencySymbols(), selectedIndex = 0,onMenuItemClick = {}, onExpandMenuItemClick = {})

                            }

                        }

                        Row(modifier = Modifier.fillMaxWidth().weight(1f).background(color = Color.Red), verticalAlignment = Alignment.CenterVertically){

                            Box(modifier = Modifier.height(100.dp).fillMaxWidth(0.80f).background(color = Color.Black).padding(end = 10.dp, start = 20.dp), contentAlignment = Alignment.CenterStart){
                                TextComponent(
                                    text = NumberFormat.getInstance().format(150000.09),
                                    fontSize = 40,
                                    textStyle = MaterialTheme.typography.titleLarge,
                                    textColor = Color.White,
                                    textAlign = TextAlign.Start,
                                    fontWeight = FontWeight.Normal
                                )

                            }

                            Box(modifier = Modifier.height(100.dp).fillMaxWidth().background(color = Color.Green)){


                                DropDownWidget(menuItems = getCurrencySymbols(), selectedIndex = 0,onMenuItemClick = {}, onExpandMenuItemClick = {})


                            }

                        }

                    }

                    Box(modifier = Modifier.fillMaxWidth().weight(1f).background(color = Color.Black), contentAlignment = Alignment.TopStart){

                        Box(modifier = Modifier.height(50.dp).fillMaxWidth(0.50f).padding(start = 20.dp), contentAlignment = Alignment.CenterStart){
                            TextComponent(
                                text = "Rate",
                                fontSize = 20,
                                textStyle = MaterialTheme.typography.titleLarge,
                                textColor = Color.White,
                                textAlign = TextAlign.Start,
                                fontWeight = FontWeight.Normal
                            )
                        }

                        Box(modifier = Modifier.height(50.dp).fillMaxWidth().padding(end = 20.dp),contentAlignment = Alignment.CenterEnd){

                            TextComponent(
                                text = "1USD - 1500NGN",
                                fontSize = 20,
                                textStyle = MaterialTheme.typography.titleLarge,
                                textColor = Color.White,
                                textAlign = TextAlign.Start,
                                fontWeight = FontWeight.Normal
                            )
                        }

                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DropDownDemoPreview() {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

        }
    }
}