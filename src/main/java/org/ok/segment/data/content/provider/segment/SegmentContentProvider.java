package org.ok.segment.data.content.provider.segment;

import org.ok.segment.model.Segment;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface SegmentContentProvider {

    @NotNull List<Segment> get(int numberOfItems);
}
