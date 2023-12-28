package redblue.bulk.test.service;

import redblue.bulk.test.vo.InsertDataVo;

import java.util.List;

public interface BulkInsertService {

    void insertBulkData(List<InsertDataVo> dtoList);
}
