package redblue.multipart.test.service;

import org.springframework.web.multipart.MultipartFile;
import redblue.multipart.test.vo.FileVo;

import java.io.IOException;


public interface FileService {
    public FileVo upload(MultipartFile file) throws IOException;

    public FileVo findFile(String fileName) throws IOException;
}
