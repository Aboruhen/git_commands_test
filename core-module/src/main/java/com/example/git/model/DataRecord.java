package com.example.git.model;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class DataRecord {
    private String id;
    private String content;
    private long timestamp;
    private String metadata;
} // TODO: Enhance data model - Branch: feature/enhance-data-model
