package com.beerhouse.templates;

import java.math.BigDecimal;

import com.beerhouse.model.Beer;
import com.beerhouse.model.Ingredient;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class BeerTemplate implements TemplateLoader {
	
	
	public static final String LABEL_BEER_VALID = "Beer Valid";

	@Override
	public void load() {

		Fixture.of(Beer.class).addTemplate(LABEL_BEER_VALID, new Rule() {
			{

				add("id", 1);
				add("name", "Taila");
				add("ingredients", has(1).of(Ingredient.class, IngredientTemplate.LABEL_INGREDIENT_VALID));
				add("alcoholContent", "80");
				add("price", new BigDecimal("19.60"));
				add("category","Teste");
				
			}
		});

	}

}
