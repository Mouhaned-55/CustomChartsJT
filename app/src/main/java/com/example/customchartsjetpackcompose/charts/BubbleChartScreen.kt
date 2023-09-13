package com.example.customchartsjetpackcompose.charts

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.axis.DataCategoryOptions
import co.yml.charts.common.model.Point
import co.yml.charts.common.utils.DataUtils
import co.yml.charts.ui.barchart.models.BarChartType
import co.yml.charts.ui.bubblechart.BubbleChart
import co.yml.charts.ui.bubblechart.model.BubbleChartData
import co.yml.charts.ui.linechart.model.GridLines

@Composable
fun BubbleChartScreen() {

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

    val barChartListSize = 10
    val maxRange = 10
    val yStepSize =  10

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

    val bubbleChartData = BubbleChartData(
        DataUtils.getBubbleChartDataWithGradientStyle(pointsData),
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        gridLines = GridLines()
    )

    BubbleChart(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp),
        bubbleChartData = bubbleChartData
    )
}