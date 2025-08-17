abstract class Person {
    private String name;
    private int age;
    private String contactNumber;


    public Person(String name, int age, String contactNumber) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be a positive number.");
        }
        if (contactNumber == null || contactNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Contact number cannot be null or empty.");
        }
        
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}
class Doctor extends Person {
    private String specialization;
    public Doctor(String name, int age, String contactNumber, String specialization) {
        super(name, age, contactNumber);
        
        if (specialization == null || specialization.trim().isEmpty()) {
            throw new IllegalArgumentException("Specialization cannot be null or empty.");
        }
        
        this.specialization = specialization;
    }
    
    public String getSpecialization() {
        return specialization;
    }

}

class Patient extends Person {
    private String medicalCondition;

    // Constructor
    public Patient(String name, int age, String contactNumber, String medicalCondition) {
        super(name, age, contactNumber);
        
        if (medicalCondition == null || medicalCondition.trim().isEmpty()) {
            throw new IllegalArgumentException("Medical condition cannot be null or empty.");
        }


        this.medicalCondition = medicalCondition;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

}


public class HospitalManagementSystem {
    public static void main(String[] args) {
        try {
            // Creating doctor and patient objects
            Doctor doctor = new Doctor("Dr. Smith", 45, "1234567890", "Cardiology");
            Patient patient = new Patient("John Doe", 30, "0987654321", "Hypertension");

            System.out.println("Doctor Details:");
            System.out.println("Name: " + doctor.getName());
            System.out.println("Age: " + doctor.getAge());
            System.out.println("Contact: " + doctor.getContactNumber());
            System.out.println("Specialization: " + doctor.getSpecialization());

            System.out.println("\nPatient Details:");
            System.out.println("Name: " + patient.getName());
            System.out.println("Age: " + patient.getAge());
            System.out.println("Contact: " + patient.getContactNumber());
            System.out.println("Medical Condition: " + patient.getMedicalCondition());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
