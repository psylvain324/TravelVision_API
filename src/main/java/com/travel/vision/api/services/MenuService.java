package com.travel.vision.api.services;

import com.travel.vision.api.dto.restaurants.*;
import com.travel.vision.api.models.restaurants.FoodImage;
import com.travel.vision.api.models.restaurants.Menu;
import com.travel.vision.api.models.restaurants.MenuItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface MenuService {
    Menu createMenu(MenuPost menuPost);
    MenuItem addMenuItem(MenuItemPost menuItemPost, long menuId);
    Menu updateMenu(MenuPatch menuPatch);
    MenuItem updateMenuItem(MenuItemPatch menuItem);
    Menu getOneMenu(long menuId);
    MenuItem getOneMenuItem(long menuItemId);
    List<Menu> findAllActiveMenus();
    Page<Menu> findAllMenus(Pageable pageable);
    List<MenuItem> finaAllActiveMenuItemsByMenu(long menuId);
    List<MenuItem> findAllMenuItemsByMenu(long menuId);
    void deleteMenu(long menuId);
    void deleteMenuItem(long menuItemId);
    void changeMenuStatus(long menuId);
    void changeMenuItemStatus(long menuItemId);
    void makeMenuInactive(List<Long> menuIds);
    void makeMenuItemInactive(List<Long> menuItemIds);
    FoodImage saveFoodImage(FoodImagePost foodImagePost);
}
