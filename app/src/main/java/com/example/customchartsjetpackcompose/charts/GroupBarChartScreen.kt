package com.example.customchartsjetpackcompose.charts

import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.axis.DataCategoryOptions
import co.yml.charts.common.utils.DataUtils
import co.yml.charts.common.utils.DataUtils.getColorPaletteList
import co.yml.charts.ui.barchart.GroupBarChart
import co.yml.charts.ui.barchart.models.BarChartType
import co.yml.charts.ui.barchart.models.BarPlotData
import co.yml.charts.ui.barchart.models.GroupBarChartData

@Composable
fun GroupBarChartScreen() {

    val barChartListSize = 10
    val maxRange = 10
    val eachGroupBarSize = 3
    val barSize = 8
    val yStepSize =  10


    val groupBarPlotData = BarPlotData(
        groupBarList = DataUtils.getGroupBarChartData(
            barChartListSize,
            maxRange,
            eachGroupBarSize
        ),
        barColorPaletteList = getColorPaletteList(barSize)
    )

    val barsData = DataUtils.getBarChartData(
        listSize = barChartListSize, maxRange = maxRange, barChartType = BarChartType.VERTICAL,
        DataCategoryOptions()
    )

    val xAxisData = AxisData.Builder()
        .axisStepSize(30.dp)
        .steps(barsData.size - 1)
        .bottomPadding(40.dp)
        .labelData { index -> barsData[index].label }
        .build()

    val yAxisData = AxisData.Builder()
        .steps(yStepSize)
        .labelAndAxisLinePadding(20.dp)
        .axisOffset(20.dp)
        .labelData { index -> (index * (maxRange / yStepSize)).toString() }
        .build()

    val groupBarChartData = GroupBarChartData(
        barPlotData = groupBarPlotData,
        xAxisData = xAxisData,
        yAxisData = yAxisData
    )

    GroupBarChart(modifier = Modifier.height(350.dp), groupBarChartData = groupBarChartData)


}