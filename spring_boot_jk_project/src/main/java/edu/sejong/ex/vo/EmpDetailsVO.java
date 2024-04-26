package edu.sejong.ex.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
//@Getter
public class EmpDetailsVO implements UserDetails {
	private EmpVO2 emp;

	public EmpVO2 getEmp() {
		return this.emp;
	}

	public EmpDetailsVO(EmpVO2 emp) {
		this.emp = emp;
	}

	private GrantedAuthority authority;

	/*
	 * // public UserDetailsVO(UserVO user) { public UserDetailsVO(UserAuthorityVO
	 * user) { this.setUsername(user.getUsername());
	 * this.setPassword(user.getPassword()); // this.setAuthorities(authorities); //
	 * this.setAuthorities(user); // this.setAuthority(user.getAuthority()); //
	 * this.setAuthority(authority); // this.setAuthority(user);
	 * this.setAuthority(user); }
	 */

	// private EmpVO2 emp;

	/*
	 * //public void setAuthorities(UserVO user) { public void
	 * setAuthorities(UserAuthorityVO user) { List<GrantedAuthority>
	 * grantedAuthorities = new ArrayList<GrantedAuthority>(); //for (AuthoritiesVO
	 * authVO : user.getAuthList()) { for (AuthoritiesVO authVO : user.get) {
	 * 
	 * authorities.add(new SimpleGrantedAuthority(authVO.getAuthority())); } }
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		// return null;
		// return this.authority ;
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		// list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role));
		// list.add(new UserAuthorityVO(this.username, this.password, 1, "ROLE_USER"));
		// list.add(new SimpleGrantedAuthority(authority.getAuthority()));
		list.add(new SimpleGrantedAuthority("ROLE_USER"));
		// return list;
		return list;
	}

	@Override
	public String getPassword() {
		// return this.password;
		return String.valueOf(this.emp.getEmpno());
	}

	@Override
	public String getUsername() {
		// return this.username;
		return this.emp.getEname();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}