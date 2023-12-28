package redblue.multipart.test.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import redblue.multipart.test.vo.FileVo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceImpl implements FileService {

    @Value("${file.dir}")
    private String FILE_DIRECTORY;

    @Value("${project.file.dir}")
    private String FILE_DIRECTORY_TARGET;

    @Value("${view.file.dir}")
    private String FILE_DIRECTORY_VIEW;

    @Override
    public FileVo upload(MultipartFile file) throws IOException {
        System.out.println("파일 이름 : "+file.getOriginalFilename());
        dirExistsCheck(FILE_DIRECTORY);
        File saveFile = new File(FILE_DIRECTORY,file.getOriginalFilename());
        try{
            file.transferTo(saveFile);
            saveFile.setReadable(true);
            saveFile.setWritable(true);
        }catch (IOException e){
            e.printStackTrace();
        }
        return new FileVo(FILE_DIRECTORY,file.getName());
    }


    @Override
    public FileVo findFile(String fileName) throws IOException {
        File findFile = new File(FILE_DIRECTORY,fileName);
        if(!findFile.exists()){
            throw new FileNotFoundException(FILE_DIRECTORY +" 경로에 "+fileName+" 파일이 존재하지 않습니다.");
        }
        // 로컬에 있는 파일을 복사 하고 view에 보여주기..

        dirExistsCheck(FILE_DIRECTORY_TARGET);

        Path targetDir = Paths.get(FILE_DIRECTORY_TARGET);

        // 서버 용량이 늘어나니까 비우기
        Files.newDirectoryStream(targetDir).forEach(path -> {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        
        Path localPath = Paths.get(FILE_DIRECTORY + fileName);
        Path targetPath = Paths.get(FILE_DIRECTORY_TARGET+fileName);
        
        Files.copy(localPath, targetPath, StandardCopyOption.REPLACE_EXISTING);

        return new FileVo(FILE_DIRECTORY_VIEW,fileName);
    }

    private void dirExistsCheck(String path){
        // 해당 폴더 없으면 생성
        File dir = new File(path);
        if(!dir.exists()){
            dir.mkdirs();
        }
    }
}
