package com.example.git.generator;

import com.example.git.model.DataRecord;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

public class LargeFileGenerator {
    
    public void generateLargeJsonFile(Path outputPath, int recordCount) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath.toFile()))) {
            writer.write("[\n");
            for (int i = 0; i < recordCount; i++) {
                DataRecord record = createRandomRecord();
                writer.write("  " + recordToJson(record));
                if (i < recordCount - 1) {
                    writer.write(",");
                }
                writer.write("\n");
            }
            writer.write("]\n");
        }
    }

    private DataRecord createRandomRecord() {
        return DataRecord.builder()
                .id(UUID.randomUUID().toString())
                .content(RandomStringUtils.randomAlphanumeric(1000))
                .timestamp(System.currentTimeMillis())
                .metadata(RandomStringUtils.randomAlphanumeric(200))
                .build();
    }

    private String recordToJson(DataRecord record) {
        return String.format(
                "{\"id\":\"%s\",\"content\":\"%s\",\"timestamp\":%d,\"metadata\":\"%s\"}",
                record.getId(),
                record.getContent(),
                record.getTimestamp(),
                record.getMetadata()
        );
    }
} // TODO: Optimize JSON generation - Branch: feature/optimize-json-generation
