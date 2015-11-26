package com.kitchen

class KnifeService {

    def cut(Ingredient ingredient) {
        log.info("Cutting ${ingredient.name}...")
    }
}
