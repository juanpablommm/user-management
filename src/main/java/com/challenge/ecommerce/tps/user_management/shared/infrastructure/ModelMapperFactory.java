package com.challenge.ecommerce.tps.user_management.shared.infrastructure;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public final class ModelMapperFactory {

    private static ModelMapper modelMapper;

    public static ModelMapper getModelMapper() {
        if (Objects.nonNull(modelMapper)) return modelMapper;
        modelMapper = new ModelMapper();
        Configuration configuration = modelMapper.getConfiguration();
        configuration.setMatchingStrategy(MatchingStrategies.STRICT);
        configuration.setPropertyCondition(Conditions.isNotNull());
        return modelMapper;
    }
}
