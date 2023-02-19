package dat3.jparelations.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Town {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private String zipCode;

  private String mayor;

  private String schools;


  public Town(String name, String zipCode, String mayor, String schools) {
    this.name = name;
    this.zipCode = zipCode;
    this.mayor = mayor;
    this.schools = schools;
  }
}
