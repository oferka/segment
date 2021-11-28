package org.ok.segment.data.content.health.segment;

import org.ok.segment.data.service.SegmentService;
import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("segmentContent")
@ConditionalOnEnabledHealthIndicator("segmentContent")
public class SegmentContentHealthIndicator implements HealthIndicator {

    private final SegmentService segmentService;

    public SegmentContentHealthIndicator(SegmentService segmentService) {
        this.segmentService = segmentService;
    }

    @Override
    public Health health() {
        Health.Builder status;
        try {
            long count = segmentService.count();
            status = (count > 0)?Health.up():Health.down();
            status.withDetail("number_of_segments", count);
        }
        catch (Exception e) {
            status = Health.down(e);
        }
        return status.build();
    }
}
