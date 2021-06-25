package bruce.home.SpringBootTransactional;

import bruce.home.SpringBootTransactional.service.IBruceTblService;
import bruce.home.SpringBootTransactional.service.impl.BruceTblServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = SpringBootTransactionalApplication.class)
class SpringBootTransactionalApplicationTests {
    @Resource
    private IBruceTblService iBruceTblService;

    @Resource
    BruceTblServiceImpl bruceTblServiceImpl;

    @Test
    void testInsert() {
        iBruceTblService.insert();
    }

    @Test
    public void testTransaction2() {
        iBruceTblService.insert2();
    }

    @Test
    public void cglibTest() {
        // 如果使用 JDK 動態代理就會出如下的錯
        // Error creating bean with name 'bruce.home.SpringBootTransactional.SpringBootTransactionalApplicationTests':
        // Injection of resource dependencies failed;
        // nested exception is org.springframework.beans.factory.BeanNotOfRequiredTypeException:
        // Bean named 'bruceTblServiceImpl' is expected to be of type
        // 'bruce.home.SpringBootTransactional.service.impl.BruceTblServiceImpl'
        // but was actually of type 'com.sun.proxy.$Proxy60'
        bruceTblServiceImpl.aaa();
    }
}