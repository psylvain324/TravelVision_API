package com.travel.vision.api.services.ServiceImpl;

import com.travel.vision.api.dto.restaurants.*;
import com.travel.vision.api.enums.Status;
import com.travel.vision.api.mappers.MenuItemMapper;
import com.travel.vision.api.mappers.MenuMapper;
import com.travel.vision.api.models.restaurants.FoodImage;
import com.travel.vision.api.models.restaurants.Menu;
import com.travel.vision.api.models.restaurants.MenuItem;
import com.travel.vision.api.repositories.FoodImageRepository;
import com.travel.vision.api.repositories.MenuItemRepository;
import com.travel.vision.api.repositories.MenuRepository;
import com.travel.vision.api.services.BaseService;
import com.travel.vision.api.services.ImageStorage;
import com.travel.vision.api.services.MenuService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl extends BaseService implements MenuService {
    private final MenuRepository menuRepository;
    private final MenuItemRepository menuItemRepository;
    private final FoodImageRepository foodImageRepository;
    private final MenuItemMapper menuItemMapper;
    private final MenuMapper menuMapper;
    private final ImageStorage imageStorage;

    public MenuServiceImpl(MenuRepository menuRepository, MenuItemRepository menuItemRepository, FoodImageRepository foodImageRepository,
                          MenuItemMapper menuItemMapper, MenuMapper menuMapper, ImageStorage imageStorage) {
        this.menuRepository = menuRepository;
        this.menuItemRepository = menuItemRepository;
        this.foodImageRepository = foodImageRepository;
        this.menuItemMapper = menuItemMapper;
        this.menuMapper = menuMapper;
        this.imageStorage = imageStorage;
    }

    @Override
    public Menu createMenu(MenuPost menuPost) {
        return menuRepository.save(menuMapper.toEntity(menuPost));
    }

    @Override
    public MenuItem addMenuItem(MenuItemPost menuItemPost, String menuId) {
        Menu menu = getOneMenu(menuId);
        List<MenuItem> menuItems = menu.getMenuItems();
        MenuItem menuItem = menuItemMapper.toEntity(menuItemPost);
        menuItems.add(menuItem);
        menu.setMenuItems(menuItems);
        menuRepository.save(menu);
        return menuItemRepository.save(menuItem);
    }

    @Override
    public Menu updateMenu(MenuPatch menuPatch) {
        Menu menu = menuMapper.copy(menuPatch, getOneMenu(menuPatch.getId()));
        return menuRepository.save(menu);
    }

    @Override
    public MenuItem updateMenuItem(MenuItemPatch menuItemPatch) {
        MenuItem menuItem = menuItemMapper.copy(menuItemPatch, getOneMenuItem(menuItemPatch.getId()));
        return menuItemRepository.save(menuItem);
    }

    @Override
    public Menu getOneMenu(String menuId) {
        return findOne(Menu.class, menuId);
    }

    @Override
    public MenuItem getOneMenuItem(String menuItemId) {
        return findOne(MenuItem.class, menuItemId);
    }

    @Override
    public List<Menu> findAllActiveMenus() {
        return menuRepository.findAllByStatus(Status.Active);
    }

    @Override
    public Page<Menu> findAllMenus(Pageable pageable) {
        return menuRepository.findAll(pageable);
    }

    @Override
    public List<MenuItem> finaAllActiveMenuItemsByMenu(String menuId) {
        Menu menu = menuRepository.getOne(menuId);
        ArrayList<MenuItem> activeMenuItems = new ArrayList<>();
        List<MenuItem> menuItems = menu.getMenuItems();
        menuItems.forEach(t -> {
            if (t.getStatus() == Status.Active) {
                activeMenuItems.add(t);
            }
        });

        return activeMenuItems;
    }

    @Override
    public List<MenuItem> findAllMenuItemsByMenu(String menuId) {
        Menu menu = menuRepository.getOne(menuId);
        return menu.getMenuItems();
    }

    @Override
    public void deleteMenu(String menuId) {
        Menu menu = getOneMenu(menuId);
        menuRepository.delete(menu);
    }

    @Override
    public void deleteMenuItem(String menuItemId) {
        MenuItem menuItem = getOneMenuItem(menuItemId);
        menuItemRepository.delete(menuItem);
    }

    @Override
    public void changeMenuStatus(String menuId) {
        Menu menu = getOneMenu(menuId);
        if (menu.getStatus() == Status.Active) {
            menu.setStatus(Status.Inactive);
        } else {
            menu.setStatus(Status.Active);
        }

        menuRepository.save(menu);
    }

    @Override
    public void changeMenuItemStatus(String menuItemId) {
        MenuItem menuItem = getOneMenuItem(menuItemId);
        if (menuItem.getStatus() == Status.Active) {
            menuItem.setStatus(Status.Inactive);
        } else {
            menuItem.setStatus(Status.Active);
        }

        menuItemRepository.save(menuItem);
    }

    @Override
    public void makeMenuInactive(List<String> menuIds) {
        List<Menu> menus = new ArrayList<>();
        menuIds.forEach(t -> {
            Menu menu = getOneMenu(t);
            menu.setStatus(Status.Inactive);
            menus.add(menu);
        });
        menuRepository.saveAll(menus);
    }

    @Override
    public void makeMenuItemInactive(List<String> menuItemIds) {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItemIds.forEach(t -> {
            MenuItem menuItem = getOneMenuItem(t);
            menuItem.setStatus(Status.Inactive);
            menuItems.add(menuItem);
        });
        menuItemRepository.saveAll(menuItems);
    }

    @Override
    public FoodImage saveFoodImage(FoodImagePost foodImagePost) {
        FoodImage foodImage = new FoodImage();
        foodImage.setUrl(imageStorage.upload(foodImagePost.getData(), foodImagePost.getDocumentType()));
        return foodImageRepository.save(foodImage);
    }
}
