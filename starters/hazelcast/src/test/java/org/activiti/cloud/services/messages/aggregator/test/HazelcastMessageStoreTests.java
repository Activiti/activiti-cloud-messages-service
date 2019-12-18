package org.activiti.cloud.services.messages.aggregator.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.hazelcast.store.HazelcastMessageStore;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class HazelcastMessageStoreTests extends AbstractIntegrationFlowTests {
    
    @TestConfiguration
    static class HazelcastConfiguration {
        @Bean
        public HazelcastInstance hazelcastInstance(Config hazelcastConfig) {
            return Hazelcast.newHazelcastInstance(hazelcastConfig);
        }

        @Bean
        public HazelcastInstance hazelcastInstance2(Config hazelcastConfig) {
            return Hazelcast.newHazelcastInstance(hazelcastConfig);
        }

        @Bean
        public HazelcastInstance hazelcastInstance3(Config hazelcastConfig) {
            return Hazelcast.newHazelcastInstance(hazelcastConfig);
        }
    }

    @Test
    public void testMessageStore() throws Exception {
        assertThat(this.aggregatingMessageHandler.getMessageStore()).isInstanceOf(HazelcastMessageStore.class);
    }
}
