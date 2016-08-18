# Spring JDBC Example

Spring provide JdbcTemplate for integation with JDBC. JdbcTemplate support JTA, Spring Transaction and JDBC Transaction. 

## Dependencies

**Database**: H2 (Version: 1.4.192)

**Spring Modules** (**Version**: 4.2.5.RELEASE )
- spring-core
- spring-context
- spring-jdbc
- spring-tx

**Other Dependencies**
- commons-dbcp 1.4

## Example 

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


