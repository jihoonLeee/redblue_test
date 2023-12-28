package redblue.bulk.test.mapper;

import org.apache.ibatis.annotations.Mapper;
import redblue.bulk.test.vo.InsertDataVo;

import java.util.List;

@Mapper
public interface BulkInsertMapper {
    void insertData(List<InsertDataVo> dtos);
}
