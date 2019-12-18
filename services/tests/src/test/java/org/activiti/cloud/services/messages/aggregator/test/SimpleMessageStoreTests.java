package org.activiti.cloud.services.messages.aggregator.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.metadata.ConcurrentMetadataStore;
import org.springframework.integration.metadata.SimpleMetadataStore;
import org.springframework.integration.store.MessageGroupStore;
import org.springframework.integration.store.SimpleMessageStore;
import org.springframework.integration.support.locks.DefaultLockRegistry;
import org.springframework.integration.support.locks.LockRegistry;
import org.springframework.integration.transaction.PseudoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

public class SimpleMessageStoreTests extends AbstractIntegrationFlowTests {
    
    @TestConfiguration
    static class SimpleMessageStoreConfiguration {
        
        @Bean
        public PlatformTransactionManager transactionManager() {
          return new PseudoTransactionManager();
        }
        
        @Bean
        public MessageGroupStore messageStore() {
            return new SimpleMessageStore();
        }

        @Bean
        public ConcurrentMetadataStore metadataStore() {
            return new SimpleMetadataStore();
        }
        
        @Bean
        public LockRegistry lockRegistry() {
            return new DefaultLockRegistry();
        }
        
    }    

    @Test
    public void testMessageStore() throws Exception {
        assertThat(this.aggregatingMessageHandler.getMessageStore()).isInstanceOf(SimpleMessageStore.class);
    }
}
