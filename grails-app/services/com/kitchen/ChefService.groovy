package com.kitchen

import com.kitchen.exception.*

class ChefService {

    def kitchenStorageService

    def knifeService

    def cook(Recipe recipe) throws RecipeNotAvailableException {
        if (recipe == null) {
            throw new IllegalArgumentException("recipe can't be null on ChefService.cook()")
        }
        try {
            for (def ingredient : recipe.ingredients) {
                def ingredientFromStorage = kitchenStorageService.grab(ingredient)
                knifeService.cut(ingredient)
            }
            return new Meal(name : recipe.name)
        } catch (IngredientNotAvailableException e) {
            throw new RecipeNotAvailableException();
        }
    }
}
