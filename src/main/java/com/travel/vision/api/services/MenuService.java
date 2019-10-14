package com.travel.vision.api.services;

import com.travel.vision.api.dto.menu.*;
import com.travel.vision.api.models.FoodImage;
import com.travel.vision.api.models.Menu;
import com.travel.vision.api.models.MenuItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface MenuService {
    Menu createMenu(MenuPost menuPost);
    MenuItem addMenuItem(MenuItemPost menuItemPost, String menuId);
    Menu updateMenu(MenuPatch menuPatch);
    MenuItem updateMenuItem(MenuItemPatch menuItem);
    Menu getOneMenu(String menuId);
    MenuItem getOneMenuItem(String menuItemId);
    List<Menu> findAllActiveMenus();
    Page<Menu> findAllMenus(Pageable pageable);
    List<MenuItem> finaAllActiveMenuItemsByMenu(String menuId);
    List<MenuItem> findAllMenuItemsByMenu(String menuId);
    void deleteMenu(String menuId);
    void deleteMenuItem(String menuItemId);
    void changeMenuStatus(String menuId);
    void changeMenuItemStatus(String menuItemId);
    void makeMenuInactive(List<String> menuIds);
    void makeMenuItemInactive(List<String> menuItemIds);
    FoodImage saveFoodImage(FoodImagePost foodImagePost);
}
