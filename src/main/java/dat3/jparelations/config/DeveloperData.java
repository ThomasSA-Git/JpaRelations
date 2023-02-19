package dat3.jparelations.config;

import dat3.jparelations.entity.Address;
import dat3.jparelations.entity.Citizen;
import dat3.jparelations.entity.Town;
import dat3.jparelations.repository.AddressRepository;
import dat3.jparelations.repository.CitizenRepository;
import dat3.jparelations.repository.TownRepository;
import dat3.jparelations.service.AddressService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class DeveloperData implements ApplicationRunner {

  private TownRepository townRepository;

  private CitizenRepository citizenRepository;

  private AddressRepository addressRepository;

  private AddressService addressService;


  public DeveloperData(TownRepository townRepository, CitizenRepository citizenRepository, AddressRepository addressRepository, AddressService addressService) {
    this.townRepository = townRepository;
    this.citizenRepository = citizenRepository;
    this.addressRepository = addressRepository;
    this.addressService = addressService;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {

  setUp();
  }
  public void setUp() throws IOException {

    Address a1 = new Address("Lyngbyvej 1", "Lyngby", "2800");
    Citizen citizen1 = new Citizen("Kurt", "Wonnegut", "a@b.dk","123");
    Citizen citizen2 = new Citizen("Hanne", "Wonnegut", "h@b.dk", "234");
    Town t1 = new Town("By", "2800", "Mayor", "School");
 /*   citizenRepository.save(citizen1);
    citizenRepository.save(citizen2);*/
    townRepository.save(t1);

    citizen1.setTown(t1);
    citizen2.setTown(t1);

    a1.addCitizen(citizen1);
    a1.addCitizen(citizen2);

    addressRepository.save(a1);//Save the address

    //step 10
    addressService.printFullAddressInfo(a1.getId(), false);

/*
//step 9
    System.out.println("------- Select statements starts here ------------");
    Address address_1 = addressRepository.findById(a1.getId()).get();
    System.out.println(address_1.getStreet());
    System.out.println("Press Enter to continue");
    System.in.read();  //This will block so you have time to read the DEBUG statements
    System.out.println("Citizens: "+address_1.getCitizens().size());
    addressService.printFullAddressInfo(a1.getId(), false);
*/
  }
}

