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

import org.hibernate.boot.model.source.internal.hbm.PluralAttributeElementSourceOneToManyImpl;

@Entity // This tells Hibernate to make a table out of this class
public class Provider {
    @Id
    @GeneratedValue
	private Integer id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String phone;

	@Column(nullable = false)
	private ProviderType speciality;

	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;
	
	@ManyToMany
	private List<Patient> patients = new ArrayList<>();

	public Provider() { }
	
	public Provider(String username, String password, String name, String email, String phone, int type){
		setUsername(username);
		setPassword(password);
		setSpeciality(type);
		setEmail(email);
		setName(name);
		setPhone(phone);
		
	}

	public void setSpeciality(int type){
		ProviderType enumValue = ProviderType.values()[type];
		this.speciality = enumValue;
	}

	public List<Patient> getPatients(){
		return patients;
	}

	public void addPateint(Patient patient){
		patients.add(patient);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}