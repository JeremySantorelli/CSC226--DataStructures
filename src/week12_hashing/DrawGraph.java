/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week12_hashing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class DrawGraph extends Application {

    private static List<Double> points;
    private static List<Double> stored2Size;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Hash Map Standard Deviation");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Array Size");
        //creating the chart
        final LineChart<Number, Number> lineChart
                = new LineChart<Number, Number>(xAxis, yAxis);

        lineChart.setTitle("Standard Deviation");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        series.setName("Deviation");
        series1.setName("Stored / Size");
        series2.setName("0.7");
        //populating the series with data
        for (int i = 2; i < points.size(); i++) {
            series.getData().add(new XYChart.Data(i, points.get(i)));
            series1.getData().add(new XYChart.Data(i, stored2Size.get(i)));
            series2.getData().add(new XYChart.Data(i, 0.7));
        }
        Scene scene = new Scene(lineChart, 1200, 800);
        lineChart.getData().add(series);
        lineChart.getData().add(series1);
        lineChart.getData().add(series2);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Random r = new Random();
        Assignment<Integer, Integer> s;
        List<Double> sDev = new ArrayList<>();
        List<Double> s2s = new ArrayList<>();
        for (int size = 1; size < 100; size++) {
            s = new Assignment<>(size);
            for (int i = 0; i < 101; i++) {
                s.put(r.nextInt(size), r.nextInt(100) + i);
            }
            //System.out.print("Array Size: " + size + " ");
            sDev.add(s.hashMapStatistics());
            s2s.add((100 / size) * 1.0);
        }
        points = sDev;
        stored2Size = s2s;

        launch(args);
    }
}
