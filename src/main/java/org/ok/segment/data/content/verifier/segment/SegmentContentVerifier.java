package org.ok.segment.data.content.verifier.segment;

import org.ok.segment.model.Segment;

import javax.validation.constraints.NotNull;

public interface SegmentContentVerifier {

    @NotNull Iterable<Segment> findLoaded(@NotNull Iterable<Segment> segments);

    @NotNull Iterable<Segment> findNotLoaded(@NotNull Iterable<Segment> segments);
}
