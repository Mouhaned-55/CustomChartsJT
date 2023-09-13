package com.example.customchartsjetpackcompose.charts

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.axis.DataCategoryOptions
import co.yml.charts.common.model.Point
import co.yml.charts.common.utils.DataUtils
import co.yml.charts.ui.barchart.models.BarChartType
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import co.yml.charts.ui.wavechart.WaveChart
import co.yml.charts.ui.wavechart.model.Wave
import co.yml.charts.ui.wavechart.model.WaveChartData
import co.yml.charts.ui.wavechart.model.WaveFillColor
import co.yml.charts.ui.wavechart.model.WavePlotData

@Composable
fun WaveChartScreen() {
    val pointsData: List<Point> =
        listOf(
            Point(0f, 40f),
            Point(1f, 90f),
            Point(2f, 0f),
            Point(3f, -60f),
            Point(4f, -10f),

            Point(5f, -33f),
            Point(6f, 90f),
            Point(7f, -5f),
            Point(8f, -23f),
            Point(9f, 10f),

            Point(10f, 53f),
            Point(11f, -60f),
            Point(12f, 32f),
            Point(13f, -83f),
            Point(14f, 10f)

        )
    val yStepSize = 10
    val maxRange = 10
    val barChartListSize = 10

    val barsData = DataUtils.getBarChartData(
        listSize = barChartListSize, maxRange = maxRange, barChartType = BarChartType.VERTICAL,
        DataCategoryOptions()
    )


    val xAxisData = AxisData.Builder()
        .axisStepSize(30.dp)
        .steps(maxOf(barsData.size - 1, 20 - 1))
        .bottomPadding(40.dp)
        .labelData { index -> index.toString() }
        .build()

    val yAxisData = AxisData.Builder()
        .steps(yStepSize)
        .labelAndAxisLinePadding(20.dp)
        .axisOffset(20.dp)
        .labelData { index -> (index * (maxRange / yStepSize)).toString() }
        .build()


    val waveChartData = WaveChartData(
        wavePlotData = WavePlotData(
            lines = listOf(
                Wave(
                    dataPoints = pointsData,
                    waveStyle = LineStyle(color = Color.Black),
                    selectionHighlightPoint = SelectionHighlightPoint(),
                    shadowUnderLine = ShadowUnderLine(),
                    selectionHighlightPopUp = SelectionHighlightPopUp(),
                    waveFillColor = WaveFillColor(topColor = Color.Green, bottomColor = Color.Red),
                )
            )
        ),
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        gridLines = GridLines()
    )

    WaveChart(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        waveChartData = waveChartData
    )

}