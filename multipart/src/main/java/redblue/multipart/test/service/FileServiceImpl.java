package redblue.multipart.test.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import redblue.multipart.test.vo.FileVo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService {

    @Value("${file.dir}")
    private String FILE_DIRECTORY;

    @Override
    public FileVo upload(MultipartFile file) throws IOException {
        System.out.println("파일 이름 : "+file.getOriginalFilename());
        dirExistsCheck();
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
    public FileVo findFile(String fileName) throws FileNotFoundException {
        File findFile = new File(FILE_DIRECTORY,fileName);
        if(!findFile.exists()){
            throw new FileNotFoundException(FILE_DIRECTORY +" 경로에 "+fileName+" 파일이 존재하지 않습니다.");
        }
        return new FileVo(FILE_DIRECTORY,fileName);
    }

    private void dirExistsCheck(){
        // 해당 파일 없으면 생성
        File dir = new File(FILE_DIRECTORY);
        if(!dir.exists()){
            dir.mkdirs();
        }
    }
}
