package bruce.home.SpringBootTransactional;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.aop.framework.ProxyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import javax.sql.DataSource;

@EnableAspectJAutoProxy(proxyTargetClass = false, exposeProxy = false)
// Spring
// @EnableAspectJAutoProxy，預設是 JDK 動態代理，@Transactional 寫在介面或類別都會生效
// Spring 5.x 如果寫了 @EnableAspectJAutoProxy proxyTargetClass = false，這是預設值
// 如果寫了 @EnableAspectJAutoProxy proxyTargetClass = true，只走 CGLIB 動態代理，此時 @Transactional 寫在介面無效

// exposeProxy 在同一類別呼叫自己的方法時，直接呼叫會使 @Transactional 失效，如果這個屬性為 true，
// 就可以使用 AopContext.currentProxy()，有使用 AopContext.currentProxy()，目標方法的 @Transactional 才不會失效
// 總結：同類調用時，用兩種的動態代理，目標方法的 @Transactional 都會失效
// 只有是 JDK 動態代理且使用 exposeProxy=true + AopContext.currentProxy()


// SpringBoot 2.x 預設 已經有 @EnableAspectJAutoProxy ，所以可以不寫
// 預設是 CGLIB 動態代理，註解的 proxyTargetClass 屬性設定無效；但 exposeProxy 屬性有效
// 在 yml 設定 spring.aop.proxy-target-class=false 可以解決

@SpringBootApplication
public class SpringBootTransactionalApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootTransactionalApplication.class, args);
    }

    @Resource
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));//使用者名稱
        dataSource.setPassword(env.getProperty("spring.datasource.password"));//密碼
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setInitialSize(2);
        dataSource.setMaxActive(20);
        dataSource.setMinIdle(0);
        dataSource.setMaxWait(60000);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setPoolPreparedStatements(false);
        return dataSource;
    }

}
