package ma.Ensate.StuRent.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/request")
public class RequestController {
    @Autowired
    private RequestRepository requestRepository;

    @GetMapping(path = "/add")
    public @ResponseBody String addNewProperty(
            //@RequestParam int request_id,
            @RequestParam int post_id,
            @RequestParam int requester_id,
            @RequestParam(defaultValue = "Waiting") String status
    ){
        Request newRequest = new Request(post_id, requester_id);
        requestRepository.save(newRequest);
        return "Saved";
    }

    @GetMapping(path = "/RequestsList")
    public @ResponseBody void getAllRequests(Model model){
        Iterable<Request> requests = requestRepository.findAll();

        model.addAttribute("requests", requests);
    }
}