/*
 * Copyright 2018 Alfresco, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.cloud.messages.integration.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class PostgresMessageStoreIT {
    
    private static ConfigurableApplicationContext messagesCtx;
    
    @SpringBootApplication
    static class MessagesApplication {
        
    }
        
    
    @BeforeClass
    public static void setUp() {
        messagesCtx = new SpringApplicationBuilder(MessagesApplication.class).web(WebApplicationType.NONE)
                                                                             .properties("spring.datasource.url=jdbc:postgresql://localhost:5432/postgres",
                                                                                         "spring.datasource.username=postgres",
                                                                                         "spring.datasource.password=",
                                                                                         "spring.datasource.platform=postgres",
                                                                                         "spring.application.name=messages-app",
                                                                                         "spring.jmx.enabled=false",
                                                                                         "spring.rabbitmq.host=localhost")
                                                                             .run();
    }

    @AfterClass
    public static void tearDown() {
        messagesCtx.close();
    }

    @Test
    public void contextLoads() throws Exception {
        assertThat(messagesCtx).isNotNull();        
    }    

}