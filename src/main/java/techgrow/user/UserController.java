package techgrow.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Techgrow/")
public class UserController {
    @Autowired
    private UserSevice userSevice;
    @PostMapping("/addUser")
    public User postUser(@RequestBody User user){
        return userSevice.addUser(user);
    }
}
