package database.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity // This tells Hibernate to make a table out of this class
public class Patient {
    @Id
    @GeneratedValue
	private Integer id;
	
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String phone;

	@ManyToMany(mappedBy = "patients")
	private List<Provider> providers = new ArrayList<>();

	@OneToMany
	@JoinColumn(name = "sbar_id")
	private List<SBAR> sbars =  new ArrayList<>();

	public Patient() { }
	
	public Patient(String name, String email, String phone){
		setEmail(email);
		setName(name);
		setPhone(phone);
	}


	public List<SBAR> getSBARS(){
		return sbars;
	}

	public void addSBAR(SBAR sbar){
		sbars.add(sbar);
	}
	public List<Provider> getProviders(){
		return providers;
	}

	public void addPateint(Provider provider){
		providers.add(provider);
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String toString(){
		return name + " " + email + " " + phone;
	}


}