package com.kitchen

import com.kitchen.exception.IngredientNotAvailableException

class KitchenStorageService {

    Ingredient grab(Ingredient ingredient) throws IngredientNotAvailableException {
        def storage = Storage.findByIngredient(ingredient)
        if (!storage) {
            throw new IngredientNotAvailableException()
        }
        if (storage.quantity <= 0) {
            throw new IngredientNotAvailableException()
        }
        storage.quantity--
        storage.save()
        return storage.ingredient
    }
    
}
