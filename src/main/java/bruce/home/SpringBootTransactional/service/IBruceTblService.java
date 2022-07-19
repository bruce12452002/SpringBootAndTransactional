package bruce.home.SpringBootTransactional.service;

public interface IBruceTblService {
    //    @Transactional(rollbackFor = Exception.class)
    void insert();

    void insert2();

    void testMainNested();

    void testNested();

//    @Transactional(rollbackFor = Exception.class)
//    void aaa();
}
