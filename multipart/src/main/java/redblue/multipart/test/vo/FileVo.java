package redblue.multipart.test.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
public class FileVo {

    private String filePath;
    private String fileName;

    public FileVo(String filePath,String fileName){
        this.filePath=filePath;
        this.fileName=fileName;
    }
}
