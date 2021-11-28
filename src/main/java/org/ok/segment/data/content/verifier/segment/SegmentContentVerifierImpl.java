package org.ok.segment.data.content.verifier.segment;

import lombok.extern.slf4j.Slf4j;
import org.ok.segment.data.service.SegmentService;
import org.ok.segment.model.Segment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SegmentContentVerifierImpl implements SegmentContentVerifier {

    private final SegmentService segmentService;

    public SegmentContentVerifierImpl(SegmentService segmentService) {
        this.segmentService = segmentService;
    }

    @Override
    public Iterable<Segment> findLoaded(Iterable<Segment> segments) {
        List<Segment> result = new ArrayList<>();
        for(Segment segment : segments) {
            if(segmentService.exists(segment)) {
                result.add(segment);
            }
        }
        log.info("{} segments found as loaded", result.size());
        return result;
    }

    @Override
    public Iterable<Segment> findNotLoaded(Iterable<Segment> segments) {
        List<Segment> result = new ArrayList<>();
        for(Segment segment : segments) {
            if(!segmentService.exists(segment)) {
                result.add(segment);
            }
        }
        log.info("{} segments found as unloaded", result.size());
        return result;
    }
}
