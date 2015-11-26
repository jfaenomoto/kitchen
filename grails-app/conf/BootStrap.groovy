import com.kitchen.*

class BootStrap {

    def kitchenStorageService

    def init = { servletContext ->
        def meat = new Ingredient(name : "Sirloin", type : IngredientType.MEAT).save(failOnError : true)
        def potato = new Ingredient(name : "Potato", type : IngredientType.VEGETABLE).save(failOnError : true)
        def season = new Ingredient(name : "Rosemary", type : IngredientType.SEASONING).save(failOnError : true)

        new Recipe(name : "Meat & Potatoes", ingredients : [meat, potato, season]).save(failOnError : true)

        new Storage(quantity : 3, ingredient : meat).save(failOnError : true)
        new Storage(quantity : 6, ingredient : potato).save(failOnError : true)
        new Storage(quantity : 5, ingredient : season).save(failOnError : true)
    }
}
