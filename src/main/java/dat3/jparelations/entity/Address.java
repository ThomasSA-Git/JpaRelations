package dat3.jparelations.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String street;

  private String city;

  private String zip;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "address", fetch = FetchType.LAZY)
  private List<Citizen> citizens = new ArrayList();


  public Address(String street, String city, String zip) {
    this.street = street;
    this.city = city;
    this.zip = zip;
  }

  public void addCitizen(Citizen citizen){
    if(citizens == null) {
      citizens = new ArrayList<>();
    }
      citizens.add(citizen);
      citizen.setAddress(this);
    }
  }

