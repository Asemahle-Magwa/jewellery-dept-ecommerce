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

    // Default constructor
    public Customer() {}

    // All-args constructor (optional for JPA)
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


    // ----------- Builder -----------
    public static class Builder {
        private UUID id;
        private String passwordHash;
        private String fullName;
        private String email;
        private String phone;
        private String universityId;

        public Builder id(UUID id) { this.id = id; return this; }
        public Builder passwordHash(String passwordHash) { this.passwordHash = passwordHash; return this; }
        public Builder fullName(String fullName) { this.fullName = fullName; return this; }
        public Builder email(String email) { this.email = email; return this; }
        public Builder phone(String phone) { this.phone = phone; return this; }
        public Builder universityId(String universityId) { this.universityId = universityId; return this; }

        public Customer build() {
            return new Customer(id, passwordHash, fullName, email, phone, universityId);
        }
    }

    public static Builder builder() {
        return new Builder();
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

