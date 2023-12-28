package redblue.bulk.test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import redblue.bulk.test.service.BulkInsertService;
import redblue.bulk.test.vo.InsertDataVo;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BulkInsertController {

    private final BulkInsertService service;

    @GetMapping("/putJsonBulk")
    public ResponseEntity<Void> putJsonBulk(@RequestBody List<InsertDataVo> dtoList){
        service.insertBulkData(dtoList);
        return ResponseEntity.ok().build();
    }

}
