package ma.ensate.sturent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
    @Autowired

    private PropertyRepository propertyRepository;

    @GetMapping(path = "/add")
    public @ResponseBody String addNewProperty(
            @RequestParam int id,
            @RequestParam String address,
            @RequestParam String city,
            @RequestParam int max,
            @RequestParam int available,
            @RequestParam int price
    ){
        Property newProperty = new Property(id, city, address, max, available, price);
        propertyRepository.save(newProperty);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Property> getAllProperties(){
        return propertyRepository.findAll();
    }
}
