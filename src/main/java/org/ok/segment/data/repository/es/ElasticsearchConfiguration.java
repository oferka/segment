package org.ok.segment.data.repository.es;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

import javax.validation.constraints.NotNull;

@Configuration
public class ElasticsearchConfiguration extends AbstractElasticsearchConfiguration {

    private final ElasticsearchRestHighLevelClientConfiguration elasticsearchRestHighLevelClientConfiguration;

    public ElasticsearchConfiguration(@Autowired ElasticsearchRestHighLevelClientConfiguration elasticsearchRestHighLevelClientConfiguration) {
        this.elasticsearchRestHighLevelClientConfiguration = elasticsearchRestHighLevelClientConfiguration;
    }

    @Override
    @Bean
    public @NotNull RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(elasticsearchRestHighLevelClientConfiguration.getConnectTo())
                .build();
        return RestClients.create(clientConfiguration).rest();
    }
}
