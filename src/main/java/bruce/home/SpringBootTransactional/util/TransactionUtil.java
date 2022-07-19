package bruce.home.SpringBootTransactional.util;

import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Optional;

public class TransactionUtil {
    public static Object getSavePoint() {
        return TransactionAspectSupport.currentTransactionStatus().createSavepoint();
    }

    public static void rollback(Object savePoint) {
        Optional.ofNullable(savePoint)
                .ifPresent(s -> TransactionAspectSupport.currentTransactionStatus().rollbackToSavepoint(s));
    }
}
