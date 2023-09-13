package com.example.customchartsjetpackcompose.charts

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.yml.charts.common.model.PlotType
import co.yml.charts.ui.piechart.charts.DonutPieChart
import co.yml.charts.ui.piechart.charts.PieChart
import co.yml.charts.ui.piechart.models.PieChartConfig
import co.yml.charts.ui.piechart.models.PieChartData

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DonutChartScreen() {

    val donutChartData = PieChartData(
        slices = listOf(
            PieChartData.Slice("HP", 15f, Color(0xFF5F0A87)),
            PieChartData.Slice("Dell", 30f, Color(0xFF20BF55)),
            PieChartData.Slice("Lenovo", 40f, Color(0xFFEC9F05)),
            PieChartData.Slice("Asus", 10f, Color(0xFFF53844))
        ), plotType = PlotType.Donut
    )

    val donutChartConfig = PieChartConfig(
        labelVisible = true,
        labelColor = Color.White,
        labelType = PieChartConfig.LabelType.PERCENTAGE,
        isAnimationEnable = true,
        showSliceLabels = false,
        animationDuration = 1500
    )

    DonutPieChart(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp),
        donutChartData,
        donutChartConfig
    )
}