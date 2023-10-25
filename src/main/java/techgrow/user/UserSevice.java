package techgrow.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserSevice {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }
    public User getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }
    public User updateUser(User user) {
        User updatedUser = userRepository.findById(user.getUserId()).orElse(null);
        if(updatedUser != null){
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setUsername(user.getUsername());
            userRepository.save(updatedUser);
            return updatedUser;
        }else return null;
    }
    public String deletedUser(int id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "User Removed";
        }else return "user not found";
    }
}
