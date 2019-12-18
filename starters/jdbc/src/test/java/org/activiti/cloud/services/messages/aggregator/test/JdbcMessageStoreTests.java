package org.activiti.cloud.services.messages.aggregator.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.integration.jdbc.store.JdbcMessageStore;

public class JdbcMessageStoreTests extends AbstractIntegrationFlowTests {

    @Test
    public void testMessageStore() throws Exception {
        assertThat(this.aggregatingMessageHandler.getMessageStore()).isInstanceOf(JdbcMessageStore.class);
    }
}