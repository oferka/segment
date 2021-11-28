package org.ok.segment.data.content.provider;

import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Service
public class IdProviderImpl implements IdProvider {

    @Override
    public @NotNull @Size(min = 2, max = 64) @NotBlank String getRandom() {
        return UUID.randomUUID().toString();
    }
}
