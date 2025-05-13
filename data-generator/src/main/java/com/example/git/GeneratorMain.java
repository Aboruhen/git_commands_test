package com.example.git;

import com.example.git.generator.LargeFileGenerator;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GeneratorMain {
    public static void main(String[] args) {
        LargeFileGenerator generator = new LargeFileGenerator();
        
        try {
            // Generate multiple large files with different sizes
            Path resourcePath = Paths.get("../resource-module/src/main/resources");
            resourcePath.toFile().mkdirs();

            generator.generateLargeJsonFile(
                    resourcePath.resolve("data-small.json"),
                    1_000
            );
            
            generator.generateLargeJsonFile(
                    resourcePath.resolve("data-medium.json"),
                    10_000
            );
            
            generator.generateLargeJsonFile(
                    resourcePath.resolve("data-large.json"),
                    100_000
            );
            
            System.out.println("Generated all data files successfully!");
            
        } catch (IOException e) {
            System.err.println("Error generating files: " + e.getMessage());
            e.printStackTrace();
        }
    }
} // TODO: Add parallel generation - Branch: feature/parallel-generation
