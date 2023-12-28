package redblue.bulk.test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import redblue.bulk.test.mapper.BulkInsertMapper;
import redblue.bulk.test.vo.InsertDataVo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BulkInsertServiceImpl implements BulkInsertService{

    private final BulkInsertMapper mapper;

    @Transactional
    public void insertBulkData(List<InsertDataVo> dtoList){
        int index = 0;

        while(index < dtoList.size()) {
            List<InsertDataVo> subList = dtoList.subList(index, Math.min(index + 500, dtoList.size()));
            mapper.insertData(subList);
            index += 500;
        }
    }

}
