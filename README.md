# NewsApplication
A news rss feed generation application with Spring Boot,JPA,Spring Security,Github actions

If you want to secure endponits as per the documentations remove the comment in the SecurityConfig.java file (method -- >protected void configure(HttpSecurity http)).One default User has been already Configured.

.antMatchers("/news/add/**").authenticated()
.antMatchers("/news/delete/**").authenticated()


Configure a default User to access secure end points - 
Username - test@gmail.com
password - test123

Have Created a Documentation for this Web Service also host it using CI/CD (GitHub Actions)
To access the Documentation [click here](https://newsservices.herokuapp.com/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config)
