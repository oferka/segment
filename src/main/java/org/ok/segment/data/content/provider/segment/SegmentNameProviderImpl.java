package org.ok.segment.data.content.provider.segment;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Service
public class SegmentNameProviderImpl implements SegmentNameProvider {

    @Override
    public @NotNull @Size(min = 2, max = 64) @NotBlank String get() {
        return new Faker().country().name();
    }
}
