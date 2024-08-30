package itstep.learning.generators;

import com.google.inject.Inject;
import sun.nio.cs.Surrogate;

import javax.inject.Named;

public class GeneratorDemo {

    Generators generatorsCrypto;
    Generators generatorsNameFile;
    Generators generatorsOTP;
    Generators generatorsPassword;

    @Inject
    public GeneratorDemo(@Named("CryptoGen")Generators generatorsCrypto ,@Named("NameFileGen") Generators generatorsNameFile,@Named("OTPGen") Generators generatorsOTP ,@Named("PassGen") Generators generatorsPassword ) {
        this.generatorsCrypto = generatorsCrypto;
        this.generatorsNameFile = generatorsNameFile;
        this.generatorsOTP = generatorsOTP;
        this.generatorsPassword = generatorsPassword;
    }

    public String generateCryptoSalt()
    {
        return generatorsCrypto.generate();
    }

    public String generateFileName()
    {
        return generatorsNameFile.generate();
    }

    public String generateOTP()
    {
        return generatorsOTP.generate();
    }
    public String generatePassword()
    {
        return generatorsPassword.generate();
    }


}
