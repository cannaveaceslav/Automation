import com.github.javafaker.Faker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class FakerTestDataGenerator {

    public static void main(String[] args) throws ParseException {
        Faker faker = new Faker(new Locale("ru-RU"));
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();
        //-------------дата рождения
        Date date1 = faker.date().birthday(18,70);
        //String DATE_FORMAT = "dd/mm/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String birthday = sdf.format(date1);
        //------------

        String email = "Auto_"+faker.internet().emailAddress();
        String phone = "+7 "+faker.phoneNumber().cellPhone();

        System.out.println(firstname);
        System.out.println(lastname);
        System.out.println(email);
        System.out.println(phone);
        System.out.println(birthday);


    }
}
