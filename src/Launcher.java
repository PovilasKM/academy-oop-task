import service.InputOutputService;
import service.TextFileInputOutputService;

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
