package RiEZAS.domain.models.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "role")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Role {

    @Id
    @Column
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String name;
}
