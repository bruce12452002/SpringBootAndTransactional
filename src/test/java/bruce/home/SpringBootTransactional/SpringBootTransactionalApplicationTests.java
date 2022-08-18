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
    public void testNested() {
//        iBruceTblService.testNested();
        iBruceTblService.testMainNested();
    }

    @Test
    void testTryCatch() {
        bruceTblServiceImpl.tryCatch();
    }

    @Test
    public void cglibTest() {
        // 如果使用 JDK 動態代理就會出如下的錯，因為要從 interface 進入才可以
        // Error creating bean with name 'bruce.home.SpringBootTransactional.SpringBootTransactionalApplicationTests':
        // Injection of resource dependencies failed;
        // nested exception is org.springframework.beans.factory.BeanNotOfRequiredTypeException:
        // Bean named 'bruceTblServiceImpl' is expected to be of type
        // 'bruce.home.SpringBootTransactional.service.impl.BruceTblServiceImpl'
        // but was actually of type 'com.sun.proxy.$Proxy60'
        bruceTblServiceImpl.aaa();

        // 如果使用 CGLIB，雖然 bruceTblServiceImpl.aaa() 沒有經過 interface，也沒有寫 @Transactional
        // 但只要 bruceTblServiceImpl 實作了 IBruceTblService，然後 IBruceTblService 的 aaa()有 @Transactional
        // 這時 @Transactional 也是有效的
    }

    @Test
    void testPreparedStmt() {
        iBruceTblService.preparedStmt();
    }
}