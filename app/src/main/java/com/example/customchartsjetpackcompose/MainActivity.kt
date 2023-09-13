package com.example.customchartsjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.customchartsjetpackcompose.charts.BarChartScreen
import com.example.customchartsjetpackcompose.charts.GroupBarChartScreen
import com.example.customchartsjetpackcompose.charts.LineChartScreen
import com.example.customchartsjetpackcompose.charts.PieChartScreen
import com.example.customchartsjetpackcompose.ui.theme.CustomChartsJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomChartsJetpackComposeTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.surface)
                ) {
                    PieChartScreen()
                }
            }
        }
    }
}
