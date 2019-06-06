package service.impl;

import dao.impl.ProvinceDao;
import dao.impl.dao.ProvinceDaoImpl;
import domain.Province;
import org.codehaus.jackson.map.ObjectMapper;
import redis.clients.jedis.Jedis;
import service.ProvinceService;
import utils.JedisPoolUtils;

import java.io.IOException;
import java.util.List;

public class ProvinceServiceimpl implements ProvinceService {
    private ProvinceDao dao=new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    //使用redis进行数据的查询
    @Override
    public String findAllJson() {
        Jedis jedis = JedisPoolUtils.getJrdis();
        String province = jedis.get("province");
        //System.out.println(province);
        if (province==null || province.length()==0){
            List<Province> list = dao.findAll();
            ObjectMapper mapper=new ObjectMapper();
            try {
                province = mapper.writeValueAsString(list);
                jedis.set("province",province);

                jedis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else {
            System.out.println("redis...");
        }
        return province;
    }
}

