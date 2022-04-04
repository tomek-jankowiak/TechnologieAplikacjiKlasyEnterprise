package com.mycompany.PrimeFaces.beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

/**
 *
 * @author Tomek
 */
@Named(value = "chartBean")
@RequestScoped
public class ChartBean {

    private LineChartModel lineChartModel;

    public ChartBean() {
        lineChartModel = initChart();
    }

    public LineChartModel getLineChartModel() {
        return lineChartModel;
    }

    public void setLineChartModel(LineChartModel lineChartModel) {
        this.lineChartModel = lineChartModel;
    }

    private LineChartModel initChart() {
        LineChartModel chart = new LineChartModel();
        chart.setLegendPosition("sw");
        chart.getAxis(AxisType.X).setLabel("X");
        chart.getAxis(AxisType.Y).setLabel("Y(x)");
        chart.setZoom(true);
        generateSeries(chart);
        return chart;
    }

    private void generateSeries(LineChartModel chart) {
        ChartSeries sin = new ChartSeries();
        ChartSeries cos = new ChartSeries();
        
        sin.setLabel("sin(x)");
        cos.setLabel("cos(x)");
        
        for (int i = 0; i <= 360; i++) {
            double rad = Math.toRadians(i);
            sin.set(i, Math.sin(rad));
            cos.set(i, Math.cos(rad));
        }
        
        chart.addSeries(sin);
        chart.addSeries(cos);
    }
}
