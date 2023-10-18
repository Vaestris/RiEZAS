package RiEZAS.business.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto extends BaseDto{

    private UUID id;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthday;
    private LocalDate registrationDate;
}
