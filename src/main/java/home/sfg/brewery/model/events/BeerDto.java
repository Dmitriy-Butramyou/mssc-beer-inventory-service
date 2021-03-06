package home.sfg.brewery.model.events;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BeerDto implements Serializable {

  static final long serialVersionUID = -8150796741030672486L;

  @Null
  private UUID id;

  @Null
  private Integer version;

  @Null
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
  private OffsetDateTime createdDate;

  @Null
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
  private OffsetDateTime lastModifiedDate;

  @NotBlank
  private String beerName;

  @NotNull
  private String beerStyle;

  @NotNull
  private String upc;

  @Positive
  @NotNull
  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private BigDecimal price;

  private Integer quantityOnHand;
}
