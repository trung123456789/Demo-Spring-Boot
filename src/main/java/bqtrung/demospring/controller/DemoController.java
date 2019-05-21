package bqtrung.demospring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bqtrung.demospring.model.User;
import bqtrung.demospring.repository.impl.DemoRepository;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

	@Autowired
	DemoRepository demoRepository;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/users")
	public ResponseEntity<List<User>> listAllContact() {
		List<User> listUser = demoRepository.findAll();
		if (listUser.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(listUser, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUsersById(@PathVariable(value = "id") Integer userId) {
		// Type 1:
		// User user = demoRepository.findById(userId).orElse(null);
		// Type 2:
		User user = demoRepository.findByUserId(userId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
	}

	@RequestMapping(path = "/pusers", method = RequestMethod.POST)
	@ResponseBody
	public User createUser(@Valid @RequestBody User user) {
		return demoRepository.save(user);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateContact(@PathVariable(value = "id") Integer userId,
			@Valid @RequestBody User user) {
		// Type 1:
		// User user_rs = demoRepository.findById(userId).orElse(null);
		// Type 2:
		User user_rs = demoRepository.findByUserId(userId);
		if (user_rs == null) {
			return ResponseEntity.notFound().build();
		}
		user_rs.setFirstName(user.getFirstName());
		user_rs.setLastName(user.getLastName());
		user_rs.setEmail(user.getEmail());

		User updatedContact = demoRepository.save(user_rs);
		return ResponseEntity.ok(updatedContact);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteContact(@PathVariable(value = "id") Integer userId) {
		// Type 1:
		// User user_rs = demoRepository.findById(userId).orElse(null);
		// Type 2:
		User user = demoRepository.findByUserId(userId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}

		demoRepository.delete(user);
		return ResponseEntity.ok().build();
	}
}
