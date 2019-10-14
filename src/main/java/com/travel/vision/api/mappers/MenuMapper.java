package com.travel.vision.api.mappers;

import com.travel.vision.api.dto.menu.MenuGet;
import com.travel.vision.api.dto.menu.MenuPatch;
import com.travel.vision.api.dto.menu.MenuPost;
import com.travel.vision.api.models.Menu;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class MenuMapper {
    public abstract Menu toEntity(MenuPost menuPost);
    public abstract Menu copy(MenuPatch menuPatch, @MappingTarget Menu menu);
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    public abstract MenuGet fromEntity(Menu menu);
}

