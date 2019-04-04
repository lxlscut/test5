package alipay.test1.com.dao;
import alipay.test1.com.entity.commodity;
import alipay.test1.com.entity.info;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface mapper {
    /**
     * 向数据库中插入支付信息
     * @param i
     * @return
     */
    int insert(info i);

    /**
     * 删除数据库中的支付信息
     * @param id
     * @return
     */
    int delete(int id);

    List<info> queryall();

    commodity querybyid(int id);

    int insertmq(commodity c);

}