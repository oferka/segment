package org.ok.segment.data.content.loader;

import lombok.extern.slf4j.Slf4j;
import org.ok.segment.data.content.loader.segment.SegmentContentLoader;
import org.ok.segment.model.Segment;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ContentLoaderImpl implements ContentLoader {

    private final SegmentContentLoader segmentContentLoader;

    public ContentLoaderImpl(SegmentContentLoader segmentContentLoader) {
        this.segmentContentLoader = segmentContentLoader;
    }

    @Override
    public void ensureContentLoaded() {
        Iterable<Segment> segments = segmentContentLoader.ensureContentLoaded();
    }
}
