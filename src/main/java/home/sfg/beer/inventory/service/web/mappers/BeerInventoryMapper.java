package home.sfg.beer.inventory.service.web.mappers;

import home.sfg.beer.inventory.service.domain.BeerInventory;
import home.sfg.brewery.model.BeerInventoryDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerInventoryMapper {

  BeerInventory beerInventoryDtoToBeerInventory(BeerInventoryDto beerInventoryDTO);

  BeerInventoryDto beerInventoryToBeerInventoryDto(BeerInventory beerInventory);
}
