package com.beerhouse.service;

import static br.com.six2six.fixturefactory.Fixture.from;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.beerhouse.model.Beer;
import com.beerhouse.templates.BeerTemplate;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BeerServiceTest {

	Beer beer;
	Beer newBeer;

	@Autowired
	private BeerService beerService;

	@Before
	public void setup() {

		FixtureFactoryLoader.loadTemplates("com.beerhouse");

		beer = from(Beer.class).gimme(BeerTemplate.LABEL_BEER_VALID);
		newBeer = beerService.createNewBeer(beer);
	}

	@Test
	public void shouldCreateNewBeerWithSuccess() {

		assertThat(newBeer).isEqualToComparingFieldByFieldRecursively(beer);

	}

	@Test
	public void shouldSearchAllBeerWithSuccess() {

		beerService.createNewBeer(beer);

		List<Beer> listBeer = beerService.searchAllBeer();

		assertThat(listBeer).isNotNull();
		assertThat(listBeer.size()).isEqualTo(2);

	}

	@Test
	public void shouldSearchBeerWithSuccess() {

		Beer beer = beerService.searchBeer(newBeer.getId());

		assertThat(beer).isEqualToComparingFieldByFieldRecursively(newBeer);

	}

	@Test
	public void shouldDeleteBeerWithSuccess() {

		List<Beer> searchAllBeer = beerService.searchAllBeer();

		Optional<Beer> findFirst = searchAllBeer.stream().findFirst();

		Boolean retorno = beerService.deleteBeer(findFirst.get().getId());

		assertThat(retorno).isEqualTo(true);

	}

	@Test
	public void shouldUpdateBeerWithSuccess() {

		newBeer.setAlcoholContent("50");
		List<Beer> searchAllBeer = beerService.searchAllBeer();

		Optional<Beer> findFirst = searchAllBeer.stream().findFirst();

		Beer beerUpdated = beerService.updateBeer(findFirst.get().getId(), newBeer);

		assertThat(beerUpdated).isEqualToComparingFieldByFieldRecursively(beerUpdated);

	}

}
