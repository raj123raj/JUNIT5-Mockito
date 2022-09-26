package gfg.springframework.model;

public class Author extends Geek {

    private String address;
    private String city;
    private String telephone;
   

    public Author(Long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }



    /**
     * Return the Pet with the given name, or null if none found for this Author.
     *
     * @param name to test
     * @return true if pet name is already in use
     */
    

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


}
