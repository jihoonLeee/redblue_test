package redblue.multipart.test.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Getter
public class FileDto {

    private String filePath;
    private String fileName;

    public FileDto(String filePath, String fileName) throws IOException {
        this.fileName = fileName;
        this.filePath = filePath;
    }

}
