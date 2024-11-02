package com.challenge.ecommerce.tps.user_management.shared.infrastructure;

import java.util.Objects;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public final class ModelMapperFactory {

	private static ModelMapper modelMapper;

	public static ModelMapper getModelMapper() {
		if (Objects.nonNull(modelMapper))
			return modelMapper;
		modelMapper = new ModelMapper();
		Configuration configuration = modelMapper.getConfiguration();
		configuration.setMatchingStrategy(MatchingStrategies.STRICT);
		configuration.setPropertyCondition(Conditions.isNotNull());
		return modelMapper;
	}
}
