package com.patient_manager.Entity;

import java.sql.Types;
import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
//	@JdbcTypeCode(Types.VARCHAR) 
//	@Column(length = 36)
	private UUID id;
	
	@NotNull
	private String name;
	
	@NotNull
	@Email
	@Column(unique=true)
	private String email;
	
	@NotNull
	private String address;
	
	@NotNull
	private LocalDate dateOfBirth;
	
	@Column(name = "registered_date", nullable = false)
    private LocalDate registeredDate;
	
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(UUID id, @NotNull String name, @NotNull @Email String email, @NotNull String address,
			@NotNull LocalDate dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
	}

	
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	
	 public LocalDate getRegisteredDate() {
	        return registeredDate;
	    }
	  public void setRegisteredDate(LocalDate registeredDate) {
	        this.registeredDate = registeredDate;
	    }
	  @PrePersist
	    public void setDefaultRegisteredDate() {
	        if (this.registeredDate == null) {
	            this.registeredDate = LocalDate.now();
	        }
	    }
	    // setter
	 

	
	

}
