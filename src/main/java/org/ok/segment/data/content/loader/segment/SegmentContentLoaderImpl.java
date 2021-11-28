package org.ok.segment.data.content.loader.segment;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.IterableUtils;
import org.ok.segment.data.content.provider.segment.SegmentContentProvider;
import org.ok.segment.data.content.verifier.segment.SegmentContentVerifier;
import org.ok.segment.data.service.SegmentService;
import org.ok.segment.model.Segment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SegmentContentLoaderImpl implements SegmentContentLoader {

    private final SegmentContentProvider segmentContentProvider;
    private final SegmentContentVerifier segmentContentVerifier;
    private final SegmentService segmentService;

    public SegmentContentLoaderImpl(SegmentContentProvider segmentContentProvider, SegmentContentVerifier segmentContentVerifier, SegmentService segmentService) {
        this.segmentContentProvider = segmentContentProvider;
        this.segmentContentVerifier = segmentContentVerifier;
        this.segmentService = segmentService;
    }

    @Override
    public Iterable<Segment> ensureContentLoaded() {
        List<Segment> content = segmentContentProvider.get(100);
        Iterable<Segment> unloadedContent = segmentContentVerifier.findNotLoaded(content);
        if(!IterableUtils.isEmpty(unloadedContent)) {
            Iterable<Segment> saved = segmentService.saveAll(unloadedContent);
            log.info("{} segments saved", IterableUtils.size(saved));
        }
        log.info("{} segments ensured loaded", content.size());
        return content;
    }
}
