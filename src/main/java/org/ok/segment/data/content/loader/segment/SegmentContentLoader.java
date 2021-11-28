package org.ok.segment.data.content.loader.segment;

import org.ok.segment.model.Segment;

import javax.validation.constraints.NotNull;

public interface SegmentContentLoader {

    @NotNull Iterable<Segment> ensureContentLoaded();
}
