package org.ok.segment.data.service;

import org.ok.segment.model.Segment;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface SegmentService {

    @NotNull List<Segment> findAll();

    @NotNull Optional<Segment> findById(@NotNull String id);

    @NotNull List<Segment> findByName(@NotNull String name);

    @NotNull Optional<Segment> findRandom();

    long count();

    @NotNull Segment save(@NotNull Segment segment);

    @NotNull Iterable<Segment> saveAll(@NotNull Iterable<Segment> segments);

    @NotNull Optional<Segment> update(@NotNull String id, @NotNull Segment segment);

    void deleteById(@NotNull String id);

    boolean existsById(@NotNull String id);

    boolean exists(@NotNull Segment segment);
}
