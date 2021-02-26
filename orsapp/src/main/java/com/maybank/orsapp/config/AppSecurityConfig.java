package com.maybank.orsapp.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.security.ldap.search.FilterBasedLdapUserSearch;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.maybank.orsapp.security.CustomAccessDeniedHandler;
import com.maybank.orsapp.security.JwtAuthenticationFilter;
import com.maybank.orsapp.security.UnauthorizedEntryPoint;

/**
 * 
 * @author 80003905
 *
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private UnauthorizedEntryPoint unauthorizedEntryPoint;
	
	@Autowired
	private CustomAccessDeniedHandler customAccessDeniedHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		
		http.cors().configurationSource(corsConfigurationSource()).and().csrf().disable().authorizeRequests()
		// .antMatchers("/ORS/MBBORS/v1/login").permitAll()
		// .antMatchers("/ORS/MBBORS/v1/GetRewardTypeList").permitAll()
		// .antMatchers("/ORS/MBBORS/v1/GetAllAirlines").permitAll()
		// .antMatchers("/ORS/MBBORS/v1/GetAllPrograms").permitAll()
		// .antMatchers("/ORS/MBBORS/v1/GetAllCategoryTypes").permitAll()
		// .antMatchers("/ORS/MBBORS/v1/GetAllMerchants").permitAll()
		// .antMatchers("/ORS/MBBORS/v1/GetAllPlasticTypes").permitAll()
		// .antMatchers("/ORS/MBBORS/v1/getUserGroups").permitAll()
		// .antMatchers("/ORS/MBBORS/v1/GetMenuList").permitAll()
		// YAU TEMPORARY
		// Terminal
		// .antMatchers("/ORS/MBBORS/v1/GetTerminalDetailByTid").permitAll()
		// .antMatchers("/ORS/MBBORS/v1/GetTerminalListByMid").permitAll()
		// .antMatchers("/ORS/MBBORS/v1/GetMMPTerminalListByMid").permitAll()
		// .antMatchers("/ORS/MBBORS/v1/downloadTerminal").permitAll()
		// .antMatchers("/ORS/MBBORS/v1/CreateTerminal").permitAll()
		// PointRedemption
		// .antMatchers("/ORS/MBBORS/v1/SearchProductRedemptionAndCardInfo").permitAll()
		// .antMatchers("/ORS/MBBORS/v1/SearchProductRedemptionAndCardInfoAirline").permitAll()
		// .antMatchers("/ORS/MBBORS/v1/PointRedemption").permitAll()
		// .antMatchers("/ORS/MBBORS/v1/M2UPointRedemption").permitAll()
		// .antMatchers("/ORS/MBBORS/v1/TerminalValueRedemption").permitAll()
		// .antMatchers("/ORS/MBBORS/v1/PointRedemptionAirline").permitAll()
		// Merchant
		// .antMatchers("/ORS/MBBORS/v1/GetAllMerchantList").permitAll()
		// .antMatchers("/ORS/MBBORS/v1/GetMerchantDetailByMerchantID").permitAll()
		// .antMatchers("/ORS/MBBORS/v1/GetMMPMerchantDetailByMerchantID").permitAll()
		// .antMatchers("/ORS/MBBORS/v1/CreateMerchant").permitAll()
		// .antMatchers("/ORS/MBBORS/v1/EditMerchant").permitAll()
		// .antMatchers("/ORS/MBBORS/v1/DeleteMerchant").permitAll()
		// Reward Type
		// .antMatchers("/ORS/MBBORS/v1/GetAllRewardTypeList").permitAll()
		// YAU TEMPORARY
		// .antMatchers("/ORS/MBBORS/v1/*").authenticated()
		.antMatchers("/orsapp/login").permitAll()
		.antMatchers("/orsapp/GetRewardTypeList").permitAll()
		.antMatchers("/orsapp/GetAllAirlines").permitAll()
		.antMatchers("/orsapp/GetAllPrograms").permitAll()
		.antMatchers("/orsapp/GetAllCategoryTypes").permitAll()
		.antMatchers("/orsapp/GetAllMerchants").permitAll()
		.antMatchers("/orsapp/GetAllPlasticTypes").permitAll()
		.antMatchers("/orsapp/getUserGroups").permitAll()
		.antMatchers("/orsapp/GetMenuList").permitAll()
		.antMatchers("/orsapp/InquirePointsBalWithCardNoForTerminal").permitAll()
		.antMatchers("/orsapp/GetRedemptionHistoryList").permitAll()
		.antMatchers("/orsapp/GetRedemptionHistoryDetails/*").permitAll()
		.antMatchers("/orsapp/VoidRedemption").permitAll()
		// YAU TEMPORARY
		// Terminal
		.antMatchers("/orsapp/GetTerminalDetailByTid").permitAll()
		.antMatchers("/orsapp/GetTerminalListByMid").permitAll()
		.antMatchers("/orsapp/GetMMPTerminalListByMid").permitAll()
		.antMatchers("/orsapp/downloadTerminal").permitAll()
		.antMatchers("/orsapp/CreateTerminal").permitAll()
		// PointRedemption
		.antMatchers("/orsapp/SearchProductRedemptionAndCardInfo").permitAll()
		.antMatchers("/orsapp/SearchProductRedemptionAndCardInfoAirline").permitAll()
		.antMatchers("/orsapp/PointRedemption").permitAll()
		.antMatchers("/orsapp/M2UPointRedemption").permitAll()
		.antMatchers("/orsapp/TerminalValueRedemption").permitAll()
		.antMatchers("/orsapp/PointRedemptionAirline").permitAll()
		// Merchant
		.antMatchers("/orsapp/GetAllMerchantList").permitAll()
		.antMatchers("/orsapp/GetMerchantDetailByMerchantID").permitAll()
		.antMatchers("/orsapp/GetMMPMerchantDetailByMerchantID").permitAll()
		.antMatchers("/orsapp/CreateMerchant").permitAll()
		.antMatchers("/orsapp/EditMerchant").permitAll()
		.antMatchers("/orsapp/DeleteMerchant").permitAll()
		// Reward Type
		.antMatchers("/orsapp/GetAllRewardTypeList").permitAll()
		// YAU TEMPORARY
		.antMatchers("/orsapp/*").authenticated()
		.anyRequest().permitAll().and().logout().permitAll()
		.logoutSuccessUrl("/login")
		.and()
		.exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint)
		.accessDeniedHandler(customAccessDeniedHandler)
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

	}

	/**
	 * 
	 * auth.authenticationProvider(activeDirectoryLdapAuthenticationProvider());
	 * Useful when we are authenticating logged in user with Microsoft Active
	 * Directory using LDAP Protocol. No Need to Implement UserDetailsService
	 * interface. Spring-security's activeDirectoryLdapAuthenticationProvider() will
	 * handle authentication process.
	 * 
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(activeDirectoryLdapAuthenticationProvider());
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	/**
	 * new
	 * DefaultSpringSecurityContextSource(Arrays.asList("mbbadsyncdev01.mbbuat.local:389"),"dc=mbbuat,
	 * dc=local");
	 * 
	 * @return
	 */
	@Bean
	public DefaultSpringSecurityContextSource contextSource() {
		String url = "ldap://172.31.20.193:389/DC=mbbuat,DC=local";
		DefaultSpringSecurityContextSource contextSource = new DefaultSpringSecurityContextSource(url);
		contextSource.setUserDn("Surendra");
		contextSource.setPassword("Maybank@123");
		contextSource.afterPropertiesSet();
		return contextSource;

	}

	@Bean
	public AuthenticationProvider activeDirectoryLdapAuthenticationProvider() {
		ActiveDirectoryLdapAuthenticationProvider provider = new ActiveDirectoryLdapAuthenticationProvider(
				"mbbuat.local", "ldap://172.31.20.193:389/", "DC=mbbuat,DC=local");
		provider.setSearchFilter("OU=MMP");
		provider.setConvertSubErrorCodesToExceptions(true);
		provider.setUseAuthenticationRequestCredentials(true);
		return provider;
	}

	@Bean
	public FilterBasedLdapUserSearch filterBasedLdapUserSearch() {
		return new FilterBasedLdapUserSearch("", "(&(objectClass=*)(sAMAccountName={0}))", contextSource());
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Collections.singletonList("*")); // <-- you may change "*"
		configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));
		configuration.setAllowCredentials(true);
		configuration.setAllowedHeaders(
				Arrays.asList("Accept", "Origin", "Content-Type", "Depth", "User-Agent", "If-Modified-Since,",
						"Cache-Control", "Authorization", "X-Req", "X-File-Size", "X-Requested-With", "X-File-Name"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilterRegistrationBean() {
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(
				new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
	
	@Bean
    public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationFilter();
    }

}
