package com.example.customchartsjetpackcompose.charts

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import      co.yml.charts.common.model.Point
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.*

@Composable
fun LineChartScreen() {
    val steps = 10

    val pointsData: List<Point> = listOf(
        Point(0f, 40f),
        Point(1f, 90f),
        Point(2f, 0f),
        Point(3f, 60f),
        Point(4f, 10f),
        Point(5f, 70f),
        Point(6f, 90f),
        Point(7f, 5f),
        Point(8f, 30f),
        Point(9f, 67f),
    )

    val xAxisData = AxisData.Builder()
        .axisStepSize(100.dp)
        .backgroundColor(Color.Transparent)
        .steps(pointsData.size - 1)
        .labelData { i -> i.toString() }
        .labelAndAxisLinePadding(15.dp)
        .axisLineColor(MaterialTheme.colors.secondary)
        .axisLabelColor(MaterialTheme.colors.secondary)
        .build()

    val yAxisData = AxisData.Builder()
        .steps(steps)
        .backgroundColor(Color.Transparent)
        .labelAndAxisLinePadding(20.dp)
        .labelData { i ->
            val yScale = 100 / steps
            (i * yScale).toString()
        }
        .axisLineColor(MaterialTheme.colors.secondary)
        .axisLabelColor(MaterialTheme.colors.secondary)
        .build()

    val lineChartData = LineChartData(
        linePlotData = LinePlotData(
            lines = listOf(
                Line(
                    dataPoints = pointsData,
                    LineStyle(
                        color = MaterialTheme.colors.secondary,
                        lineType = LineType.SmoothCurve(isDotted = false)
                    ),
                    IntersectionPoint(
                        color = MaterialTheme.colors.secondary
                    ),
                    SelectionHighlightPoint(
                        color = MaterialTheme.colors.secondary
                    ),
                    ShadowUnderLine(
                        alpha = 0.5f,
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                MaterialTheme.colors.primary,
                                Color.Transparent
                            )
                        )
                    ),
                    SelectionHighlightPopUp(),
                )
            )
        ),
        backgroundColor = MaterialTheme.colors.surface,
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        gridLines = GridLines(color = MaterialTheme.colors.primaryVariant)
    )

    LineChart(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp), lineChartData =lineChartData)


}