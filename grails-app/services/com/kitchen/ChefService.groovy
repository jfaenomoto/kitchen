package com.kitchen

import com.kitchen.exception.IngredientNotAvailableException

class ChefService {

    def kitchenStorageService
    
    def knifeService
        
    def cook(Recipe recipe) throws IngredientNotAvailableException {
        if (recipe == null) {
            throw new IllegalArgumentException("recipe can't be null on ChefService.cook()")
        }
        for (def ingredient : recipe.ingredients) {
            def ingredientFromStorage = kitchenStorageService.grab(ingredient)
            knifeService.cut(ingredient)
        }
        return new Meal(name : recipe.name)
    }
}
