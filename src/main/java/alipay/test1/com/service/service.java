package alipay.test1.com.service;
import alipay.test1.com.entity.commodity;
import alipay.test1.com.entity.info;


import java.util.List;
public interface service {


    /**
     * 保存数据
     * @param f
     */
    void save(info f);

    /**
     * 查询所有
     * @return
     */
    List<info> quaryall();

    /**
     * 根据id删除特定的数据
     * @param id
     */
    void delete(int id);

    commodity queryid(int id);

    int insertmq(commodity c);
}
