package itstep.learning.generators;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class GeneratorsModule extends AbstractModule {

    @Override
    protected void configure() {
        System.out.println("GeneratorModule Start");

        bind(Generators.class).annotatedWith(Names.named("CryptoGen")).to(GenCryptoSalt.class);
        bind(Generators.class).annotatedWith(Names.named("NameFileGen")).to(GenNameFile.class);
        bind(Generators.class).annotatedWith(Names.named("OTPGen")).to(GenOTP.class);
        bind(Generators.class).annotatedWith(Names.named("PassGen")).to(GenPass.class);

   }
}
