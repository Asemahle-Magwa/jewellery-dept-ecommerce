package za.co.jewellerysystem.domain;



import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private UUID id;

    private String passwordHash;
    private String fullName;
    private String email;
    private String phone;
    private String universityId;

    // Constructors
    public Customer() {}

    public Customer(UUID id, String passwordHash, String fullName, String email, String phone, String universityId) {
        this.id = id;
        this.passwordHash = passwordHash;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.universityId = universityId;
    }

    public Customer(UUID uuid, String john, String doe, String mail, String number) {

    }

    // Getters and setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public void setName(String johnDoe) {

    }
}

