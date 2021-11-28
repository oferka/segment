package org.ok.segment.data.repository.es.segment;

import org.ok.segment.model.Segment;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SegmentElasticsearchRepository extends ElasticsearchRepository<Segment, String> {

    List<Segment> findByName(String name);
}
