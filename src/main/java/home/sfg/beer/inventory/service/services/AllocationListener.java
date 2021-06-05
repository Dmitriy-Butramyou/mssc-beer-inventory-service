package home.sfg.beer.inventory.service.services;

import home.sfg.beer.inventory.service.config.JmsConfig;
import home.sfg.brewery.model.events.AllocateOrderResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class AllocationListener {

  private final AllocationService allocationService;
  private final JmsTemplate jmsTemplate;

  @JmsListener(destination = JmsConfig.ALLOCATE_ORDER_QUEUE)
  public void listen(AllocateOrderResult request) {
    AllocateOrderResult.AllocateOrderResultBuilder builder = AllocateOrderResult.builder();
    builder.beerOrderDto(request.getBeerOrderDto());

    try {
      boolean allocationResult = allocationService.allocateOrder(request.getBeerOrderDto());
      builder.pendingInventory(!allocationResult);
    } catch (Exception e) {
      log.error("Allocation failed for order id: " + request.getBeerOrderDto().getId());
      builder.allocationError(true);
    }

    jmsTemplate.convertAndSend(JmsConfig.ALLOCATE_ORDER_RESPONSE_QUEUE,
        builder.build());
  }
}
