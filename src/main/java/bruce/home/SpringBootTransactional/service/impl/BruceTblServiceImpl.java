package bruce.home.SpringBootTransactional.service.impl;

import bruce.home.SpringBootTransactional.service.IBruceTblService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class BruceTblServiceImpl implements IBruceTblService {
    @Resource
    private JdbcTemplate jdbcTemplate;


    /**
     * CREATE TABLE `bruce_tbl` (
     *   `id` int DEFAULT NULL,
     *   `name` varchar(10) DEFAULT NULL
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert() {
        final String sql = "insert into bruce_tbl(id, name) values(?,?) ";
        jdbcTemplate.update(sql, 777, "monkey");
//        int i = 1 / 0;
    }
}
