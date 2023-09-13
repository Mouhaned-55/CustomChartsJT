package com.example.customchartsjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.customchartsjetpackcompose.charts.BarChartScreen
import com.example.customchartsjetpackcompose.charts.BubbleChartScreen
import com.example.customchartsjetpackcompose.charts.CombinedChartScreen
import com.example.customchartsjetpackcompose.charts.DonutChartScreen
import com.example.customchartsjetpackcompose.charts.GroupBarChartScreen
import com.example.customchartsjetpackcompose.charts.LineChartScreen
import com.example.customchartsjetpackcompose.charts.PieChartScreen
import com.example.customchartsjetpackcompose.charts.WaveChartScreen
import com.example.customchartsjetpackcompose.ui.theme.CustomChartsJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomChartsJetpackComposeTheme {
                var selectedScreen by remember { mutableStateOf(0) }

                val screens = listOf(
                    "Line", "Pie", "Bar", "GroupBar",
                    "Donut", "Combined", "Wave", "Bubble"
                )

                Scaffold(
                    bottomBar = {
                        BottomNavigation {
                            screens.forEachIndexed { index, screen ->
                                BottomNavigationItem(
                                    selected = index == selectedScreen,
                                    onClick = {
                                        selectedScreen = index
                                    },
                                    icon = {

                                    },
                                    label = { Text(text = screen, textAlign = TextAlign.Center) }
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    val modifier = Modifier.padding(innerPadding)
                    when (selectedScreen) {
                        0 -> LineChartScreen()
                        1 -> PieChartScreen()
                        2 -> BarChartScreen()
                        3 -> GroupBarChartScreen()
                        4 -> DonutChartScreen()
                        5 -> CombinedChartScreen()
                        6 -> WaveChartScreen()
                        7 -> BubbleChartScreen()
                        else -> LineChartScreen()
                    }
                }
            }
        }
    }
}
