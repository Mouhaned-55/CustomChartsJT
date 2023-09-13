package com.example.customchartsjetpackcompose.charts

import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.Point
import co.yml.charts.common.utils.DataUtils
import co.yml.charts.ui.barchart.models.BarPlotData
import co.yml.charts.ui.barchart.models.BarStyle
import co.yml.charts.ui.combinedchart.CombinedChart
import co.yml.charts.ui.combinedchart.model.CombinedChartData
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp

@Composable
fun CombinedChartScreen() {

    val barChartListSize = 10
    val maxRange = 10
    val barSize = 8
    val yStepSize = 10


    val linePlotData = LinePlotData(
        lines = listOf(
            Line(
                DataUtils.getLineChartData(barChartListSize, maxRange = 100),
                lineStyle = LineStyle(color = Color.Blue),
                intersectionPoint = IntersectionPoint(),
                selectionHighlightPoint = SelectionHighlightPoint(),
                selectionHighlightPopUp = SelectionHighlightPopUp()
            ),
            Line(
                DataUtils.getLineChartData(barChartListSize, start = 0, maxRange),
                lineStyle = LineStyle(color = Color.Black),
                intersectionPoint = IntersectionPoint(),
                selectionHighlightPoint = SelectionHighlightPoint(),
                selectionHighlightPopUp = SelectionHighlightPopUp()
            )
        )
    )

    val barPlotData = BarPlotData(
        groupBarList = DataUtils.getGroupBarChartData(barChartListSize, maxRange, barSize),
        barStyle = BarStyle(barWidth = 35.dp),
    )

    val xAxisData = AxisData.Builder()
        .axisStepSize(30.dp)
        .steps(maxOf(0, 20))
        .bottomPadding(40.dp)
        .labelData { index -> index.toString() }
        .build()

    val yAxisData = AxisData.Builder()
        .steps(yStepSize)
        .labelAndAxisLinePadding(20.dp)
        .axisOffset(20.dp)
        .labelData { index -> (index * (maxRange / yStepSize)).toString() }
        .build()

    val combinedChartData = CombinedChartData(
        combinedPlotDataList = listOf(barPlotData, linePlotData),
        xAxisData = xAxisData,
        yAxisData = yAxisData
    )

    CombinedChart(
        modifier = Modifier.height(400.dp),
        combinedChartData
    )

}