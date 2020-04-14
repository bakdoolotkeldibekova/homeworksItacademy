import java.time.LocalDate;

public class Phone {
    private String model;
    private String countryOfOrigin;
    private LocalDate dateOfManufacture;
    private Integer price;
    private boolean isHas;

    public static class PhoneBuilder{
        private String model;
        private String countryOfOrigin;
        private LocalDate dateOfManufacture;
        private Integer price;
        private boolean isHas;

        public PhoneBuilder(String model){
            this.model = model;
        }

        public PhoneBuilder setCountryOfOrigin(String countryOfOrigin){
            this.countryOfOrigin = countryOfOrigin;
            return this;
        }

        public PhoneBuilder setDateOfManufacture(LocalDate dateOfManufacture){
            this.dateOfManufacture = dateOfManufacture;
            return this;
        }

        public PhoneBuilder setPrice(Integer price){
            this.price = price;
            return this;
        }

        public PhoneBuilder setIsHas(Boolean isHas){
            this.isHas = isHas;
            return this;
        }

        public Phone build(){
            Phone phone = new Phone();
            phone.setModel(this.model);
            phone.setCountryOfOrigin(this.countryOfOrigin);
            phone.setDateOfManufacture(this.dateOfManufacture);
            phone.setPrice(this.price);
            phone.setHas(this.isHas);
            return phone;
        }

    }

    private Phone() { }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(LocalDate dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public boolean isHas() {
        return isHas;
    }

    public void setHas(boolean has) {
        isHas = has;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "model='" + model + '\'' +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", dateOfManufacture=" + dateOfManufacture +
                ", price=" + price +
                ", isHas=" + isHas +
                '}';
    }
}
