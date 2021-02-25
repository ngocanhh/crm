package com.myclass.util;

import org.modelmapper.ModelMapper;

public class Mapper {

	public static <T> T mapObject(Object source, Class<T> destination) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(source, destination);
	}

}
