package org.ok.segment.data.service;

import org.apache.commons.lang3.RandomUtils;
import org.ok.segment.data.repository.es.segment.SegmentElasticsearchRepository;
import org.ok.segment.model.Segment;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SegmentServiceImpl implements SegmentService {

    private final SegmentElasticsearchRepository segmentElasticsearchRepository;

    public SegmentServiceImpl(SegmentElasticsearchRepository segmentElasticsearchRepository) {
        this.segmentElasticsearchRepository = segmentElasticsearchRepository;
    }

    @Override
    public @NotNull List<Segment> findAll() {
        Iterable<Segment> items = segmentElasticsearchRepository.findAll();
        return StreamSupport
                .stream(items.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public @NotNull Optional<Segment> findById(@NotNull String id) {
        return segmentElasticsearchRepository.findById(id);
    }

    @Override
    public @NotNull List<Segment> findByName(@NotNull String name) {
        return segmentElasticsearchRepository.findByName(name);
    }

    @Override
    public Optional<Segment> findRandom() {
        List<Segment> items = findAll();
        if(items.isEmpty()) {
            return Optional.empty();
        }
        Segment item = items.get(RandomUtils.nextInt(0, items.size()));
        return Optional.of(item);
    }

    @Override
    public @NotNull Segment save(@NotNull Segment segment) {
        return segmentElasticsearchRepository.save(segment);
    }

    @Override
    public @NotNull Iterable<Segment> saveAll(@NotNull Iterable<Segment> segments) {
        return segmentElasticsearchRepository.saveAll(segments);
    }

    @Override
    public Optional<Segment> update(@NotNull String id, @NotNull Segment segment) {
        Optional<Segment> result = Optional.empty();
        if(existsById(id)) {
            result = Optional.of(save(segment));
        }
        return result;
    }

    @Override
    public void deleteById(@NotNull String id) {
        segmentElasticsearchRepository.deleteById(id);
    }

    @Override
    public long count() {
        return segmentElasticsearchRepository.count();
    }

    @Override
    public boolean existsById(@NotNull String id) {
        return segmentElasticsearchRepository.existsById(id);
    }

    @Override
    public boolean exists(@NotNull @NotNull Segment segment) {
        List<Segment> segments = segmentElasticsearchRepository.findByName(segment.getName());
        return (!segments.isEmpty());
    }
}
