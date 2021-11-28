package org.ok.segment.data.content.provider.segment;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public interface SegmentNameProvider {

    @NotNull @Size(min = 2, max = 64) @NotBlank String get();
}
