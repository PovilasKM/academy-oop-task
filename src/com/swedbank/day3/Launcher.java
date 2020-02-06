package com.swedbank.day3;

import com.swedbank.day3.service.InputOutputService;
import com.swedbank.day3.service.TextFileInputOutputService;
import com.swedbank.day3.shapes.Shape;

import java.io.File;
import java.util.List;

public class Launcher {

    public static void main(String[] args) {
        InputOutputService inputOutputService = new TextFileInputOutputService();
        File inputFile = new File("resources/shape.txt");
        List<Shape> shapeList = inputOutputService.read(inputFile);
        File outputFile = new File("resources/output.txt");
        inputOutputService.write(outputFile, shapeList);
    }
}
