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

//    @Resource
//    private IBruceTblService iBruceTblService;

//    @Resource
//    private ProxyConfig proxyConfig;

    /**
     * CREATE TABLE `bruce_tbl` (
     * `id` int DEFAULT NULL,
     * `name` varchar(10) DEFAULT NULL
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
     */
    /**
     * spring transactional 主邏輯 PlatformTransactionManager
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert() {
        final String sql = "insert into bruce_tbl(id, name) values(?,?) ";
        jdbcTemplate.update(sql, 777, "monkey");
         int i = 1 / 0;


// 手動 rollback，如果想在錯誤時增加 log 之類的話
//        Object savePoint = null;
//        try {
//            savePoint = TransactionAspectSupport.currentTransactionStatus().createSavepoint();
//            final String sql = "insert into bruce_tbl(id, name) values(?,?) ";
//            jdbcTemplate.update(sql, 666, "monkey");
//            int i = 1 / 0;
//        } catch (Exception e) {
//            System.out.println("xxxxx");
//            Optional.ofNullable(savePoint)
//                    .ifPresent(s -> TransactionAspectSupport.currentTransactionStatus().rollbackToSavepoint(s));
//        }


//        iBruceTblService.aaa();
//        this.aaa();
    }

    @Override
//    @Transactional(rollbackFor = Exception.class)
    public void insert2() {
        // AopContext.currentProxy() 要在 exposeProxy = true 才不會在調用時報錯
//        IBruceTblService iBruceTblService = (IBruceTblService) AopContext.currentProxy();
//        iBruceTblService.aaa();
        aaa();
    }

    @Transactional(rollbackFor = Exception.class)
    public void aaa() {
        final String sql = "insert into bruce_tbl(id, name) values(?,?) ";
        jdbcTemplate.update(sql, 777, "monkey");
        int i = 1 / 0;
    }
}
