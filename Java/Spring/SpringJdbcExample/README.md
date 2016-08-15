# Spring JDBC Example

Spring provide JdbcTemplate for integation with JDBC. JdbcTemplate support JTA, Spring Transaction and JDBC Transaction. 


## Example 


**Database**: H2


**Spring Config**
```
	<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
		<constructor-arg ref="dataSource"/>
	</bean>
```

**Java Code**
```
  @autowired
  private JdbcTemplate jdbcTemplate;

  public int count(){
		int count = jdbcTemplate.queryForObject("select count(1) from test2", Integer.class);
		return count
  }```


