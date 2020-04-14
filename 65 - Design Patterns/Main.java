public class Main {
    public static void main(String[] args) {

        Phone phone = new Phone.PhoneBuilder("samsung a40")
                .setCountryOfOrigin("South Korea")
                .setPrice(16000)
                .setIsHas(true).build();

        System.out.println(phone);
    }
}
