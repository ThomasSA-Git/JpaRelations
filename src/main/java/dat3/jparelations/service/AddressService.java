package dat3.jparelations.service;

import dat3.jparelations.entity.Address;
import dat3.jparelations.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AddressService {
  @Autowired
  AddressRepository addressRepository;

  //Lær og forstå denne annotation.
  @Transactional
  public void printFullAddressInfo(int id, boolean includeCitizens) {
    //Lav denne metode i stedet for at skifte til eager i relations.

    Address address_1 = addressRepository.findById(id).get();
    System.out.println(address_1.getStreet());
    if (includeCitizens) {
      System.out.println("Citizens: " + address_1.getCitizens().size());
    }
  }
}
