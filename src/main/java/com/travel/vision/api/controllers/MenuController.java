package com.travel.vision.api.controllers;

import com.travel.vision.api.dto.FoodImagePost;
import com.travel.vision.api.models.FoodImage;
import com.travel.vision.api.models.MenuItem;
import com.travel.vision.api.repositories.FoodImageRepository;
import com.travel.vision.api.repositories.MenuItemRepository;
import com.travel.vision.api.repositories.MenuRepository;
import com.travel.vision.api.services.ImageStorage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Api(tags = {"Menu Resource"})
@RestController
@RequestMapping( value = "/admin/menu/")
public class MenuController {
    private final MenuRepository menuRepository;
    private final MenuItemRepository menuItemRepository;
    private final FoodImageRepository foodImageRepository;
    private final ImageStorage imageStorage;

    public MenuController(MenuRepository menuRepository, MenuItemRepository menuItemRepository, FoodImageRepository foodImageRepository, ImageStorage imageStorage) {
        this.menuRepository = menuRepository;
        this.menuItemRepository = menuItemRepository;
        this.foodImageRepository = foodImageRepository;
        this.imageStorage = imageStorage;
    }

    @ApiOperation("Get list of menu items")
    @GetMapping()
    public List<MenuItem> getMenuItems(){
        return menuItemRepository.findAll();
    }

    @ApiOperation("Add new menu item")
    @PostMapping()
    public FoodImage saveMenuItem(@Valid @RequestBody FoodImagePost foodImagePost){
        FoodImage foodImage = new FoodImage();
        foodImage.setUrl(imageStorage.upload(foodImagePost.getData(), foodImagePost.getDocumentType()));
        return foodImageRepository.save(foodImage);
    }

    @ApiOperation("Get list of food item images")
    @GetMapping()
    public List<FoodImage> getFoodImages(){
        return foodImageRepository.findAll();
    }

    @ApiOperation("Add new food item Image")
    @PostMapping()
    public FoodImage saveFoodImage(@Valid @RequestBody FoodImagePost foodImagePost){
        FoodImage foodImage = new FoodImage();
        foodImage.setUrl(imageStorage.upload(foodImagePost.getData(), foodImagePost.getDocumentType()));
        return foodImageRepository.save(foodImage);
    }
}
