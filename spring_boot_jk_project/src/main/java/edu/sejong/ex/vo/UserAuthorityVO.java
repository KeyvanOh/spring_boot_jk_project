package edu.sejong.ex.vo;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
USERNAME NOT NULL VARCHAR2(50)  
PASSWORD NOT NULL VARCHAR2(100) 
ENABLED           CHAR(1)   


USERNAME  NOT NULL VARCHAR2(50) 
AUTHORITY NOT NULL VARCHAR2(50) 



 */

@Setter
//@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserAuthorityVO implements GrantedAuthority {
	private String username;
	private String password;
	private int enabled;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public int getEnabled() {
		return enabled;
	}

	@Override
	public String getAuthority() {
		return authority;
	}

	// private String username;
	private String authority;
}