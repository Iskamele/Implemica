package implemica.FindShortestPath.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import implemica.FindShortestPath.service.FileWriterService;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(String data, String toFilePath) {
        try {
            Files.writeString(Path.of(toFilePath), data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + toFilePath, e);
        }
    }
}
