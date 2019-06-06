package dao.impl.dao;

import dao.impl.ProvinceDao;
import domain.Province;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCutils;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {
    private JdbcTemplate template =new JdbcTemplate(JDBCutils.getDs());


    @Override
    public List<Province> findAll() {
        String sql="select * from province";
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}
