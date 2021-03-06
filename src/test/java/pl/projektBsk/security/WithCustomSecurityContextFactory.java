package pl.projektBsk.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import java.util.List;

public class WithCustomSecurityContextFactory implements WithSecurityContextFactory<WithCustomUser> {

    //Potrzebne do testów, pozwala na tworzenie dowolnego użytkownika z odpowiednią rolą
    @Override
    public SecurityContext createSecurityContext(WithCustomUser withCustomUser) {
     SecurityContext context = SecurityContextHolder.createEmptyContext();

        Authentication a = new UsernamePasswordAuthenticationToken("username",null,
                List.of(()-> withCustomUser.authority()));

        context.setAuthentication(a);

     return context;
    }
}
