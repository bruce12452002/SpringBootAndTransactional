package bruce.home.SpringBootTransactional;

import bruce.home.SpringBootTransactional.service.IBruceTblService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = SpringBootTransactionalApplication.class)
class SpringBootTransactionalApplicationTests {
    @Resource
    private IBruceTblService bruceTblServiceImpl;

    @Test
    void testInsert() {
        bruceTblServiceImpl.insert();
    }
}