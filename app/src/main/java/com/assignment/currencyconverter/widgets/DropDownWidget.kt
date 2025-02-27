package com.assignment.currencyconverter.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.assignment.craftsilicontest.component.ImageComponent
import com.assignment.currencyconverter.component.TextComponent
import com.assignment.currencyconverter.R


@Composable
fun DropDownWidgetView(menuItems: List<String>,
                       menuExpandedState: Boolean,
                       selectedIndex : Int,
                       updateMenuExpandStatus : () -> Unit,
                       onDismissMenuView : () -> Unit,
                       onMenuItemClick : (Int) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable(
                onClick = {
                    updateMenuExpandStatus()
                },
            ),
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().fillMaxHeight()
        ) {

            Box(modifier = Modifier.fillMaxHeight().fillMaxWidth(0.8f), contentAlignment = Alignment.Center){

                TextComponent(
                    text =  menuItems[selectedIndex],
                    fontSize = 20,
                    textStyle = TextStyle(),
                    textColor = Color.Black,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.SemiBold)
            }

            Box(modifier = Modifier.fillMaxHeight().fillMaxWidth(), contentAlignment = Alignment.Center){
                val imageModifier = Modifier
                    .size(30.dp)
                ImageComponent(
                    modifier = imageModifier,
                    imageRes = R.drawable.down
                )
            }

        }
    }

    val textStyle = TextStyle(
        fontSize = TextUnit(20f, TextUnitType.Sp),
        textAlign = TextAlign.Start,
        fontWeight = FontWeight.Normal
    )

    DropdownMenu(
        expanded = menuExpandedState,
        onDismissRequest = { onDismissMenuView() },
        modifier = Modifier
            .fillMaxWidth(0.90f)
            .background(Color.White)
    ) {
        menuItems.forEachIndexed { index, title ->
            DropdownMenuItem(
                onClick = {
                    if (index != -1) {
                        onMenuItemClick(index)
                    }
                },
                text = {
                    TextComponent(text = title, fontSize = 20, textStyle = textStyle,
                        textAlign = TextAlign.Start, textColor = Color.Gray)
                })
        }
    }
}


@Composable
fun DropDownWidget(menuItems: List<String>, selectedIndex: Int = -1, onMenuItemClick : (Int) -> Unit,
                   onExpandMenuItemClick : () -> Unit) {

    val expandedMenuItem = remember { mutableStateOf(false) }
    val selectedMenuIndex = remember { mutableStateOf(selectedIndex) }

    val modifier  = Modifier
        .padding(end = 10.dp, start = 10.dp, top = 20.dp)
        .fillMaxWidth()
        .height(55.dp)

    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,

        ) {
        DropDownWidgetView(
            menuItems = menuItems,
            menuExpandedState = expandedMenuItem.value,
            selectedIndex = selectedMenuIndex.value,
            updateMenuExpandStatus = {
                onExpandMenuItemClick()
                expandedMenuItem.value = true
            },
            onDismissMenuView = {
                expandedMenuItem.value = false
            },
            onMenuItemClick = { index ->
                selectedMenuIndex.value = index
                expandedMenuItem.value = false
                onMenuItemClick(selectedMenuIndex.value)
            }
        )
    }
}





