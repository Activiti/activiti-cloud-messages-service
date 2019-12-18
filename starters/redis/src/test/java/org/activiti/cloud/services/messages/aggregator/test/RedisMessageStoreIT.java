package org.activiti.cloud.services.messages.aggregator.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.redis.store.RedisMessageStore;
import org.springframework.integration.transaction.PseudoTransactionManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.PlatformTransactionManager;

@TestPropertySource(properties = {
        "spring.redis.host=localhost",
        "spring.redis.port=6379"})
public class RedisMessageStoreIT extends AbstractIntegrationFlowTests {
    
    @TestConfiguration 
    static class Configuration {

        @Bean
        public PlatformTransactionManager transactionManager() {
          return new PseudoTransactionManager();
        }
    }
    
    @Test
    public void testMessageStore() throws Exception {
        assertThat(this.aggregatingMessageHandler.getMessageStore()).isInstanceOf(RedisMessageStore.class);
    }
}