package com.swedbank.day3.service;

import com.swedbank.day3.shapes.Shape;

import java.io.File;
import java.util.List;

public interface InputOutputService {
    List<Shape> read(File file);
    void write(File file, List<Shape> shapes);
}
