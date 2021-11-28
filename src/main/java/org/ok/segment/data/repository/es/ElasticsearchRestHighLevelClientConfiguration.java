package org.ok.segment.data.repository.es;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Configuration
@PropertySource("classpath:segment-elasticsearch-rest-client.properties")
@ConfigurationProperties(prefix = "segment.elasticsearch.rest.client")
@Data
public class ElasticsearchRestHighLevelClientConfiguration {

    @NotNull
    @NotBlank
    @Size(min = 2, max = 256)
    private String connectTo = "localhost:9200";
}
