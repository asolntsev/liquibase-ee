liquibase-ee
============

Example of using LiquiBase for heavyweight enterprise DB code


### IDEA project setup
1. Run configuration:
`-ea -Dselenide.reports=test-result -Dbrowser=chrome -Dwebdriver.chrome.driver=c:/programs/chromedriver.exe`

2. Project dependencies: add
  "modules/liquibase-2.4.1/play-liquibase-2.4.1.jar" and
  "modules/liquibase-2.4.1/liquibase.jar"
   to module dependencies as two separate files (not "jars or directories").
   Otherwise play classloader doesn't see "play.plugins" file in play-liquibase-2.4.1.jar and doesn't load
   liquibase module at application startup.