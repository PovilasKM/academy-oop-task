package service;

import utils.ShapeFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFileInputOutputService implements InputOutputService {

    @Override
    public List<Shape> read(File file) {
        ShapeFactory shapeFactory = new ShapeFactory();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            List<Shape> shapes = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                shapes.add(shapeFactory.getShape(line));
                line = reader.readLine();
            }
            return shapes;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
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
