package com.travel.vision.api.controllers;

import com.travel.vision.api.dto.restaurants.MenuItemPatch;
import com.travel.vision.api.dto.restaurants.MenuItemPost;
import com.travel.vision.api.dto.restaurants.MenuPatch;
import com.travel.vision.api.dto.restaurants.MenuPost;
import com.travel.vision.api.models.restaurants.Menu;
import com.travel.vision.api.models.restaurants.MenuItem;
import com.travel.vision.api.services.MenuService;
import com.travel.vision.api.utilities.ResponseDtoConverter;
import com.travel.vision.api.utilities.TvResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Api(tags = {"Menu Resource"})
@RestController
@RequestMapping( value = "/admin/menu/")
public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @ApiOperation("Get list of all Menu records")
    @GetMapping("/get-all/")
    public TvResponse<Page<Menu>> getMenus(@RequestBody Pageable pageable){
        return ResponseDtoConverter.convert(menuService.findAllMenus(pageable));
    }

    @ApiOperation("Get list of all Menu Items by Menu Id")
    @GetMapping("/{menuId}/menu_items/")
    public TvResponse<List<MenuItem>> getMenuItems(@PathVariable long menuId){
        return ResponseDtoConverter.convert(menuService.findAllMenuItemsByMenu(menuId));
    }

    @ApiOperation("Get list of all Active Menus")
    @GetMapping("/active/get-all/")
    public TvResponse<List<Menu>> getActiveMenus(){
        return ResponseDtoConverter.convert(menuService.findAllActiveMenus());
    }

    @ApiOperation("Get list of active Menu Items by Menu Id")
    @GetMapping("/{menuId}/menu_items/active/")
    public TvResponse<List<MenuItem>> getActiveMenuItems(@PathVariable long menuId){
        return ResponseDtoConverter.convert(menuService.finaAllActiveMenuItemsByMenu(menuId));
    }

    @ApiOperation("Create a new Menu")
    @GetMapping("/create/")
    public TvResponse<Menu> saveMenu(@Valid @RequestBody MenuPost menuPost){
        return ResponseDtoConverter.convert(menuService.createMenu(menuPost));
    }

    @ApiOperation(value = "Update an already created Menu")
    @PatchMapping(value = "/update/")
    public TvResponse<String> updateMenu (@Valid @RequestBody MenuPatch menuPatch) {
        menuService.updateMenu(menuPatch);
        return ResponseDtoConverter.convert(Message.MENU_UPDATED);
    }

    @ApiOperation(value = "Update an already created Menu Item")
    @PatchMapping(value = "/items/update/")
    public TvResponse<String> updateMenuItem (@Valid @RequestBody MenuItemPatch menuItemPatch) {
        menuService.updateMenuItem(menuItemPatch);
        return ResponseDtoConverter.convert(Message.MENU_ITEM_UPDATED);
    }

    @ApiOperation(value = "Delete a Menu by Id")
    @DeleteMapping(value = "/delete/{menuId}")
    public TvResponse<String> deleteMenu(@PathVariable("menuId") long menuId) {
        menuService.deleteMenu(menuId);
        return ResponseDtoConverter.convert(Message.MENU_DELETED);
    }

    @ApiOperation(value = "Delete a Menu Item by Id")
    @DeleteMapping(value = "/delete/items/{menuItemId}")
    public TvResponse<String> deleteMenuItem(@PathVariable("menuItemId") long menuItemId) {
        menuService.deleteMenuItem(menuItemId);
        return ResponseDtoConverter.convert(Message.MENU_ITEM_DELETED);
    }

    @ApiOperation("Add new menu item to an existing menu")
    @PostMapping("/{menuId}/add/")
    public TvResponse<MenuItem> addMenuItem(@Valid @RequestBody MenuItemPost menuItemPost, @PathVariable long menuId){
        return ResponseDtoConverter.convert(menuService.addMenuItem(menuItemPost, menuId));
    }

    @ApiOperation("Change status of a menu")
    @PatchMapping("/change-status/{menuId}")
    public TvResponse<String> changeMenuStatus(@PathVariable("menuId") long menuId) {
        menuService.changeMenuStatus(menuId);
        return ResponseDtoConverter.convert(Message.STATUS_CHANGED);
    }

    @ApiOperation("Change status of a menu item")
    @PatchMapping("/change-status/{menuItemId}")
    public TvResponse<String> changeMenuItemStatus(@PathVariable("menuItemId") long menuItemId) {
        menuService.changeMenuItemStatus(menuItemId);
        return ResponseDtoConverter.convert(Message.STATUS_CHANGED);
    }

    @ApiOperation("Make a list of Menus Inactive")
    @PatchMapping("/make-inactive/")
    public TvResponse<String> makeMenuInactive(@RequestParam("menuId") List<Long> menuIds) {
        menuService.makeMenuInactive(menuIds);
        return ResponseDtoConverter.convert(Message.STATUS_CHANGED);
    }

    @ApiOperation("Make a list of Menu Items Inactive")
    @PatchMapping("/items/make-inactive/")
    public TvResponse<String> makeMenuItemInactive(@RequestParam("menuItemId") List<Long> menuItemIds) {
        menuService.makeMenuItemInactive(menuItemIds);
        return ResponseDtoConverter.convert(Message.STATUS_CHANGED);
    }

    private static class Message {
        private final static String STATUS_CHANGED = "Status changed successfully";
        private final static String MENU_UPDATED = "Menu updated successfully";
        private final static String MENU_ITEM_UPDATED = "Menu item updated successfully";
        private final static String MENU_DELETED = "Menu deleted successfully";
        private final static String MENU_ITEM_DELETED= "Menu item deleted successfully";
    }
}
