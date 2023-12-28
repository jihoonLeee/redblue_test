package redblue.multipart.test.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import redblue.multipart.test.dto.FileDto;
import redblue.multipart.test.service.FileService;
import redblue.multipart.test.vo.FileVo;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {

    private final FileService fileService;

    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<FileDto> upload(@RequestParam("file") MultipartFile file) throws IOException {
        FileVo vo = fileService.upload(file);
        return ResponseEntity.ok(new FileDto(vo.getFilePath(),vo.getFileName()));
    }

    @ResponseBody
    @GetMapping("/find/{fileName}")
    public ResponseEntity<FileDto> findFile(@PathVariable("fileName") String fileName) throws IOException {
        FileVo vo = fileService.findFile(fileName);

        return ResponseEntity.ok(new FileDto(vo.getFilePath(),vo.getFileName()));
    }
}
