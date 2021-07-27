package embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;

    private String city;

}
