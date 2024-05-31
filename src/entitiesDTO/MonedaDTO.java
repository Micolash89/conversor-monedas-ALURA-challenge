package entitiesDTO;

import java.util.Map;

public record MonedaDTO(
        Map<String,Double> conversion_rates
) {
}
