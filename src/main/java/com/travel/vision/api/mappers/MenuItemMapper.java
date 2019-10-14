package com.travel.vision.api.mappers;

import com.travel.vision.api.dto.menu.MenuItemGet;
import com.travel.vision.api.dto.menu.MenuItemPatch;
import com.travel.vision.api.dto.menu.MenuItemPost;
import com.travel.vision.api.models.MenuItem;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class MenuItemMapper {
    public abstract MenuItem toEntity(MenuItemPost menuItemPost);
    public abstract MenuItem copy(MenuItemPatch menuItemPatch, @MappingTarget MenuItem menuItem);
    public abstract MenuItemGet fromEntity(MenuItem menuItem);
}
