package com.travel.vision.api.mappers;

import com.travel.vision.api.dto.restaurants.MenuGet;
import com.travel.vision.api.dto.restaurants.MenuPatch;
import com.travel.vision.api.dto.restaurants.MenuPost;
import com.travel.vision.api.models.restaurants.Menu;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class MenuMapper {
    public abstract Menu toEntity(MenuPost menuPost);
    public abstract Menu copy(MenuPatch menuPatch, @MappingTarget Menu menu);
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    public abstract MenuGet fromEntity(Menu menu);
}

