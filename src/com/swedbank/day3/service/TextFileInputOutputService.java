package com.swedbank.day3.service;

import com.swedbank.day3.exceptions.WrongCoordinatesCountException;
import com.swedbank.day3.factory.ShapeFactory;
import com.swedbank.day3.shapes.Shape;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileInputOutputService implements InputOutputService {

    @Override
    public List<Shape> read(File file) {
        List<Shape> shapes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                shapes.add(ShapeFactory.createShape(line));
                line = reader.readLine();
            }
            return shapes;
        } catch (WrongCoordinatesCountException e) {
            System.out.printf("Must be %d coordinates", e.getCount());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return shapes;
    }

    @Override
    public void write(File file, List<Shape> shapes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Shape shape : shapes) {
                writer.write(shape.print());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
