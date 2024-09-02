package itstep.learning.ioc;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import itstep.learning.fs.FileDemo;
import itstep.learning.hash.HashService;
import itstep.learning.hash.Md5HashService;
import itstep.learning.hash.ShaHashService;

public class ServicesModule extends AbstractModule {
    @Override
    protected void configure(){
        //Lazy
        System.out.println("ServicesModule construct work");

        bind(HashService.class).annotatedWith(Names.named("digest")).to(Md5HashService.class);
        bind(HashService.class).annotatedWith(Names.named("signature")).to(ShaHashService.class);
        bind(String.class).annotatedWith(Names.named("appName")).toInstance("Java-2024");
    }
}
