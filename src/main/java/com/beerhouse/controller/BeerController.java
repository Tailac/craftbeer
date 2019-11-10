package com.beerhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beerhouse.model.Beer;
import com.beerhouse.service.BeerService;

@RestController
@RequestMapping("/")
public class BeerController {
	

	@Autowired
	BeerService beerService;

	@GetMapping("beers")
	public List<Beer> getBeers() {
		return beerService.searchAllBeer();
	}

	@PostMapping("beers")
	@ExceptionHandler
	public ResponseEntity<Object> newBeer(@RequestBody Beer newBeer) {
		return ResponseEntity.status(HttpStatus.CREATED).body(beerService.createNewBeer(newBeer));
	}

	@GetMapping("beers/{id}")
	public ResponseEntity<Object> searchBeer(@PathVariable(value = "id") Integer id) {
		return ResponseEntity.ok(beerService.searchBeer(id));
	}

	@DeleteMapping("beers/{id}")
	@ExceptionHandler
	public ResponseEntity<Object> deleteBeer(@PathVariable(value = "id") Integer id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(beerService.deleteBeer(id));
	}

	@PutMapping("beers/{id}")
	@ExceptionHandler
	public ResponseEntity<Object> updateBeer(@PathVariable(value = "id") Integer id, @RequestBody Beer beer) {
		return ResponseEntity.ok().body(beerService.updateBeer(id, beer));
	}

	@PatchMapping("beers/{id}")
	@ExceptionHandler
	public ResponseEntity<Object> updateFieldBeer(@PathVariable(value = "id") Integer id, @RequestBody Beer beer) {
		beerService.updateBeer(id, beer);
		return ResponseEntity.ok().body(beerService.updateBeer(id, beer));
	}

}
