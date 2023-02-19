package dat3.jparelations.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Citizen {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  //@Column(name="citizen_ID")
  private Integer id;

  private String firstName;

  private String lastName;

  private String email;

  private String phone;

  @ManyToOne
  Address address;

  @ManyToOne
  Town town;


  public Citizen(String firstName, String lastName, String email, String phone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
  }
}
