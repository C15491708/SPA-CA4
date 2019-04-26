package main.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
		
	public List<User> getAllUsers(){
		List<User> Users = new ArrayList<User>();
		for(User u: userRepository.findAll()) {
			Users.add(u);
		}
		return Users;
	}
	
	public User getUserById(int id) {
		return userRepository.findOne(id);
	}
	
	public User getUserByUsernameAndPassword(String username, String password) {
		User c = userRepository.findByUsernameAndPassword(username, password);
		return c;
	}
	
	
	public void addUser(User u) {
		userRepository.save(u);
	}
	
	public void updateUser(int id, User u) {
		userRepository.save(u);
	}
	
	public void deleteUser(int id) {
		userRepository.delete(id);
	}

}
