package techgrow.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("Techgrow/")
public class UserController {
    @Autowired
    private UserSevice userSevice;
    @PostMapping("/addUser")
    public User postUser(@RequestBody User user){
        return userSevice.addUser(user);
    }
    @GetMapping("/viewUserDetails/{id}")
    public User getUser(@PathVariable int id){
        return userSevice.getUser(id);
    }
    @PutMapping("/updateDetails")
    public User putUser(@RequestBody User user){
        return userSevice.updateUser(user);
    }
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id){
        return userSevice.deletedUser(id);
    }
}
