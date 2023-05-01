package org.online.common.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.online.common.dto.CreateOrderParam;
import org.online.common.model.OrderInfoEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(imports = {
        LocalDateTime.class
})
public interface IOrderConvert {

    IOrderConvert INSTANCE = Mappers.getMapper(IOrderConvert.class);

    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Mappings({
           @Mapping(target = "departTime",
                   expression = "java(LocalDateTime.parse(param.getDepartTime(),format))")
    })
    OrderInfoEntity param2Entity(CreateOrderParam param);
}
