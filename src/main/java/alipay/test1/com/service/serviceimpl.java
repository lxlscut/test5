package alipay.test1.com.service;
import alipay.test1.com.dao.mapper;
import alipay.test1.com.entity.commodity;
import alipay.test1.com.entity.info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Component
public class serviceimpl implements service{

    @Autowired
    private mapper map;

    @Override
    public void save(info f) {
        map.insert(f);
    }

    @Override
    public List<info> quaryall() {
        List<info> inf = new ArrayList<info>();
        inf=map.queryall();
        return inf;
    }

    @Override
    public void delete(int id) {
        delete(id);
    }

    @Override
    public commodity queryid(int id) {
        commodity comm = new commodity();
       comm= map.querybyid(id);
        return comm;
    }

    @Override
    public int insertmq(commodity c) {
        int n = map.insertmq(c);
        return n;
    }


}
