package org.ok.segment.data.content.provider.segment;

import lombok.extern.slf4j.Slf4j;
import org.ok.segment.data.content.provider.IdProvider;
import org.ok.segment.model.Segment;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Profile("random-segments-provider")
public class SegmentRandomContentProvider implements SegmentContentProvider {

    private final IdProvider idProvider;

    private final SegmentNameProvider segmentNameProvider;

    public SegmentRandomContentProvider(IdProvider idProvider, SegmentNameProvider segmentNameProvider) {
        this.idProvider = idProvider;
        this.segmentNameProvider = segmentNameProvider;
    }

    @Override
    public List<Segment> get(int numberOfItems) {
        List<Segment> result =  new ArrayList<>();
        for(int i=0; i<numberOfItems; i++) {
            result.add(getSegment());
        }
        log.info("{} segments provided", result.size());
        return result;
    }

    private @NotNull Segment getSegment() {
        return new Segment(
                idProvider.getRandom(),
                segmentNameProvider.get()
        );
    }
}
