package com.kitchen

import grails.test.mixin.TestFor

import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Ingredient)
class IngredientSpec extends Specification {

    @Unroll
    def 'ingredient type #type is ovo-lacto'() {
        given:
        def ingredient = new Ingredient(type : type)

        expect:
        ingredient.isOvoLacto()

        where:
        type << [
            IngredientType.SEASONING,
            IngredientType.VEGETABLE,
            IngredientType.ANIMAL_DERIVATIVE
        ]
    }

    //    @Unroll
    //    def 'ingredient type #type is vegetarian'()

    //    @Unroll
    //    def 'ingredient type #type is not vegetarian'()
}