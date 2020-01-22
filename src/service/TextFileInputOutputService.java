package service;

import factory.ShapeFactory;
import interfaces.Shape;

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
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return shapes;
    }

    @Override
    public void write(File file, List<Shape> shapes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Shape shape : shapes) {
                writer.write(shape.print());
            }
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
