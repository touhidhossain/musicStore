# musicStore

#User Schema
#The standard JDBC implementation of the UserDetailsService (JdbcDaoImpl) requires tables to load the password, account status (enabled or disabled) and a list of authorities (roles) for the user.
create table users(
      username varchar_ignorecase(50) not null primary key,
      password varchar_ignorecase(50) not null,
      enabled boolean not null);

  create table authorities (
      username varchar_ignorecase(50) not null,
      authority varchar_ignorecase(50) not null,
      constraint fk_authorities_users foreign key(username) references users(username));
      create unique index ix_auth_username on authorities (username,authority);
