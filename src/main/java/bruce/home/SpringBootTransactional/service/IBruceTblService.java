package bruce.home.SpringBootTransactional.service;

import org.springframework.transaction.annotation.Transactional;

public interface IBruceTblService {
//    @Transactional(rollbackFor = Exception.class)
    void insert();

    void insert2();

//    @Transactional(rollbackFor = Exception.class)
//    void aaa();
}
