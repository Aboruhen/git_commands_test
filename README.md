# Git Features Demo Project

This project is designed to demonstrate various Git features, particularly focusing on partial cloning and handling large files. The project is structured as a multi-module Maven project with the following components:

## Project Structure

- **core-module**: Contains the core business logic and data models
- **data-generator**: Module responsible for generating large JSON files
- **resource-module**: Contains the generated large files (useful for demonstrating Git LFS and partial clone features)

## Generated Files

The project generates three JSON files of different sizes:
- `data-small.json`: ~300KB (1,000 records)
- `data-medium.json`: ~3MB (10,000 records)
- `data-large.json`: ~30MB (100,000 records)

## Git Features to Demonstrate

1. **Partial Clone**
   ```bash
   # Clone only the core-module
   git clone --filter=blob:none --sparse <repository-url>
   cd <repository>
   git sparse-checkout set core-module/
   ```

2. **Git LFS Setup**
   ```bash
   # Install Git LFS
   git lfs install
   
   # Track large files
   git lfs track "resource-module/src/main/resources/*.json"
   ```

3. **Working with Large Files**
   ```bash
   # Generate large files
   mvn clean install
   cd data-generator
   mvn exec:java -Dexec.mainClass="com.example.git.GeneratorMain"
   ```

## Building the Project

```bash
mvn clean install
```

## Requirements

- Java 17 or higher
- Maven 3.6 or higher
- Git 2.25 or higher (for sparse checkout features)
- Git LFS

###
- test
