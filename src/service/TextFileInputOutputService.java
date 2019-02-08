package service;

import utils.ShapeFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFileInputOutputService implements InputOutputService {

    @Override
    public List<Shape> read(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            List<Shape> shapes = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                shapes.add(/*create / add new shapes */);
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
