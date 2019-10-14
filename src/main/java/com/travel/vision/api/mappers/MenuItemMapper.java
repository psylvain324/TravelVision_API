package com.travel.vision.api.mappers;

import com.travel.vision.api.dto.MenuItemGet;
import com.travel.vision.api.dto.MenuItemPatch;
import com.travel.vision.api.dto.MenuItemPost;
import com.travel.vision.api.models.MenuItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class MenuItemMapper {
    public abstract MenuItem toEntity(MenuItemPost menuItemPost);
    public abstract MenuItem copy(MenuItemPatch affinityPatch, @MappingTarget MenuItem menuItem);
    public abstract MenuItemGet fromEntity(MenuItem menuItem);
}
