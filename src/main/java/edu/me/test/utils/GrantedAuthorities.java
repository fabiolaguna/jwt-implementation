package edu.me.test.utils;

import edu.me.test.exceptions.NotValidRolException;
import edu.me.test.models.enums.Rol;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class GrantedAuthorities {

    public static List<GrantedAuthority> getGrantedAuthority(Rol rol){

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if (rol.equals(Rol.client)){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + Rol.client.toString()));
        } else if (rol.equals(Rol.employee)){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + Rol.client.toString()));
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + Rol.employee.toString()));
        } else if (rol.equals(Rol.administrator)){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + Rol.client.toString()));
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + Rol.employee.toString()));
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + Rol.administrator.toString()));
        } else {
            throw new NotValidRolException("Invalid rol");
        }

        return grantedAuthorities;
    }
}
