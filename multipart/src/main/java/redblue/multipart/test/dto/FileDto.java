package redblue.multipart.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@Getter
@Setter
public class FileDto {

    private String filePath;
    private String fileName;

    public FileDto(String filePath, String fileName) throws IOException {
        this.fileName = fileName;
        this.filePath = filePath;
    }

}
