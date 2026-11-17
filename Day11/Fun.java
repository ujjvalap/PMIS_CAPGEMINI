package CG_Java_Training.Day11;

import java.util.Random;
import java.util.function.Supplier;

public class Fun {
    public static void main(String[] args) {
        Supplier<String> Otpgen= () ->{
            Random random=new Random();
            int Otp = 10000 + random.nextInt(285734);
            return String.valueOf(Otp);
        };

        String otp=Otpgen.get();
        System.out.println("Use This Otp : " + otp);
    }
}
