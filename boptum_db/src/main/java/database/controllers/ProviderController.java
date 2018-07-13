package database.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import database.data.Provider;
import database.PatientRepository;
import database.ProviderRepository;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/provider") // This means URL's start with /lynx (after Application path)
public class ProviderController {
	@Autowired 
	private PatientRepository patientRepository;

	@Autowired
	private ProviderRepository providerRepository;
	private Provider currentUser;
	private boolean updated;

	/**
	 * Adds a user to the database
	 * 
	 * @param username the username
	 * @param password the password
	 * @param name the name
	 * @param email the email
	 * @param phone the phone number
	 */
	@PostMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addProvider (@RequestParam String username, @RequestParam String password, @RequestParam String name, @RequestParam String email, @RequestParam String phone, @RequestParam int type) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Provider newProvider = new Provider(username,password,name,email,phone,type);
		providerRepository.save(newProvider);
		return "New provider has been added\n";
	}

	/**
	 * A method to find a user based on their name
	 * 
	 * @param name the name of the user
	 * @return the user with the specfied name
	 */
	@GetMapping(path="/find") // Map ONLY GET Requests
	public @ResponseBody Provider findProvider (@RequestParam String name) {
		Iterable<Provider> providers = providerRepository.findAll();
		for (Provider item: providers){
			if (item.getName().equals(name)){
				return item;
			}
		}
		// Make sure to catch this null
		return new Provider();

	}

	/**
	 * Gets a list of all the users in the databse
	 * 
	 * @return the list of users
	 */
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Provider> getAllProviders() {
		// This returns a JSON or XML with the users
		return providerRepository.findAll();
	}

	/**
	 * Controls the login of the application
	 * 
	 * @param username the username
	 * @param password the password
	 * @return the result of the credentials
	 */
	@GetMapping(path="/user/login")
	public @ResponseBody String login(@RequestParam String username, @RequestParam String password){
		updated = false;
		Iterable<Provider> users = providerRepository.findAll();
		for (Provider item: users){
			if (item.getUsername().equals(username)){
				if (item.getPassword().equals(password)){
					currentUser = item;
					return "Login Successful";
				}
			}
		}
		return "Invalid Credentials";
	}

	/**
	 * Gets the data for the current user
	 * 
	 * @return the current users data
	 */
	@GetMapping(path="/user/data")
	public @ResponseBody Provider getCurrentUserData(){
		if(updated){
			currentUser = findProvider(currentUser.getName());
		}
		return currentUser;
	}

	/**
	 * Controls the logout of the application
	 *
	 * @return the result of the operation
	 */
	@GetMapping(path="/user/logout")
	public @ResponseBody String logout(){
		if(currentUser == null){
			return "There is no user signed in";
		} else{
			currentUser = null;
			return "Logout Successful";
		}
	}

	@GetMapping(path="/load") // Map ONLY GET Requests
	public @ResponseBody String importData(){
		addProvider("indianajones", "password", "Indiana Jones", "indy@gmail.com", "7046269313",1);
		addProvider("doctor", "password", "doctor", "doc@gmail.com", "7046269313",2);
		addProvider("drdoom", "password", "Dr. Doom", "doom@gmail.com", "7046269313",3);
		addProvider("saheli", "password", "Dr. Saheli Parekh", "saheli@gmail.com", "7046269313",9);
		addProvider("example1", "password", "Micheal Jackson", "Jackson@gmail.com", "7046269313",5);
		addProvider("example2", "password", "Kid Cudi", "Cudi@gmail.com", "7046269313",6);
		addProvider("example3", "password", "Jaden Smith", "SYRE@gmail.com", "7046269313",7);
		addProvider("example4", "password", "Kodak Black", "Black@gmail.com", "7046269313",8);
		addProvider("example5", "password", "Dr. Dre", "Dre@gmail.com", "7046269313",9);
		addProvider("example6", "password", "Tee Grizzly", "Grizzly@gmail.com", "7046269313",10);
		addProvider("example7", "password", "Quavo", "migos@gmail.com", "7046269313",11);
		addProvider("example8", "password", "Offset", "migos@gmail.com", "7046269313",4);
		addProvider("example9", "password", "Takeoff", "migos@gmail.com", "7046269313",10);
		addProvider("example10", "password", "Cardi B", "migos@gmail.com", "7046269313",1);
		addProvider("example11", "password", "Drake", "ovo@gmail.com", "7046269313",2);
		addProvider("example12", "password", "Kendrick Lamar", "damn@gmail.com", "7046269313",3);
		addProvider("example13", "password", "J.Cole", "kod@gmail.com", "7046269313",4);
		addProvider("example14", "password", "The Game", "game@gmail.com", "7046269313",5);
		addProvider("example15", "password", "Pusha T", "daytona@gmail.com", "7046269313",6);
		addProvider("example16", "password", "Lil Yachty", "boom@gmail.com", "7046269313",7);
		addProvider("example17", "password", "Post Malone", "BandB@gmail.com", "7046269313",8);
		return "";
	}
}